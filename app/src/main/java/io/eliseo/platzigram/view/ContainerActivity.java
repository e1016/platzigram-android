
package io.eliseo.platzigram.view;

import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;

import io.eliseo.platzigram.R;
import io.eliseo.platzigram.view.fragment.HomeFragment;
import io.eliseo.platzigram.view.fragment.ProfileFragment;
import io.eliseo.platzigram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = findViewById(R.id.bottom_bar_view);
        bottomBar.setDefaultTab(R.id.home_tab);

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                switch (tabId) {
                    case R.id.home_tab:
                        addFragment(new HomeFragment());
                        break;
                    case R.id.search_tab:
                        addFragment(new SearchFragment());
                        break;
                    case R.id.profile_tab:
                        addFragment(new ProfileFragment());
                        break;
                }
            }
        });
    }

    public void addFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragments_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
