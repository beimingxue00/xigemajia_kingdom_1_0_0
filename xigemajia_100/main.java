package com.example.xigemajia_100;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xigemajia_100.system.initsystem;
import com.example.xigemajia_100.system.mainsystem;
import com.example.xigemajia_100.system.musicsystem;

public class main  extends AppCompatActivity implements View.OnClickListener{
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    ScrollView sc;
    EditText txt;
    LinearLayout lin;
    Thread t1;
    initsystem ini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_out);//初始页面

        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        bt5=findViewById(R.id.button5);
        bt6=findViewById(R.id.button6);
        sc=findViewById(R.id.scrollview);
        lin=findViewById(R.id.texts);
        txt=findViewById(R.id.editText);
        txt.setHint("非快捷键请在此输入......");
        //初始化
        Handler handler=new Handler();
        mainsystem.getInstance().viewinit(bt1,bt2,bt3,bt4,bt5,bt6,sc,txt,lin,handler,this);

        bt1.setOnClickListener(this::onClick);
        bt2.setOnClickListener(this::onClick);
        bt3.setOnClickListener(this::onClick);
        bt4.setOnClickListener(this::onClick);
        bt5.setOnClickListener(this::onClick);
        bt6.setOnClickListener(this::onClick);

        ini=new initsystem();
        t1=new Thread(ini);
        musicsystem mus=new musicsystem();
        Thread t2=new Thread(mus);
        t2.start();
        t1.start();
    }
    public void onClick(View view){
        if(t1.getState()==Thread.State.WAITING){
            int b=0;
            if(view.getId()==bt1.getId()){
                txt.setText("1");
            }else if(view.getId()==bt2.getId()){
                txt.setText("2");
            }else if(view.getId()==bt3.getId()){
                txt.setText("3");
            }else if(view.getId()==bt4.getId()){
                txt.setText("4");
            }else if(view.getId()==bt5.getId()){
                b=1;
                mainsystem.content=txt.getText().toString();
            }else if(view.getId()==bt6.getId()){
                txt.setText("");
            }
            if(b==1){
                synchronized (mainsystem.inputsystem){
                    mainsystem.inputsystem.notify();
                    Log.i("Test",t1.getState().toString());
                }
            }
        }
    }
}
