package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by denghaohai on 13/03/2018.
 */

public class initial_pageActivity extends Activity {
    private Button create;
    private Button viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_page);

        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("Businesses");

        create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(initial_pageActivity.this, CreateBuinessAcitivity.class);
                startActivity(intent);
            }
        });
        viewall = (Button) findViewById(R.id.view);
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(initial_pageActivity.this, ViewListActivity.class);
                startActivity(intent2);
            }
        });
    }
}
