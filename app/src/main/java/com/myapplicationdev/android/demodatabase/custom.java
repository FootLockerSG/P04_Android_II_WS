package com.myapplicationdev.android.demodatabase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class custom extends ArrayAdapter {

    private ArrayList<Task> tasks;
    private Context context;
    TextView tvID, tvDesc, tvDate;

    public custom(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        tasks = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_custom, parent, false);
        tvID = rowView.findViewById(R.id.tvId);
        tvDesc = rowView.findViewById(R.id.tvDesc);
        tvDate = rowView.findViewById(R.id.tvDate);
        Task task = tasks.get(position);

        tvID.setText(Integer.toString(task.getId()));
        tvDate.setText(task.getDate());
        tvDesc.setText(task.getDescription());

        return rowView;

    }
}
