package com.example.xigemajia_100.system;
import static java.lang.Thread.sleep;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xigemajia_100.R;

import java .util.Scanner;

public class inputsystem {
	public inputsystem() {}
	public void s() throws InterruptedException {
		synchronized (this) {
			mainsystem.handler.post(new Runnable() {
				@Override
				public void run() {
					run1();
				}
				public synchronized void run1(){
					//mainsystem.sc.fullScroll(ScrollView.FOCUS_DOWN);
					mainsystem.sc.scrollTo(0, mainsystem.lin.getMeasuredHeight()-mainsystem.sc.getHeight());
				}
			});
			wait();
			mainsystem.handler.post(new Runnable() {
				@Override
				public void run() {
					run1();
				}
				public synchronized void run1(){
					//mainsystem.sc.fullScroll(ScrollView.FOCUS_DOWN);
					mainsystem.lin.removeAllViews();
					mainsystem.outputsystem.println1("您的输入："+mainsystem.content);
				}
			});
			try{
				sleep(500);
			}catch(InterruptedException e){}
		}
	}
	public String tostring() {
		try{
			s();
		}catch(InterruptedException e){}
		return mainsystem.content;
	}
	public int toint() {
		try{
			s();
		}catch(InterruptedException e){}
		return new Integer(mainsystem.content);
	}

}
