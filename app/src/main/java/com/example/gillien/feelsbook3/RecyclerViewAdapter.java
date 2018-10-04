package com.example.gillien.feelsbook3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mEmotionData;
    //private Context mContext;
    //private int position;

    public RecyclerViewAdapter(ArrayList<String> emotionData, Context context) {
        mEmotionData = emotionData;
        //mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_viewhistory, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        viewHolder.emotionData.setText(mEmotionData.get(i));
     
    }

    @Override
    public int getItemCount() {
        return mEmotionData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        TextView emotionData;
        CardView cardView;

        public ViewHolder(View v) {
            
            super(v);

            emotionData = v.findViewById(R.id.emotion_data);
            cardView = itemView.findViewById(R.id.view_layout);
            cardView.setOnCreateContextMenuListener(this);
            Log.d(TAG, "cardview: called.");

        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            Log.d(TAG, "onCreateContextMenu: called.");
            contextMenu.setHeaderTitle("Select an Option");
            contextMenu.add(this.getAdapterPosition(), 121, 0, "Delete Entry");
            contextMenu.add(this.getAdapterPosition(), 122, 1, "Edit Entry");
        }
    }

    /*public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }   */

    /*public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        public TextView emotionData;
        public ConstraintLayout viewLayout;

        public ViewHolder(View v) {
            super(v);
            emotionData = itemView.findViewById(R.id.emotion_data);
            viewLayout = itemView.findViewById(R.id.view_layout);
            v.setOnCreateContextMenuListener(this);

        }       */

        /*@Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menu.setHeaderTitle("Select an Action");
            menu.add(Menu.NONE, R.id.menu_delete, Menu.NONE, R.string.menu_delete);
            menu.add(Menu.NONE, R.id.menu_edit, Menu.NONE, R.string.menu_edit);
        }
    }    */
}
    