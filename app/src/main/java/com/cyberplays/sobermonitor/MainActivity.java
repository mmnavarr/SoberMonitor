package com.cyberplays.sobermonitor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView h1, h2, bl1, bl2, bl3;
    private at.markushi.ui.CircleButton b1, b2, b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_main);

            initViews();
        }
    }

    //INITIALIZE VIEWS
    private void initViews(){
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/MYRIADPRO-COND.OTF");


        h1 = (TextView) findViewById(R.id.h1);
        h1.setTypeface(tf);
        h2 = (TextView) findViewById(R.id.h2);
        h2.setTypeface(tf);

        //BUTTON 1
        b1 = (at.markushi.ui.CircleButton) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Button DEBUG", "b1");
                Intent i = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(i);
            }
        });
        bl1 = (TextView) findViewById(R.id.bl1);
        bl1.setTypeface(tf);

        //BUTTON 2
        b2 = (at.markushi.ui.CircleButton) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Button DEBUG", "b2");
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });
        bl2 = (TextView) findViewById(R.id.bl2);
        bl2.setTypeface(tf);

        //BUTTON 3
        b3 = (at.markushi.ui.CircleButton) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Button DEBUG", "b3");
                Intent i = new Intent(MainActivity.this, SelectActivity.class);
                startActivity(i);
            }
        });
        bl3 = (TextView) findViewById(R.id.bl3);
        bl3.setTypeface(tf);

        TextView cp = (TextView) findViewById(R.id.cyberplays);
        cp.setText(Html.fromHtml("<a href=\"http://www.cyberplays.com\">CyberPlays</a>"));
        cp.setMovementMethod(LinkMovementMethod.getInstance());
        cp.setLinkTextColor(Color.WHITE);
    }


} //END
