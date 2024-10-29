package com.example.xigemajia_100.system;
import com.example.xigemajia_100.tools.*;

public class toolsystem {
	public random random;
	public setsprite setsprite;
	public createsprite createsprite;
	public iniskill iniskill;
	public createboss createboss;
	public ownerto ownerto;
	public showingsprite showingsprite;
	public showingskill showingskill;
	public resprite resprite;
	public reskill reskill;
	public order order;
	public ifmiankong ifmiankong;
	public weatherto weatherto;
	public reround reround;
	public roundgoing roundgoing;
	public failure failure;
	public statechanging statechanging;
	public analyse analyse;
	public specialevent specialevent;

	public toolsystem() {
		random=new random();
		setsprite=new setsprite();
		createsprite=new createsprite();
		iniskill=new iniskill();
		createboss=new createboss();
		ownerto=new ownerto();
		showingsprite=new showingsprite();
		showingskill=new showingskill();
		resprite=new resprite();
		reskill=new reskill();
		order=new order();
		ifmiankong=new ifmiankong();
		weatherto=new weatherto();
		reround=new reround();
		roundgoing=new roundgoing();
		failure=new failure();
		statechanging=new statechanging();
		analyse=new analyse();
		specialevent=new specialevent();
	}
}
