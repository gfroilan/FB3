package com.example.gillien.feelsbook3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmotionRecorded extends AppCompatActivity {

    public static ArrayList<String> userData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_recorded);

        Intent intent = getIntent();
        String emotion_input = intent.getStringExtra(FeelsBookHome.EMOTION_INPUT);      //get public string EMOTION_INPUT from FeelsBookHome and store into emotion_input
        String message = getString(R.string.emotion_recorded_text);                     //getString in emotion_recorded_text from strings.xml and store in message
        String addon =  getString(R.string.comment_intsruction);
        message += emotion_input;                                                       //append emotion_input string to message string
        message = message + "\n" + addon;
        TextView textView = (TextView) findViewById(R.id.text_emotion_recorded);        //get of text_emotion_recorded from activity_emotion_recorded.xml
        textView.setText(message);                                                      //output emotion_inout to textView
        userData.add(emotion_input);
        //timeAdd();
    }

    /*public void timeAdd(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd.HH:mm").format(new Date());
        userData.add(timeStamp);
    }*/

    public static Intent makeIntent(Context context) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd.HH:mm").format(new Date());
        userData.add(timeStamp);
        return new Intent(context, EmotionRecorded.class);
    }

    public void enterEmotionCancel(View view) {
        Button btn  = (Button) findViewById(R.id.button_cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FeelsBookHome.makeHomeIntent(EmotionRecorded.this);
                startActivity(intent);
            }
        });
    }

    public void enterEmotionEnter(View view) {
        Button btn  = (Button) findViewById(R.id.button_enter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userComment = (EditText)findViewById(R.id.text_user_comment);
                String comment = userComment.getText().toString();
                userData.add(comment);
                Intent intent = FeelsBookHome.makeHomeIntent(EmotionRecorded.this);
                startActivity(intent);
            }
        });
    }
}
