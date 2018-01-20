package com.littlebees.andar.littlebees;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.littlebees.andar.littlebees.fragmentutama.FragmentAktifitas;
import com.littlebees.andar.littlebees.fragmentutama.FragmentBeranda;
import com.littlebees.andar.littlebees.fragmentutama.FragmentGrafik;
import com.littlebees.andar.littlebees.fragmentutama.FragmentProfil;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;



public class MainActivity extends AppCompatActivity {

    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.sholatbg)
                .addProfiles(
                        new ProfileDrawerItem().withName("Lebron").withEmail("My first Son").withIcon(getResources().getDrawable(R.drawable.profil))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Panduan Mendidik Anak");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(3).withName("Akidah");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(4).withName("Ibadah");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(5).withName("Akhlak");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(6).withName("Fisik");
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(7).withName("Akal");
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(8).withName("Kejiwaan");
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(9).withName("Sosial");

        PrimaryDrawerItem item9 = new PrimaryDrawerItem().withIdentifier(9).withName("Pengaturan");
        PrimaryDrawerItem item10 = new PrimaryDrawerItem().withIdentifier(10).withName("Tentang");

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6,
                        item7,
                        item8,

                        new DividerDrawerItem(),

                        item9,
                        item10


                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D

                        return (false);
                    }
                })
                .build();





        bottomBar = (BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            Fragment fragment = null;
            @Override
            public void onTabSelected(int tabId) {
                if (tabId == R.id.tab_beranda){
                    fragment = new  FragmentBeranda();
                }

                else if (tabId == R.id.tab_aktifitas) {
                    fragment = new FragmentAktifitas();
                }

                else if (tabId == R.id.tab_grafik) {
                    fragment = new FragmentGrafik();
                }

                else if (tabId == R.id.tab_profil) {
                    fragment = new FragmentProfil();
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();

            }
        });

    }

}
