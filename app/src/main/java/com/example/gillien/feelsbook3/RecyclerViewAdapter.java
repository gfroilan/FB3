package com.example.gillien.feelsbook3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mEmotionData;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> emotionData, Context context){
        mEmotionData = emotionData;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_viewhistory, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        viewHolder.emotionData.setText(mEmotionData.get(i));

        viewHolder.deleteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mEmotionData.get(i));
                Toast.makeText(mContext, mEmotionData.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmotionData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView emotionData;
        ConstraintLayout deleteLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            emotionData = itemView.findViewById(R.id.emotion_data);
            deleteLayout = itemView.findViewById(R.id.view_layout);

        }
    }
}
