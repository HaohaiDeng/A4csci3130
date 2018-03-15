package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class ViewListActivity extends Activity {


    private ListView contactListView;
    private FirebaseListAdapter<Buiness> firebaseAdapter;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appState = (MyApplicationData)getApplicationContext();

        //Get the reference to the UI contents
        contactListView = (ListView) findViewById(R.id.listView);

        //Set up the List View
       firebaseAdapter = new FirebaseListAdapter<Buiness>(this, Buiness.class,
                android.R.layout.simple_list_item_1, appState.firebaseReference) {
            @Override
            protected void populateView(View v, Buiness model, int position) {
                TextView contactName = (TextView)v.findViewById(android.R.id.text1);
                contactName.setText(model.Name);
                Toast.makeText(getApplicationContext(), model.Name, Toast.LENGTH_LONG).show();
            }
        };
        contactListView.setAdapter(firebaseAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Buiness person = (Buiness) firebaseAdapter.getItem(position);
                showDetailView(person);
            }
        });
    }

    public void createContactButton(View v)
    {
        Intent intent = new Intent(this, CreateBuinessAcitivity.class);
        startActivity(intent);
    }

    private void showDetailView(Buiness person)
    {
        Intent intent = new Intent(this, DetailViewActivity.class);
        intent.putExtra("Business", person);
        startActivity(intent);
    }

}
