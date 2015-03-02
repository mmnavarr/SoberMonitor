package com.cyberplays.sobermonitor;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;


public class SelectListActivity extends ActionBarActivity implements View.OnClickListener {

    private ListView mListView;
    private at.markushi.ui.CircleButton add;
    private ArrayList<Person> array = new ArrayList<Person>();
    private MyAdapter adapter;

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
        mListView = (ListView) findViewById(R.id.list);

        array.add(new Person("John Doe", 2));
        array.add(new Person("Malcolm", 1));
        array.add(new Person("Lucas", 4));
        array.add(new Person("Steve", 10));

        adapter = new MyAdapter(getApplicationContext(), R.layout.listview_item, array);
        //AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        //animationAdapter.setAbsListView(mListView);
        mListView.setAdapter(adapter);
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


        add = (CircleButton) findViewById(R.id.add);
        add.setOnClickListener(this);
    }

    //METHOD FOR ADD BUTTON
    @Override
    public void onClick(View v) {
        Log.v("BUTT PRESS", "ADD PERSON TO LIST");
        // ADD PERSON TO LIST - DIALOG BOX?
        array.add(new Person("NOG", 666));
        adapter.notifyDataSetChanged();
    }

}
