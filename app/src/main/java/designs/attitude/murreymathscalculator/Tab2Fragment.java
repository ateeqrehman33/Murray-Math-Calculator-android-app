package designs.attitude.murreymathscalculator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Tab2Fragment extends Fragment {


    private InterstitialAd mInterstitialAd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        return v;




    }

    @Nullable
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        WebView wv;
        wv = (WebView) getView().findViewById(R.id.webview);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(false);
      //  wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.loadUrl("file:///android_asset/TUTORIALnew.html");   // fails here


        // initialize the AdMob app
        MobileAds.initialize(getActivity(), getString(R.string.admob_app_id));



        prepareAd();

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {

            public void run() {
                Log.i("hello", "world");
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG"," Interstitial not loaded");
                        }

                        prepareAd();


                    }
                });

            }
        }, 45, 45, TimeUnit.SECONDS);






    }

    public void  prepareAd(){


        mInterstitialAd=new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_tab2));
        AdRequest adRequest1=new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest1);
    }



}















