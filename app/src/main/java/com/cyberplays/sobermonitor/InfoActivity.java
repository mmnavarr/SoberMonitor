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

    /*private TextView iHead1,iHead2,iHead3, iText1,iText2,iText3;*/
    private TextView info;

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

        info = (TextView) findViewById(R.id.infotext);
        info.setText(Html.fromHtml("<h2>Select From List:</h2>\n" +
                "<p>This option allows you to choose the sober monitors from a list. The list can be added to and modified. The multiplier puts those respective names in the pool x amount of times. Upon clicking the 'Select' button, you will choose how many sober monitors you need and names will be selected from the pool and displayed.</p><br>\n" +
                "<h2>Select Random Number:</h2>\n" +
                "<p>This option is for a more simple approach where you select a range of numbers to choose from and then we randomly select a number in that range. The number then may dictate who in the group of people you are choosing from is going to have to not drink tonight. Sorry!</p><br>\n" +
                "<h2>Select From Excel Spreadsheet</h2>\n" +
                "<p>Working on this portion of the application. Coming soon!..</p><br>"));
    }


}
