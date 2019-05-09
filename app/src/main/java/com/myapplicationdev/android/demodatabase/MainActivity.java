package com.myapplicationdev.android.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnTasks;
    ListView lv;
    ArrayAdapter<Task> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnTasks = findViewById(R.id.btnTasks);
        lv = findViewById(R.id.listview);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });



        btnTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> data = db.getTasks();
                db.close();

                //String txt = "";
                //for (int i = 0; i < data.size(); i++) {
                //    Log.d("Database Content", i +". "+data.get(i));
                //    txt += i + ". " + data.get(i) + "\n";
                //}
                //tvResults.setText(txt);

                aa = new custom(MainActivity.this,R.layout.activity_custom, data);
                lv.setAdapter(aa);
            }
        });




    }
}
