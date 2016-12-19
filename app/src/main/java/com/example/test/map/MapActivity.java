package com.example.test.map;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.animation.RotateAnimation;
import com.example.test.R;
import com.example.test.views.LocationView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MapActivity extends Activity implements AMap.OnMarkerClickListener, AMap.OnMapClickListener, AMap.OnPOIClickListener {

    private MapView mMapView;
    private AMap mMap;
    private boolean isFirstLocation = true;

    //方向传感器有三个坐标，现在只关注X
    private float mLastX;
    private Marker locationMarker = null;
    private LocationView mLocImageView;
    private float preDegree = -45;
    private float degree = 0;
    private RotateAnimation animation;
    private SensorManager mSensorManager;
    private Sensor sensor;
    private SensorEventListener mSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            /**
             * values[0]: x-axis 方向加速度
             * values[1]: y-axis 方向加速度
             * values[2]: z-axis 方向加速度
             */
//            float Ax = event.values[0];
//            float Ay = event.values[1];
//            float Az = event.values[2];
//            double α1 = Math.atan(Ax / Math.sqrt(Ay * Ay + Az * Az));
//
//            float degree = (float) (α1 * 180 / Math.PI);
            float degree = event.values[0];
            if (Math.abs(preDegree - degree) > 2) {
                if (locationMarker != null) {
//                    animation = new RotateAnimation(preDegree, degree,
//                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                    animation.setFillAfter(true);
//                    mLocImageView.startAnimation(animation);
                    animation = new RotateAnimation(degree, preDegree);
                    animation.setDuration(500);
                    preDegree = -degree;
                    locationMarker.setAnimation(animation);
                    locationMarker.startAnimation();

                }

//                Log.e("sensor=", String.valueOf(degree));
//                Log.e("degree<1=", String.valueOf(degree < 1));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
    //声明AMapLocationClient类对象
    private AMapLocationClient mLocationClient = null;
    private MarkerOptions mLocationMarker;
    private BitmapDescriptor bitmapDescriptor;
    private AMapLocationListener   //声明定位回调监听器
            mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (isFirstLocation) {
                    isFirstLocation = false;
                    double lat = amapLocation.getLatitude();
                    double lon = amapLocation.getLongitude();
                    // 设置当前地图显示为当前位置
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 19));
                    mLocationMarker = new MarkerOptions();
                    mLocationMarker.position(new LatLng(lat, lon));
                    mLocationMarker.title("当前位置");
                    mLocationMarker.visible(true);
                    bitmapDescriptor = BitmapDescriptorFactory.
                            fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_north));
                    mLocationMarker.icon(bitmapDescriptor);
                    locationMarker = mMap.addMarker(mLocationMarker);

                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    };
    private AMapLocationClientOption mLocationClientOption = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mMapView = (MapView) findViewById(R.id.mMapView);
        mMapView.onCreate(savedInstanceState);
        init();
        initLocation();
        initSensor();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void init() {
        mMap = mMapView.getMap();
        mMap.setInfoWindowAdapter(mWindowAdapter);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
        mMap.setOnPOIClickListener(this);
    }

    private void initLocation() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        mLocationClientOption = new AMapLocationClientOption();
        mLocationClientOption.setGpsFirst(true);
        mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClientOption.setNeedAddress(true);
        mLocationClientOption.setInterval(1000);
        mLocationClient.setLocationOption(mLocationClientOption);
        mLocationClient.startLocation();

    }


    private void initSensor() {
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mLocImageView = new LocationView(MapActivity.this, null);
        mLocImageView.setImageResource(R.drawable.ic_map_north);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mLocationClient.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mLocationClient.stopLocation();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.disconnect();
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorEventListener);
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        mSensorManager.registerListener(mSensorEventListener, sensor, SensorManager.SENSOR_DELAY_GAME);
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.isInfoWindowShown()) {
            marker.hideInfoWindow();
        } else {
            marker.showInfoWindow();
        }
        return true;
    }

    @Override
    public void onMapClick(LatLng lng) {
        locationMarker.hideInfoWindow();
    }

    private LayoutInflater mInflater;

    AMap.InfoWindowAdapter mWindowAdapter = new AMap.InfoWindowAdapter() {
        @Override
        public View getInfoWindow(Marker marker) {
            mInflater = LayoutInflater.from(MapActivity.this);
            View view = mInflater.inflate(R.layout.map_info_window, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_info_icon);
            TextView title = (TextView) view.findViewById(R.id.tv_info_title);
            TextView descript = (TextView) view.findViewById(R.id.tv_info_descript);
            try {
                imageView.setImageBitmap(marker.getIcons().get(0).getBitmap());
            } catch (Exception e) {
                e.printStackTrace();
                imageView.setImageResource(R.mipmap.ic_launcher);
            }

            try {
                title.setText(marker.getTitle());
            } catch (Exception e) {
                title.setVisibility(View.INVISIBLE);
                e.printStackTrace();
            }
            try {
                descript.setText(marker.getSnippet());
            } catch (Exception e) {
                descript.setVisibility(View.INVISIBLE);
                e.printStackTrace();
            }
            return view;
        }

        @Override
        public View getInfoContents(Marker marker) {
            mInflater = LayoutInflater.from(MapActivity.this);
            View view = mInflater.inflate(R.layout.map_info_window, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_info_icon);
            TextView title = (TextView) view.findViewById(R.id.tv_info_title);
            TextView descript = (TextView) view.findViewById(R.id.tv_info_descript);
            try {
                imageView.setImageBitmap(marker.getIcons().get(0).getBitmap());
            } catch (Exception e) {
                e.printStackTrace();
            }

            title.setText(marker.getTitle());
            descript.setText(marker.getSnippet());
            return view;
        }
    };

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Map Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    @Override
    public void onPOIClick(Poi poi) {
        Toast.makeText(this, poi.getName(), Toast.LENGTH_SHORT).show();
//        poi.
    }
}
