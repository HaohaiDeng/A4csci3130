package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Buiness implements Serializable {

    public  String id;
    public  int Bid;
    public  String Name;
    public  String Pbusiness;
    public  String Address;
    public  String Province;

    public Buiness() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Buiness(String id, int Bid, String Name, String Pbusiness, String Address, String Province){
        this.id = id;
        this.Bid = Bid;
        this.Name = Name;
        this.Pbusiness = Pbusiness;
        this.Address = Address;
        this.Province = Province;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("Bid", Bid);
        result.put("name", Name);
        result.put("Primary business", Pbusiness);
        result.put("Address", Address);
        result.put("Province", Province);

        return result;
    }
}
