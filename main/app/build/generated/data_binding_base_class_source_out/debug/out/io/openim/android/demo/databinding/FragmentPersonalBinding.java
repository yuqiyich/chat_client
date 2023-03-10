// Generated by view binder compiler. Do not edit!
package io.openim.android.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.openim.android.demo.R;
import io.openim.android.ouicore.widget.AvatarImage;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPersonalBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout aboutLy;

  @NonNull
  public final AvatarImage avatar;

  @NonNull
  public final TextView name;

  @NonNull
  public final LinearLayout personalInfo;

  @NonNull
  public final ImageView qrCode;

  @NonNull
  public final LinearLayout quit;

  @NonNull
  public final TextView userId;

  @NonNull
  public final LinearLayout userLy;

  private FragmentPersonalBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout aboutLy,
      @NonNull AvatarImage avatar, @NonNull TextView name, @NonNull LinearLayout personalInfo,
      @NonNull ImageView qrCode, @NonNull LinearLayout quit, @NonNull TextView userId,
      @NonNull LinearLayout userLy) {
    this.rootView = rootView;
    this.aboutLy = aboutLy;
    this.avatar = avatar;
    this.name = name;
    this.personalInfo = personalInfo;
    this.qrCode = qrCode;
    this.quit = quit;
    this.userId = userId;
    this.userLy = userLy;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_personal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPersonalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aboutLy;
      LinearLayout aboutLy = ViewBindings.findChildViewById(rootView, id);
      if (aboutLy == null) {
        break missingId;
      }

      id = R.id.avatar;
      AvatarImage avatar = ViewBindings.findChildViewById(rootView, id);
      if (avatar == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.personalInfo;
      LinearLayout personalInfo = ViewBindings.findChildViewById(rootView, id);
      if (personalInfo == null) {
        break missingId;
      }

      id = R.id.qrCode;
      ImageView qrCode = ViewBindings.findChildViewById(rootView, id);
      if (qrCode == null) {
        break missingId;
      }

      id = R.id.quit;
      LinearLayout quit = ViewBindings.findChildViewById(rootView, id);
      if (quit == null) {
        break missingId;
      }

      id = R.id.userId;
      TextView userId = ViewBindings.findChildViewById(rootView, id);
      if (userId == null) {
        break missingId;
      }

      id = R.id.userLy;
      LinearLayout userLy = ViewBindings.findChildViewById(rootView, id);
      if (userLy == null) {
        break missingId;
      }

      return new FragmentPersonalBinding((LinearLayout) rootView, aboutLy, avatar, name,
          personalInfo, qrCode, quit, userId, userLy);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
