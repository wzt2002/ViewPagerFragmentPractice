package com.example.viewpagerfragmentpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager mainvp = (ViewPager) findViewById(R.id.mainVP);
        mainvp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 3;
            }
            @NonNull
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                switch (position){
                    case 0:
                        fragment=new fragment1();
                        break;
                    case 1:
                        fragment=new fragment2();
                        break;
                    case 2:
                        fragment=new fragment3();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
                return fragment;
            }
        });
    }
}