package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audiomanager;
    public void play(View view)
    {
        mediaPlayer.start();
    }
    public void pause (View view)
    {
        mediaPlayer.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        audiomanager= (AudioManager)getSystemService(AUDIO_SERVICE);
        int currentvolume = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxvolume = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this ,R.raw.yalgaar);
        SeekBar volumecontrol = (SeekBar)findViewById(R.id.volumeseekBar);
        volumecontrol.setMax(maxvolume);
        volumecontrol.setProgress(currentvolume);
        volumecontrol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("volume changed", Integer.toString(progress));
                audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar musictrack = (SeekBar) findViewById(R.id.musictrackseekBar);
        musictrack.setMax(mediaPlayer.getDuration());
        musictrack.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("track skipped",Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                musictrack.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,30000);

    }
}