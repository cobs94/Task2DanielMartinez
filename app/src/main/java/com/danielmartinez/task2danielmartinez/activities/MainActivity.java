package com.danielmartinez.task2danielmartinez.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.danielmartinez.task2danielmartinez.R;
import com.danielmartinez.task2danielmartinez.fragments.AjustesFragment;
import com.danielmartinez.task2danielmartinez.fragments.DescripcionFragment;
import com.danielmartinez.task2danielmartinez.fragments.ObjetosFragment;
import com.danielmartinez.task2danielmartinez.fragments.PerfilFragment;
import com.danielmartinez.task2danielmartinez.fragments.PersonajesFragment;
import com.danielmartinez.task2danielmartinez.fragments.TipsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                PerfilFragment fragment1 = PerfilFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment1).commit();
                break;
            case R.id.item2:
                DescripcionFragment fragment2 = DescripcionFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment2).commit();
                break;
            case R.id.item3:
                PersonajesFragment fragment3 = PersonajesFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment3).commit();
                break;
            case R.id.item4:
                ObjetosFragment fragment4 = ObjetosFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment4).commit();
                break;
            case R.id.item5:
                TipsFragment fragment5 = TipsFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment5).commit();
                break;
            case R.id.item6:
                AjustesFragment fragment6 = AjustesFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, fragment6).commit();
                break;
            case R.id.item7:

                break;
        }
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
        drawerLayout.closeDrawers();
        return true;
    }
}
