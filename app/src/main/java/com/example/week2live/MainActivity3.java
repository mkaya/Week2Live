package com.example.week2live;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        GridLayout gridLayout = findViewById(R.id.rooLayout);
        int column = getIntent().getIntExtra("column",4);
        gridLayout.setColumnCount(column);
        for (int i=0; i<column*column; i++){
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1.0f
            );

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(param);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paper_plane, null));
            imageView.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border, null));
            gridLayout.addView(imageView);
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity3.this, "i="+ finalI, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}