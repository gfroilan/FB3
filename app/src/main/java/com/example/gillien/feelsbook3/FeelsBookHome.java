package com.example.gillien.feelsbook3;

//import
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Home Page of FeelsBook app
public class FeelsBookHome extends AppCompatActivity {

    //class vars
    public static String EMOTION_INPUT;

    @Override
    //Called when app icon is clicked on
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels_book_home);
    }

    //Handles when user enters love emotion
    //Navigates to comment activity
    public void sendLove(View view) {
        Button btn = findViewById(R.id.button_love);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = "love";
                Intent intent = EmotionRecorded.makeIntent(FeelsBookHome.this);
                intent.putExtra(EMOTION_INPUT, emotion);
                startActivity(intent);
            }
        });
    }

    //Handles when user enters anger emotion
    //Navigates to comment activity
    public void sendAnger(View view) {
        Button btn = findViewById(R.id.button_anger);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = "anger";
                Intent intent = EmotionRecorded.makeIntent(FeelsBookHome.this);
                intent.putExtra(EMOTION_INPUT, emotion);
                startActivity(intent);
            }
        });
    }

    //Handles when user enters joy emotion
    //Navigates to comment activity
    public void sendJoy(View view) {
        Button btn = findViewById(R.id.button_joy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = "joy";
                Intent intent = EmotionRecorded.makeIntent(FeelsBookHome.this);
                intent.putExtra(EMOTION_INPUT, emotion);
                startActivity(intent);
            }
        });
    }

    //Handles when user enters fear emotion
    //Navigates to comment activity
    public void sendFear(View view) {
        Button btn = findViewById(R.id.button_fear);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = "fear";
                Intent intent = EmotionRecorded.makeIntent(FeelsBookHome.this);
                intent.putExtra(EMOTION_INPUT, emotion);
                startActivity(intent);
            }
        });
    }

    //Handles when user enters surprise emotion
    //Navigates to comment activity
    public void sendSurprise(View view) {
        Button btn = findViewById(R.id.button_surprise);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = "surprise";
                Intent intent = EmotionRecorded.makeIntent(FeelsBookHome.this);
                intent.putExtra(EMOTION_INPUT, emotion);
                startActivity(intent);
            }
        });
    }

    //Handles when user enters sadness emotion
    //Navigates to comment activity
    public void sendSadness(View view) {
        Button btn = findViewById(R.id.button_sadness);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emotion = "sadness";
                Intent intent = EmotionRecorded.makeIntent(FeelsBookHome.this);
                intent.putExtra(EMOTION_INPUT, emotion);
                startActivity(intent);
            }
        });
    }

    //Handles when user navigates to and from home page
    public static Intent makeHomeIntent(Context context) {
        return new Intent(context, FeelsBookHome.class);
    }

    //Handles when user wants to view history
    //Navigates to and from ViewHistory activity
    public void gotoDelete(View view) {
        Button btn = findViewById(R.id.button_history);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ViewHistory.makeViewIntent(FeelsBookHome.this);
                startActivity(intent);
            }
        });
    }

    //Handles when user wants to view statistics
    //Navigates to and from ViewStats activity
    public void gotoStats(View view) {
        Button btn = findViewById(R.id.button_stats);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ViewStats.makeStatsIntent(FeelsBookHome.this);
                startActivity(intent);
            }
        });
    }

}
