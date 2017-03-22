package com.sahajarora.urdriver;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class OneWayActivity extends ActionBarActivity {

    private LinearLayout layoutNoOneWay;
    private Button btnDropOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_way);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_normal);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        layoutNoOneWay = (LinearLayout) findViewById(R.id.layoutNoOneWay);
        layoutNoOneWay.setVisibility(View.INVISIBLE);

        btnDropOff = (Button) findViewById(R.id.btnDropoff);
        btnDropOff.setVisibility(View.INVISIBLE);

    }

    public void onYesOneWaySelected(View view){
        layoutNoOneWay.setVisibility(View.INVISIBLE);
    }

    public void onNoOneWaySelected(View view){
        layoutNoOneWay.setVisibility(View.VISIBLE);
    }

    public void onYesPickupSelected(View view){
        btnDropOff.setVisibility(View.INVISIBLE);
    }

    public void onNoPickupSelected(View view){
        btnDropOff.setVisibility(View.VISIBLE);
    }

    public void openConfirmActivity(View view){
        startActivity(new Intent(OneWayActivity.this, ConfirmActivity.class));
    }

    public void chooseDropoffLocation(View view){
        startActivity(new Intent(OneWayActivity.this, MapsActivity.class));
    }

}
