package com.hybird.bottomfragmentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hybird.bottomfragmentation.Fragments.HomeFragment;
import com.hybird.bottomfragmentation.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment objectHomeFragment;
    private SearchFragment objectSearchFragment;

    private BottomNavigationView objectBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeObjects();
    }


    private void changeFragment(Fragment objectFragment)
    {
        try
        {
            FragmentTransaction objectTransaction=getSupportFragmentManager()
                    .beginTransaction();

            objectTransaction.replace(R.id.container,objectFragment).commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "changeFragment:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeObjects()
    {
        try
        {
            objectHomeFragment=new HomeFragment();
            objectSearchFragment=new SearchFragment();

            objectBottomNavigationView=findViewById(R.id.BNV);
            changeFragment(objectHomeFragment);

            objectBottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                            if(item.getItemId()==R.id.menu_home)
                            {
                                changeFragment(objectHomeFragment);
                                return true;
                            }
                            else if(item.getItemId()==R.id.menu_search)
                            {
                                changeFragment(objectSearchFragment);
                                return true;
                            }
                            return false;
                        }
                    }
            );


        }
        catch (Exception e)
        {
            Toast.makeText(this, "initializeObjects:" +
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
