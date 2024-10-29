package com.example.xigemajia_100.system;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xigemajia_100.entity.*;
import java.util.Map;
import java.util.HashMap;

public class mainsystem {
	
	//全局变量
	public static String content="";
	public static int numt=9;//（游戏总精灵数）
	public static int numtboss=2;//（mode2、3，boss数）
	public static int useless;//（临时参数）
	public static int strengthbottle=10;//（血瓶）
	public static int energybottle=10;//（魔瓶）
	public static int y1;
	public static int y2;//（不明作用变量）
	public static int win1=1;//（胜利参数）
	
	public static sprite t[];//总精灵
	public static sprite team[][];//队伍
	public static sprite boss[];//boss
	public static skill tuotang=null;//（被高老师拖堂的技能）
	public static Map<Integer,team> teams=new HashMap<Integer,team>();//（对局临时参数）
	//子系统
	public static initsystem initsystem=new initsystem();
	public static toolsystem toolsystem=new toolsystem();
	public static outputsystem outputsystem=new outputsystem();
	public static inputsystem inputsystem=new inputsystem();
	public static gamesystem_1 gamesystem_1=new gamesystem_1();
	public static gamesystem_2 gamesystem_2=new gamesystem_2();
	public static gamesystem_3 gamesystem_3=new gamesystem_3();
	public static fightsystem fightsystem=new fightsystem();
	//界面相关
	public static Button bt1;
	public static Button bt2;
	public static Button bt3;
	public static Button bt4;
	public static Button bt5;
	public static Button bt6;
	public static ScrollView sc;
	public static EditText txt;
	public static LinearLayout lin;
	public static Handler handler;
	public static Context context;
	public static MediaPlayer mediaPlayer;
	//单例模块
	private static mainsystem mainSystem=new mainsystem();
	private mainsystem() {}
	
	public static mainsystem getInstance() {
		return mainSystem;
	}
	public static void viewinit(Button bt1,Button bt2,Button bt3,Button bt4,Button bt5,Button bt6,ScrollView sc,EditText txt,LinearLayout lin,Handler handler,Context context){
		mainsystem.bt1=bt1;
		mainsystem.bt2=bt2;
		mainsystem.bt3=bt3;
		mainsystem.bt4=bt4;
		mainsystem.bt5=bt5;
		mainsystem.bt6=bt6;
		mainsystem.sc=sc;
		mainsystem.txt=txt;
		mainsystem.lin=lin;
		mainsystem.handler=handler;
		mainsystem.context=context;
	}
}
