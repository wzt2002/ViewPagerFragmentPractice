package com.example.viewpagerfragmentpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class fragment1 extends Fragment {
    ViewPager viewPager;
    ListView listView;
    private ArrayList<Integer> resId=new ArrayList<Integer>();
    private ArrayList<String> dateList=new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment1,null);
        viewPager = (ViewPager) view.findViewById(R.id.myvp);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return resId.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(resId.get(position));
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
               container.removeView((View) object);
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }
        });


    }


    private void initDate(){
        resId.add(R.drawable.pi1);
        resId.add(R.drawable.pi2);
        resId.add(R.drawable.pi3);
        for (int i=0;i<46;i++){
            dateList.add("This is the"+i+"text");
        }
    }
}
