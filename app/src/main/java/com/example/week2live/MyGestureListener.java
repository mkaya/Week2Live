package com.example.week2live;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    private Context my_activity_context;
    public MyGestureListener(Context context){
        my_activity_context = context;
    }
    @Override
    public void onLongPress(MotionEvent e) {


        super.onLongPress(e);
        Toast.makeText(my_activity_context, "Long Press", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(my_activity_context, MainActivity3.class);
        intent.putExtra("column", 6);
        my_activity_context.startActivity(intent);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("DoubleTap","TTT");
        Toast.makeText(my_activity_context, "Double Tap", Toast.LENGTH_SHORT).show();
        return super.onDoubleTap(e);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX() < e2.getX()){
            Toast.makeText(my_activity_context, "Fling Right", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(my_activity_context, "Fling Left", Toast.LENGTH_SHORT).show();
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}