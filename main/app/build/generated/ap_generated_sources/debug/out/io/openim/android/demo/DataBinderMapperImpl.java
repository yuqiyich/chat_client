package io.openim.android.demo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import io.openim.android.demo.databinding.ActivityAboutUsBindingImpl;
import io.openim.android.demo.databinding.ActivityAddFriendBindingImpl;
import io.openim.android.demo.databinding.ActivityCallHistoryActicityBindingImpl;
import io.openim.android.demo.databinding.ActivityEditTextBindingImpl;
import io.openim.android.demo.databinding.ActivityLoginBindingImpl;
import io.openim.android.demo.databinding.ActivityMainBindingImpl;
import io.openim.android.demo.databinding.ActivityMoreDataBindingImpl;
import io.openim.android.demo.databinding.ActivityPersonDetailBindingImpl;
import io.openim.android.demo.databinding.ActivityPersonInfoBindingImpl;
import io.openim.android.demo.databinding.ActivityPersonalInfoBindingImpl;
import io.openim.android.demo.databinding.ActivityRegisterBindingImpl;
import io.openim.android.demo.databinding.ActivitySearchPersonBindingImpl;
import io.openim.android.demo.databinding.ActivitySendVerifyBindingImpl;
import io.openim.android.demo.databinding.ActivityServerConfigBindingImpl;
import io.openim.android.demo.databinding.ActivitySupplementInfoBindingImpl;
import io.openim.android.demo.databinding.ActivityVerificationCodeBindingImpl;
import io.openim.android.demo.databinding.LayoutLoginBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYABOUTUS = 1;

  private static final int LAYOUT_ACTIVITYADDFRIEND = 2;

  private static final int LAYOUT_ACTIVITYCALLHISTORYACTICITY = 3;

  private static final int LAYOUT_ACTIVITYEDITTEXT = 4;

  private static final int LAYOUT_ACTIVITYLOGIN = 5;

  private static final int LAYOUT_ACTIVITYMAIN = 6;

  private static final int LAYOUT_ACTIVITYMOREDATA = 7;

  private static final int LAYOUT_ACTIVITYPERSONDETAIL = 8;

  private static final int LAYOUT_ACTIVITYPERSONINFO = 9;

  private static final int LAYOUT_ACTIVITYPERSONALINFO = 10;

  private static final int LAYOUT_ACTIVITYREGISTER = 11;

  private static final int LAYOUT_ACTIVITYSEARCHPERSON = 12;

  private static final int LAYOUT_ACTIVITYSENDVERIFY = 13;

  private static final int LAYOUT_ACTIVITYSERVERCONFIG = 14;

  private static final int LAYOUT_ACTIVITYSUPPLEMENTINFO = 15;

  private static final int LAYOUT_ACTIVITYVERIFICATIONCODE = 16;

  private static final int LAYOUT_LAYOUTLOGIN = 17;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(17);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_about_us, LAYOUT_ACTIVITYABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_add_friend, LAYOUT_ACTIVITYADDFRIEND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_call_history_acticity, LAYOUT_ACTIVITYCALLHISTORYACTICITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_edit_text, LAYOUT_ACTIVITYEDITTEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_more_data, LAYOUT_ACTIVITYMOREDATA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_person_detail, LAYOUT_ACTIVITYPERSONDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_person_info, LAYOUT_ACTIVITYPERSONINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_personal_info, LAYOUT_ACTIVITYPERSONALINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_search_person, LAYOUT_ACTIVITYSEARCHPERSON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_send_verify, LAYOUT_ACTIVITYSENDVERIFY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_server_config, LAYOUT_ACTIVITYSERVERCONFIG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_supplement_info, LAYOUT_ACTIVITYSUPPLEMENTINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.activity_verification_code, LAYOUT_ACTIVITYVERIFICATIONCODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(io.openim.android.demo.R.layout.layout_login, LAYOUT_LAYOUTLOGIN);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYABOUTUS: {
          if ("layout/activity_about_us_0".equals(tag)) {
            return new ActivityAboutUsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_about_us is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYADDFRIEND: {
          if ("layout/activity_add_friend_0".equals(tag)) {
            return new ActivityAddFriendBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_friend is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCALLHISTORYACTICITY: {
          if ("layout/activity_call_history_acticity_0".equals(tag)) {
            return new ActivityCallHistoryActicityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_call_history_acticity is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEDITTEXT: {
          if ("layout/activity_edit_text_0".equals(tag)) {
            return new ActivityEditTextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_text is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMOREDATA: {
          if ("layout/activity_more_data_0".equals(tag)) {
            return new ActivityMoreDataBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_more_data is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPERSONDETAIL: {
          if ("layout/activity_person_detail_0".equals(tag)) {
            return new ActivityPersonDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_person_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPERSONINFO: {
          if ("layout/activity_person_info_0".equals(tag)) {
            return new ActivityPersonInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_person_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPERSONALINFO: {
          if ("layout/activity_personal_info_0".equals(tag)) {
            return new ActivityPersonalInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_personal_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTER: {
          if ("layout/activity_register_0".equals(tag)) {
            return new ActivityRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSEARCHPERSON: {
          if ("layout/activity_search_person_0".equals(tag)) {
            return new ActivitySearchPersonBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_search_person is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSENDVERIFY: {
          if ("layout/activity_send_verify_0".equals(tag)) {
            return new ActivitySendVerifyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_send_verify is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSERVERCONFIG: {
          if ("layout/activity_server_config_0".equals(tag)) {
            return new ActivityServerConfigBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_server_config is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSUPPLEMENTINFO: {
          if ("layout/activity_supplement_info_0".equals(tag)) {
            return new ActivitySupplementInfoBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_supplement_info is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVERIFICATIONCODE: {
          if ("layout/activity_verification_code_0".equals(tag)) {
            return new ActivityVerificationCodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_verification_code is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTLOGIN: {
          if ("layout/layout_login_0".equals(tag)) {
            return new LayoutLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_login is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(6);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.wynsbin.vciv.DataBinderMapperImpl());
    result.add(new io.openim.android.ouicontact.DataBinderMapperImpl());
    result.add(new io.openim.android.ouiconversation.DataBinderMapperImpl());
    result.add(new io.openim.android.ouicore.DataBinderMapperImpl());
    result.add(new io.openim.android.ouigroup.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(9);

    static {
      sKeys.put(1, "ChatVM");
      sKeys.put(2, "ContactVM");
      sKeys.put(3, "GroupVM");
      sKeys.put(4, "LoginVM");
      sKeys.put(5, "MainVM");
      sKeys.put(6, "SearchVM");
      sKeys.put(0, "_all");
      sKeys.put(7, "loginVM");
      sKeys.put(8, "serverConfigVM");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(17);

    static {
      sKeys.put("layout/activity_about_us_0", io.openim.android.demo.R.layout.activity_about_us);
      sKeys.put("layout/activity_add_friend_0", io.openim.android.demo.R.layout.activity_add_friend);
      sKeys.put("layout/activity_call_history_acticity_0", io.openim.android.demo.R.layout.activity_call_history_acticity);
      sKeys.put("layout/activity_edit_text_0", io.openim.android.demo.R.layout.activity_edit_text);
      sKeys.put("layout/activity_login_0", io.openim.android.demo.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", io.openim.android.demo.R.layout.activity_main);
      sKeys.put("layout/activity_more_data_0", io.openim.android.demo.R.layout.activity_more_data);
      sKeys.put("layout/activity_person_detail_0", io.openim.android.demo.R.layout.activity_person_detail);
      sKeys.put("layout/activity_person_info_0", io.openim.android.demo.R.layout.activity_person_info);
      sKeys.put("layout/activity_personal_info_0", io.openim.android.demo.R.layout.activity_personal_info);
      sKeys.put("layout/activity_register_0", io.openim.android.demo.R.layout.activity_register);
      sKeys.put("layout/activity_search_person_0", io.openim.android.demo.R.layout.activity_search_person);
      sKeys.put("layout/activity_send_verify_0", io.openim.android.demo.R.layout.activity_send_verify);
      sKeys.put("layout/activity_server_config_0", io.openim.android.demo.R.layout.activity_server_config);
      sKeys.put("layout/activity_supplement_info_0", io.openim.android.demo.R.layout.activity_supplement_info);
      sKeys.put("layout/activity_verification_code_0", io.openim.android.demo.R.layout.activity_verification_code);
      sKeys.put("layout/layout_login_0", io.openim.android.demo.R.layout.layout_login);
    }
  }
}
