package io.openim.android.demo.vm;
import static io.openim.android.ouicore.utils.Common.md5;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;


import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.entity.LoginCertificate;
import io.openim.android.demo.repository.OpenIMService;
import io.openim.android.ouicore.base.BaseViewModel;
import io.openim.android.ouicore.base.IView;
import io.openim.android.ouicore.net.RXRetrofit.N;
import io.openim.android.ouicore.net.RXRetrofit.NetObserver;
import io.openim.android.ouicore.net.RXRetrofit.Parameter;
import io.openim.android.ouicore.net.bage.Base;
import io.openim.android.ouicore.net.bage.GsonHel;

import io.openim.android.ouicore.utils.L;
import io.openim.android.ouicore.widget.WaitDialog;
import io.openim.android.sdk.OpenIMClient;
import io.openim.android.sdk.listener.OnBase;

import okhttp3.ResponseBody;

public class LoginVM extends BaseViewModel<LoginVM.ViewAction> {
    public static final int MAX_COUNTDOWN = 10;

    public MutableLiveData<String> account = new MutableLiveData<>("");
    public MutableLiveData<String> pwd = new MutableLiveData<>("");
    public MutableLiveData<Boolean> isPhone = new MutableLiveData<>(true);
    public MutableLiveData<Integer> countdown = new MutableLiveData<>(MAX_COUNTDOWN);
    public MutableLiveData<String> nickName = new MutableLiveData<>("");

    public String verificationCode;

    public void login() {
        Parameter parameter = getParameter(null);
        N.API(OpenIMService.class).login(parameter.buildJsonBody())
            .compose(N.IOMain())
            .map(OpenIMService.turn(LoginCertificate.class))
            .subscribe(new NetObserver<LoginCertificate>(getContext()) {

                @Override
                public void onSuccess(LoginCertificate loginCertificate) {
                    try {
                        OpenIMClient.getInstance().login(new OnBase<String>() {
                            @Override
                            public void onError(int code, String error) {
                                IView.err(error);
                            }

                            @Override
                            public void onSuccess(String data) {
                                //缓存登录信息
                                loginCertificate.cache(getContext());
                                BaseApp.inst().loginCertificate = loginCertificate;
                                IView.jump();
                            }
                        }, loginCertificate.userID, loginCertificate.imToken);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                protected void onFailure(Throwable e) {
                    IView.err(e.getMessage());
                }
            });
    }

    @NonNull
    private Parameter getParameter(String verificationCode) {
        Parameter parameter = new Parameter()
            .add("password", md5(pwd.getValue()))
            .add("platform", 2)
            .add("usedFor", 1)
            .add("operationID", System.currentTimeMillis() + "")
            .add("verificationCode", verificationCode);
        if (isPhone.getValue()) {
            parameter.add("phoneNumber", account.getValue());
            parameter.add("areaCode", "+86");
        } else
            parameter.add("email", account.getValue());
        return parameter;
    }

    public void getVerificationCode() {
        Parameter parameter = getParameter(null);
        WaitDialog waitDialog = showWait();
        N.API(OpenIMService.class)
            .getVerificationCode(parameter.buildJsonBody())
            .map(OpenIMService.turn(Object.class))
            .compose(N.IOMain())
            .subscribe(new NetObserver<Object>(getContext()) {
                @Override
                public void onSuccess(Object o) {
                    IView.succ(null);
                }

                @Override
                public void onComplete() {
                    super.onComplete();
                    waitDialog.dismiss();
                }

                @Override
                protected void onFailure(Throwable e) {
                    IView.err(e.getMessage());
                }
            });

    }

    @NonNull
    public WaitDialog showWait() {
        WaitDialog waitDialog = new WaitDialog(getContext());
        waitDialog.setNotDismiss();
        waitDialog.show();
        return waitDialog;
    }

    private Timer timer;

    public void countdown() {
        if (null == timer)
            timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (countdown.getValue() == 0) {
                    timer.cancel();
                    timer = null;
                    return;
                }
                countdown.postValue(countdown.getValue() - 1);
            }
        }, 1000, 1000);

    }

    @Override
    protected void viewDestroy() {
        super.viewDestroy();
        if (null != timer) {
            timer.cancel();
            timer = null;
        }
    }

    /**
     * 检查验证码并注册
     */
    public void checkVerificationCode(String verificationCode) {
        Parameter parameter = getParameter(verificationCode);
        WaitDialog waitDialog = showWait();
        N.API(OpenIMService.class).checkVerificationCode(parameter.buildJsonBody())
            .map(OpenIMService.turn(HashMap.class))
            .compose(N.IOMain())
            .subscribe(new NetObserver<HashMap>(getContext()) {
                @Override
                public void onComplete() {
                    super.onComplete();
                    waitDialog.dismiss();
                }

                @Override
                public void onSuccess(HashMap o) {
                    LoginVM.this.verificationCode = verificationCode;
                    IView.succ("checkVerificationCode");
                }

                @Override
                protected void onFailure(Throwable e) {
                    IView.err(e.getMessage());
                }
            });
    }

    public void register() {
        Parameter parameter = getParameter(verificationCode);
        parameter.add("nickname", nickName.getValue());
        WaitDialog waitDialog = showWait();
        N.API(OpenIMService.class).register(parameter.buildJsonBody())
            .map(OpenIMService.turn(LoginCertificate.class))
            .compose(N.IOMain())
            .subscribe(new NetObserver<LoginCertificate>(context.get()) {
                @Override
                public void onComplete() {
                    super.onComplete();
                    waitDialog.dismiss();
                }

                @Override
                public void onSuccess(LoginCertificate o) {
                    setSelfInfo();
                    o.cache(getContext());
                    IView.jump();
                }

                @Override
                protected void onFailure(Throwable e) {
                    IView.toast(e.getMessage());
                }
            });
    }

    ///设置个人信息
    public void setSelfInfo() {
        OpenIMClient.getInstance().userInfoManager.setSelfInfo(new OnBase<String>() {
                                                                   @Override
                                                                   public void onError(int code, String error) {
                                                                   }

                                                                   @Override
                                                                   public void onSuccess(String data) {
                                                                   }
                                                               }, nickName.getValue(), null, 0, 0,
            null, 0, null, null);
    }

    public interface ViewAction extends IView {
        ///跳转
        void jump();

        void err(String msg);

        void succ(Object o);

        void initDate();

    }

}
