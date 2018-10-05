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

    private static final String TAG = "ViewHistory";
    private ArrayList<String> mData = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        Log.d(TAG, "onCreate: started.");

        recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initUserData();

    }

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

    private void initRecyclerView() {

        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mData, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public static Intent makeViewIntent(Context context) {
        return new Intent(context, ViewHistory.class);
    }

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

