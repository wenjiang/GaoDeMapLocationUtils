package com.example.zwb.LocalUtils;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.location.core.AMapLocException;

/**
 * Created by zwb on 2015/6/24.
 */
public class LocationManager {
    private static String address;
    private static String addressCode;
    private static float accuracy;
    private static double altitude;
    private static AMapLocException aMapLocException;
    private static String city;
    private static String country;
    private static String district;
    private static float bearing;
    private static String cityCode;
    private static String floor;
    private static double latitude;
    private static double longitude;
    private static String poiId;
    private static String poiName;
    private static String province;
    private static String road;
    private static String street;
    private static AMapLocationListener listener;

    /**
     * 开始定位
     *
     * @param context     上下文
     * @param minTime     位置变化的通知时间，单位为毫秒，实际时间有可能长于或短于设定值 。参数设置为-1，为单次定位；反之为每隔设定的时间，都会触发定位请求。
     * @param minDistance 位置变化通知距离，单位为米。
     */
    public static void startLocation(Context context, long minTime, float minDistance) {
        listener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null && aMapLocation.getAMapException().getErrorCode() == 0) {
                    //获取位置信息
                    address = aMapLocation.getAddress();
                    addressCode = aMapLocation.getAdCode();
                    accuracy = aMapLocation.getAccuracy();
                    altitude = aMapLocation.getAltitude();
                    aMapLocException = aMapLocation.getAMapException();
                    city = aMapLocation.getCity();
                    country = aMapLocation.getCountry();
                    district = aMapLocation.getDistrict();
                    bearing = aMapLocation.getBearing();
                    cityCode = aMapLocation.getCityCode();
                    country = aMapLocation.getCountry();
                    district = aMapLocation.getDistrict();
                    floor = aMapLocation.getFloor();
                    latitude = aMapLocation.getLatitude();
                    longitude = aMapLocation.getLongitude();
                    poiId = aMapLocation.getPoiId();
                    poiName = aMapLocation.getPoiName();
                    province = aMapLocation.getProvince();
                    road = aMapLocation.getRoad();
                    street = aMapLocation.getStreet();
                }
            }

            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        LocationManagerProxy locationManagerProxy = LocationManagerProxy.getInstance(context);
        locationManagerProxy.requestLocationData(
                LocationProviderProxy.AMapNetwork, minTime, minDistance, listener);
        locationManagerProxy.setGpsEnable(true);
    }

    /**
     * 返回详细的地址信息，包括省、市、区和街道。
     *
     * @return
     */
    public static String getAddress() {
        return address;
    }

    /**
     * 获取区域编码，仅在网络定位模式中才能获取，仅限中国大陆，香港和澳门
     *
     * @return
     */
    public static String getAddressCode() {
        return addressCode;
    }

    /**
     * 获取定位精度半径
     *
     * @return
     */
    public static float getAccuracy() {
        return accuracy;
    }

    /**
     * 获取海拔高度
     *
     * @return
     */
    public static double getAltitude() {
        return altitude;
    }

    /**
     * 获取定位异常信息
     *
     * @return
     */
    public static String getException() {
        return aMapLocException.getErrorMessage();
    }

    /**
     * 获取城市，只有在网络定位时才能获取到
     *
     * @return
     */
    public static String getCity() {
        return city;
    }

    /**
     * 获取国家名
     *
     * @return
     */
    public static String getCountry() {
        return country;
    }

    /**
     * 获取区或者县名，只有在网络定位模式时才能获取，仅限中国大陆，香港和澳门
     *
     * @return
     */
    public static String getDistrict() {
        return district;
    }

    /**
     * 获取定位方向，以度为单位，与正北方向顺时针的角度
     *
     * @return
     */
    public static float getBearing() {
        return bearing;
    }

    /**
     * 获取城市编码，只有在网络定位模式时才能获取到，仅限中国大陆，香港和澳门
     *
     * @return
     */
    public static String getCityCode() {
        return cityCode;
    }

    /**
     * 获取室内地图的楼层，如果不在室内或者无数据，默认返回null
     *
     * @return
     */
    public static String getFloor() {
        return floor;
    }

    /**
     * 获取纬度坐标
     *
     * @return
     */
    public static double getLatitude() {
        return latitude;
    }

    /**
     * 获取经度坐标
     *
     * @return
     */
    public static double getLongitude() {
        return longitude;
    }

    /**
     * 获取室内地图POI（兴趣点）的id，如果不在室内或者无数据，返回null
     *
     * @return
     */
    public static String getPoiId() {
        return poiId;
    }

    /**
     * 获取POI名字，仅限中国大陆，香港和澳门
     *
     * @return
     */
    public static String getPoiName() {
        return poiName;
    }

    /**
     * 获取省份，只有在网络定位时才能获取
     *
     * @return
     */
    public static String getProvince() {
        return province;
    }

    /**
     * 获取道路名字
     *
     * @return
     */
    public static String getRoad() {
        return road;
    }

    /**
     * 获取街道和门牌号，只有在网络定位时才能获取，仅限中国大陆，香港和澳门
     *
     * @return
     */
    public static String getStreet() {
        return street;
    }

    /**
     * 设置室内地图楼层
     *
     * @param floor
     */
    public static void setFloor(String floor) {
        LocationManager.floor = floor;
    }

    /**
     * 设置室内地图POI id
     */
    public static void setPoiId(String poiId) {
        LocationManager.poiId = poiId;
    }

    /**
     * 设置POI名称
     *
     * @param poiName
     */
    public static void setPoiName(String poiName) {
        LocationManager.poiName = poiName;
    }

    /**
     * 设置道路名称
     *
     * @param road
     */
    public static void setRoad(String road) {
        LocationManager.road = road;
    }

    /**
     * 停止定位
     *
     * @param context
     */
    public static void stopLocation(Context context) {
        LocationManagerProxy locationManagerProxy = LocationManagerProxy.getInstance(context);
        locationManagerProxy.removeUpdates(listener);
        locationManagerProxy.destroy();
    }
}
