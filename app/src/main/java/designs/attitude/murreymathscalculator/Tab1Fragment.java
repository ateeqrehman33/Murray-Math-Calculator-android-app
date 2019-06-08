package designs.attitude.murreymathscalculator;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.math.BigDecimal;

public class Tab1Fragment extends Fragment {



    double high,low;
    TextView td2,td3,td4,td5,td6,td7,td8,td9,td10,td11,td12,td13,td14;
    Button calculatebtn;
    EditText valuehigh,valuelow;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);


        setHasOptionsMenu(true);

        return v;



    }



    @Nullable
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);


        MobileAds.initialize(getActivity(), getString(R.string.admob_app_id));
        mAdView = getView().findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-7367763732821301/7159089584");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




        valuehigh =  getView().findViewById(R.id.valuehigh);
        valuelow = getView().findViewById(R.id.valuelow);


        calculatebtn = getView().findViewById(R.id.buttoncal);

        td2 = getView().findViewById(R.id.tv01c);
        td3 = getView().findViewById(R.id.tv02c);
        td4 = getView().findViewById(R.id.tv03c);
        td5 = getView().findViewById(R.id.tv04c);
        td6 = getView().findViewById(R.id.tv05c);
        td7 = getView().findViewById(R.id.tv06c);
        td8 = getView().findViewById(R.id.tv07c);
        td9 = getView().findViewById(R.id.tv08c);
        td10 = getView().findViewById(R.id.tv09c);
        td11 = getView().findViewById(R.id.tv10c);
        td12 = getView().findViewById(R.id.tv11c);
        td13 = getView().findViewById(R.id.tv12c);
        td14 = getView().findViewById(R.id.tv13c);




        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(valuehigh.getText().toString().length()>0&&valuelow.getText().toString().length()>0) {

                    high = Double.valueOf(valuehigh.getText().toString());
                    low = Double.valueOf(valuelow.getText().toString());
                }

                 else Toast.makeText(Tab1Fragment.this.getActivity(), "Enter the values..!",
                        Toast.LENGTH_LONG).show();




                if(high>low && low>0 && high >0) {

                    calculate(high, low);

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }

                    mInterstitialAd.loadAd(new AdRequest.Builder().build());



                }
                else Toast.makeText(Tab1Fragment.this.getActivity(), "High should be greater than Low",
                        Toast.LENGTH_LONG).show();






            }
        });


    }



    private void calculate(double high,double low) {



        td2 = getView().findViewById(R.id.tv01c);
        td3 = getView().findViewById(R.id.tv02c);
        td4 = getView().findViewById(R.id.tv03c);
        td5 = getView().findViewById(R.id.tv04c);
        td6 = getView().findViewById(R.id.tv05c);
        td7 = getView().findViewById(R.id.tv06c);
        td8 = getView().findViewById(R.id.tv07c);
        td9 = getView().findViewById(R.id.tv08c);
        td10 = getView().findViewById(R.id.tv09c);
        td11 = getView().findViewById(R.id.tv10c);
        td12 = getView().findViewById(R.id.tv11c);
        td13 = getView().findViewById(R.id.tv12c);
        td14 = getView().findViewById(R.id.tv13c);



        double b6;

        int d2 = 25000;
        int d3 = 2500;
        int d4 = 250;


        int e2 = 10000;
        int e3 = 1000;
        int e4 = 100;


        int d5 =0;


        b6 = (high-low);

        Log.d("b6 iss",String.valueOf(b6));




        if(high<d4){
            d5 = e4;
            Log.d("d5 iss",String.valueOf(d5));


        }

        else if (high<d3){
            d5 = e3;

            Log.d("d5 iss",String.valueOf(d5));

        }

        else if(high<d2){


            d5 = e2;

            Log.d("d5 iss",String.valueOf(d5));


        }






        int d6 = (int) (Math.log(d5/b6)/Math.log(2));

        Log.d("d6 iss",String.valueOf(d6));

        double d7 =  ((d5)*Math.pow(0.5,d6));

        Log.d("d7 iss",String.valueOf(d7));


        double d9 = 0.0;


        d9 = truncate(low/d7,0);
        d9 = d9*d7;









        Log.d("d9 iss",String.valueOf(d9));


        double d8 = 0;

        if((d9+d7)>high){

            d8 = d9+d7;

            Log.d("d8 iss",String.valueOf(d8));

        }

        else d8 = d9+2*d7;

        Log.d("d8 iss",String.valueOf(d8));


        /*/
          d's
         */

        double d11;
        double d12;
        double d13,d14,d15,d16;



        if(low>=((0.1875)*(d8-d9)+d9) && high<=((0.5625)*(d8-d9)+d9)){

            d12 =  (d9+(0.5)*(d8-d9));
            Log.d("d12 iss",String.valueOf(d12));


        }
        else  d12 = 0;
        Log.d("d12 iss",String.valueOf(d12));




        if(low>=((0.4375)*(d8-d9)+d9) && high<=((0.8125)*(d8-d9)+d9)){

            d14 =  (d9+0.75*(d8-d9));
            Log.d("d14 iss",String.valueOf(d14));

        }

        else d14 =0;
        Log.d("d14 iss",String.valueOf(d14));





        if (low >=(d9-(0.125)*(d8-d9)) && high<=((0.625)*(d8-d9)+d9) && d12==0){

            d11  =  (d9+(0.5)*(d8-d9));
            Log.d("d11 iss",String.valueOf(d11));

        }

        else d11 = 0;
        Log.d("d11 iss",String.valueOf(d11));









        if(low>=(0.375*(d8-d9)+d9) && high <= (1.125*(d8-d9)+d9) && d14==0){

            d15 = d8;
            Log.d("d15 iss",String.valueOf(d15));

        }

        else  d15 = 0;
        Log.d("d15 iss",String.valueOf(d15));






        if(low>=((0.125)*(d8-d9)+d9) && high<= ((0.875)*(d8-d9)+d9) && d11==0 && d12==0 && d14==0 && d15==0){

            d13 = (d9+(0.75)*(d8-d9));
            Log.d("d13 iss",String.valueOf(d13));


        }
        else d13 = 0;
        Log.d("d13 iss",String.valueOf(d13));






        if((d11+d12+d13+d14+d15)==0){

            d16 = d8;
            Log.d("d16 iss",String.valueOf(d16));

        }


        else d16=0;
        Log.d("d16 iss",String.valueOf(d16));


        double d18,e18;

        d18 =(d11+d12+d13+d14+d15+d16);
        Log.d("d18 iss",String.valueOf(d18));



/*/
e's
 */



        double e11,e12,e13,e14,e15,e16;

        if(d11>0){

            e11 = d9;
        }

        else  e11= 0;



        if(d12>0){

            e12 = (d9+0.25*(d8-d9));

        }
        else e12=0;


        if(d13>0){
            e13=  (d9+0.25*(d8-d9));
        }
        else e13=0;


        if(d14>0){

            e14 =  (d9+0.5*(d8-d9));

        }
        else e14 =0;


        if(d15>0){

            e15 =  (d9+0.5*(d8-d9));

        }
        else e15=0;



        if(d16>0){
            e16 = d9;
        }

        else e16=0;







        e18 =(e11+e12+e13+e14+e15+e16);
        Log.d("e18 iss",String.valueOf(e18));




        double g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14;


        g4 = d18;
        g4=round(g4,5);
        g12 = e18;
        g12=round(g12,5);


        g3 =  (g4+(0.125)*(g4-g12));
        g3 = round(g3,5);

        g2 =  (g3+(0.125)*(g4-g12));
        g2 = round(g2,5);


        g13 = (g12-(0.125)*(g4-g12));
        g13 = round(g13,5);


        g14 =(g13-(0.125)*(g4-g12));
        g14 = round(g14,5);



        g11 = (g12+(0.125)*(g4-g12));
        g11 = round(g11,5);



        g10 = (g11+(0.125)*(g4-g12));
        g10 = round(g10,5);



        g9 =  (g10+(0.125)*(g4-g12));
        g9 = round(g9,5);



        g8 =  (g9+(0.125)*(g4-g12));
        g8 = round(g8,5);




        g7 =  (g8+(0.125)*(g4-g12));
        g7 = round(g7,5);



        g6 =  (g7+(0.125)*(g4-g12));
        g6 = round(g6,5);



        g5 =  (g6+(0.125)*(g4-g12));
        g5 = round(g5,5);








        td2.setText(String.valueOf(g2));
        td3.setText(String.valueOf(g3));
        td4.setText(String.valueOf(g4));
        td5.setText(String.valueOf(g5));
        td6.setText(String.valueOf(g6));
        td7.setText(String.valueOf(g7));
        td8.setText(String.valueOf(g8));
        td9.setText(String.valueOf(g9));
        td10.setText(String.valueOf(g10));
        td11.setText(String.valueOf(g11));
        td12.setText(String.valueOf(g12));
        td13.setText(String.valueOf(g13));
        td14.setText(String.valueOf(g14));









    }

    public static double truncate(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }



    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }







    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // show menu when menu button is pressed
        inflater.inflate(R.menu.menu_items, menu);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // display a message when a button was pressed
        String message = "";
        if (item.getItemId() == R.id.action_rate) {
            Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
            }        }
        if (item.getItemId() == R.id.action_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out this app. Murrey maths level calculation for forex trading studies! \n http://play.google.com/store/apps/details?id=" + getActivity().getPackageName());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);        }
        if (item.getItemId() == R.id.action_about) {
            startActivity(new Intent(getContext(), About.class));        }



        return true;
    }



}















