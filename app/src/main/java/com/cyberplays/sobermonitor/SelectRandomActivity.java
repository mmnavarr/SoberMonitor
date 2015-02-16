package com.cyberplays.sobermonitor;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class SelectRandomActivity extends ActionBarActivity {


    private Button range, pick;
    private TextView num;
    private int ran = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_select_random);

            initViews();
        }


        //SET ACTION BAR COLOR
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33CCFF")));
    }


    //INITIALIZE VIEWs
    private void initViews() {
        num = (TextView) findViewById(R.id.number);

        range = (Button) findViewById(R.id.range);
        range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RANGEEEE
            }
        });

        pick = (Button) findViewById(R.id.numbersel);
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int i = r.nextInt(ran);
                num.setText(Integer.toString(i));
            }
        });
    }

}
