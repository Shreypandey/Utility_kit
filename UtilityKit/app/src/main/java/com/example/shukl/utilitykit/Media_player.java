package com.example.shukl.utilitykit;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.VideoView;

public class Media_player extends AppCompatActivity {
  private  MediaPlayer mp;
   private SeekBar seekBar;
    private Button b1,b2,b5,b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        b1=(Button)findViewById(R.id.mediaPlay);
        b2=(Button)findViewById(R.id.mediaPause);
        b5=(Button)findViewById(R.id.mediaStop);
        b6=(Button)findViewById(R.id.mediaNext);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Media_player.this,Magicplayer.class);
                startActivity(i);
                finish();
                mp.pause();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setEnabled(false);
                b2.setEnabled(true);
                b1.setCursorVisible(false);
                b2.setCursorVisible(false);
                mp.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setEnabled(false);
                b1.setEnabled(true);
                b2.setCursorVisible(false);
                b1.setCursorVisible(false);
                mp.pause();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });
        mp=MediaPlayer.create(getApplicationContext(),R.raw.song);
        seekBar.setMax(mp.getDuration());


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if (input)
                {
                    mp.seekTo(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });}}




