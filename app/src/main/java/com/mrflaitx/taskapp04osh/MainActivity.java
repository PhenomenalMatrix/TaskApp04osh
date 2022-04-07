package com.mrflaitx.taskapp04osh;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mrflaitx.taskapp04osh.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.main_container);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        navController.navigate(R.id.onBoardFragment);

        hideOrVisibleBottomNav();
    }

    private void hideOrVisibleBottomNav() {
        navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            if(navDestination.getId() == R.id.onBoardFragment || navDestination.getId() == R.id.detailFragment ){
                binding.navView.setVisibility(View.GONE);
                getSupportActionBar().hide();
            }else {
                binding.navView.setVisibility(View.VISIBLE);
                getSupportActionBar().show();
            }
        });
    }

}