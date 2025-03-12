package com.djezzy.internet;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\Constants.smali */
public class Constants {

    /* renamed from: a, reason: collision with root package name */
    public static Constants f9651a;

    static {
        System.loadLibrary("keys");
    }

    public static Constants a() {
        if (f9651a == null) {
            f9651a = new Constants();
        }
        return f9651a;
    }

    public native String getAssets();

    public native String getClient();

    public native String getCommunity();

    public native String getContents();

    public native String getCustomerCare();

    public native String getEvents();

    public native String getInformation();

    public native String getMobileGrant();

    public native String getNotifications();

    public native String getOpenId();

    public native String getOtpId();

    public native String getPayment();

    public native String getRefreshGrant();

    public native String getRegistration();

    public native String getSecret();

    public native String getServices();

    public native String getSettings();

    public native String getToken();
}