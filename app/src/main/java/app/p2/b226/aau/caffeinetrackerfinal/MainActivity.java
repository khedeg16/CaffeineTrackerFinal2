package app.p2.b226.aau.caffeinetrackerfinal;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public void CreateFragmentSettings(View view) {
        Fragment fragment;
        fragment = new SettingsFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frament_place, fragment);
        ft.commit();
    }

    public void CreateFragmentVisualization(View view) {
        Fragment fragment;
        fragment = new VisualizationFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frament_place, fragment);
        ft.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    CreateFragmentVisualization(null);
                    return true;

                case R.id.navigation_notifications:
                    CreateFragmentSettings(null);
                    return true;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}




