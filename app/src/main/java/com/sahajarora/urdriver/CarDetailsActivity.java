package com.sahajarora.urdriver;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CarDetailsActivity extends ActionBarActivity {
    private Button btnNext;

    private LinearLayout layoutNoSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_normal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layoutNoSelected = (LinearLayout) findViewById(R.id.layoutNoSelected);
        layoutNoSelected.setVisibility(View.INVISIBLE);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CarDetailsActivity.this, ConfirmActivity.class));
            }
        });

    }


    @Override
    public void onBackPressed(){
        finish();
    }

    public void onNoSelected(View v){
        layoutNoSelected.setVisibility(View.VISIBLE);
    }

    public void onYesSelected(View v){
        layoutNoSelected.setVisibility(View.INVISIBLE);
    }

}
