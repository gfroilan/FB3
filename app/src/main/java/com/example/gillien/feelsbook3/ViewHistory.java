/*
 * froilan-FeelsBook
 * Course: CMPUT 301 Fa18
 * ccid: froilan
 * Author: Gillien Froilan
 * Date: October 5th, 2018
 * Version: 1
 * Copyright: MIT
 *
 *
 */
package com.example.gillien.feelsbook3;

//import
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;

//Creates ViewHistory activity that allows user to view history of emotions
public class ViewHistory extends AppCompatActivity {

    //class vars
    private static final String TAG = "ViewHistory";
    private ArrayList<String> mData = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    //Initializes ViewHistory activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        Log.d(TAG, "onCreate: started.");

        recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initUserData();

    }

    //Initializes the userData string from EmotionRecorded into groups of three elements
    private void initUserData() {
        Log.d(TAG, "initUserData: preparing emotion data.");

        ArrayList<String> data = EmotionRecorded.userData;
        ArrayList<ArrayList<String>> parts = chopped(data, 3);
        for (ArrayList<String> A : parts) {
            String group = A.toString();
            mData.add(group);
        }

        initRecyclerView();

    }

    //Initializes recyclerview widget to incorporate initialized data
    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mData, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //Navigates to and from ViewHistory activity
    public static Intent makeViewIntent(Context context) {
        return new Intent(context, ViewHistory.class);
    }

    //Chopped method splits userData ArrayList<String> into parts
    static <T> ArrayList<ArrayList<String>> chopped(ArrayList<String> list, final int L) {
        ArrayList<ArrayList<String>> parts = new ArrayList<ArrayList<String>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<String>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }
}

//Was not able to implement Delete and Edit entry functionalities in this class
//Was not able to implement persistance in this class
