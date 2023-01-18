## 仅供学习使用，非授权请勿商业用途，违者必究
## Open-IM-Android-Demo
![avatar](https://github.com/OpenIMSDK/OpenIM-Docs/blob/main/docs/images/WechatIMG20.jpeg)

#### Demo内容
Demo 是基于 Open-IM SDK 实现的一套 UI 组件，其包含会话、聊天、关系链、群组等功能，项目目采用MVVM+模块化开发，解耦高、业务独立、代码分离、可以方便快捷集成你需要的功能。
#### 下载体验

![Android](https://www.pgyer.com/app/qrcode/OpenIM-Android)

#### 依赖说明

```
 implementation project(':OUICore') 必要模块
 implementation project(':OUIConversation') 会话相关模块
 implementation project(':OUIGroup') 群组相关模块
 implementation project(':OUIContact') 联系人相关模块
 implementation project(':OUICalling') 音视频通话相关模块
```
#### 开发环境要求
```
Android Studio 3.6.1以上
Gradle-5.1.1以上
Android Gradle Plugin Version-3.4.0以上
android x库
```
#### 开发配置
```
minSdk     : 21
targetSdk  : 32
compileSdk : 32
abiFilters : ['armeabi-v7a', 'arm64-v8a']
```
#### 开始
1.git clone：
```
git clone https://github.com/OpenIMSDK/Open-IM-Android-Demo.git
```
2.导入项目

Demo和UIkit在同一目录,导入demo/app即可

3.配置模块 

在app/config.gradl文件中
```
ext {
    //模块单独运行 为true 模块单独运行
    isModule=false

    //android 配置
    androidConfig = [
            minSdk     : 21,
            targetSdk  : 32,
            compileSdk : 32,
            versionCode: 2,
            versionName: "1.0.2",
            abiFilters : ['armeabi-v7a', 'arm64-v8a']
    ]
    //模块的id
    applicationId = [
            "app" : "io.openim.android.demo",
            "OUIConversation" : "io.openim.android.ouiconversation",
            "OUIGroup" : "io.openim.android.ouigroup",
            "OUIContact" : "io.openim.android.ouicontact",
            "OUICalling" : "io.openim.android.ouicalling",
    ]

}
```
在app/build.gradle文件中
```
    api project(':OUICore')
    if (!isModule) {
        implementation project(':OUIConversation')
        implementation project(':OUIGroup')
        implementation project(':OUIContact')
	//屏蔽一个模块即可去处该模块所有功能
       //implementation project(':OUICalling')
    }
```
4.初始化
```
OpenIMClient.getInstance().initSDK(2,
            "您的IM服务器的地址",
            "您的IM服务器socket地址", getStorageDir(), 1, "minio",
            "",IMEvent.getInstance().connListener);
```
5.登录

>1.登录自己的业务服务器，获取userID 和 token  
>2.使用1.获取到的userID 和 token 登录IM服务器；
```
public void login() {
        Parameter parameter = getParameter(null);
	//1.登录自己的业务服务器，获取userID 和 token  
        N.API(OpenIMService.class).login(parameter.buildJsonBody())
            .compose(N.IOMain())
            .subscribe(new NetObserver<ResponseBody>(getContext()) {

                @Override
                public void onSuccess(ResponseBody o) {
                    try {
                        String body = o.string();
                        Base<LoginCertificate> loginCertificate = GsonHel.dataObject(body, LoginCertificate.class);
                        if (loginCertificate.errCode != 0) {
                            IView.err(loginCertificate.errMsg);
                            return;
                        }
			//2.使用1.获取到的userID 和 token 登录IM服务器；
                        OpenIMClient.getInstance().login(new OnBase<String>() {
                            @Override
                            public void onError(int code, String error) {
                                IView.err(error);
                            }

                            @Override
                            public void onSuccess(String data) {
                                //缓存登录信息 开启愉快畅聊
                   
                            }
                        }, loginCertificate.data.userID, loginCertificate.data.token);

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
```

#### 常见问题
1.提醒: 在调用sdk相关API返回“resource loading is not complete” 如果出现该问题，需在login的callback以后调用其它API。  
2.屏蔽一个模块或添加一个模块后，app在调用该模块功能时会弹错误toast，卸载重装即可  
3.提醒:各模块资源不要重名  
4.由于vm有些需要全局共享，开发者需注意viewModels里是否缓存vm，不使用时及时释放避免内存泄露

