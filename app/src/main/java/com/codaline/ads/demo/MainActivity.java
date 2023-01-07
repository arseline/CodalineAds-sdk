package com.codaline.ads.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codaline.ads.library.format.AdNetwork;
import com.codaline.ads.library.format.BannerAd;
import com.codaline.ads.library.format.InterstitialAd;
import com.codaline.ads.library.format.NativeAd;

public class MainActivity extends AppCompatActivity {

    public static final String AD_STATUS = "1";
    public static final String AD_NETWORK = "admob";

    public static final String ADMOB_BANNER_ID = "ca-app-pub-3940256099942544/6300978111";
    public static final String ADMOB_INTERSTITIAL_ID = "ca-app-pub-3940256099942544/1033173712";
    public static final String ADMOB_NATIVE_ID = "ca-app-pub-3940256099942544/2247696110";

    public static final String STARTAPP_APP_ID = "0";

    public static final String UNITY_GAME_ID = "4089993";
    public static final String UNITY_BANNER_ID = "banner";
    public static final String UNITY_INTERSTITIAL_ID = "interstitial";

    public static final String APPLOVIN_BANNER_ID = "f32d1355463ae430";
    public static final String APPLOVIN_INTERSTITIAL_ID = "9665529a164fec6c";

    Toolbar toolbar;
    AdNetwork.Initialize adNetwork;
    BannerAd.Builder bannerAd;
    InterstitialAd.Builder interstitialAd;
    NativeAd.Builder nativeAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adNetwork = new AdNetwork.Initialize(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setAdMobAppId(null)
                .setStartappAppId(STARTAPP_APP_ID)
                .setUnityGameId(UNITY_GAME_ID)
                .setAppLovinSdkKey(null)
                .setDebug(true)
                .build();

        bannerAd = new BannerAd.Builder(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setAdMobBannerId(ADMOB_BANNER_ID)
                .setUnityBannerId(UNITY_BANNER_ID)
                .setAppLovinBannerId(APPLOVIN_BANNER_ID)
                .setDarkTheme(false)
                .build();

        interstitialAd = new InterstitialAd.Builder(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setAdMobInterstitialId(ADMOB_INTERSTITIAL_ID)
                .setUnityInterstitialId(UNITY_INTERSTITIAL_ID)
                .setAppLovinInterstitialId(APPLOVIN_INTERSTITIAL_ID)
                .setInterval(1)
                .build();

        findViewById(R.id.btn_interstitial).setOnClickListener(v -> interstitialAd.show());

        nativeAd = new NativeAd.Builder(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setAdMobNativeId(ADMOB_NATIVE_ID)
                .setDarkTheme(false)
                .build();

    }

}