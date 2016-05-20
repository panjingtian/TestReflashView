package com.pjt.testreflashview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ReFlashListView listView=null;
    ArrayAdapter<String>adapter=null;
    Toolbar toolbar=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ReFlashListView) findViewById(R.id.listView);
        toolbar= (Toolbar) findViewById(R.id.view);
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "afsaf", Toast.LENGTH_SHORT).show();
            }
        });
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
                new String[]{"1312","1312312","1312","1312","1312","1312","1312","1312","1312","1312",
                        "1312","1312","1312","1312","1312","1312","1312","1312","1312","1312",
                        "1312","1312","1312","1312",});

        listView.initView(getApplicationContext());
        listView.setAdapter(adapter);

    }
}
