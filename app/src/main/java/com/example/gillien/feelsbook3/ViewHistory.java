package com.example.gillien.feelsbook3;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;


public class ViewHistory extends AppCompatActivity {

    private static final String TAG = "DeleteEmotions";
    //ListView listView;
    private ArrayList<String> mData = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        Log.d(TAG, "onCreate: started.");

        recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setHasFixedSize(true);

        initUserData();

        //adapter = new RecyclerViewAdapter(mData, this);
        //recyclerView.setAdapter(adapter);
    }

    private void initUserData() {
        Log.d(TAG, "initUserData: preparing emotion data.");

        //int count = 0;
        ArrayList<String> data = EmotionRecorded.userData;
        ArrayList<ArrayList<String>> parts = chopped(data, 3);
        for (ArrayList<String> A : parts) {
            String group = A.toString();
            mData.add(group);
        }
        //count++;

        initRecyclerView();

    }
    private void initRecyclerView(){

        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mData, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        Log.d(TAG, "Item Selected: called.");


        switch (item.getItemId()){
            case 121:
                displayMessage("Entry Deleted...");
                return true;

            case 122:
                displayMessage("Entry Editing...");
                return true;

            default:
                return super.onContextItemSelected(item);

        }
    }

    private void displayMessage(String message){

        Snackbar.make(findViewById(R.id.view_layout), message, Snackbar.LENGTH_SHORT).show();
    }

    public static Intent makeViewIntent(Context context) {
        return new Intent(context, ViewHistory.class);
    }

    static <T> ArrayList<ArrayList<String>> chopped(ArrayList<String> list, final int L) {
        ArrayList<ArrayList<String>> parts = new ArrayList<ArrayList<String>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L){
            parts.add(new ArrayList<String>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }

    /*@Override
    public boolean onContextItemSelected(MenuItem item){
        Log.d(TAG, "Item Selected: called.");


        switch (item.getItemId()){
            case 121:
                displayMessage("Entry Deleted...");
                return true;

            case 122:
                displayMessage("Entry Editing...");
                return true;

            default:
                return super.onContextItemSelected(item);

        }
    }

    private void displayMessage(String message){

        Snackbar.make(findViewById(R.id.view_layout), message, Snackbar.LENGTH_SHORT).show();
    }*/



    /*@Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = -1;
        try{
            //RecyclerView recyclerView = findViewById(R.id.context_menu_layout);
            RecyclerViewAdapter.ViewHolder holder = new RecyclerViewAdapter.ViewHolder(View v);
            position = RecyclerView.ViewHolder.getAdapterPosition();
        } catch (Exception e) {
            Log.d(TAG, e.getLocalizedMessage(), e);
            return super.onContextItemSelected(item);
        }
        switch (item.getItemId()){
            case R.id.menu_delete:
                break;
            case R.id.menu_edit:
                break;
        }
        return super.onContextItemSelected(item);
    }*/


}

