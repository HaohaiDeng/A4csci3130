package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class CreateBuinessAcitivity extends Activity {

    private Button submitButton;
    private EditText IDField, nameField, PBField, AddressField, ProvinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        IDField = (EditText) findViewById(R.id.id);
        nameField = (EditText) findViewById(R.id.name);
        PBField = (EditText) findViewById(R.id.PB);
        AddressField = (EditText) findViewById(R.id.Address);
        ProvinceField = (EditText) findViewById(R.id.province);

    }


    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String id = IDField.getText().toString();
        String name = nameField.getText().toString();
        String PB = PBField.getText().toString();
        String address = AddressField.getText().toString();
        String province = ProvinceField.getText().toString();

        if (TextUtils.isEmpty(id)){
            IDField.setError("Required");
            return;
        }
        if (TextUtils.isEmpty(name)){
            nameField.setError("Required");
            return;
        }
        if (TextUtils.isEmpty(PB)){
            PBField.setError("Required");
            return;
        }

        int Convert_id = Integer.parseInt(id);

        Buiness person = new Buiness(personID, Convert_id, name, PB, address, province);

        appState.firebaseReference.child(personID).setValue(person, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Toast.makeText(getApplicationContext(), "Some error occured, try again", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "added to database successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}
