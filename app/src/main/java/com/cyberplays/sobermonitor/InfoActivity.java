package com.cyberplays.sobermonitor;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class InfoActivity extends ActionBarActivity {

    private TextView iHead1,iHead2,iHead3, iText1,iText2,iText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_info);

            //SET ACTION BAR COLOR
            ActionBar bar = getSupportActionBar();
            bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33CCFF")));

            initViews();
        }
    }

    public void initViews() {
        /*iHead1 = (TextView) findViewById(R.id.ih1);
        iHead2 = (TextView) findViewById(R.id.ih2);
        iHead3 = (TextView) findViewById(R.id.ih3);

        iText1 = (TextView) findViewById(R.id.it1);
        iText2 = (TextView) findViewById(R.id.it2);
        iText3 = (TextView) findViewById(R.id.it3);*/
    }


}
