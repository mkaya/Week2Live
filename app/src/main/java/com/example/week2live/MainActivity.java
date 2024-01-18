package com.example.week2live;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String LogKey = "LogKey";
    private Integer score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LogKey,"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LogKey,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LogKey,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LogKey,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LogKey,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LogKey,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LogKey,"onRestart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LogKey,"onSaveInstanceState");
        outState.putInt("score",score);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("score");
        TextView textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(score));
        Log.d(LogKey,"onRestoreInstanceState");
    }
    public void Up(View view) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(Integer.toString(++score));
    }

    public void GoNext(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }

}