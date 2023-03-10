// Generated by data binding compiler. Do not edit!
package io.openim.android.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.openim.android.demo.R;
import io.openim.android.demo.vm.LoginVM;
import io.openim.android.ouicore.widget.CodeEditText;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityVerificationCodeBinding extends ViewDataBinding {
  @NonNull
  public final TextView accountTv;

  @NonNull
  public final CodeEditText codeEditText;

  @NonNull
  public final TextView countdown;

  @NonNull
  public final TextView resend;

  @NonNull
  public final TextView tips;

  @Bindable
  protected LoginVM mLoginVM;

  protected ActivityVerificationCodeBinding(Object _bindingComponent, View _root,
      int _localFieldCount, TextView accountTv, CodeEditText codeEditText, TextView countdown,
      TextView resend, TextView tips) {
    super(_bindingComponent, _root, _localFieldCount);
    this.accountTv = accountTv;
    this.codeEditText = codeEditText;
    this.countdown = countdown;
    this.resend = resend;
    this.tips = tips;
  }

  public abstract void setLoginVM(@Nullable LoginVM LoginVM);

  @Nullable
  public LoginVM getLoginVM() {
    return mLoginVM;
  }

  @NonNull
  public static ActivityVerificationCodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_verification_code, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityVerificationCodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityVerificationCodeBinding>inflateInternal(inflater, R.layout.activity_verification_code, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityVerificationCodeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_verification_code, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityVerificationCodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityVerificationCodeBinding>inflateInternal(inflater, R.layout.activity_verification_code, null, false, component);
  }

  public static ActivityVerificationCodeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityVerificationCodeBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityVerificationCodeBinding)bind(component, view, R.layout.activity_verification_code);
  }
}
