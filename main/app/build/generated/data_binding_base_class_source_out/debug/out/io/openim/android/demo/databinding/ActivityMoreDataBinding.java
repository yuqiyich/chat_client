// Generated by data binding compiler. Do not edit!
package io.openim.android.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import io.openim.android.demo.R;
import io.openim.android.ouicore.databinding.ViewBackBinding;
import io.openim.android.ouicore.widget.AvatarImage;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMoreDataBinding extends ViewDataBinding {
  @NonNull
  public final AvatarImage avatar;

  @NonNull
  public final LinearLayout avatarLy;

  @NonNull
  public final ViewBackBinding back;

  @NonNull
  public final TextView birthday;

  @NonNull
  public final LinearLayout birthdayLy;

  @NonNull
  public final TextView gender;

  @NonNull
  public final LinearLayout genderLy;

  @NonNull
  public final LinearLayout idLy;

  @NonNull
  public final TextView mailTv;

  @NonNull
  public final TextView nickName;

  @NonNull
  public final LinearLayout nickNameLy;

  @NonNull
  public final TextView phoneTv;

  @NonNull
  public final LinearLayout qrCode;

  protected ActivityMoreDataBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AvatarImage avatar, LinearLayout avatarLy, ViewBackBinding back, TextView birthday,
      LinearLayout birthdayLy, TextView gender, LinearLayout genderLy, LinearLayout idLy,
      TextView mailTv, TextView nickName, LinearLayout nickNameLy, TextView phoneTv,
      LinearLayout qrCode) {
    super(_bindingComponent, _root, _localFieldCount);
    this.avatar = avatar;
    this.avatarLy = avatarLy;
    this.back = back;
    this.birthday = birthday;
    this.birthdayLy = birthdayLy;
    this.gender = gender;
    this.genderLy = genderLy;
    this.idLy = idLy;
    this.mailTv = mailTv;
    this.nickName = nickName;
    this.nickNameLy = nickNameLy;
    this.phoneTv = phoneTv;
    this.qrCode = qrCode;
  }

  @NonNull
  public static ActivityMoreDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_more_data, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMoreDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMoreDataBinding>inflateInternal(inflater, R.layout.activity_more_data, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMoreDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_more_data, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMoreDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMoreDataBinding>inflateInternal(inflater, R.layout.activity_more_data, null, false, component);
  }

  public static ActivityMoreDataBinding bind(@NonNull View view) {
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
  public static ActivityMoreDataBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMoreDataBinding)bind(component, view, R.layout.activity_more_data);
  }
}