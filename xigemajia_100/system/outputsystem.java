package com.example.xigemajia_100.system;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xigemajia_100.R;

public class outputsystem {
	String result;
	public outputsystem() {}
	public void print(String a) {
		if(result==null){
			result="";
		}
		if(a!=null) {
			result=result+a;
		}
	}
	public void println(String a) {
		if (a != null) {
			print(a);
			//组件操作
			mainsystem.handler.post(new Runnable() {
				@Override
				public void run() {
					View itemView = LayoutInflater.from(mainsystem.context).inflate(R.layout.item_text, null);
					itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
					mainsystem.lin.addView(itemView);
					TextView text = itemView.findViewById(R.id.text1);
					text.setText(result);
					mainsystem.sc.scrollTo(0, mainsystem.lin.getMeasuredHeight()-mainsystem.sc.getHeight());
					result = "";
				}
			});
			try {
				Thread.sleep(200);
			}catch(InterruptedException e){}
		}
	}

	public void println0(String a) {
		if (a != null) {
			print(a);
			try {
				Thread.sleep(500);
			}catch(InterruptedException e){}
			//组件操作
			mainsystem.handler.post(new Runnable() {
				@Override
				public void run() {
					View itemView = LayoutInflater.from(mainsystem.context).inflate(R.layout.item_text, null);
					itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
					mainsystem.lin.addView(itemView);
					TextView text = itemView.findViewById(R.id.text1);
					text.setText(result);
					mainsystem.sc.scrollTo(0, mainsystem.lin.getMeasuredHeight()-mainsystem.sc.getHeight());
					result = "";
				}
			});
			try {
				Thread.sleep(500);
			}catch(InterruptedException e){}
		}
	}

	public synchronized void println1(String a) {
		if (a != null) {
			print(a);
			//组件操作
			mainsystem.handler.post(new Runnable() {
				@Override
				public void run() {
					run1();
				}
				public synchronized void run1(){
					View itemView = LayoutInflater.from(mainsystem.context).inflate(R.layout.item_text, null);
					itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
					mainsystem.lin.addView(itemView);
					TextView text = itemView.findViewById(R.id.text1);
					text.setText(result);
					//mainsystem.sc.fullScroll(ScrollView.FOCUS_DOWN);
					result = "";
				}
			});
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){}
		}
	}
	public void print_i(String url){
		mainsystem.handler.post(new Runnable() {
			@Override
			public void run() {
				run1();
			}
			public synchronized void run1(){
				View itemView = LayoutInflater.from(mainsystem.context).inflate(R.layout.item_image, null);
				itemView.setLayoutParams(new LinearLayout.LayoutParams(600,600));
				mainsystem.lin.addView(itemView);
				ImageView image = itemView.findViewById(R.id.imageView);

				String resourceName = url; // 要找的资源名称
				String packageName = mainsystem.context.getPackageName(); // 获取当前应用的包名
				int resId = mainsystem.context.getResources().getIdentifier(resourceName, "drawable", packageName);

				image.setImageResource(resId);
				//mainsystem.sc.fullScroll(ScrollView.FOCUS_DOWN);
				result = "";
			}
		});
	}

}