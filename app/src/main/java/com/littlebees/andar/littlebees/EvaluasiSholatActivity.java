package com.littlebees.andar.littlebees;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.littlebees.andar.littlebees.adapter.SectionPageAdapter;
import com.littlebees.andar.littlebees.fragmentevaluasisholat.ashar_fragment;
import com.littlebees.andar.littlebees.fragmentevaluasisholat.isya_fragment;
import com.littlebees.andar.littlebees.fragmentevaluasisholat.magrib_fragment;
import com.littlebees.andar.littlebees.fragmentevaluasisholat.subuh_fragment;
import com.littlebees.andar.littlebees.fragmentevaluasisholat.zuhur_fragment;
import com.melnykov.fab.FloatingActionButton;



public class EvaluasiSholatActivity extends AppCompatActivity {

    private SectionPageAdapter mSectionPageAdapter;

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluasi_sholat);


        FloatingActionButton fabSholat = (FloatingActionButton) findViewById(R.id.fabsholat);
        fabSholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DataSholat.class);
                v.getContext().startActivity(intent);
            }
        });


        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new magrib_fragment(),"Magrib");
        adapter.addFragment(new isya_fragment(),"Isya");
        adapter.addFragment(new subuh_fragment(),"Subuh");
        adapter.addFragment(new zuhur_fragment(),"Zuhur");
        adapter.addFragment(new ashar_fragment(),"Ashar");
        this.mViewPager.setAdapter(adapter);
    }



}
