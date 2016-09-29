package com.example.cisc.mysoundfx;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //page 169 step 9
    private SoundPool soundPool;
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        try
        {
            //create objects of the 2 required classes
            AssetManager assetsManager = getAssets();
            AssetFileDescriptor descriptor;

            //create our three fx in memory ready for use
            descriptor = assetsManager.openFd("coin.wav");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetsManager.openFd("jump.wav");
            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetsManager.openFd("powerup.wav");
            sample3 = soundPool.load(descriptor, 0);
        }
        catch (IOException e)
        {

            Context context = getApplicationContext();
            CharSequence text = "BUTTON NOT FOUND!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        //Make a button from each of the 3 buttons in our layout
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        //make each of them listen for clicks
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.button:  //when the first button is pressed
                //play sample 1
                soundPool.play(sample1,1,1,0,0,1);
                break;
            case R.id.button2:  //when the first button is pressed
                //play sample 1
                soundPool.play(sample2,1,1,0,0,1);
                break;
            case R.id.button3:  //when the first button is pressed
                //play sample 1
                soundPool.play(sample3,1,1,0,0,1);
                break;

        }
    }
}
