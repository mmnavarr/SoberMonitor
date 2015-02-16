package com.cyberplays.sobermonitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malcolmnavarro on 2/3/15.
 */
public class MyAdapter extends ArrayAdapter<Person> {
    private final Context context;
    private ArrayList<Person> peeps = new ArrayList<Person>();
    private final int resource;
    private LayoutInflater mInflater;
    private TextView name, mult;

    public MyAdapter(Context context, int resource, ArrayList<Person> peeps) {
        super(context, resource, peeps);
        this.context = context;
        this.peeps = peeps;
        this.resource = resource;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return peeps.size();
    }

    @Override
    public Person getItem(int position) {
        return peeps.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(position, convertView, parent, resource);
    }

    private View createViewFromResource(int position, View convertView,
                                        ViewGroup parent, int resource) {
        View v;
        if (convertView == null) {
            v = mInflater.inflate(resource, parent, false);
            name = (TextView) v.findViewById(R.id.name);

            mult = (TextView) v.findViewById(R.id.multiplier);
        } else {
            v = convertView;
        }

        name.setText(peeps.get(position).getName());

        mult.setText("x" + peeps.get(position).getMult());

        return v;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }


}
