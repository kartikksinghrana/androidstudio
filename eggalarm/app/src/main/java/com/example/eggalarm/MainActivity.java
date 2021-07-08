package com.example.eggalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView counter;
    ImageView imageht;
    SeekBar timer;
    boolean counterisactive=false;
    CountDownTimer countdowntime;
    Button gobutton;
    public void count(View view){
        if (counterisactive)
        {
            timer.setProgress(20);
            timer.setEnabled(true);
            gobutton.setText("Start!");
            countdowntime.cancel();
            mediaPlayer.pause();
            imageht.setImageResource(R.drawable.ht);
            counterisactive=false;
        }
        else
        {
            timer.setEnabled(false);
            gobutton.setText("Stop!");
            counterisactive=true;
            countdowntime = new CountDownTimer(timer.getProgress() * 1000, 1000) {
                public void onTick(long l) {
                    updatetime((int) l / 1000);
                }

                public void onFinish() {
                    Log.i("msg count", "Long.toString(l)");
                    mediaPlayer.start();
                    imageht.setImageResource(R.drawable.htw);
                }
            }.start();
        }
    }
    public void updatetime(int secondsLeft)
    {
        int minutes= secondsLeft/60;
        int seconds= secondsLeft - (minutes*60);
        String secondString= Integer.toString(seconds);
        if (seconds<=9)
        {
            secondString="0"+secondString;
        }
        counter.setText(Integer.toString(minutes)+":"+secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (SeekBar) findViewById(R.id.seekBar);
        counter =(TextView)findViewById(R.id.counter);
        gobutton= (Button)findViewById(R.id.gobutton);
        timer.setMax(600);
        timer.setProgress(20);
        imageht = (ImageView)findViewById(R.id.imageView);
        imageht.setImageResource(R.drawable.ht);
        timer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                updatetime(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mediaPlayer = MediaPlayer.create(this , R.raw.humtum);
    }
}