package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.model.Account;
import com.example.myapplication.model.Tour;
import com.example.myapplication.model.User;
import com.example.myapplication.ui.CustomerFragment;
import com.example.myapplication.ui.EditTourActivity;
import com.example.myapplication.ui.HomeFragment;
import com.example.myapplication.ui.InfoFragment;
import com.example.myapplication.ui.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    public static Account account;
    public static Tour tour;
    public static User user;
    BottomNavigationView bottomNavigationView;


    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    InfoFragment infoFragment = new InfoFragment();
    CustomerFragment customerFragment = new CustomerFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        account = (Account) getIntent().getSerializableExtra("account");
        String accountName = account.getUsername();
        if(accountName.equalsIgnoreCase("anhtuancao")){
            initListener();
        }
        else {
            initListener();
            bottomNavigationView.getMenu().removeItem(R.id.menu2);
            bottomNavigationView.getMenu().removeItem(R.id.menu4);
        }
    }

    private void initListener() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        setCurrentFragment(homeFragment);
//                        i.putExtra("account",account);
                        break;
                    case R.id.menu2:
                        setCurrentFragment(searchFragment);
                        break;
                    case R.id.menu4:
                        setCurrentFragment(customerFragment);
                        break;
                    case R.id.menu3:
                        setCurrentFragment(infoFragment);
                        break;
                }

                return true;
            }

        });
        bottomNavigationView.setSelectedItemId(R.id.menu1);

    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();
    }

}