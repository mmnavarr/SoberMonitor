package com.cyberplays.sobermonitor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class SelectRandomActivity extends ActionBarActivity {


    private Button range, pick;
    private TextView num;
    private int rangeVal = 10;
    final Context context = this;

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
        bar.setTitle("Select Random Number");
        bar.setSubtitle("Cross your fingers..");
    }


    //INITIALIZE VIEWs
    private void initViews() {
        num = (TextView) findViewById(R.id.number);

        //SET PICK BUTTON ATTR
        pick = (Button) findViewById(R.id.numbersel);
        pick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    //STYLE BUTTON ON ONTOUCH
                    pick.setTextColor(Color.parseColor("#33CCFF"));
                    pick.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    //SELECT RANDOM # BASED ON GVEN RANGE
                    Random r = new Random();
                    int i = r.nextInt(rangeVal) + 1;
                    num.setText(Integer.toString(i));

                } else if(event.getAction()==MotionEvent.ACTION_UP) {
                    //RETURN TO ORIGINAL STYLE
                    pick.setTextColor(Color.parseColor("#FFFFFF"));
                    pick.setBackgroundColor(Color.parseColor("#33CCFF"));
                }

                return false;
            }
        });

        //SET RANGE BUTTON ATTRB
        range = (Button) findViewById(R.id.range);
        range.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    //STYLE BUTTON ONTOUCH
                    range.setTextColor(Color.parseColor("#33CCFF"));
                    range.setBackgroundColor(Color.parseColor("#FFFFFF"));

                    //OPEN DIALOG
                    openDialog();

                } else if(event.getAction()==MotionEvent.ACTION_UP) {
                    //RETUR TO ORIGINAL STYLE
                    range.setTextColor(Color.parseColor("#FFFFFF"));
                    range.setBackgroundColor(Color.parseColor("#33CCFF"));
                }

                return false;
            }
        });
    }

    //CREATES AND SHOWS THE DIALOG FOR RANGE INPUT
    public void openDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.dialog_getrange, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(dialogView);
        //INITIALIZE EDIT TEXT
        final EditText input = (EditText) dialogView.findViewById(R.id.dialog_addperson_getname);

        //SETUP DIALOG WINDOW
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // get user input and set it to range value
                        Editable temp = input.getText();
                        rangeVal = Integer.parseInt(temp.toString());
                        num.setText(temp);
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,	int id) {
                                dialog.cancel();
                 }});

        //CREATE THE ALERT DIALOG
        AlertDialog alert = alertDialogBuilder.create();
        // SHOW THE ALERT
        alert.show();
    }

}
