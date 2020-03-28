package com.mari05lim.covidinfo;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mari05lim.covidinfo.fragment.AboutFragment;
import com.mari05lim.covidinfo.fragment.CountryFragment;
import com.mari05lim.covidinfo.fragment.WorldFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextView tvToday;
    String hoje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvToday = findViewById(R.id.tvDate);
        Date dateNow = Calendar.getInstance().getTime();
        hoje = (String) DateFormat.format("EEEE", dateNow);

        WorldFragment worldFragment = new WorldFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flMain, worldFragment)
                .commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getToday();

    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String data = (String) DateFormat.format("d MMM yyyy", date);
        String formatFix = hoje + ", " + data;
        tvToday.setText(formatFix);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.worldMenu:
                WorldFragment worldFragment = new WorldFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, worldFragment)
                        .commit();
                return true;

            case R.id.countryMenu:
                CountryFragment countryFragment = new CountryFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, countryFragment)
                        .commit();
                return true;

            case R.id.aboutMenu:
                AboutFragment aboutFragment = new AboutFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flMain, aboutFragment)
                        .commit();
                return true;
        }
        return false;
    }
}
