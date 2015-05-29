package com.example.textfun;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    private static final int STEP = 1;
    private static final int MAX = 60;
    private static final int MIN = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tekst = (TextView) findViewById(R.id.tekst);
        tekst.setTextSize(TypedValue.COMPLEX_UNIT_SP, MIN);

        Button czarnyButton = (Button) findViewById(R.id.button1);
        Button czerwonyButton = (Button) findViewById(R.id.button3);
        Button niebieskiButton = (Button) findViewById(R.id.button2);

        SeekBar rozmiar = (SeekBar) findViewById(R.id.seekBar);

        czarnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setTextColor(Color.BLACK);
            }
        });

        czerwonyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setTextColor(Color.RED);
            }
        });

        niebieskiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tekst.setTextColor(Color.BLUE);
            }
        });

        rozmiar.setMax((MAX - MIN) / STEP );
        rozmiar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = MIN + (progress * STEP);
                tekst.setTextSize(TypedValue.COMPLEX_UNIT_SP, value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
