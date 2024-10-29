package com.example.xigemajia_100.system;

import android.media.MediaPlayer;

import com.example.xigemajia_100.R;

public class musicsystem extends Thread{
    public musicsystem(){}
    public void run(){
        mainsystem.mediaPlayer = MediaPlayer.create(mainsystem.context, R.raw.bgm);
        mainsystem.mediaPlayer.setLooping(true);
        mainsystem.mediaPlayer.start();
    }
}
