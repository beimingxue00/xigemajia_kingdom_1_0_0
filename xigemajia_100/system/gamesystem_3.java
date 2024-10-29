package com.example.xigemajia_100.system;

import com.example.xigemajia_100.entity.sprite;

public class gamesystem_3 {
	public gamesystem_3() {}
	public void run() {
		sprite[] ss=mainsystem.team[0];
		ss[0]= mainsystem.t[0];
		ss[0].team=0;
		ss[1]= mainsystem.t[1];
		ss[1].team=0;
		ss[2]= mainsystem.t[3];
		ss[2].team=0;
		ss[3]= mainsystem.t[4];
		ss[3].team=0;
		ss[4]= mainsystem.t[5];
		ss[4].team=0;
		ss[5]= mainsystem.t[8];
		ss[5].team=0;
		
		mainsystem.team[3][0]=mainsystem.boss[1];
		mainsystem.boss[1].team=3;
		mainsystem.fightsystem.run(mainsystem.team[0],mainsystem.team[3]);
	}
}
