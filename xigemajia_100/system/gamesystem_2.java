package com.example.xigemajia_100.system;
import com.example.xigemajia_100.entity.*;

public class gamesystem_2 {
	public gamesystem_2() {}
	public void run() {
		mainsystem.boss[0].team=2;
		mainsystem.team[2][0]=mainsystem.boss[0];
		mainsystem.fightsystem.run(mainsystem.team[0],mainsystem.team[2]);
	}
}
