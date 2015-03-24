package com.cyberplays.sobermonitor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;

import java.util.ArrayList;



public class SelectListActivity extends ActionBarActivity implements View.OnTouchListener {

    private ListView mListView;
    private Button btn;
    private ArrayList<Person> array = new ArrayList<Person>();
    private MyAdapter adapter;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_select_list);

            initViews();
        }

        //SET ACTION BAR COLOR
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33CCFF")));
    }


    //INITIALIZE THE VIEWS
    private void initViews() {
        btn = (Button) findViewById(R.id.selectfromlist);
        btn.setOnTouchListener(this);

        mListView = (ListView) findViewById(R.id.list);

        array.add(new Person("John Doe", 2));
        array.add(new Person("Malcolm Navarro", 1));
        array.add(new Person("Lucas Whereishe", 4));
        array.add(new Person("Steve Prezz", 10));
        array.add(new Person("Arnold Triteboy", 3));
        array.add(new Person("Townie Phil", 2));
        array.add(new Person("Sexually Frustrated Chris Cocaine", 9));

        adapter = new MyAdapter(getApplicationContext(), R.layout.listview_item, array);
        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        animationAdapter.setAbsListView(mListView);
        mListView.setAdapter(animationAdapter);
        //mListView.enableDragAndDrop();
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //mListView.startDragging(position);
                return true;
            }
        });
        /*mListView.enableSwipeToDismiss(new OnDismissCallback() {
            @Override
            public void onDismiss(@NonNull ViewGroup viewGroup, @NonNull int[] ints) {
                for (int position : reverseSortedPositions) {
                    adapter.remove(position);
                }
            }
        });*/
    }

    //METHOD FOR ADD PERSON DIALOG
    public void openDialog() {
        Log.v("BUTT PRESS", "ADD PERSON TO LIST");
        //CREATE VIEW FOR DIALOG BOX AND SET THE VIEW
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View dialogView = layoutInflater.inflate(R.layout.dialog_addperson, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(dialogView);

        //INITIALIZE EDIT TEXT
        final EditText inputName = (EditText) dialogView.findViewById(R.id.dialog_addperson_getname);
        final EditText inputMult = (EditText) dialogView.findViewById(R.id.dialog_addperson_getmult);

        //SETUP DIALOG WINDOW
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // get user input and set it to name and mult

                        String name = inputName.getText().toString();
                        String mult =inputMult.getText().toString();

                        //MAKE SURE USER FILLED BOTH FIELDS
                        if (name.length() < 1 || mult.length() < 1) {
                            Toast.makeText(context, "Please Enter Valid Information", Toast.LENGTH_LONG).show();
                            openDialog();
                        } else {
                            //ADD PERSON TO ARRAY AND UPDATE LIST
                            Person newPerson = new Person(name,  Integer.parseInt(mult));
                            array.add(newPerson);
                            //notifyDataSetCHanged updates the listview
                            adapter.notifyDataSetChanged();
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        //CREATE THE ALERT DIALOG
        AlertDialog alert = alertDialogBuilder.create();
        // SHOW THE ALERT
        alert.show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            //STYLE BUTTON ONTOUCH
            btn.setTextColor(Color.parseColor("#33CCFF"));
            btn.setBackgroundColor(Color.parseColor("#FFFFFF"));

            //CHOOSE PERSON
            selectWho();

        } else if(event.getAction()==MotionEvent.ACTION_UP) {
            //RETUR TO ORIGINAL STYLE
            btn.setTextColor(Color.parseColor("#FFFFFF"));
            btn.setBackgroundColor(Color.parseColor("#33CCFF"));
        }
        return false;
    }

    public void selectWho() {
        //FIGURE OUT HOW TO SELECT WHO
        Toast.makeText(context, "Still working on it", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_addperson) {
            openDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
