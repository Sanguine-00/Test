package com.example.jingfeng.android;

import android.os.Environment;

public interface ConfigCommon {

    /************************* 常用参数 **************************/
    /**
     * 当前程序包名
     */
    String PAKAGENAME = "com.mobcb.kingmo";
    /**
     * 调试keystore的签名(MD5)
     */
    String SIGN_DEBUG = "da26fd8b485d40f333a019e4ed314383";
    /**
     * 发布包keystore的签名(MD5)，可通过校验这2个签名来判断是否是调试版或发布版，自动判断该用什么微信appid
     */
    String SIGN_ONLINE = "713b11e2e94facd0453143f057217231";
    /**
     * 在线升级等功能需要的参数
     */
    String API_APP_NAME = "jingfeng_android";
    /**
     * 字符编码
     */
    String ENCODING = "UTF-8";
    /**
     * http超时时间
     */
    int HTTP_TIMEOUT = 60000;
    /**
     * 儿童手环登陆密码
     */
    String CHILD_PWD = "123456";
    /**
     * 文件保存到SDCARD中文件夹名
     */
    String SDCARD_DIR_NAME = "." + PAKAGENAME;
    /**
     * 文件保存到SDCARD路径
     */
    String SDCARD_PATH = //Environment.getExternalFilesDir()
            Environment.getExternalStorageDirectory()
                    + "/" + SDCARD_DIR_NAME;
    /**
     * 登陆与注册来源
     */
    String LOGIN_SOURCE = "app_android";
    /**
     * 秒杀来源
     */
    String SECKILL_SOURCE = "app";
    /**
     * AES加密解密的key
     */
    String AES_KEY = "mobcb_wondercity";
    /**
     * 设置Umeng推送的用户alias的时候需要用到的Aliastype
     */
    String UMENG_ALIAS_SELF_TYPE = "mid";
    /**
     * 内嵌webView的javascript接口名
     */
    String JAVASCRIPT_INTERFACE_NAME = "MobCBAndroidClient";
    /**
     * 在线客服的IM号
     */
    String CUSTOMER_SERVICE_IM_NAME = "customer-service";

    /**
     * 敬请期待本地页面
     */
    String PAGE_COMING_SOON = "file:///android_asset/page/jqqd.htm";
    /************************* 常用参数 **************************/

    /************************* 广播参数 **************************/
    /**
     * 图片编号变量的KEY，多个地方用到，因此定义为公共常量
     */
    String KEY_IMAGE_SN = "image_key";
    /**
     * 设置图片广播事件
     */
    String BROADCAST_SET_PICTURE = "broadcast_set_picture";
    /**
     * 提示以申请会员卡
     */
    String BROADCAST_APPLYED_MEMBERCARD = "broadcast_applyed_membercard";
    /**
     * 关闭当前Activity
     */
    String BROADCAST_CLOSE_THIS = "broadcast_close_this";
    /**
     * 刷新会员卡信息
     */
    String BROADCAST_REFRESH_CARDINFO = "broadcast_refresh_cardinfo";
    /**
     * 刷新我的订单列表
     */
    String BROADCAST_REFRESH_MINE_ORDERS = "broadcast_refresh_mine_orders";
    /**
     * 刷新我的订单列表
     */
    String BROADCAST_REFRESH_MINE_FOOD_ORDERS = "broadcast_refresh_mine_food_orders";
    /**
     * 刷新我的酒吧排号
     */
    String BROADCAST_REFRESH_MINE_BAR_BOOK = "broadcast_refresh_mine_bar_book";
    /**
     * 刷新我的KTV预约
     */
    String BROADCAST_REFRESH_MINE_KTV_BOOK = "broadcast_refresh_mine_ktv_book";
    /**
     * 刷新订单详情
     */
    String BROADCAST_REFRESH_ORDER_DETAIL = "broadcast_refresh_order_detail";
    /**
     * 刷新用户服务列表
     */
    String BROADCAST_REFRESH_FUWU = "broadcast_refresh_fuwu";
    /**
     * 酒店预约成功
     */
    String BROADCAST_HOTEL_BOOK_SUCCESS = "broadcast_hotel_book_success";
    /************************* 广播参数 **************************/

    /*************************
     * POST接口状态
     **************************/
    int API_RESULT_SUCCESS = 0;
    int API_RESULT_FAILURE = -1;
    /************************* POST接口状态 **************************/

    /************************* WIFI配置 **************************/
    /**
     * WIFI-SSID
     */
    String WIFI_SSID = "KINGMO";
    /**
     * WIFI-一键认证
     */
    String WIFI_LOGIN_URL = ConfigAPI.MAIN_PATH + "/system/appOneKey";
    /************************* WIFI配置 **************************/

    /************************* 微信配置 **************************/
    /**
     * 测试APP_ID-没有测试
     */
    String WEIXIN_TEST_APP_ID = "wxf08bcc059b8a5136";
    /**
     * 测试AppSecret
     */
    String WEIXIN_TEST_AppSecret = "6f341f2835b60047b2f15384739223f6";
    /**
     * 发布版APP_ID
     */
    String WEIXIN_APP_ID = "wxf08bcc059b8a5136";
    /**
     * 发布版AppSecret
     */
    String WEIXIN_AppSecret = "6f341f2835b60047b2f15384739223f6";
    /**
     * 微信分享链接
     */
    //String WEIXIN_SHARE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc292d420db7615fc&redirect_uri=http://m.wondercity.com.cn/oauth/OAuthAPI?backurl=%1$s&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    /**
     * 微信连接
     */
    String WXURL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    String WXURL2 = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    String WXUSERINFO = "https://api.weixin.qq.com/sns/userinfo";
    /************************* 微信配置 **************************/

    /************************* 本地HTML相关配置BEGIN **************************/
    /**
     * 页面模版文件夹名称,已废弃。因为在APP版本编号4(包含)以上的文件夹前面夹了“.”，用来隐藏文件夹
     */
    int SDCARD_PATHNAME_OLD_VERSION = 4;//4以下的版本需要删除老文件夹
    /**
     * 页面模版保存路径,已废弃。因为在APP版本编号4(包含)以上的文件夹前面夹了“.”，用来隐藏文件夹
     */
    String SDCARD_PATH_OLD = Environment.getExternalStorageDirectory() + "/" + PAKAGENAME;
    ;
    /**
     * 页面模版文件夹名称
     */
    String SDCARD_PATHNAME_TEMPLATES = ".pages_templates_" + ConfigAPI.ISONLINE;
    /**
     * 页面模版保存路径
     */
    String SDCARD_PATH_TEMPLATES = ConfigCommon.SDCARD_PATH + "/" + SDCARD_PATHNAME_TEMPLATES;
    /**
     * 页面模版下载的zip包保存路径
     */
    String SDCARD_PATH_TEMPLATES_DOWNLOADZIP = ConfigCommon.SDCARD_PATH + "/" + SDCARD_PATHNAME_TEMPLATES + "/.download_zip";
    /**
     * 页面模版解压临时路径
     */
    String SDCARD_PATH_TEMPLATES_UNZIPTEMP = ConfigCommon.SDCARD_PATH + "/" + SDCARD_PATHNAME_TEMPLATES + "/.unziptemp";
    /**
     * 模版ingcheng
     */
    String TEMPLATES_NAME = "jingfeng-template";
    /**
     * 本地HTMLProvider前缀
     */
    String LOCAL_HTML_PROVIDER = "content://" + PAKAGENAME + ".localhtmlprovider";
    /**
     * 本地HTMLProvide相对路径
     */
    String LOCAL_HTML_RELETIVEPATH = "/sdcard/" + SDCARD_DIR_NAME + "/" + SDCARD_PATHNAME_TEMPLATES + "/" + TEMPLATES_NAME;
    /**
     * asset中的zip文件拷贝到sdcard中的路径
     */
    String SDCARD_PATH_ASSETS_ZIP = ConfigCommon.SDCARD_PATH + "/" + SDCARD_PATHNAME_TEMPLATES + "/.assets";
    /**
     * 当前asset中包含的zip文件的版本号，如果是这个版本则直接解压asset中的zip，否则从网络上去下载zip
     */
    String ASSETS_ZIP_FILE_VERSION = ConfigAPI.ASSETS_ZIP_FILE_VERSION;
    /**
     * 当前asset中zip文件名称
     */
    String ASSETS_ZIP_FILENAME = ConfigAPI.ASSETS_ZIP_FILENAME;

    String ENCRYPT_KEY = "MOBCB123";    //DES加密Key
    /************************* 本地HTML相关配置END **************************/
    /**
     * webview自适应加的前缀代码
     */
    String WEBVIEW_FRONT_CODE = "<style type='text/css'>img{max-width:100% !important} div{max-width:100% !important}</style>";
}
