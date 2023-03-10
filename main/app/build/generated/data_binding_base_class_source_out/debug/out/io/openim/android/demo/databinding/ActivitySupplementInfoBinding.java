// Generated by data binding compiler. Do not edit!
package io.openim.android.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.openim.android.demo.R;
import io.openim.android.demo.vm.LoginVM;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySupplementInfoBinding extends ViewDataBinding {
  @NonNull
  public final EditText nickName;

  @NonNull
  public final EditText password;

  @Bindable
  protected LoginVM mLoginVM;

  protected ActivitySupplementInfoBinding(Object _bindingComponent, View _root,
      int _localFieldCount, EditText nickName, EditText password) {
    super(_bindingComponent, _root, _localFieldCount);
    this.nickName = nickName;
    this.password = password;
  }

  public abstract void setLoginVM(@Nullable LoginVM LoginVM);

  @Nullable
  public LoginVM getLoginVM() {
    return mLoginVM;
  }

  @NonNull
  public static ActivitySupplementInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_supplement_info, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySupplementInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySupplementInfoBinding>inflateInternal(inflater, R.layout.activity_supplement_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySupplementInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_supplement_info, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySupplementInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySupplementInfoBinding>inflateInternal(inflater, R.layout.activity_supplement_info, null, false, component);
  }

  public static ActivitySupplementInfoBinding bind(@NonNull View view) {
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
  public static ActivitySupplementInfoBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySupplementInfoBinding)bind(component, view, R.layout.activity_supplement_info);
  }
}
