package io.openim.android.ouiconversation.vm;


import static io.openim.android.ouicore.utils.Common.UIHandler;

import android.os.Build;
import android.text.TextUtils;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import io.openim.android.ouiconversation.adapter.MessageAdapter;
import io.openim.android.ouicore.base.BaseApp;
import io.openim.android.ouicore.entity.NotificationMsg;
import io.openim.android.ouicore.entity.OnlineStatus;
import io.openim.android.ouicore.net.RXRetrofit.N;
import io.openim.android.ouicore.net.RXRetrofit.NetObserver;
import io.openim.android.ouicore.net.RXRetrofit.Parameter;
import io.openim.android.ouicore.net.bage.Base;
import io.openim.android.ouicore.services.OneselfService;
import io.openim.android.ouicore.utils.Constant;
import io.openim.android.ouicore.base.BaseViewModel;
import io.openim.android.ouicore.base.IView;
import io.openim.android.ouicore.im.IMEvent;
import io.openim.android.ouicore.im.IMUtil;
import io.openim.android.ouicore.net.bage.GsonHel;
import io.openim.android.ouicore.utils.L;
import io.openim.android.ouicore.widget.WaitDialog;
import io.openim.android.sdk.OpenIMClient;

import io.openim.android.sdk.listener.OnAdvanceMsgListener;
import io.openim.android.sdk.listener.OnBase;
import io.openim.android.sdk.listener.OnMsgSendCallback;
import io.openim.android.sdk.models.AdvancedMessage;
import io.openim.android.sdk.models.ConversationInfo;
import io.openim.android.sdk.models.GroupInfo;
import io.openim.android.sdk.models.KeyValue;
import io.openim.android.sdk.models.Message;
import io.openim.android.sdk.models.NotDisturbInfo;
import io.openim.android.sdk.models.OfflinePushInfo;
import io.openim.android.sdk.models.ReadReceiptInfo;
import io.openim.android.sdk.models.RevokedInfo;
import io.openim.android.sdk.models.SearchResult;
import okhttp3.ResponseBody;

public class ChatVM extends BaseViewModel<ChatVM.ViewAction> implements OnAdvanceMsgListener {
    //搜索的本地消息
    public MutableLiveData<List<Message>> searchMessageItems = new MutableLiveData<>(new ArrayList<>());
    public MutableLiveData<List<Message>> addSearchMessageItems = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<Integer> notDisturbStatus = new MutableLiveData<>(0);
    //通知消息
    public MutableLiveData<ConversationInfo> conversationInfo = new MutableLiveData<>();
    public MutableLiveData<NotificationMsg> notificationMsg = new MutableLiveData<>();
    public MutableLiveData<List<Message>> messages = new MutableLiveData<>(new ArrayList<>());
    //@消息
    public MutableLiveData<List<Message>> atMessages = new MutableLiveData<>(new ArrayList<>());
    //表情
    public MutableLiveData<List<String>> emojiMessages = new MutableLiveData<>(new ArrayList<>());
    public ObservableBoolean typing = new ObservableBoolean(false);
    public MutableLiveData<String> inputMsg = new MutableLiveData<>("");
    MutableLiveData<Boolean> isNoData = new MutableLiveData<>(false);

    //开启多选
    public MutableLiveData<Boolean> enableMultipleSelect = new MutableLiveData(false);

    private MessageAdapter messageAdapter;
    private Observer<String> inputObserver;
    public Message startMsg = null; // 消息体，取界面上显示的消息体对象/搜索时的起始坐标
    public String otherSideID = ""; // 接受消息的用户Id
    public String groupID = ""; // 接受消息的群ID
    public boolean isSingleChat = true; //是否单聊 false 群聊
    public boolean isSuperGroup = false;//是否超级大群
    public boolean isVideoCall = true;//是否是视频通话
    public boolean fromChatHistory = false;//从查看聊天记录跳转过来
    public boolean firstChatHistory = true;// //用于第一次消息定位
    public int count = 20; //条数

    public Message loading, forwardMsg;
    private int lastMinSeq = 0;

    public void init() {
        loading = new Message();
        loading.setContentType(Constant.LOADING);
        //获取会话信息
        getConversationInfo();
        //标记所有消息已读
        markReaded(null);

        IMEvent.getInstance().addAdvanceMsgListener(this);

        if (isSingleChat) {
            listener();
        }
    }

    //获取在线状态
    public void getUserOnlineStatus(UserOnlineStatusListener userOnlineStatusListener) {
        List<String> uIds = new ArrayList<>();
        uIds.add(otherSideID);
        Parameter parameter = new Parameter()
            .add("userIDList", uIds)
            .add("operationID", System.currentTimeMillis() + "");

        N.API(OneselfService.class)
            .getUsersOnlineStatus(
                Constant.getImApiUrl() + "/user/get_users_online_status",
                BaseApp.inst().loginCertificate.imToken,
                parameter.buildJsonBody())
            .compose(N.IOMain())
            .subscribe(new NetObserver<ResponseBody>(getContext()) {

                @Override
                public void onSuccess(ResponseBody o) {
                    try {
                        String body = o.string();
                        Base<List<OnlineStatus>> base = GsonHel.dataArray(body, OnlineStatus.class);
                        if (base.errorCode != 0) {
                            IView.toast(base.errorMsg);
                            return;
                        }
                        if (null == base.data || base.data.isEmpty()) return;
                        userOnlineStatusListener.onResult(base.data.get(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                protected void onFailure(Throwable e) {
                    IView.toast(e.getMessage());
                }
            });
    }

    public String handlePlatformCode(List<OnlineStatus.DetailPlatformStatus> detailPlatformStatus) {
        List<String> pList = new ArrayList<>();
        for (OnlineStatus.DetailPlatformStatus platform : detailPlatformStatus) {
            if (platform.platform.equals("Android") || platform.platform.equals("IOS")) {
                pList.add(getContext().getString(io.openim.android.ouicore.
                    R.string.mobile_phone));
            } else if (platform.platform.equals("Windows")) {
                pList.add(getContext().getString(io.openim.android.ouicore.
                    R.string.pc));
            } else if (platform.platform.equals("Web")) {
                pList.add(getContext().getString(io.openim.android.ouicore.
                    R.string.Web));
            } else if (platform.platform.equals("MiniWeb")) {
                pList.add(getContext().getString(io.openim.android.ouicore.
                    R.string.webMiniOnline));
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return String.join("/", pList);
        }
        return "";
    }

    public interface UserOnlineStatusListener {
        void onResult(OnlineStatus onlineStatus);
    }

    private void getConversationInfo() {
        if (isSingleChat) {
            getOneConversation();
        } else {
            List<String> groupIds = new ArrayList<>();
            groupIds.add(groupID);
            OpenIMClient.getInstance().groupManager.getGroupsInfo(new OnBase<List<GroupInfo>>() {
                @Override
                public void onError(int code, String error) {
                    IView.toast(error + code);
                }

                @Override
                public void onSuccess(List<GroupInfo> data) {
                    if (data.isEmpty()) return;
                    GroupInfo groupInfo = data.get(0);
                    isSuperGroup =
                        groupInfo.getGroupType() == 2;
                    getOneConversation();
                }
            }, groupIds);
        }
    }

    private void getOneConversation() {
        OpenIMClient.getInstance().conversationManager.getOneConversation(new OnBase<ConversationInfo>() {
            @Override
            public void onError(int code, String error) {
                IView.toast(error);
            }

            @Override
            public void onSuccess(ConversationInfo data) {
                conversationInfo.setValue(data);
                loadHistory();
                getConversationRecvMessageOpt(data.getConversationID());
            }
        }, isSingleChat ? otherSideID : groupID, isSingleChat ?
            Constant.SessionType.SINGLE_CHAT : isSuperGroup ? Constant.SessionType.SUPER_GROUP
            : Constant.SessionType.GROUP_CHAT);
    }

    private void loadHistory() {
        //加载消息记录
        if (fromChatHistory)
            loadHistoryMessageReverse();
        else
            loadHistoryMessage();
    }

    @Override
    protected void viewDestroy() {
        super.viewDestroy();
        IMEvent.getInstance().removeAdvanceMsgListener(this);
        inputMsg.removeObserver(inputObserver);
    }

    /**
     * 标记已读
     *
     * @param msgIDs 为null 清除里列表小红点
     */
    private void markReaded(List<String> msgIDs) {
        if (isSingleChat)
            OpenIMClient.getInstance().messageManager.markC2CMessageAsRead(null, otherSideID, null == msgIDs ? new ArrayList<>() : msgIDs);
        else
            OpenIMClient.getInstance().messageManager.markGroupMessageAsRead(null, groupID, null == msgIDs ? new ArrayList<>() : msgIDs);
    }


    private void listener() {
        //提示对方我正在输入
        inputMsg.observeForever(inputObserver = s -> {
                OpenIMClient.getInstance().messageManager.typingStatusUpdate(new OnBase<String>() {
                    @Override
                    public void onError(int code, String error) {

                    }

                    @Override
                    public void onSuccess(String data) {

                    }
                }, otherSideID, "");
            }
        );
    }


    public void setMessageAdapter(MessageAdapter messageAdapter) {
        this.messageAdapter = messageAdapter;
    }

    public void loadHistoryMessage() {
        if (isSuperGroup) {
            OpenIMClient.getInstance().messageManager.getAdvancedHistoryMessageList(
                new OnBase<AdvancedMessage>() {
                    @Override
                    public void onError(int code, String error) {
                        IView.toast(error + code);
                    }

                    @Override
                    public void onSuccess(AdvancedMessage data) {
                        lastMinSeq = data.getLastMinSeq();
                        handleMessage(data.getMessageList(), false);
                    }
                }, null, null, conversationInfo.getValue().getConversationID(), lastMinSeq, startMsg, count);
        } else {
            OpenIMClient.getInstance().messageManager.getHistoryMessageList(new OnBase<List<Message>>() {
                @Override
                public void onError(int code, String error) {

                }

                @Override
                public void onSuccess(List<Message> data) {
                    handleMessage(data, false);
                }

            }, otherSideID, groupID, null, startMsg, count);
        }
    }

    private void handleMessage(List<Message> data, boolean isReverse) {
        for (Message datum : data) {
            IMUtil.buildExpandInfo(datum);
        }
        List<Message> list = messages.getValue();
        if (data.isEmpty()) {
            if (!messages.getValue().isEmpty()) {
                isNoData.setValue(true);
                removeLoading(list);
            }
            return;
        } else {
            startMsg = data.get(0);
            Collections.reverse(data);
        }
        if (list.isEmpty()) {
            IMUtil.calChatTimeInterval(data);
            messages.setValue(data);
            return;
        }
        if (isReverse) {
            list.addAll(0, data);
            IMUtil.calChatTimeInterval(list);
            messageAdapter.notifyItemRangeInserted(0, data.size());
            return;
        }
        removeLoading(list);
        list.addAll(data);
        IMUtil.calChatTimeInterval(list);
        list.add(loading);
        messageAdapter.notifyItemRangeChanged(list.size() - 1 - data.size(), list.size() - 1);
    }

    //移除加载视图
    private void removeLoading(List<Message> list) {
        int index = list.indexOf(loading);
        if (index > -1) {
            list.remove(index);
            messageAdapter.notifyItemRemoved(index);
        }
    }

    //发送消息已读回执
    public void sendMsgReadReceipt(int firstVisiblePosition, int lastVisiblePosition) {
        int size = messages.getValue().size();
        if (lastVisiblePosition > size || firstVisiblePosition < 0) return;

        List<Message> megs = messages.getValue().subList(firstVisiblePosition, lastVisiblePosition);
        List<String> msgIds = new ArrayList<>();
        for (Message meg : megs) {
            if (!meg.isRead() && meg.getSendID().equals(otherSideID))
                msgIds.add(meg.getClientMsgID());
        }
        markReaded(msgIds);
    }

    private Runnable typRunnable = () -> typing.set(false);

    /// 是当前聊天窗口
    Boolean isCurrentChat(Message message) {
        String senderId = message.getSendID();
        String receiverId = message.getRecvID();
        String groupId = message.getGroupID();
        boolean isCurSingleChat = message.getSessionType()
            == Constant.SessionType.SINGLE_CHAT &&
            isSingleChat &&
            (senderId.equals(otherSideID) ||
                receiverId.equals(otherSideID));
        boolean isCurGroupChat = message.getSessionType()
            != Constant.SessionType.SINGLE_CHAT && !isSingleChat
            && groupID.equals(groupId);
        return isCurSingleChat || isCurGroupChat;
    }

    @Override
    public void onRecvNewMessage(Message msg) {
        if (!isCurrentChat(msg)) return;
        boolean isTyp = msg.getContentType() == Constant.MsgType.TYPING;
        if (isSingleChat) {
            if (msg.getSendID().equals(otherSideID)) {
                UIHandler.post(() -> typing.set(isTyp));
                if (isTyp) {
                    UIHandler.removeCallbacks(typRunnable);
                    UIHandler.postDelayed(typRunnable, 5000);
                }
            }
        }
        if (isTyp) return;

        messages.getValue().add(0, IMUtil.buildExpandInfo(msg));
        IMUtil.calChatTimeInterval(messages.getValue());
        UIHandler.post(() -> {
            IView.scrollToPosition(0);
            messageAdapter.notifyItemInserted(0);
        });

        //清除列表小红点
        markReaded(null);
        //标记本条消息已读
        List<String> ids = new ArrayList<>();
        ids.add(msg.getClientMsgID());
        markReaded(ids);
    }

    @Override
    public void onRecvC2CReadReceipt(List<ReadReceiptInfo> list) {

    }

    @Override
    public void onRecvGroupMessageReadReceipt(List<ReadReceiptInfo> list) {
        if (isSingleChat) return;
        try {
            for (ReadReceiptInfo readInfo : list) {
                if (readInfo.getGroupID().equals(groupID)) {
                    for (Message e : messages.getValue()) {
                        List<String> uidList =
                            e.getAttachedInfoElem().getGroupHasReadInfo().getHasReadUserIDList();
                        if (null == uidList)
                            uidList = new ArrayList<>();
                        if (!uidList.contains(readInfo.getUserID()) &&
                            (readInfo.getMsgIDList().contains(e.getClientMsgID()))) {
                            uidList.add(readInfo.getUserID());
                            e.getAttachedInfoElem().getGroupHasReadInfo().setHasReadUserIDList(uidList);
                            messageAdapter.notifyItemChanged(messages.getValue().indexOf(e));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRecvMessageRevoked(String msgId) {
        try {
            for (int i = 0; i < messageAdapter.getMessages().size(); i++) {
                Message message = messageAdapter.getMessages().get(i);
                if (TextUtils.isEmpty(message.getClientMsgID()))
                    continue;
                if (message.getClientMsgID().equals(msgId)) {
                    message.setContentType(Constant.MsgType.REVOKE);
                    messageAdapter.notifyItemChanged(i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRecvMessageRevokedV2(RevokedInfo info) {

    }

    @Override
    public void onRecvMessageExtensionsChanged(String msgID, List<KeyValue> list) {

    }

    @Override
    public void onRecvMessageExtensionsDeleted(String msgID, List<String> list) {

    }


    public void sendMsg(Message msg) {
        msg.setStatus(Constant.Send_State.SENDING);
        messages.getValue().add(0, IMUtil.buildExpandInfo(msg));
        messageAdapter.notifyItemInserted(0);
        IView.scrollToPosition(0);

        UIHandler.post(() -> {
            msg.setExt(null);//必须重置 不然android8.0 gson 会崩溃
            OfflinePushInfo offlinePushInfo = new OfflinePushInfo();  // 离线推送的消息备注；不为null
            OpenIMClient.getInstance().messageManager.sendMessage(new OnMsgSendCallback() {
                @Override
                public void onError(int code, String error) {
                    if (code != 302)
                        IView.toast(error + code);
                    UIHandler.postDelayed(() -> {
                        msg.setStatus(Constant.Send_State.SEND_FAILED);
                        messageAdapter.notifyItemChanged(messages.getValue().indexOf(msg));
                    }, 500);
                }

                @Override
                public void onProgress(long progress) {
                    L.e("");
                }

                @Override
                public void onSuccess(Message message) {
                    // 返回新的消息体；替换发送传入的，不然撤回消息会有bug
                    int index = messages.getValue().indexOf(msg);
                    messages.getValue().remove(index);
                    messages.getValue().add(index, IMUtil.buildExpandInfo(message));
                    IMUtil.calChatTimeInterval(messages.getValue());
                    messageAdapter.notifyItemChanged(index);
                }
            }, msg, otherSideID, groupID, offlinePushInfo);
        });
    }

    /**
     * 独立发送
     */
    public void aloneSendMsg(Message msg, String otherSideID, String otherSideGroupID) {
        if (this.otherSideID.equals(otherSideID) || groupID.equals(otherSideGroupID)) {
            //如果转发给本人/本群
            sendMsg(msg);
            return;
        }
        OfflinePushInfo offlinePushInfo = new OfflinePushInfo();  // 离线推送的消息备注；不为null
        OpenIMClient.getInstance().messageManager.sendMessage(new OnMsgSendCallback() {
            @Override
            public void onError(int code, String error) {
                IView.toast(error + code);
            }

            @Override
            public void onProgress(long progress) {
            }

            @Override
            public void onSuccess(Message message) {
                IView.toast(getContext().getString(io.openim.android.ouicore.R.string.send_succ));
            }
        }, msg, otherSideID, otherSideGroupID, offlinePushInfo);
    }

    /**
     * 撤回消息
     *
     * @param message
     */
    public void revokeMessage(Message message) {
        OpenIMClient.getInstance().messageManager.revokeMessageV2(new OnBase<String>() {
            @Override
            public void onError(int code, String error) {
                IView.toast(error + code);
            }

            @Override
            public void onSuccess(String data) {
                message.setContentType(Constant.MsgType.REVOKE);
                messageAdapter.notifyItemChanged(messageAdapter.getMessages().indexOf(message));
            }
        }, message);


    }

    public void deleteMessageFromLocalStorage(Message message) {
        message.setExt(null);
        OpenIMClient.getInstance().messageManager.deleteMessageFromLocalStorage(new OnBase<String>() {
            @Override
            public void onError(int code, String error) {
                IView.toast(error + "(" + code + ")");
            }

            @Override
            public void onSuccess(String data) {
                int index = messageAdapter.getMessages().indexOf(message);
                messageAdapter.getMessages().remove(index);
                messageAdapter.notifyItemRemoved(index);
            }
        }, message);
    }

    public void closePage() {
        IView.closePage();
    }

    public void clearC2CHistory(String uid) {
        WaitDialog waitDialog = new WaitDialog(getContext());
        waitDialog.show();
        OpenIMClient.getInstance().messageManager
            .clearC2CHistoryMessageFromLocalAndSvr(new OnBase<String>() {
                @Override
                public void onError(int code, String error) {
                    waitDialog.dismiss();
                    IView.toast(error + code);
                }

                @Override
                public void onSuccess(String data) {
                    waitDialog.dismiss();
                    messages.getValue().clear();
                    IView.toast(getContext().getString(io.openim.android.ouicore.R.string.clear_succ));
                }
            }, uid);

    }

    public void getConversationRecvMessageOpt(String... cid) {
        OpenIMClient.getInstance().conversationManager.getConversationRecvMessageOpt(new OnBase<List<NotDisturbInfo>>() {
            @Override
            public void onError(int code, String error) {

            }

            @Override
            public void onSuccess(List<NotDisturbInfo> data) {
                if (data.isEmpty()) return;
                notDisturbStatus.setValue(data.get(0).getResult());
            }
        }, Arrays.asList(cid));
    }

    public void setConversationRecvMessageOpt(int status, String... cid) {
        OpenIMClient.getInstance().conversationManager.setConversationRecvMessageOpt(new OnBase<String>() {
            @Override
            public void onError(int code, String error) {
            }

            @Override
            public void onSuccess(String data) {
                notDisturbStatus.setValue(status);
            }
        }, Arrays.asList(cid), status);
    }

    public void searchLocalMessages(String key, int page, Integer... messageTypes) {
        List<String> keys = null;
        if (!TextUtils.isEmpty(key)) {
            keys = new ArrayList<>();
            keys.add(key);
        }
        List<Integer> messageTypeLists;
        if (0 == messageTypes.length) {
            messageTypeLists = new ArrayList<>();
            messageTypeLists.add(Constant.MsgType.TXT);
            messageTypeLists.add(Constant.MsgType.MENTION);
        } else
            messageTypeLists = Arrays.asList(messageTypes);

        String conversationId = conversationInfo.getValue().getConversationID();
        OpenIMClient.getInstance()
            .messageManager
            .searchLocalMessages
                (new OnBase<SearchResult>() {
                     @Override
                     public void onError(int code, String error) {
                         IView.toast(error + code);
                         L.e("");
                     }

                     @Override
                     public void onSuccess(SearchResult data) {
                         if (page == 1) {
                             searchMessageItems.getValue().clear();
                         }
                         if (data.getTotalCount() != 0) {
                             searchMessageItems.getValue().addAll(data.getSearchResultItems().get(0).getMessageList());
                             addSearchMessageItems.setValue(data.getSearchResultItems().get(0).getMessageList());
                         }
                         searchMessageItems.setValue(searchMessageItems.getValue());
                     }
                 }, conversationId,
                    keys, 0,
                    new ArrayList<>(), messageTypeLists, 0,
                    0, page, count);
    }

    public void loadHistoryMessageReverse() {
        OpenIMClient.getInstance().messageManager.getHistoryMessageListReverse(
            new OnBase<List<Message>>() {
                @Override
                public void onError(int code, String error) {

                }

                @Override
                public void onSuccess(List<Message> data) {
                    if (firstChatHistory) {
                        data.add(0, startMsg);
                        firstChatHistory = false;
                    }
                    handleMessage(data, true);
                }

            }, otherSideID, groupID, null, startMsg, count * 50);


    }


    public interface ViewAction extends IView {
        void scrollToPosition(int position);

        void closePage();
    }
}
