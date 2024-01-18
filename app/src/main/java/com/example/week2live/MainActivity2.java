package com.example.week2live;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ProgressBar progressBar;
    private SeekBar seekBar;
    private Integer progress;
    private Integer oldProgress;
    private GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressBar = findViewById(R.id.progressBar);
        seekBar = findViewById(R.id.seekBar);
        int score = getIntent().getIntExtra("score", 0);
        progress = score;
        progressBar.setProgress(score);
        seekBar.setProgress(score);

        seekBar.setOnSeekBarChangeListener(this);

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener(this));

        ConstraintLayout root =findViewById(R.id.rootView);
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity2.this, "Down in Root", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity2.this, "UP in Root", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity2.this, "Move in Root", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(MainActivity2.this, "Down in Activity", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(MainActivity2.this, "UP in Activity", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Toast.makeText(MainActivity2.this, "Move in Activity", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
        // return super.onTouchEvent(event); //call this if you did not handle the event
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetectorCompat.onTouchEvent(event);
                /*int action = event.getActionMasked();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity2.this, "Down", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity2.this, "UP", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Toast.makeText(MainActivity2.this, "Move", Toast.LENGTH_SHORT).show();
                        break;

                }*/
                return true;
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("MyTag","Progresschanged");
        progressBar.setProgress(progress);
        this.progress = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        oldProgress = progress;
    }

    @Override
    public void onStopTrackingTouch(final SeekBar seekBar) {
        Snackbar snackbar = Snackbar.make(seekBar/*findViewById(R.id.rootView)*/, "Progress Changed", BaseTransientBottomBar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(oldProgress);
                seekBar.setProgress(oldProgress);
                progress = oldProgress;
                Toast.makeText(MainActivity2.this, "Progress is changed to "+oldProgress, Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }
}