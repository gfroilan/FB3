package com.example.gillien.feelsbook3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeelsBookHome extends AppCompatActivity {

    public static String EMOTION_INPUT;
    public static String TIME_STAMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels_book_home);

        //sendLove();
        //sendFear();
        //sendJoy();
        //sendAnger();
        //sendSadness();
        //sendSurprise();
    }

    public void sendLove(View view) {
        Button btn = (Button) findViewById(R.id.button_love);
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

    public void sendAnger(View view) {
        Button btn = (Button) findViewById(R.id.button_anger);
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

    public void sendJoy(View view) {
        Button btn = (Button) findViewById(R.id.button_joy);
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

    public void sendFear(View view) {
        Button btn = (Button) findViewById(R.id.button_fear);
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

    public void sendSurprise(View view) {
        Button btn = (Button) findViewById(R.id.button_surprise);
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

    public void sendSadness(View view) {
        Button btn = (Button) findViewById(R.id.button_sadness);
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

    public static Intent makeHomeIntent(Context context) {
        return new Intent(context, FeelsBookHome.class);
    }

    public void gotoDelete(View view) {
        Button btn = (Button) findViewById(R.id.button_delete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = DeleteEmotions.makeDeleteIntent(FeelsBookHome.this);
                startActivity(intent);
            }
        });
    }
}
