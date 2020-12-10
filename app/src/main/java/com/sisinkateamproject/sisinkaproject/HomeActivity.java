package com.sisinkateamproject.sisinkaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    public static final String KATAKUNCI ="katakunci";
    private String keyword;
    private Bundle bundle= new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        keyword = getIntent().getStringExtra(KATAKUNCI);
        bundle.putString("searchdata", keyword);

        BottomNavigationView bottonNav = findViewById(R.id.nav_view);
        bottonNav.setOnNavigationItemSelectedListener(navListener);


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment getFrag = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getFrag = new HomeFragment();
                    break;
                case R.id.navigation_donation:
                    getFrag = new DonationFragment();
                    break;
                case R.id.navigation_account:
                    getFrag = new AccountFragment();
                    break;
            }
            getFrag.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, getFrag).commit();
            return true;
        }
    };
}