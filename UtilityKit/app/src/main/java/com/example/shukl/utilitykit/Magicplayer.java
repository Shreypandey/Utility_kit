package com.example.shukl.utilitykit;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Magicplayer extends AppCompatActivity implements SensorEventListener{
    MediaPlayer mp;
    SensorManager sa;
    Sensor s;
    Button b1;
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.values[0]>2)
        {
            mp.start();
        }
        else{
            mp.pause();
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magicplayer);
        mp = MediaPlayer.create(this, R.raw.song);
        b1=(Button)findViewById(R.id.button10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Magicplayer.this,Media_player.class);
                startActivity(i);
                finish();
                mp.stop();
            }
        });
        sa = (SensorManager) getSystemService(SENSOR_SERVICE);
        s = sa.getDefaultSensor(Sensor.TYPE_LIGHT);
        sa.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);


    }





}
