package com.example.gillien.feelsbook3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ViewHistory extends AppCompatActivity {

    private static final String TAG = "DeleteEmotions";

    //vars
    private ArrayList<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        Log.d(TAG, "onCreate: started.");

        initUserData();
    }

    private void initUserData() {
        Log.d(TAG, "initUserData: preparing emotion data.");
        String data = EmotionRecorded.userData.toString();
        mData.add("Singapore");
        mData.add("Philippines");
        mData.add("Canada");
        mData.add("America");
        mData.add("Jamaica");
        mData.add("Japan");
        mData.add("Indonesian");
        mData.add("Thailand");
        mData.add("China");
        mData.add("Switzerland");
        mData.add("Iceland");
        mData.add(data);


        initRecyclerView();


    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mData, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
    }

    public static Intent makeViewIntent(Context context) {
        return new Intent(context, ViewHistory.class);
    }
}
