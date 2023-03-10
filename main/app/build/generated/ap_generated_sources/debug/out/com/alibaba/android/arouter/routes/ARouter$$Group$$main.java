package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import io.openim.android.demo.SplashActivity;
import io.openim.android.demo.ui.main.MainActivity;
import io.openim.android.demo.ui.search.PersonDetailActivity;
import io.openim.android.demo.ui.search.SendVerifyActivity;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * DO NOT EDIT THIS FILE!!! IT WAS GENERATED BY AROUTER. */
public class ARouter$$Group$$main implements IRouteGroup {
  @Override
  public void loadInto(Map<String, RouteMeta> atlas) {
    atlas.put("/main/MainActivity", RouteMeta.build(RouteType.ACTIVITY, MainActivity.class, "/main/mainactivity", "main", null, -1, -2147483648));
    atlas.put("/main/PersonDetailActivity", RouteMeta.build(RouteType.ACTIVITY, PersonDetailActivity.class, "/main/persondetailactivity", "main", null, -1, -2147483648));
    atlas.put("/main/SendVerifyActivity", RouteMeta.build(RouteType.ACTIVITY, SendVerifyActivity.class, "/main/sendverifyactivity", "main", null, -1, -2147483648));
    atlas.put("/main/SplashActivity", RouteMeta.build(RouteType.ACTIVITY, SplashActivity.class, "/main/splashactivity", "main", null, -1, -2147483648));
  }
}