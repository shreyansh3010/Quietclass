package com.shreyanshvit.quietclass;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mStart, mStop;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStart = (Button) findViewById(R.id.start);
        mStop = (Button) findViewById(R.id.stop);
        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

            }
        });
    }
}
