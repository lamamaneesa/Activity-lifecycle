package com.example.activitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText messageEdit;
    private static final String LOG_TAB = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.Activity.extra.MESSAGE";

    private TextView textViewMessage;
    private TextView textViewReply;
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageEdit = findViewById(R.id.editText);

        textViewMessage = findViewById(R.id.textViewMessage);
        textViewReply = findViewById(R.id.text_reply);

    }

    public void nextPage(View view) {
        Log.d(LOG_TAB, "Button clicked");
        Intent intent = new Intent(this, SecondPage.class);
        String message = messageEdit.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAB, "onStart");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAB, "onPause");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAB, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAB, "onRestart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAB, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAB, "onDestroy");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondPage.EXTRA_REPLY);
                textViewMessage.setVisibility(View.VISIBLE);
                textViewReply.setText(reply);
                textViewReply.setVisibility(View.VISIBLE);
            }
        }
    }
}
