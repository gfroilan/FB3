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
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

//EmotionRecorded activity makes userData ArrayList<String> that contains timestamp, emotion, and comment 
public class EmotionRecorded extends AppCompatActivity {

    //class vars
    public static ArrayList<String> userData = new ArrayList<>();
    private TextInputLayout textInputComment;

    @Override
    //onCreate appends user emotion to userData from FeelsBookHome
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_recorded);
        textInputComment = findViewById(R.id.text_user_comment);

        Intent intent = getIntent();
        String emotion_input = intent.getStringExtra(FeelsBookHome.EMOTION_INPUT);      //get public string EMOTION_INPUT from FeelsBookHome and store into emotion_input
        String message = getString(R.string.emotion_recorded_text);                     //getString in emotion_recorded_text from strings.xml and store in message
        message += emotion_input;                                                       //append emotion_input string to message string
        TextView textView = (TextView) findViewById(R.id.text_emotion_recorded);        //get of text_emotion_recorded from text_emotion_recorded.xml
        textView.setText(message);                                                      //output message to textView
        userData.add(emotion_input);
    }

    //Intent for navigating from home to EmotionRecorded activity
    //Appends timestamp for userData string
    public static Intent makeIntent(Context context) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.CANADA).format(new Date());
        userData.add(timeStamp);
        return new Intent(context, EmotionRecorded.class);
    }

    //Checks if comment has reached the 100 character limit
    //Gets user comment
    private boolean commentCheck(){
        String commentInput = textInputComment.getEditText().getText().toString();
        if (commentInput.length() > 100){
            textInputComment.setError("Comment has surpassed the max of 100 characters");
            return false;
        } else {
            textInputComment.setError(null);
            return true;
        }
    }

    //Validates that comment has followed constraints
    public void confirmInput(View v){
        if (!commentCheck()){
            return;
        }
    }

    //Handles the cancel button when user doesn't want to enter a comment
    //Navigates the user back to home
    public void enterEmotionCancel(View view) {
        Button btn  = (Button) findViewById(R.id.button_cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData.add("No comment");
                Intent intent = FeelsBookHome.makeHomeIntent(EmotionRecorded.this);
                startActivity(intent);
            }
        });
    }

    //Handles the enter button when the user wants to enter a comment
    //Appends user comment to userData string
    //Navigates the user back to home
    public void enterEmotionEnter(View view) {
        Button btn  = (Button) findViewById(R.id.button_enter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentText = textInputComment.getEditText().getText().toString();
                userData.add(commentText);
                Intent intent = FeelsBookHome.makeHomeIntent(EmotionRecorded.this);
                startActivity(intent);
            }
        });
    }

}
