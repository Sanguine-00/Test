package com.example.jingfeng.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jingfeng.android.adapter.MListAdapter;
import com.example.jingfeng.android.bean.APIHostInfo;
import com.example.jingfeng.android.bean.APIResultInfo;
import com.example.jingfeng.android.bean.Restaurant;
import com.example.test.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class CanTingActivity extends AppCompatActivity {

    private int mPage = 0;
    private int mPageSize = 20;
    private List<Restaurant> mListItems;
    private APIHostInfo apiHostInfo;
    private PullToRefreshListView mListView;
    private MListAdapter mListAdapter;
    private Spinner mSpinnerBuildingId, mSpinnerKewword;
    private boolean isHavaDate = true;
    public static String url = "http://192.168.0.13:8080/jingfeng/api/v1/catering/restaurants?city=&area=&buildingId=";
    private String floorId = "floorid=&";
    private String typeId = "type=&";
    ILoadingLayout startLabels = null;
    ILoadingLayout endLabels = null;
    private boolean isInit = true;


    private Animation mAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_ting);
        initView();
        resetPage();
        requestData();

    }


    private void initView() {
        mAnimation = AnimationUtils.loadAnimation(CanTingActivity.this, R.anim.list_anim);
        mListView = (PullToRefreshListView) this.findViewById(R.id.pull_refresh_list);
        mSpinnerBuildingId = (Spinner) findViewById(R.id.spinnerBuildingId);
        mSpinnerKewword = (Spinner) findViewById(R.id.spinnerKeyWord);
        mSpinnerBuildingId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> view, View view1, int i, long l) {
                switch (i) {
                    case 0:
                        floorId = "floorid=&";
                        break;
                    case 1:
                        floorId = "floorid=-1&";
                        break;
                    case 2:
                        floorId = "floorid=1&";
                        break;
                    case 3:
                        floorId = "floorid=2&";
                        break;
                    case 4:
                        floorId = "floorid=3&";
                        break;
                    case 5:
                        floorId = "floorid=4&";
                        break;
                    case 6:
                        floorId = "floorid=5&";
                        break;
                    case 7:
                        floorId = "floorid=8&";
                        break;
                }
//                refresh();
                Toast.makeText(CanTingActivity.this,
                        "选择的楼层是:" + view.getAdapter().getItem(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> view) {

            }
        });

        mSpinnerKewword.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> view, View view1, int i, long l) {
                switch (i) {
                    case 0:
                        typeId = "type=1&";
                        break;
                    case 1:
                        typeId = "type=2&";
                        break;
                    case 2:
                        typeId = "type=3&";
                        break;
                    case 3:
                        typeId = "type=4&";
                        break;
                    case 4:
                        typeId = "type=5&";
                        break;
                    case 5:
                        typeId = "type=6&";
                        break;
                }
//                refresh();
                Toast.makeText(CanTingActivity.this,
                        "选择的关键字是:" + view.getAdapter().getItem(i).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> view) {

            }
        });


        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mListView.setAnimation(mAnimation);


        startLabels = mListView.getLoadingLayoutProxy(true, false);
        endLabels = mListView.getLoadingLayoutProxy(false, true);

        startLabels.setRefreshingLabel("正在刷新...");
        startLabels.setReleaseLabel("释放开始刷新");

        endLabels.setRefreshingLabel("正在加载...");
        endLabels.setPullLabel("上拉刷新更多...");

        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                refresh();
//                Toast.makeText(CanTingActivity.this, "下拉刷新", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                loadMore();

//                Toast.makeText(CanTingActivity.this, "上拉加载", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void refresh() {
        resetPage();
        requestData();
    }

    private void loadMore() {
        mPage += 1;
        requestData();

    }

    private void resetPage() {
        mListItems = null;
        mListAdapter = null;
        mPage = 0;
    }

    private void requestData() {
        if (isHavaDate) {
            OkHttpUtils
                    .get()
                    .addParams("iPage", String.valueOf(mPage))
                    .addParams("iPageSize", String.valueOf(mPageSize))
                    .url(url.concat(typeId).concat(floorId))
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {

                        }

                        @Override
                        public void onResponse(Call call, String s) {
                            formatJson(s);
                        }
                    });
        }
    }

    private void formatJson(String mJson) {
        mListView.onRefreshComplete();
        if (mJson != null && !mJson.equals("")) {
            if (mListItems == null || mPage == 0) {
                mListItems = new ArrayList<>();
            }
            List<Restaurant> list = null;
            APIResultInfo<List<Restaurant>> apiInfo = new APIResultInfo<List<Restaurant>>();
            Gson gson = new Gson();
            apiInfo = gson.fromJson(mJson,
                    new TypeToken<APIResultInfo<List<Restaurant>>>() {
                    }.getType());
            list = apiInfo.getItems();
            apiHostInfo = apiInfo.getApiHostInfo();
            if (list == null || list.size() == 0) {
                isHavaDate = false;
            } else {
                mListItems.addAll(list);
                if (list.size() < mPageSize) {
                    isHavaDate = false;
                }
                if (mListAdapter == null) {
                    mListAdapter = new MListAdapter(mListItems, CanTingActivity.this, apiHostInfo);
                    mListView.getRefreshableView().setAdapter(mListAdapter);
                    mListAdapter.notifyDataSetChanged();
                } else {
                    mListAdapter.notifyDataSetChanged();
                }
            }


        } else {
            noMoreData();
        }
    }

    private void noMoreData() {
        Toast.makeText(this, "没有更多的数据", Toast.LENGTH_SHORT).show();

    }

    private void loadFinish() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }


    //本地数据测试
//    private void initLocalData() {
//
//        APIResultInfo<List<Restaurant>> info;
//        String json = "{'httpCode':200,'errorCode':0,'message':'成功了吗','display':false,'schema':'http','host':'192.168.0.13:8080','contextPath':'/jingfeng','isEncrypted':false,'items':[{'id':737,'name':'芭琪冰激淋(B101)','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'35','icon':'https://m.dejiplaza.com/zimgs/eebb9f65f034899754d7a28e000d4ccf?f=PNG','location':'[B101]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/81a6363b6af1124fab129d1a917c2464?f=JPEG'},{'id':742,'name':'茶客老站','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'26','icon':'https://m.dejiplaza.com/zimgs/33092fdba2a793b2276c46e9794dcdac?f=JPEG','location':'[B102]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/add77ba4b3149b48a262cc51313aa6bc?f=JPEG'},{'id':857,'name':'胖仙女GROSFAIRY','restaurantType':{'id':1,'name':'世界美食','nameEnglish':'world'},'icon':'https://m.dejiplaza.com/zimgs/ed32569b8a69b8d3fa154e468f0ab248?f=JPEG','location':'[B103]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/3b0a155e83b98c98fdc5f8ab1ec731d5?f=JPEG'},{'id':743,'name':'肯德基','restaurantType':{'id':5,'name':'咖啡/快餐','nameEnglish':'coffee'},'personConsumption':'30','icon':'https://m.dejiplaza.com/zimgs/202c1aaa4ba6b372f01ad4f1c9c8cc7f?f=JPEG','location':'[B105]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[{'floorId':8,'floorName':'8F','shopNumber':'B105','objectId':2049722725}],'doorImage':'https://m.dejiplaza.com/zimgs/9dc984c467b6d1e4a27854b2e0be02ae?f=JPEG'},{'id':744,'name':'宜芝多','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'38','icon':'https://m.dejiplaza.com/zimgs/b36ccc83d7a3604ff8ed0b0caaebe349?f=JPEG','location':'[B106]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/66fa1798110ed874d4b55a6a7fc26929?f=JPEG'},{'id':746,'name':'必胜客','restaurantType':{'id':5,'name':'咖啡/快餐','nameEnglish':'coffee'},'personConsumption':'68','icon':'https://m.dejiplaza.com/zimgs/08ce65b7f17ec3e6ffa3403b338cff8d?f=JPEG','location':'[B112]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/329c8ac7688b8e976465b5cd90f0d2d7?f=JPEG'},{'id':749,'name':'石打食','restaurantType':{'id':4,'name':'中式盛馔','nameEnglish':'chinese'},'personConsumption':'45','icon':'https://m.dejiplaza.com/zimgs/3e91780433444ebefed82d9ee935c05a?f=JPEG','location':'[B113]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/5437284da35bb309bc9732b226764135?f=JPEG'},{'id':750,'name':'澳门粥面庄','restaurantType':{'id':4,'name':'中式盛馔','nameEnglish':'chinese'},'personConsumption':'46','icon':'https://m.dejiplaza.com/zimgs/d61c2afb517218018006d11a0960cb46?f=JPEG','location':'[B115]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/84355477ed76d72b72bc8a5b23e15591?f=JPEG'},{'id':751,'name':'新石器烤肉','restaurantType':{'id':1,'name':'世界美食','nameEnglish':'world'},'personConsumption':'60','icon':'https://m.dejiplaza.com/zimgs/87254f5794e984ec535b1ddc314a475e?f=JPEG','location':'[B116]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/a6f94676d2fb377aa78dbac0b66aeb53?f=JPEG'},{'id':752,'name':'洋葱牛肉面馆','restaurantType':{'id':4,'name':'中式盛馔','nameEnglish':'chinese'},'personConsumption':'55','icon':'https://m.dejiplaza.com/zimgs/f2a4bcd5edd79a35b44907afe32432e7?f=JPEG','location':'[B118]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/f75caab780d7579b75195e16771f1e5a?f=JPEG'},{'id':753,'name':'洋葱咖喱','restaurantType':{'id':1,'name':'世界美食','nameEnglish':'world'},'personConsumption':'55','icon':'https://m.dejiplaza.com/zimgs/0c9fbc2d9b9008ecd07b39818204d7e8?f=JPEG','location':'[B119]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/751dfa1a445c91a73ef0d90a578924b3?f=JPEG'},{'id':756,'name':'布歌东京','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'130','icon':'https://m.dejiplaza.com/zimgs/291145c2716118942670bcee9fc7afed?f=JPEG','location':'[B120]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/cc5ce5216f900db1e0a3838c1729657d?f=JPEG'},{'id':754,'name':'星巴克(B130)','restaurantType':{'id':5,'name':'咖啡/快餐','nameEnglish':'coffee'},'personConsumption':'35','icon':'https://m.dejiplaza.com/zimgs/deea71bd9c3157acd6207c83ade14d0d?f=JPEG','location':'[B130]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/8032c26656d121109a492f559798bca6?f=JPEG'},{'id':755,'name':'芭琪可丽饼(B131)','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'35','icon':'https://m.dejiplaza.com/zimgs/d273d05b43ad47c70d0452a8f35c8024?f=PNG','location':'[B131]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/99b63751b7b37edd79669cbd0d71713a?f=JPEG'},{'id':856,'name':'鱼铺','restaurantType':{'id':1,'name':'世界美食','nameEnglish':'world'},'personConsumption':'66','icon':'https://m.dejiplaza.com/zimgs/bfd7adad93e2fa6378796b5d2b9486e7?f=JPEG','location':'[B133]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/3b0a155e83b98c98fdc5f8ab1ec731d5?f=JPEG'},{'id':759,'name':'米芝莲','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'15','icon':'https://m.dejiplaza.com/zimgs/396a5e8c22e888ed8c54b652c3269fad?f=JPEG','location':'[B135-1]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/12bb25a5dad815bec44609863292330f?f=JPEG'},{'id':763,'name':'乌云冰淇淋','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'45','icon':'https://m.dejiplaza.com/zimgs/98f589fdc60aba96241f0330b68d4dcf?f=JPEG','location':'[B136]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/5bf64c3ec47eab2fec043ee4d1d873d1?f=JPEG'},{'id':842,'name':'芭琪可丽饼(F416)','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'26','icon':'https://m.dejiplaza.com/zimgs/9f9c0ba537d249be6dbcd197ee091a21?f=JPEG','location':'[F416]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/419d95a3f9272325671206291a6439d3?f=JPEG'},{'id':733,'name':'洋葱','restaurantType':{'id':1,'name':'世界美食','nameEnglish':'world'},'personConsumption':'60','icon':'https://m.dejiplaza.com/zimgs/254c5e618d396b5b19f06238e5de3884?f=JPEG','location':'[F433]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/347c1d7b9afa4be45991cfeacf5f441b?f=JPEG'},{'id':735,'name':'芭琪冰激淋(F437)','restaurantType':{'id':3,'name':'零食美点','nameEnglish':'food'},'personConsumption':'40','icon':'https://m.dejiplaza.com/zimgs/40940275210cc02863c47b872a830703?f=JPEG','location':'[F437]','supportBookTable':false,'supportLineup':false,'supportDishesOrder':false,'restaurantNumbers':[],'doorImage':'https://m.dejiplaza.com/zimgs/26a06c454761bbb64cc10f2e236050fc?f=JPEG'}]}";
//        info = new Gson().fromJson(json,
//                new TypeToken<APIResultInfo<List<Restaurant>>>() {
//                }.getType());
//        if (mListItems == null) {
//            mListItems = new ArrayList<>();
//        }
//        List<Restaurant> list = info.getItems();
//        apiHostInfo = info.getApiHostInfo();
//        if (list == null || list.size() == 0) {
//            isHavaDate = false;
//        } else {
//            mListItems.addAll(list);
//            if (list.size() < mPageSize) {
//                isHavaDate = false;
//            }
//            if (mListAdapter == null) {
//                mListAdapter = new MListAdapter(mListItems, CanTingActivity.this, apiHostInfo);
//                mListView.getRefreshableView().setAdapter(mListAdapter);
//                mListAdapter.notifyDataSetChanged();
//            } else {
//                mListAdapter.notifyDataSetChanged();
//            }
//        }
//
//
//    }

}
