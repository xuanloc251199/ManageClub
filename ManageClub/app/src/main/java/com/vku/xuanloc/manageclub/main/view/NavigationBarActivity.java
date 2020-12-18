package com.vku.xuanloc.manageclub.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.vku.xuanloc.manageclub.home.view.HomeFragment;
import com.vku.xuanloc.manageclub.member.view.MemberFragment;
import com.vku.xuanloc.manageclub.setting.view.MenuFragment;
import com.vku.xuanloc.manageclub.notification.view.NotificationFragment;
import com.vku.xuanloc.manageclub.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class NavigationBarActivity extends AppCompatActivity {

    private static final String TAG = NavigationBarActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        animatedBottomBar = findViewById(R.id.nav_animatedBottomBar);

        if (savedInstanceState == null){
            animatedBottomBar.selectTabById(R.id.bar_home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.nav_fragment_container, homeFragment)
                    .commit();
        }

       animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
           @Override
           public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab newtab) {
               Fragment fragment = null;
               switch (newtab.getId()){
                   case R.id.bar_home:
                       fragment = new HomeFragment();
                       break;
                   case R.id.bar_member:
                       fragment = new MemberFragment();
                       break;
                   case R.id.bar_notification:
                       fragment = new NotificationFragment();
                       break;
                   case R.id.bar_menu:
                       fragment = new MenuFragment();
                       break;
               }

               if (fragment != null){
                   fragmentManager = getSupportFragmentManager();
                   fragmentManager.beginTransaction().replace(R.id.nav_fragment_container, fragment)
                           .commit();
               } else {
                   Log.e(TAG, "Lỗi");
               }
           }

           @Override
           public void onTabReselected(int i, @NotNull AnimatedBottomBar.Tab tab) {

           }
       });
    }
}