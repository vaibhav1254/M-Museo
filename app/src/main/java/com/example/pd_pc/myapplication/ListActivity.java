package com.example.pd_pc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
ListView stadiumlistview;
List<Stadium> stadiums;
    StadiumAdapter stadiumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        stadiumlistview = (ListView) findViewById(R.id.stadiumlistview);
        stadiums = new ArrayList<>();
        stadiums.add(new Stadium("Eden Garden","Kolkata",545231231,"edenmail@gmail.com"));
        stadiums.add(new Stadium("The Lords","London",545311231,"thelordsmail@gmail.com"));
        stadiums.add(new Stadium("MCG","Melbourne",545231561,"mcgmail@gmail.com"));
        stadiums.add(new Stadium("The Wanderers","Johannesburg",545231681,"wanmail@gmail.com"));
        stadiums.add(new Stadium("SCG","Sydney",545421231,"scgmail@gmail.com"));
        stadiums.add(new Stadium("The Oval","Kensington",545231231,"ovalmail@gmail.com"));
        stadiums.add(new Stadium("The WACA","Perth",545451231,"wacamail@gmail.com"));
        stadiums.add(new Stadium("Old Trafford","Manchester",545234731,"oldtraffordmail@gmail.com"));
        stadiums.add(new Stadium("Kensington Oval","Barbados",541131231,"kenovalmail@gmail.com"));
        stadiums.add(new Stadium("New Lands","Cape Town",545233231,"newlandsmail@gmail.com"));

        stadiumAdapter = new StadiumAdapter(this,stadiums);
        stadiumlistview.setAdapter(stadiumAdapter);
    }
}
