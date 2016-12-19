package com.example.test.jingfeng;

public interface ConfigAPI {

    String SCHEMA_HTTPS = "https://";
    String SCHEMA_HTTP = "http://";
//    /***********************13 接口参数************************/
//    /**
//     * 线上或线下标识
//     */
//    Boolean ISONLINE = true;
//    /**
//     * 域名和IP地址
//     */
//    String MAIN_DOMAIN = "192.168.0.13:8080";
//    String MAIN_IPADDR = "192.168.0.13:8080";
//    String POS_MAIN =SCHEMA_HTTP+ "pos.kingmocn.com:9080";
////    String MAIN_DOMAIN = "120.266.62.103:8080";
////    String MAIN_IPADDR = "120.266.62.103:8080";
//    /**
//     * 主接口
//     */
//    String MAIN = SCHEMA_HTTP + MAIN_DOMAIN;
//    /**
//     * 内嵌主页面
//     */
//    String W_MAIN = MAIN + "/small-jingfeng";
//    /**
//     * 地图服务-地图文件及楼层配置等接口
//     */
//    String MAP_HOST = SCHEMA_HTTP + "192.168.0.13:8080";
//    /**
//     * 地图服务-定位和路线等接口
//     */
//    String MAP_SERVER = MAIN + "/KingMoMapServer";
//    /**
//     * 地图服务-内网地址-心跳等
//     */
//    String MAP_HOST_PRIVATENETWORK = "http://192.168.0.254:8080";
//    /**
//     * 支付宝通知的接口前缀
//     */
//    String ALIPAY_NOTIFY_HOST_PATH = "http://mobcb.xicp.net:8082/jingfeng";
//    /**
//     * 当前asset中包含的zip文件的版本号，如果是这个版本则直接解压asset中的zip，否则从网络上去下载zip
//     */
//    String ASSETS_ZIP_FILE_VERSION = "";
//    /**
//     * 当前asset中zip文件名称
//     */
//    String ASSETS_ZIP_FILENAME = "";
//    /**
//     * 模板的web URL地址
//     */
//    String TEMPLATE_HTTP_URL = W_MAIN + "/template";
//    /***********************13 接口参数************************/

    /***********************景枫 接口参数************************/
    /**
     * 线上或线下标识
     */
    Boolean ISONLINE = true;
    /**
     * 域名和IP地址
     */
    String MAIN_DOMAIN = "m.kingmocn.com";
    String MAIN_IPADDR = "m.kingmocn.com";
    String POS_MAIN =SCHEMA_HTTP+ "pos.kingmocn.com:9080";
    /**
     * 主接口
     */
    String MAIN = SCHEMA_HTTPS + MAIN_DOMAIN;
    /**
     * 内嵌主页面
     */
    String W_MAIN = MAIN;
    /**
     * 地图服务-地图文件及楼层配置等接口
     */
    String MAP_HOST = SCHEMA_HTTPS + MAIN_IPADDR;
    /**
     * 地图服务-定位和路线等接口
     */
    String MAP_SERVER = MAIN + "/KingMoMapServer";
    /**
     * 地图服务-内网地址-心跳等
     */
    String MAP_HOST_PRIVATENETWORK = "https://m.kingmocn.com";
    /**
     * 支付宝通知的接口前缀
     */
    String ALIPAY_NOTIFY_HOST_PATH = MAIN + "/jingfeng";
    /**
     * 当前asset中包含的zip文件的版本号，如果是这个版本则直接解压asset中的zip，否则从网络上去下载zip
     */
    String ASSETS_ZIP_FILE_VERSION = "";
    /**
     * 当前asset中zip文件名称
     */
    String ASSETS_ZIP_FILENAME = ".zip";
    /**
     * 模板的web URL地址
     */
    String TEMPLATE_HTTP_URL = W_MAIN + "/template";
    /***********************景枫 接口参数************************/

    /************************* 网络地址 **************************/
    /**
     * 网络加密请求的appkey
     */
    String API_APP_KEY_ANDROID = "3I63U6MSDIA";
    /**
     * 主接口路径
     */
    String MAIN_PATH = MAIN + "/jingfeng/api/v1";
    /**
     * pos机相关住路径
     */
    String POS_MAIN_PAHT = POS_MAIN + "/jingfeng/api/v1";
    /**
     * 地图主接口路径
     */
    String MAIN_MAP_PATH = MAP_HOST + "/jingfeng/api/v1";
//    /**
//     * 主接口路径
//     */
//    String MAIN_PATH = MAIN + "/jingfeng-openapi-web/api/v1";
//    /**
//     * 地图主接口路径
//     */
//    String MAIN_MAP_PATH = MAP_HOST + "/jingfeng-openapi-web/api/v1";
    /**
     * 主页展示连接
     */
    String MAIN_HOME = MAIN_PATH + "/home";
    /**
     * 活动主接口
     */
    String ACTICITY_PORT = MAIN_PATH + "/activity";
    /**
     * 摇一摇
     */
    String ACTICITY_SHAKE = MAIN_PATH + "/activity/sharkitoff";

    /**
     * 摇一摇
     */
    String ACTICITY_SHAKE_NUMBER = MAIN_PATH + "/activity/shake/members/%1$S/availabletimes?shakeType=spell_luck";


    /**
     * 会员中心主接口
     */
    String USER = MAIN_PATH + "/member";
    /**
     * 餐厅菜品信息
     */
    String CATERING_DISHES = MAIN_PATH + "/catering/dishes?restaurant=%1$S&page=0&pagesize=" + Integer.MAX_VALUE;
    /**
     * 会员券信息
     */
    String USER_COUPONS_INFO = MAIN_PATH + "/member/%1$s/coupons/info";
    /**
     * 会员券列表
     */
    String USER_COUPONS_LIST = MAIN_PATH + "/member/%1$s/coupons";
    /**
     * 用户信息
     */
    String USER_INFO = MAIN_PATH + "/member/%1$s/info";
    /**
     * 用户积分
     */
    String USER_CREDIT = MAIN_PATH + "/member/%1$s/credit";
    /**
     * 评论商品
     */
    String COMMENT_GOODS = MAIN_PATH + "/eshop/goods/%1$s/comments";


    /**
     * 首页广告
     */
    String HOME_AD = MAIN_PATH + "/appad/home?number=5&picspec=%1$s&channel=app";

    /**
     * 秒杀站位广告
     */
    String SKILL_AD = MAIN_PATH + "/appad/ads?number=5&picspec=banner&type=%1$s";

    /**
     * 广告点击
     */
    String AD_CLICK = MAIN_PATH + "/appad/%1$s/click";

    /**
     * 优惠券页面广告
     */
    String COUPON_AD = MAIN_PATH
            + "/appad/ads?number=5&picspec=%1$s&type=coupon&channel=app";

    /**
     * 活动页面广告
     */
    String ACTIVITY_AD = MAIN_PATH
            + "/appad/ads?number=5&picspec=%1$s&type=activity&channel=app";
    /**
     * 会员卡登录
     */
    String USER_CARDLOGIN = USER + "/mall/crm/cardlogin";

    /**
     * 优惠券页面广告
     */
    String API_TOUTIAO_AD = MAIN_PATH + "/appad/ads?number=5&picspec=textview&type=home&channel=app";

    /**
     * 积分商城组合兑页面广告
     */
    String GIFT_SUIT_AD = MAIN_PATH
            + "/appad/ads?number=5&picspec=%1$s&type=giftsuit&channel=app";
    /**
     * 商品页面广告
     */
    String GOODS_AD = MAIN_PATH
            + "/appad/ads?number=5&picspec=%1$s&type=goods&channel=app";
    /**
     * 启动时滑屏广告
     */
    String STARTUP_AD = MAIN_PATH + "/appad/startup?picspec=%1$s&number=5&channel=app";
    /**
     * 通用广告接口
     */
    String COMMON_AD = MAIN_PATH
            + "/appad/ads?number=5&picspec=%1$s&type=%2$s&channel=app";
    /**
     * 客服中心
     */
    String KF_LIST = MAIN_PATH + "/member/%1$s/kf?lastId=%2$s&page=0&pagesize=100";
    /**
     * 客服中心，发表问题
     */
    String KF_POST = MAIN_PATH + "/member/%1$s/kf";
    /**
     * 版本检查更新接口
     */
    String API_UPDATE = MAIN_PATH + "/system/update?channel=%1$s&vcode=%2$s&vname=%3$s&deviceId=%4$s&app=" + ConfigCommon.API_APP_NAME;
    /**
     * 检查某app是否在线，如果返回false则无法使用app
     */
    String API_ONLINE_CHECK = "http://api.mobcb.com/apiconfig/online/check?key=" + ConfigCommon.API_APP_NAME;
    /**
     * 品鉴列表接口
     */
    String PINJIAN_LIST = MAIN_PATH + "/onshow/list";
    /**
     * 分店列表接口
     */
    String BRANCH_STORE_LIST = MAIN_PATH + "/mall/list";
    /**
     * 用户密码修改
     */
    String USER_PASSWORD = USER + "/password";

    /**
     * VIP卡信息查询
     */
    String API_MEMBER_CARD_INFO = MAIN_PATH + "/member/%1$s/mall/crm/vipcard";
    /**
     * VIP卡余额信息
     */
    String API_MEMBER_CARD_BALANCE = MAIN_PATH + "/member/%1$s/mall/crm/balance";

    /**
     * 上传头像文件接口
     */
    String APP_UPLOAD = MAIN_PATH + "/app/upload";
    /**
     * 上传文件接口
     */
    String API_UPLOAD_FILE = MAIN_PATH + "/system/upload";

    /**
     * 查询手机号是否绑定
     */
    String CHECK_PHONE = USER + "/check?nameType=phone&name=";
    /**
     * 商户列表接口
     */
    String SHOP_LIST = MAIN_PATH + "/shop/list?type=%1$s&floorid=%2$s";

    /**
     * 商户详情
     */
    String SHOP_INFO = MAIN_PATH + "/shop/%1$s";
    /**
     * 收藏商户
     */
    String CARE_SHOP = MAIN_PATH + "/shop/%1$s/care/%2$s";

    /**
     * 取消收藏商户
     */
    String CANCEL_CARE_SHOP = MAIN_PATH + "/shop/%1$s/uncare/%2$s";
    /**
     * 商户类型下拉列表
     */
    String SHOP_TYPE = MAIN_PATH + "/shop/type";
    /**
     * 商户楼层下拉列表
     */
    String SHOP_FLOORS = MAIN_PATH + "/shop/floors?hasSell=true";
    /**
     * 美食列表接口
     */
    //String FOOD_LIST = MAIN_PATH + "/shop/list?type=5&foodtype=%1$s&floor=%2$s";
    /**
     * 美食类型下拉列表
     */
    //String FOOD_TYPE = MAIN_PATH + "/catering/foodtype";
    /**
     * 优惠券主接口
     */
    String COUPON_PORT = MAIN_PATH + "/coupon";
    /**
     * 优惠券类型-下拉列表
     */
    String COUPON_TYPE = COUPON_PORT + "/type";
    /**
     * 优惠券类型-我的券包列表
     */
    String COUPON_TYPEINFO = COUPON_PORT + "/typeinfo";

    /**
     * 优惠券详细
     */
    String COUPON_DETAIL = USER + "/%1$s/coupons/%2$s";
    /**
     * 优惠券分类
     */
    String COUPON_CAT = COUPON_PORT + "/category";
    /**
     * 优惠券列表接口
     */
    String COUPON_LIST = COUPON_PORT + "/list";
    /**
     * 代金券购买
     */
    String COUPON_VOUCHER_BUY = COUPON_PORT + "/%1$s/buy/%2$s?count=%3$s";
    /**
     * 订单详情
     */
    String ORDER_DETAIL = MAIN_PATH + "/member/%1$s/orders/%2$s";
    /**
     * 放弃支付订单，http DELETE
     */
    String ORDER_FORGIVE = MAIN_PATH + "/member/%1$s/orders/%2$s";

    /**
     * 优惠券退款（单个）
     */
    String ORDER_REFUND = MAIN_PATH + "/member/%1$s/coupons/%2$s";
    /**
     * 退款详情
     */
    String ORDER_REFUND_DETAIL = MAIN_PATH + "/member/%1$s/orders/refund/%2$s";
    /**
     * 活动列表接口
     */
    String ACTIVITY_LIST = ACTICITY_PORT + "/list";
    /**
     * 活动详情接口
     */
    String ACTIVITY_INFO = ACTICITY_PORT + "/%1$s";

    String ACTIVITY_CAN = ACTICITY_PORT + "/%1$s/enterfor";

    /**
     * 活动类型
     */
    String ACTIVITY_TYPE = ACTICITY_PORT + "/type";
    /**
     * 获取停车费
     */
    String PARKING = MAIN_PATH + "/parking/member/bill";
    /**
     * 停车费缴费接口
     */
    String PARKING_PAY = MAIN_PATH + "/parking/member/payment";
    /**
     * 查询停车费到积分的兑换
     */
    String CREDIT_EXCHANGE = MAIN_PATH + "/parking/credit/exchange";
    /**
     * app更新设备信息接口
     */
    String DEVICE_TOKEN = MAIN_PATH + "/app/device";
    /**
     * 礼品兑换历史
     */
    String GIFT_HISTORY = MAIN_PATH + "/member/%1$s/gift/history";

    /**
     * 美食详情
     */
    String W_FOOD_DETAIL = W_MAIN + "/food/#/info/";
    /**
     * 我的门票详情
     */
    String W_MENPIAO_DETAIL = W_MAIN + "/skating/#/coupon/info/";
    /**
     * 积分商城页面地址
     */
    String INTEGRAL_MALL_URL = W_MAIN + "/pointsmall";
    /**
     * 首页搜索
     */
    String HOME_SEARCH = MAIN_PATH + "/home/search?keyword=%1$s&pagesize=%2$s";
    /**
     * 自助积分-商户查询
     */
    String SELFCREDIT_SHOP = MAIN_PATH + "/pos/push/getshoplist?shopname=";
    /**
     * 自助积分-支持自助积分的商户列表
     */
    String SELFCREDIT_GETPOSSHOP = MAIN_PATH + "/pos/push/getposshop";
    /**
     * 自助积分-POS水单查询
     */
    String SELFCREDIT_POSINFO = MAIN_PATH + "/pos/push/checksingle?saleno=%1$s&date=%2$s&shopid=%3$s&amount=%4$s";
    /**
     * 自助积分-兑换积分接口
     */
    String SELFCREDIT_POSTDATA = MAIN_PATH + "/pos/push/set/{billId}/{cardCode}/{status}?type={type}";

    /**
     * 淘精品
     */
    String W_GOODS = W_MAIN + "/goods";
    /**
     * 商品详情界面（页面）
     */
    String W_GOODS_DETAIL = W_MAIN + "/goods/#/info/";
    /**
     * 活动详情页面
     */
    String W_ACTIVITY_DETAIL = W_MAIN + "/active/#/info/";
    /**
     * 优惠券详情页面（页面）
     */
    String W_COUPON_DETAIL = W_MAIN + "/coupon/#/info/";

    /**
     * 礼品券详情
     */
    String W_GIFT_COUPON_DETAIL = W_MAIN + "/user/#/coupon/gift/";
    /**
     * 礼品详情
     */
    String W_GIFT_DETAIL = W_MAIN + "/jifen/#/gift/";

    /**
     * 我的优惠券详情
     */
    String W_USER_COUPON_DETAIL = W_MAIN + "/user/#/coupon/";
    /**
     * 品牌详情（页面）
     */
    String W_BRAND = W_MAIN + "/brand/#/info/";

    /**
     * 商铺详情（页面）
     */
    String W_SHOP_DETAIL = W_MAIN + "/shop/#/info/";
    /**
     * 商铺列表
     */
    String W_SHOP_LIST = W_MAIN + "/shop/";

    /**
     * 电影
     */
    String W_MOVIE = "http://m.gewara.com/touch/choiceMovie.xhtml?cid=85295732";

    /**
     * 冰场
     */
    String W_SKATE = W_MAIN + "/skating/";
    /**
     * 游戏
     */
    String W_GAME = W_MAIN + "/game/#/";
    /**
     * 停车缴费
     */
    String W_PARKING_FEE = W_MAIN + "/park/#/";
    /**
     * 停车预定
     */
    String W_PARKING_BOOK = W_MAIN + "/park/#/book";
    /**
     * 我的冰场门票
     */
    String W_SKATE_ORDER = W_MAIN + "/skating/#/order/record";
    /**
     * KTV
     */
    String W_KTV = W_MAIN + "/ktv/";

    /**
     * 我的KTV
     */
    String W_KTV_ORDER = W_MAIN + "/ktv/#/order/record";

    /**
     * KTV包厢类型
     */
    String KTV_ROOM_TYPES = MAIN_PATH + "/ktvonline/boxtype";
    /**
     * 酒吧取号设置
     */
    String BAR_BOOK_CONFIG = MAIN_PATH + "/bars/initbookconfig";
    /**
     * 美食排号
     */
    String W_FOOD_ORDER = W_MAIN + "/food/#/order/record";
    /**
     * 短信新接口
     */
    String SMS_MAIN = MAIN_PATH + "/smscaptcha";

    /**
     * 短信登录接口
     */
    String SMS_LOGIN = USER + "/smslogin";

    /**
     * 发送短信验证码
     */
    String SMS_SEND = SMS_MAIN + "/send";
    /**
     * 校验短信验证码
     */
    String SMS_RECEIVE = SMS_MAIN + "/verify";

    /**
     * 我的消息
     */
    String MY_NEWS = USER + "/1/news";

    /**
     * 我的卡包
     */
    String MY_CARD = USER + "/1/cards";
    /**
     * 会员注册
     */
    String USER_REGIST = USER + "/regist";
    /**
     * 会员登录
     */
    String USER_LOGIN = USER + "/login";
    /**
     * 微信登录接口
     */
    String USER_WXLOGIN = USER + "/wxlogin";
    /**
     * 积分和临时积分
     */
    String W_INTERAL_DESCRIBE = W_MAIN + "/credits/describe.html";
    /**
     * 怎样消耗积分
     */
    String W_INTERAL_HOW = W_MAIN + "/credits/how.html";
    /**
     * 怎样获得积分
     */
    String W_INTERAL_MAKE = W_MAIN + "/credits/make.html";
    /**
     * LOAD JAVASCRIPT
     */
    String W_LOADJS = W_MAIN + "/loadjs.html";
    /**
     * 签到规则页面
     */
    String W_RULE_SIGNIN = W_MAIN + "/user/#/signinrule";
    /**
     * 摇一摇规则页面
     */
    String W_RULE_SHAKE = W_MAIN + "/shake/#shakerule";
    /**
     * 摇一摇中奖记录
     */
    String W_SHAKE_PRIZELIST = W_MAIN + "/shake/#/record/%1$s";

    /**
     * 上传定位信息接口
     */
    String API_UPLOAD_LOCATION = MAIN_PATH + "/member/upload/position";
    /**
     * 在线服务
     */
    String W_ONLINE_SERVICE = W_MAIN + "/service/#/";

    /**
     * 用户系统信息列表
     */
    String API_MEMBER_SYSTEM_MESSAGE_LIST = MAIN_PATH + "/member/%1$s/news";
    /**
     * 用户更新通知消息状态
     * 方式 PUT
     */
    String API_MEMBER_SYSTEM_MESSAGE_STATUS = MAIN_PATH + "/member/%1$s/news";
    /**
     * 用户系统信息数目
     */
    String API_MEMBER_SYSTEM_MESSAGE_COUNT = MAIN_PATH + "/member/%1$s/news/count";
    /**
     * 在线客服未读数目
     */
    String API_MEMBER_KF_UNREAD_COUNT = MAIN_PATH + "/member/%1$s/kf/unread/count?lastId=%2$s";
    /**
     * 客服语音上传
     */
    String API_SOUND_UPLOAD = MAIN + "/upload/file/upload";
    /**
     * 修改手机号
     * PUT
     */
    String SAVE_PHONE = USER + "/phone";
    /******************************** 网络地址 *****************************************/

    /******************************** 地图接口begin *****************************************/
    /**
     * 定位接口
     */
    String MAP_LOCATION_URL = MAP_SERVER + "/navigation?signaling=2";
    /**
     * 路线接口
     */
    String MAP_NAVIGATIONLINE_URL = MAP_SERVER
            + "/navigation?signaling=1";
    /**
     * 路线接口
     */
    String MAP_NAVIGATIONLINE_POINT_URL = MAP_SERVER
            + "/navigation?signaling=4";
    /**
     * 用户当前区域的接口
     */
    String AREA_API = MAP_SERVER
            + "/navigation?signaling=3&mac=%1$s";
    /**
     * 空车位接口
     */
    String PARKING_EMPTY_API = MAIN_MAP_PATH + "/parking/empty?area=%1$s&floor=%2$s";
    /**
     * 空车位数量接口
     */
    String PARKING_EMPTY_COUNT_API = MAIN_MAP_PATH + "/parking/empty/count";
    /**
     * 地图版本接口
     */
    String MAPINFO_API = MAIN_MAP_PATH + "/system/mapinfo/";
    /**
     * 地图版本接口-DES
     */
    String MAPINFO_API_DES = MAIN_MAP_PATH + "/system/desMapInfo/";
    /**
     * 地图版本接口-是否使用DES接口
     */
    Boolean MAPINFO_API_USEDES = true;
    /**
     * 心跳地址
     */
    String MAP_HEARTBEAT = MAP_HOST_PRIVATENETWORK + "/jingfengMapServer/map.html";
    /**
     * 获取某分店的楼层清单,
     * mallId参数这里先不传
     */
    //String API_FLOOR_LIST = MAIN_PATH + "/shop/floors";
    /**
     * 获取某分店的楼层清单
     */
    String API_FLOOR_CONFIG_LIST = MAIN_MAP_PATH + "/system/floor/%1$s";
    /******************************** 地图接口end *****************************************/
    /**
     * 根据环信的username查询用户头像等信息
     */
    String API_IM_USERNAME_IFNO = MAIN_PATH + "/im/%1$s";
    /**
     * 根据商户人员的id去查环信影虎头像等信息
     */
    String API_IM_SHOP_USERNAME_IFNO = MAIN_PATH + "/im/shop/%1$s/username";
    /**
     * 逛街足记新增
     * 方式 POST
     */
    String API_SHOPPING_GUANGJIE_ADD = MAIN_PATH + "/shopping/timeline";
    /**
     * 逛街足记修改
     * 方式 PUT
     */
    String API_SHOPPING_GUANGJIE_EDIT = MAIN_PATH + "/shopping/timeline/%1$s";
    /**
     * 逛街足记列表
     * 方式 POST
     */
    String API_SHOPPING_GUANGJIE_LIST = MAIN_PATH + "/shopping/timeline/member/%1$s?keyword=%2$s";
    /**
     * 获取用户的聊天用户名
     */
    String API_IM_USERNAME_MEMBER = MAIN_PATH + "/im/member/%1$s/username";
    /**
     * 搜索热词推荐
     */
    String API_SEARCH_HOTWORD = MAIN_PATH + "/home/search/hotwords";
    /**
     * 欣荣短信发送
     */
    String API_XR_SMSSEND = "https://%1$s/authentication/?AN=%2$s&MAC=%3$s&SID=3XXXXXXXXXXXXX";
    /**
     * 欣荣短信校验
     */
    String API_XR_SMSAUTH = "https://%1$s/authorization/?AN=%2$s&MAC=%3$s&PW=%4$s&SID=3XXXXXXXXXXXXX";
    /**
     * 欣荣分店wifi认证
     */
    String API_XR_MALLAUTH = "https://%1$s/authorization/?AN=%2$s&MAC=%3$s&PW=%4$s&SID=3XXXXXXXXXXXXX";
    /**
     * 百度地图的geocoder接口
     */
    String API_BAIDU_GEOCODER = "http://api.map.baidu.com/geocoder/v2/?ak=BbPEgVgKTkmd17wnQo15ArFT&callback=renderReverse&location=%1$s,%2$s&output=json&pois=1";
    /**
     * 品牌列表
     */
    String API_BRAND_LIST = MAIN_PATH + "/brand/all";
    /**
     * 品鉴类别列表
     */
    String API_PINJIAN_TYPE_LIST = MAIN_PATH + "/news/types";
    /**
     * 餐厅楼层
     */
    String API_RESTAURANTS_FLOOR_LIST = MAIN_PATH + "/catering/restaurants/floors";
    /**
     * 餐厅类型列表
     */
    String API_RESTAURANTS_TYPE_LIST = MAIN_PATH + "/catering/restaurants/types";
    /**
     * 餐厅楼宇列表
     */
    String API_RESTAURANTS_BUILDING_LIST = MAIN_PATH + "/catering/restaurants/buildings";
    /**
     * 餐厅列表
     */
    String API_RESTAURANTS_LIST = MAIN_PATH + "/catering/restaurants?type=%1$s&city=&area=&floorid=%2$s&buildingId=%3$s";
    /**
     * 餐厅详情
     */
    String API_RESTAURANTS_INFO = MAIN_PATH + "/catering/restaurants/%1$s";
    /**
     * 餐厅订座接口
     * POST
     */
    String API_RESTAURANTS_BOOK = MAIN_PATH + "/catering/restaurants/%1$s/tables/book";
    /**
     * 订座历史
     */
    String API_RESTAURANTS_BOOK_LIST = MAIN_PATH + "/member/%1$s/catering/book";
    /**
     * 商户评论接口
     * POST
     */
    String API_COMMENT_SHOP = MAIN_PATH + "/shop/%1$s/comments";
    /**
     * 商户评论列表
     */
    String API_COMMENT_SHOP_LIST = MAIN_PATH + "/shop/%1$s/comments";
    /**
     * 餐厅评论接口
     * POST
     */
    String API_COMMENT_RESTAURANT = MAIN_PATH + "/catering/restaurants/%1$s/comments";
    /**
     * 餐厅评论列表
     */
    String API_COMMENT_RESTAURANT_LIST = MAIN_PATH + "/catering/restaurants/%1$s/comments";
    /**
     * 点菜订单提交
     */
    String API_DISHES_ORDER_POST = MAIN_PATH + "/catering/dishesorders";
    /**
     * 获取菜品详情
     */
      String API_DISHE_DETAILS = MAIN_PATH + "/catering/dishes/%1$s";
    /**
     * 会员点菜订单列表
     */
    String API_MEMBER_DISHED_ORDER_LIST = MAIN_PATH + "/member/%1$s/catering/dishesorders";
    /**
     * 会员点菜订单详情
     */
    String API_MEMBER_DISHED_ORDER_DETAIL = MAIN_PATH + "/catering/dishesorders/%1$s";
    /**
     * 会员点菜订单状态修改（status 3删除）
     * PUT
     */
    String API_MEMBER_DISHED_ORDER_STATUS = MAIN_PATH + "/catering/dishesorders/%1$s/status";
    /**
     * 获取用户申请会员卡进度
     * 方式 GET
     */
    String API_MEMBER_APPLY_CARD_STATUS = MAIN_PATH + "/member/%1$s/mall/crm/vipcard/apply/progress";
    /**
     * 获取收藏的店铺
     * GET
     */
    String API_MEMBER_COLLECT_SHOP = MAIN_PATH + "/member/%1$s/shops?page=%2$s&pagesize=20";
    /**
     * 获取收藏的商品
     */
    String API_MEMBER_COLLECT_PRODUCT = MAIN_PATH + "/member/%1$s/goods?page=%2$s&pagesize=20";
    /**
     * 商品收藏
     */
    String API_PRODUCT_CARE = MAIN_PATH + "/eshop/goods/%1$s/care/%2$s";
    /**
     * 取消商品的收藏
     */
    String API_PRODUCT_NO_CARE = MAIN_PATH + "/eshop/goods/%1$s/uncare/%2$s";
    /**
     * 秒杀商品详情
     */
    String API_SECKILL_PRODUCT_DETAILS = MAIN_PATH + "/eshop/goods/%1$s/skus/%2$s";
    /**
     * 商户的活动列表
     */
    String SHOP_ACTIVE_LIST = MAIN_PATH + "/shop/%1$s/activities";
    /**
     * 商户的商品列表
     */
    String SHOP_GOODS_LIST = MAIN_PATH + "/shop/%1$s/goods";
    /**
     * 查询用户美食广场订单信息
     */
    String API_MINE_FOOD_ORDERS = MAIN_PATH + "/foodplaza/orders/%1$s/orderinfo?status=%2$s&page=%3$s&type=%4$s&pagesize=20";
    /**
     * 查询用户美食广场订单详情
     */
    String API_MINE_FOOD_ORDERS_DETAIL = MAIN_PATH + "/foodplaza/orders/%1$s/orderinfo?orderId=%2$s&";
    /**
     * 查询用户订单列表
     */
    String API_MINE_ORDERS = MAIN_PATH + "/member/%1$s/orders?status=%2$s&page=%3$s&type=%4$s&pagesize=20";
    /**
     * 确认收货
     * DELETE
     */
    String API_SURE_ORDER = MAIN_PATH + "/orders/%1$s/takedelivery";
    /**
     * 取消订单
     * DELETE
     */
    String API_CANCEL_ORDER = MAIN_PATH + "/orders/%1$s";

    /**
     * 订单退款
     */
    String API_REFUND_ORDER = MAIN_PATH + "/orders/%1$s/refund";
    /**
     * 订单详情
     */
    String API_ORDER_DETAIL = MAIN_PATH + "/orders/%1$s";
    /**
     * 商铺地图地址
     */
    String API_SHOP_LOCATION = MAIN_PATH + "/shop/%1$s/location";
    /**
     * 获取APP中展示的文本
     */
    String API_APP_TEXT = MAIN_PATH + "/app/text?type=%1$s&subType=%2$s";
    /**
     * 请求服务器生成验证码
     */
    String API_VERIFY_CODE = MAIN_PATH + "/captcha/numbers?captchaId=%1$s";

    //****************************************在线商城相关接口***************************************
    /**
     * 在线商城首页
     */
    String API_ESHOP_HOME = MAIN_PATH + "/eshop/home";
    /**
     * 限时抢购
     */
    String API_ESHOP_SECKILLS_LIST = MAIN_PATH + "/eshop/seckills";
    /**
     * 秒杀详情
     */
    String API_SECKILL_DETAIL = MAIN_PATH + "/eshop/seckills/%1$s";
    /**
     * 获取商品详情
     */
    String SHOP_GOOD_DETAIL = MAIN_PATH + "/eshop/goods/%1$s";
    /**
     * 主题详情
     */
    String API_ESHOP_SUBJECT_INFO = MAIN_PATH + "/eshop/subjects/%1$s";
    /**
     * 主体下商品列表
     */
    String API_ESHOP_SUBJECT_GOODS_LIST = MAIN_PATH + "/eshop/subjects/%1$s/goods";
    /**
     * 淘精品-类别列表
     */
    String GOODS_LIST_TYPE = MAIN_PATH + "/eshop/goods/type";
    /**
     * 淘精品列表-全部
     */
    String GOODS_LIST_HOT = MAIN_PATH + "/eshop/goods/list?sortby=&discount=false&needprice=false";
    /**
     * 获取团购栏目列表
     */
    String COLUMN_LIST_GROUP = MAIN_PATH + "/eshop/columns?";
    /**
     * 淘精品列表-最新
     */
    String GOODS_LIST_NEW = MAIN_PATH + "/eshop/goods/list?sortby=date&discount=false&needprice=false";
    /**
     * 淘精品列表-优惠
     */
    String GOODS_LIST_DISCOUNT = MAIN_PATH + "/goods/list?sortby=discount&discount=true&needprice=false";
    /**
     * 商城-购物车商品数量增减PUT
     */
    String ESHOP_CART_ITEM_COUNT_MODIFY = MAIN_PATH + "/eshop/cart/items/%1$s/count";
    /**
     * 商城-购物车商品删除DELETE
     */
    String ESHOP_CART_ITEM_DELETE = MAIN_PATH + "/eshop/cart/items/%1$s";
    /**
     * 商城，将购物车ID绑定只用户PUT
     */
    String ESHOP_CART_BINDTOMEMBER = MAIN_PATH + "/eshop/cart/%1$s";
    /**
     * 商城，根据用户ID查询购物车
     */
    String ESHOP_CART_MEMBERCART = MAIN_PATH + "/member/%1$s/eshop/cart";
    /**
     * 商城-购物车内商品列表
     */
    String ESHOP_CART_ITEMLIST = MAIN_PATH + "/eshop/cart/%1$s/list";
    /**
     * 商城-购物车内商品数目
     */
    String ESHOP_CART_ITEMCOUNT = MAIN_PATH + "/member/%1$s/eshop/cart/items/count";
    /**
     * 秒杀提交POST,不用这个，用前面接口返回的seckillUrl字段
     */
    //String ESOP_SECKILL_POST = MAIN_PATH + "/eshop/seckills/%1$s/goods/%2$s/kill";
    /**
     * 根据Token查询秒杀状态
     */
    String ESOP_SECKILL_STATUS = MAIN_PATH + "/eshop/seckills/killing/%1$s/queue/status";
    /**
     * 放弃下单DELETE
     */
    String ESOP_SECKILL_FANGQI = MAIN_PATH + "/eshop/seckills/killing/%1$s/queue";
    /**
     * 根据skuid获取详情
     */
    String ESOP_SECKILL_INFO = MAIN_PATH + "/eshop/seckills/%1$s";
    //****************************************在线商城相关接口***************************************

    //****************************************积分商城相关接口***************************************
    /**
     * 积分商城列表接口
     */
    String GIFT_LIST = MAIN_PATH + "/cshop/gifts/list?type=%1$s&credit=%2$s";
    /**
     * 积分商城礼品详情接口
     */
    String GIFT_INFO = MAIN_PATH + "/cshop/gifts/%1$s";
    /**
     * 积分商城-礼品套装列表
     */
    String GIFT_SUIT_LIST = MAIN_PATH + "/cshop/gifts/suits";
    /**
     * 积分商城-礼品套装详情
     */
    String GIFT_SUIT_INFO = MAIN_PATH + "/cshop/gifts/suits/%1$s";
    /**
     * 积分商城-类别列表
     */
    String GIFT_TYPE = MAIN_PATH + "/cshop/gifts/types";
    /**
     * 积分商城-添加至购物车POST
     */
    String GIFT_CART_ADD = MAIN_PATH + "/cshop/cart";
    /**
     * 积分商城-购物车商品数量增减PUT
     */
    String GIFT_CART_ITEM_COUNT_MODIFY = MAIN_PATH + "/cshop/cart/items/%1$s/count";
    /**
     * 积分商城-购物车商品删除DELETE
     */
    String GIFT_CART_ITEM_DELETE = MAIN_PATH + "/cshop/cart/items/%1$s";
    /**
     * 积分商城，将购物车ID绑定只用户PUT
     */
    String GIFT_CART_BINDTOMEMBER = MAIN_PATH + "/cshop/cart/%1$s";
    /**
     * 积分商城，根据用户ID查询购物车
     */
    String GIFT_CART_MEMBERCART = MAIN_PATH + "/member/%1$s/cshop/cart";
    /**
     * 积分商城-购物车内商品列表
     */
    String GIFT_CART_ITEMLIST = MAIN_PATH + "/cshop/cart/%1$s/list";
    /**
     * 积分商城-购物车内商品数目
     */
    String GIFT_CART_ITEMCOUNT = MAIN_PATH + "/member/%1$s/cshop/cart/items/count";
    /**
     * 积分商城-购物车提交到订单POST
     */
    String GIFT_CART_ORDER = MAIN_PATH + "/cshop/orders";
    /**
     * 会员收货地址 ,是一个列表
     * get
     */
    String API_MEMBER_DELIVERY_ADDRESS_INFO = MAIN_PATH + "/member/%1$s/delivery/addresses";
    /**
     * 会员收货地址 ,修改
     * PUT
     */
    String API_MEMBER_DELIVERY_ADDRESS_EDIT = MAIN_PATH + "/member/%1$s/delivery/addresses/%2$s";
    /**
     * 会员收货地址，新增
     * POST
     */
    String API_MEMBER_DELIVERY_ADDRESS_ADD = MAIN_PATH + "/member/%1$s/delivery/addresses";

    /**
     * 更改商品的选中状态
     */
    String GIFT_CHECK_UTL = MAIN_PATH + "/cshop/cart/items/checked";
    //****************************************积分商城相关接口***************************************

    //*****************************************订单支付**********************************************
    /**
     * 订单支付
     */
    String API_ORDER_PAY = MAIN_PATH + "/orders/%1$s/pay";
    /**
     * 客户端支付完成后主动通知服务器
     */
    String API_ORDER_NOTIFY_BYAPP = MAIN_PATH + "/orders/%1$s/notify";
    //*****************************************订单支付**********************************************

    //****************************************网页模版相关接口***************************************
    /**
     * 网页模版清单
     */
    String API_TEMPLATES_LIST = MAIN_PATH + "/system/pagetemplates";
    /**
     * 网页模版更新接口，传入模版ID和上次更新的版本号
     */
    String API_TEMPLATES_VERSIONUPDATE = MAIN_PATH + "/system/pagetemplates/%1$s/update?version=%2$s";
    /**
     * 网页模版所有页面列表
     */
    String API_TEMPLATES_PAGES_HTML_LIST = MAIN_PATH + "/system/pagetemplates/pages";

    //****************************************网页模版相关接口***************************************

    //****************************************会员卡相关接口***************************************
    /**
     * 申请会员卡
     * POST
     */
    String API_APPLY_MEMBERCARD = MAIN_PATH + "/member/%1$s/mall/crm/vipcard/apply";
    //****************************************会员卡相关接口***************************************

    //****************************************服务相关接口***************************************
    /**
     * 会员可用服务列表
     */
    String API_MEMBER_SERVICE_LIST = MAIN_PATH + "/mall/services/list?mid=%1$s";
    /**
     * 会员服务预订POST
     */
    String API_MEMBER_SERVICE_BOOK = MAIN_PATH + "/mall/services/%1$s/book/%2$s";
    /**
     * 获取失物通告列表
     */
    String API_MEMBER_SERVICE_LOST_NOTICE_LIST = MAIN_PATH + "/mall/services/list/lostnotices";
    /**
     * 获取服务所需的元素
     */
    String API_MEMBER_SERVICE_ITEM_TYPE_LIST = MAIN_PATH + "/mall/services/list/%1$s/items";

    /**
     * 预借童车轮椅提交接口
     * POST
     */
    String API_MEMBER_SERVICE_BOOK_CHAIRS = MAIN_PATH + "/mall/services/chair/book/%1$s";

    /**
     * KTV包厢预定
     */
    String API_BOOK_KTV_ROOM = MAIN_PATH + "/ktvonline/book";
    /**
     * 酒店预订
     */
    String API_BOOK_HOTEL_ROOM = MAIN_PATH + "/jingfeng/hotel/book";
    /**
     * 酒吧排号
     */
    String API_BOOK_BAR = MAIN_PATH + "/bars/booking";
    /**
     * 取消排号
     */
    String API_BAR_CANCEL_BOOK = MAIN_PATH + "/bars/cancel";
    /**
     * 取消KTV预约
     */
    String API_KTV_CANCEL_BOOK = MAIN_PATH + "/ktvonline/book?id=%1$s";
    /**
     * 取消酒店预约
     */
    String API_HOTEL_CANCEL_BOOK = MAIN_PATH + "/jingfeng/hotel/book/%1$s";
    /**
     * 取消会员服务预约
     * DELETE
     */
    String API_MEMBER_SERVICE_CANCEL = MAIN_PATH + "/mall/services/%1$s/book/%2$s/%3$s";

    /**
     * 查询已预借童车轮椅接口
     * GET
     */
    String API_MEMBER_SERVICE_BOOKED_CHAIRS = MAIN_PATH + "/mall/services/book/chair/%1$s?page=%2$s&pagesize=20";

    /**
     * 查询我的酒吧排号
     */
    String API_MINE_BAR_BOOKS = MAIN_PATH + "/bars/bookrecord/%1$s/list?mallId=1&status=&page=%2$s";
    /**
     * 查询酒店房间类型
     */
    String API_HOTEL_ROOMS = MAIN_PATH + "/jingfeng/hotel/roomtype";
    /**
     * 查询酒店房间价格
     */
    String API_HOTEL_PRICE = MAIN_PATH + "/jingfeng/hotel/roomprice?stayDays=%1$s&typeId=%2$s&reachDate=%3$s";
    /**
     * 酒店预订列表
     */
    String API_HOTEL_BOOK_LIST = MAIN_PATH + "/jingfeng/hotel/book/list?memberId=%1$s&starttime=%2$s&endtime=%3$s";

    /**
     * 娱乐页面显示项
     */
    String API_YULE_ITEM_LIST = MAIN_PATH + "/entertainment/home";
    /**
     * 查询我的KTV预约
     */
    String API_MINE_KTV_BOOKS = MAIN_PATH + "/ktvonline/book/list?memberId=%1$s&startTime&endTime=%2$s";

    /**
     * 用户自助积分记录
     */
    String API_MEMBER_SELF_CREDIT_RECORD = MAIN_PATH + "/member/%1$s/mall/crm/credits/selfadd/records?page=%2$s&pagesize=20";

    /**
     * 用户近一个月预订的服务
     */
    String API_MEMBER_BOOKED_SERVICE = MAIN_PATH + "/mall/services/%1$s/book/%2$s?page=%3$s&pagesize=20";
    /**
     * 获取我的报名
     */
    String API_MEMBER_ENROLLED = MAIN_PATH + "/member/%1$s/enterfor?page=%2$s&pagesize=20";
    /**
     * 我的券包
     * GET
     */
    String API_MEMBER_COUPONS = MAIN_PATH + "/member/%1$s/coupons";
    /**
     * 用户近一个月预订的服务数量
     * get
     */
    String API_MEMBER_BOOKED_SERVICE_COUNT = MAIN_PATH + "/mall/services/all/counts/%1$s";
    /**
     * 自助积分
     * POST
     */
    String API_MEMBER_SELF_CHARGE_CREDIT = MAIN_PATH + "/member/%1$s/mall/crm/credits";
    /**
     * 查询礼品兑换历史
     * GET
     */
    String API_MEMBER_EXCHANGE_RECORD = MAIN_PATH + "/member/%1$s/cshop/exchange/records";
    //****************************************服务相关接口***************************************

    //****************************************优惠券相关接口***************************************
    /**
     * 优惠券接口
     */
    String API_COUPON_TYPE = MAIN_PATH + "/coupon/type";
    /**
     * 优惠券类别
     */
    String API_COUPON_CATEGORY = MAIN_PATH + "/coupon/category";
    /**
     * 优惠券列表
     */
    String API_COUPON_LIST = MAIN_PATH + "/coupon/list?page=%1$s&pagesize=10&type=%2$s&category=%3$s&sortby=%4$s";
    /**
     * 优惠券列表
     */
    String API_SHOP_COUPON_LIST = MAIN_PATH + "/shop/%1$s/coupons?page=%2$s&pagesize=10&type=%3$s&keywork=%4$s&promotionFlag=%5$s";
    /**
     * 优惠券详情
     */
    String API_COUPON_INFO = MAIN_PATH + "/coupon/%1$s";
    /**
     * 在线客服，常见问题接口
     */
    String API_KF_ANSWERS = MAIN_PATH + "/kf/faq/list?questionNumber=&&question=%1$s";
    /**
     * 获取扫描单号支付
     */
    String GET_SCAN_ORDER_INFO = POS_MAIN_PAHT + "/mpos/heading/ewallet/query?sn=%1$s";

    /**
     * 支付账单
     */
    String PAY_SCAN_ORDER_INFO = POS_MAIN_PAHT + "/mpos/heading/ewallet/pay";
    //****************************************优惠券相关接口***************************************
    //获取会员VIP卡信息
    String API_VIPCARD_INFO = MAIN_PATH + "/member/%1$d/mall/crm/vipcard";

    /**
     * wifi用户开户
     */
    String OPEN_WIFI_USER = MAIN + "/wifiportal/app/addwifiuser";

    //****************************************儿童手环相关接口***************************************
    /**
     * 获取儿童手环信息
     */
    String GET_CHILD_BRACELET = MAIN_PATH + "/member/%1$s/childwatch";
    /**
     * 修改儿童手环的绑定手机号
     */
    String REPLACE_CHILD_BRACELET_PHONE = MAIN_PATH + "/member/%1$s/childwatch/phone";

    //****************************************小米推送相关配置Start***************************************
    String MIPUSH_APP_ID = "2882303761517504716";
    String MIPUSH_APP_KEY = "5101750439716";
    //****************************************小米推送相关配置End***************************************

}
