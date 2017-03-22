package com.sahajarora.urdriver;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumberDriversActivity extends ActionBarActivity {
    private Spinner spinnerNumberDrivers, spinnerNumberHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_drivers);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_normal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initComponents();
    }

    private void initComponents() {
        spinnerNumberDrivers = (Spinner) findViewById(R.id.spinnerNumberDrivers);
        ArrayList<String> listNumDrivers = new ArrayList<>();
        for (int i=1; i<16;i++){
            listNumDrivers.add(i+"");
        }

        ArrayAdapter adapterNumDrivers = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner, listNumDrivers);

        spinnerNumberDrivers.setAdapter(adapterNumDrivers);


        spinnerNumberHours = (Spinner) findViewById(R.id.spinnerNumberHours);
        ArrayList<String> listNumHours = new ArrayList<>();
        for (int i=1; i<11;i++){
            listNumHours.add(i+"");
        }

        ArrayAdapter adapterNumHours = new ArrayAdapter(getApplicationContext(), R.layout.item_spinner, listNumHours);

        spinnerNumberHours.setAdapter(adapterNumHours);
    }

    public void openConfirmActivity(View view){
        startActivity(new Intent(NumberDriversActivity.this, ConfirmActivity.class));
    }
}
