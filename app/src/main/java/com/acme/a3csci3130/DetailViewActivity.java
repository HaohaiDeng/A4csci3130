package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class DetailViewActivity extends Activity {

    private EditText ID, nameField, PBField, AddressField, ProvinceField;
    Buiness receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Buiness) getIntent().getSerializableExtra("Business");
        appState = ((MyApplicationData) getApplicationContext());


        ID = (EditText) findViewById(R.id.id_U);
        nameField = (EditText) findViewById(R.id.name_U);
        PBField = (EditText) findViewById(R.id.PB_U);
        AddressField = (EditText) findViewById(R.id.Address_U);
        ProvinceField = (EditText) findViewById(R.id.province_U);

        if(receivedPersonInfo != null){
            ID.setText(String.valueOf(receivedPersonInfo.Bid));
            nameField.setText(receivedPersonInfo.Name);
            PBField.setText(receivedPersonInfo.Pbusiness);
            AddressField.setText(receivedPersonInfo.Address);
            ProvinceField.setText(receivedPersonInfo.Province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        String keyid = receivedPersonInfo.id;
        String id = ID.getText().toString();
        String name = nameField.getText().toString();
        String PB = PBField.getText().toString();
        String address = AddressField.getText().toString();
        String province = ProvinceField.getText().toString();
        if (TextUtils.isEmpty(id)){
            ID.setError("Required");
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

        receivedPersonInfo = new Buiness(keyid, Convert_id, name, PB, address, province);
        appState.firebaseReference.child(keyid).setValue(receivedPersonInfo, new DatabaseReference.CompletionListener() {
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

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String keyid = receivedPersonInfo.id;

        appState.firebaseReference.child(keyid).removeValue();

        finish();
    }
}
