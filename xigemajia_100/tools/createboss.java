package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.system.mainsystem;

public class createboss {
	public createboss() {}
	public void run(sprite t[]) {
		//添加boss记得修改numtboss
		
		//初始化
		t[0] = mainsystem.toolsystem.setsprite.run
				(-1, "圣·高老师(BOSS)", "光明系精灵，来自第四维度的至高神灵、数学位面守护者，\n手执神圣西格玛加之剑，进可除妖邪、退可定乾坤，拥有无法撼动的绝对实力", "光明", 
						600, 130, 30, 143, 20, 200, 5, 50, 10);
		t[0].url="sprite_7_8";
		//技能1
		t[0].myskill[0] = mainsystem.toolsystem.iniskill.run
				("西格玛加圣裁之剑", "普通系技能，高老师挥出西格玛加之剑，千里金云开、三界妖魔退", "普通", 10, 999, 80);
		//技能2
		t[0].myskill[1] = mainsystem.toolsystem.iniskill.run
				("诛邪·数学", "光明系技能，数学之光迸裂而出、净化世间万物，撕裂苍穹、普射大地，东方生灼日、四海起明煌", "光明", 11, 12, 90);
		t[0].myskill[1].miankong = 2;
		t[0].myskill[1].reflect = 1;
		t[0].myskill[1].reflect1 = 50;
		t[0].myskill[1].reflect12 = 0;
		//技能3
		t[0].myskill[2] = mainsystem.toolsystem.iniskill.run
				("吃亏是福", "普通系技能，高老师吃了个小亏、换来了好运气，牺牲部分生命,提升攻击力、和速度,获得巨额护盾", "普通", 11, 6, 0);
		t[0].myskill[2].attack2 = 8;
		t[0].myskill[2].strength20 = -15;
		t[0].myskill[2].speed2 = 6;
		t[0].myskill[2].shield = 80;
		//技能4
		t[0].myskill[3] = mainsystem.toolsystem.iniskill
				.run("拖堂", "普通系技能，打铃了，高老师决定讲个十分钟再下课", "普通", 12, 5, 20);
		t[0].myskill[3].special = 3;
		
		//健涵
		t[1] = mainsystem.toolsystem.setsprite
				.run(-2, "生日大BOSS健涵", "武系精灵，过生日的健涵威力暴涨，大家快来组团挑战他", "武",
				6666, 150, 20, 144, 40, 135, 5, 50, 10);
		t[1].url="sprite_3";
		t[1].shield0 = 200;
		t[1].myskill[0] = mainsystem.toolsystem.iniskill
				.run("上勾拳", "武系技能，健涵上来就是一拳，牙给你打丢，并提升少量攻击力，对恐惧状态下敌人伤害增加", "武", 99, 20, 90);
		t[1].myskill[0].attack2 = 3;
		t[1].myskill[0].afraid3 = 30;
		t[1].myskill[1] = mainsystem.toolsystem.iniskill
				.run("健涵威慑", "武系技能，健涵大叫一声企图吓死对手，提升暴击率，有一定概率把对手吓住", "武", 8, 4, 40);
		t[1].myskill[1].afraid1 = 1;
		t[1].myskill[1].heavyrate2 = 15;
		t[1].myskill[2] = mainsystem.toolsystem.iniskill
				.run("赤血", "武系技能，健涵小血压刺挠儿一下就上来了，牺牲自身部分生命，提升大量攻击力，并获得六回合伤害减免", "武", 12, 1, 0);
		t[1].myskill[2].attack2 = 30;
		t[1].myskill[2].strength20 = -40;
		t[1].myskill[2].reflect = 7;
		t[1].myskill[2].reflect1 = 70;
		t[1].myskill[2].reflect12 = 0;
		t[1].myskill[2].heavyrate2 = 20;
		t[1].myskill[3] = mainsystem.toolsystem.iniskill
				.run("八法五步", "健涵舞动太极术，用化劲给予对方沉重打击", "普通", 11, 6, 20);
		t[1].myskill[3].reflect = 1;
		t[1].myskill[3].reflect1 = 1;
		t[1].myskill[3].reflect12 = 15000;
	}
}
