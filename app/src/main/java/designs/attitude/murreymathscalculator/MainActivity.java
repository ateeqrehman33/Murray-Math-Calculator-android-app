package designs.attitude.murreymathscalculator;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Calculator");
        adapter.addFragment(new Tab2Fragment(), "Tutorial");
        adapter.addFragment(new Tab3Fragment(), "Disclaimer");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }


    @Override
    public void onBackPressed() {

        /*if(isDrawerOpen){
            drawerLayout.closeDrawer(GravityCompat.START);
            isDrawerOpen=false;
            return;
        }*/

        if (doubleBackToExitPressedOnce) {
            moveTaskToBack(true);
            finish();
            //  interstitial.show();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}