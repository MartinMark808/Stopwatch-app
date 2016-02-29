package com.martin.stopwatch.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;


public class Stopwatch extends Activity {
 //Number of seconds displayed on the stopwatch.
 private int centiseconds = 0;
 //Is the stopwatch running?
 private boolean running;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_stopwatch);
 runTimer();
 }

 //Start the stopwatch running when the Start button is clicked.
 public void onClickStart(View view) {
 running = true;
 }
 //Stop the stopwatch running when the Stop button is clicked.
 public void onClickStop(View view) {
 running = false;
 }
    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        centiseconds = 0;
    }
    //Sets the number of seconds on the timer.
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes = centiseconds/3600;
                int secs = (centiseconds%3600)/60;
                int centi = centiseconds%60;
                String time = String.format("%02d:%02d:%02d", minutes, secs, centi);
                timeView.setText(time);
                if (running) {
                    centiseconds++;
                }
                handler.postDelayed(this, 1);
            }
        });
    }
}