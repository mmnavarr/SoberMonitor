package com.cyberplays.sobermonitor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class SelectActivity extends ActionBarActivity {

    private TextView h, bt1, bt2, bt3;
    private at.markushi.ui.CircleButton b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            setContentView(R.layout.activity_select);

            initViews();
        }

        //SET ACTION BAR COLOR
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33CCFF")));
    }

    private void initViews() {
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/MYRIADPRO-COND.OTF");

        h = (TextView) findViewById(R.id.hs1);
        h.setTypeface(tf);

        bt1 = (TextView) findViewById(R.id.bt1);
        bt1.setTypeface(tf);

        b1 = (at.markushi.ui.CircleButton) findViewById(R.id.bs1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("BUTT PRESS", "SELECT LIST");
                Intent i = new Intent(SelectActivity.this, SelectListActivity.class);
                startActivity(i);
            }
        });

        bt2 = (TextView) findViewById(R.id.bt2);
        bt2.setTypeface(tf);

        b2 = (at.markushi.ui.CircleButton) findViewById(R.id.bs2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("BUTT PRESS", "SELECT RANDO #");
                Intent i = new Intent(SelectActivity.this, SelectRandomActivity.class);
                startActivity(i);
            }
        });

        bt3 = (TextView) findViewById(R.id.bt3);
        bt3.setTypeface(tf);

        b3 = (at.markushi.ui.CircleButton) findViewById(R.id.bs3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("BUTT PRESS", "IMPORT EXCEL");
                Toast.makeText(getApplicationContext(), "Coming soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
