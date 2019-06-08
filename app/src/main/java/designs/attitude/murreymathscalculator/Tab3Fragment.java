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

import java.math.BigDecimal;

public class Tab3Fragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_three, container, false);
        return v;


    }

    @Nullable
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        WebView wv2;
        wv2 = (WebView) getView().findViewById(R.id.webview);
        wv2.getSettings().setBuiltInZoomControls(true);
        wv2.getSettings().setDisplayZoomControls(false);
        wv2.loadUrl("file:///android_asset/Disclaimer.html");   // fails here


    }

}















