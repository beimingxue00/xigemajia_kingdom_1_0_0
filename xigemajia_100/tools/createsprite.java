package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.R;
import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.system.mainsystem;

public class createsprite {
	public createsprite() {}
	public void run(sprite[] t) {
		//添加精灵请记得修改numt
		
		//初始化
		t[0] = mainsystem.toolsystem.setsprite
				.run(1, "纵火浩文", "火系精灵，性能较为综合，善于出拳和纵火，拥有较为不错的进攻和消耗能力，坦度一般，速度较快", "火",
						450, 90, 25, 100, 20, 180, 3, 50, 10);
		t[0].url="sprite_1";
		t[0].myskill[0] = mainsystem.toolsystem.iniskill
				.run("霹雳拳", "火系技能，浩文迅速出拳，对对方造成一定伤害,并降低对手防御", "电",9, 8, 80);
		t[0].myskill[0].defence22 = -25;
		t[0].myskill[1] = mainsystem.toolsystem.iniskill
				.run("燎原赤焰", "火系技能，浩文对全场纵火，对对方造成少量伤害，回复部分生命，提升防御，并造成烧伤效果", "火", 8, 8, 60);
		t[0].myskill[1].strength2 = 20;
		t[0].myskill[1].defence2 = 20;
		t[0].myskill[1].fired = 50;
		t[0].myskill[2] = mainsystem.toolsystem.iniskill
				.run("趁火打劫", "火系技能，浩文趁乱出击，造成一定伤害，烧伤状态下造成高额伤害", "火", 10, 10, 100);
		t[0].myskill[2].fired3 = 110;
		t[0].myskill[3] = mainsystem.toolsystem.iniskill
				.run("节约用纸", "普通系技能，浩文坚持用巴掌大小的纸作答题卡，节约的精神感动了上天，获得一回合免伤，强化攻击，并回复大量生命", "普通", 12, 1, 0);
		t[0].myskill[3].wudi = 1;
		t[0].myskill[3].attack2 = 30;
		t[0].myskill[3].strength2 = 50;

		//二号精灵
		t[1] = mainsystem.toolsystem.setsprite
				.run(2, "摸鱼成成", "水系精灵，性能偏向敏捷型，善于摸鱼，拥有较快的速度、较强的控制和闪避能力，伤害中等，坦度略弱", "水", 
						360, 120, 15, 140, 20, 180, 3, 80, 20);
		t[1].url="sprite_2";
		t[1].myskill[0] = mainsystem.toolsystem.iniskill
				.run("摸鱼", "水系技能，成成开始摸鱼，回复一定生命，净化自身异常，本回合有一定反伤，并提高闪避率", "水", 12, 6, 0);
		t[1].myskill[0].strength2 = 25;
		t[1].myskill[0].defence2 = 5;
		t[1].myskill[0].reflect = 1;
		t[1].myskill[0].reflect1 = 40;
		t[1].myskill[0].reflect12 = 100;
		t[1].myskill[0].miss2 = 6;
		t[1].myskill[0].miankong = 1;
		t[1].myskill[1] = mainsystem.toolsystem.iniskill
				.run("水波动", "水系技能，成成使劲扑腾激起浪花，对对手造成伤害和冲击，有一定概率把对手拍晕", "水", 12, 10, 60);
		t[1].myskill[1].sleeping = 1;
		t[1].myskill[2] = mainsystem.toolsystem.iniskill
				.run("怒海狂涛", "水系技能，成成操纵水魔法向敌人攻去，额外造成固定伤害", "水", 9, 10, 80);
		t[1].myskill[2].strength22 = -50;
		t[1].myskill[3] = mainsystem.toolsystem.iniskill
				.run("飞毛腿", "普通系技能，成成一跃而起给了对方一脚，提升少量攻击", "普通", 11, 4, 70);
		t[1].myskill[3].attack2 = 15;

		//三号精灵
		t[2] = mainsystem.toolsystem.setsprite
				.run(3, "武斗健涵", "武系精灵，牺牲续航换来强大的进攻能力，拥有较快的速度和较高的爆发，坦度中等，善于在短时间内迅速KO对手", "武", 
						400, 140, 20, 155, 40, 160, 3, 50, 15);
		t[2].url="sprite_3";
		t[2].shield0 = 50;
		t[2].myskill[0] = mainsystem.toolsystem.iniskill
				.run("上勾拳", "武系技能，健涵上来就是一拳，牙给你打丢，并提升少量攻击力，对恐惧状态下敌人伤害增加", "武", 10, 12, 80);
		t[2].myskill[0].attack2 = 3;
		t[2].myskill[0].afraid3 = 30;
		t[2].myskill[1] = mainsystem.toolsystem.iniskill
				.run("健涵威慑", "武系技能，健涵大叫一声企图吓死对手，提升暴击率，有一定概率把对手吓住", "武", 8, 2, 40);
		t[2].myskill[1].afraid1 = 1;
		t[2].myskill[1].heavyrate2 = 25;
		t[2].myskill[2] = mainsystem.toolsystem.iniskill
				.run("赤血", "武系技能，健涵小血压刺挠儿一下就上来了，牺牲自身部分生命，提升大量攻击力，并获得四回合伤害减免", "武", 12, 1, 0);
		t[2].myskill[2].attack2 = 30;
		t[2].myskill[2].strength20 = -35;
		t[2].myskill[2].reflect = 5;
		t[2].myskill[2].reflect1 = 75;
		t[2].myskill[2].reflect12 = 0;
		t[2].myskill[2].heavyrate2 = 20;
		t[2].myskill[3] = mainsystem.toolsystem.iniskill
				.run("八法五步", "健涵舞动太极术，用化劲给予对方沉重打击，净化自身负面状态", "普通", 12, 4, 20);
		t[2].myskill[3].reflect = 1;
		t[2].myskill[3].reflect1 = 1;
		t[2].myskill[3].reflect12 = 17000;
		t[2].myskill[3].miankong = 1;

		//四号精灵
		t[3] = mainsystem.toolsystem.setsprite
				.run(4, "生草松松", "草系精灵，拥有强大的回复手段，擅长减伤和续航，坦度中等，回复能力极为优秀", "草", 
						450, 90, 15, 130, 20, 180, 3, 50, 10);
		t[3].url="sprite_4";
		t[3].myskill[0] = mainsystem.toolsystem.iniskill
				.run("光合作用", "草系技能，松松尽情沐浴在阳光之中，净化自身负面，回复当前失去生命的一半并获得一个小额护盾", "草", 12, 4, 40);
		t[3].myskill[0].strength200 = 45;
		t[3].myskill[0].shield = 30;
		t[3].myskill[0].miankong = 1;
		t[3].myskill[1] = mainsystem.toolsystem.iniskill
				.run("寄生种子", "草系技能，松松朝对手丢出一颗寄生种子，持续3回合吸血，并降低对手攻击力，有一定概率使对手沉睡", "草", 10, 6, 55);
		t[3].myskill[1].parasitising = 4;
		t[3].myskill[1].parasitising1 = 15;
		t[3].myskill[1].sleeping = 1;
		t[3].myskill[2] = mainsystem.toolsystem.iniskill
				.run("休养生息", "普通系技能，连续3回合回复生命，获得微弱减伤能力，并对对手造成固定伤害", "普通", 8, 4, 0);
		t[3].myskill[2].recovering = 4;
		t[3].myskill[2].recovering1 = 11;
		t[3].myskill[2].reflect = 4;
		t[3].myskill[2].reflect1 = 20;
		t[3].myskill[2].reflect12 = 0;
		t[3].myskill[2].strength22 = -20;
		t[3].myskill[2].reflect12 = 0;
		t[3].myskill[3] = mainsystem.toolsystem.iniskill
				.run("藤蔓侵袭", "草系技能，松松召唤出藤蔓对对手进行攻击，造成固定伤害，吸取部分精力", "草", 9, 10, 80);
		t[3].myskill[3].parasitising = 1;
		t[3].myskill[3].parasitising1 = 25;
		t[3].myskill[3].strength22 = -20;

		//五号精灵
		t[4] = mainsystem.toolsystem.setsprite
				.run(5, "电基小子", "电系精灵，拥有较快的速度和较强的爆发力，坦度一般，拥有绝招连锁闪电", "电", 
						360, 110, 15, 160, 30, 180, 4, 100, 15);
		t[4].url="sprite_5";
		t[4].myskill[0] = mainsystem.toolsystem.iniskill
				.run("飞基中的战斗基", "电系技能，庆基卯足力气，一跃而起冲云霄，提升速度，强化攻击，获得一个小额护盾，增加一格电量，净化自身负面并获得当前回合无敌", "普通", 11, 4, 20);
		t[4].myskill[0].miankong = 1;
		t[4].myskill[0].wudi = 1;
		t[4].myskill[0].speed2 = 20;
		t[4].myskill[0].attack2 = 10;
		t[4].myskill[0].shield = 30;
		t[4].myskill[0].electricity = 1;
		t[4].myskill[1] = mainsystem.toolsystem.iniskill
				.run("雷电积蓄", "电系技能，庆基为自身积攒两格电量，当前回合获得一定免伤，回复少量生命", "电", 10, 6, 30);
		t[4].myskill[1].reflect = 1;
		t[4].myskill[1].reflect1 = 30;
		t[4].myskill[1].reflect12 = 0;
		t[4].myskill[1].strength20 = 15;
		t[4].myskill[1].electricity = 2;
		t[4].myskill[2] = mainsystem.toolsystem.iniskill
				.run("闪电五连鞭", "电系技能，消耗一格电量，对对手造成伤害，有一定概率使对手麻痹", "电", 10, 10, 60);
		t[4].myskill[2].electricity = -1;
		t[4].myskill[2].sleeping = 1;
		t[4].myskill[3] = mainsystem.toolsystem.iniskill
				.run("连锁闪电", "电系技能，庆基发动闪电，直接连接和传导到对方阵营，使对方全员受到不同程度的闪电伤害，并消耗自身一格电量", "电", 10, 4, 35);
		t[4].myskill[3].special = 1;
		t[4].myskill[3].electricity = -1;

		//六号精灵
		t[5] = mainsystem.toolsystem.setsprite
				.run(6, "巨力济航", "石系精灵，拥有极强的生命力和防御力，续航能力弱，生存能力强", "石", 
						600, 70, 25, 120, 20, 200, 3, 50, 10);
		t[5].url="sprite_6";
		t[5].myskill[0] = mainsystem.toolsystem.iniskill
				.run("石破天惊", "石系技能，济航一记重锤，对对方造成一定伤害，破除对方防御、弱化对方攻击", "石", 8, 8, 80);
		t[5].myskill[0].defence22 = -20;
		t[5].myskill[0].attack22 = -5;
		t[5].myskill[0].strength22 = -10;
		t[5].myskill[1] = mainsystem.toolsystem.iniskill
				.run("铜墙铁壁", "石系技能，获得护盾，强化自身防御和攻击,缓慢回复生命", "石", 9, 5, 40);
		t[5].myskill[1].defence2 = 20;
		t[5].myskill[1].attack2 = 10;
		t[5].myskill[1].recovering = 4;
		t[5].myskill[1].recovering1 = 2;
		t[5].myskill[1].shield = 40;
		t[5].myskill[2] = mainsystem.toolsystem.iniskill
				.run("不动如山", "石系技能，济航发动土石魔法，对对方造成固定伤害，首回合若对方发动攻击则反弹伤害并获得3回合伤害减免，若对方不攻击则自身扣除生命", "石", 12, 4, 30);
		t[5].myskill[2].strength22 = -30;
		t[5].myskill[2].reflect = 1;
		t[5].myskill[2].reflect1 = 100;
		t[5].myskill[2].reflect12 = 50;
		t[5].myskill[2].special = 2;
		t[5].myskill[3] = mainsystem.toolsystem.iniskill
				.run("地爆天星", "石系技能，济航发动大招对对手造成沉重打击，对方血量越少，伤害越高", "石", 9, 10, 90);
		t[5].myskill[3].strength2200 = -20;

		//七号精灵
		t[6] = mainsystem.toolsystem.setsprite
				.run(7, "圣·高老师(不可选择)", "光明系精灵，来自第四维度的至高神灵、数学位面守护者，\n手执神圣西格玛加之剑，进可除妖邪、退可定乾坤，拥有无法撼动的绝对实力", "光明", 
						450, 120, 20, 146, 20, 200, 4, 50, 20);
		t[6].url="sprite_7_8";
		t[6].myskill[0] = mainsystem.toolsystem.iniskill
				.run("西格玛加圣裁之剑", "普通系技能，高老师挥出西格玛加之剑，千里金云开、三界妖魔退", "普通", 10, 999, 90);
		t[6].myskill[0].special = 4;
		t[6].myskill[1] = mainsystem.toolsystem.iniskill
				.run("诛邪·数学", "光明系技能，数学之光迸裂而出、净化世间万物，撕裂苍穹、普射大地，东方生灼日、四海起明煌", "光明", 11, 10, 80);
		t[6].myskill[1].reflect = 1;
		t[6].myskill[1].reflect1 = 30;
		t[6].myskill[1].reflect12 = 0;
		t[6].myskill[2] = mainsystem.toolsystem.iniskill
				.run("吃亏是福", "普通系技能，高老师吃了个小亏、换来了好运气，牺牲部分生命,提升攻击力、速度,获得巨额护盾", "普通", 11, 4, 0);
		t[6].myskill[2].attack2 = 9;
		t[6].myskill[2].strength20 = -15;
		t[6].myskill[2].speed2 = 6;
		t[6].myskill[2].shield = 40;
		t[6].myskill[2].miankong = 1;
		t[6].myskill[3] = mainsystem.toolsystem.iniskill
				.run("拖堂", "普通系技能，打铃了，高老师决定讲个十分钟再下课", "普通", 12, 2, 20);
		t[6].myskill[3].special = 3;

		//八号精灵
		t[7] = mainsystem.toolsystem.setsprite
				.run(8, "魔·高老师(不可选择)", "黑暗系精灵，被导数吞噬心智的高老师进入狂暴状态，\n强化了生命力和攻击力，手段极其残忍、一刀一个小朋友", "黑暗", 
						500, 130, 20, 133, 30, 180, 4, 50, 10);
		t[7].url="sprite_7_8";
		t[7].myskill[0] = mainsystem.toolsystem.iniskill
				.run("西格玛加寂灭之刃", "普通系技能，东方阴云起、高老师挥出寂灭之刃，千山少鸟鸣、万里无人烟", "普通", 10, 999, 40);
		t[7].myskill[0].strength22 = -40;
		t[7].myskill[1] = mainsystem.toolsystem.iniskill
				.run("深渊·同构", "黑暗系技能，导数阴气迸裂而出、腐蚀世间万物，一线黑龙、光明退散", "黑暗", 10, 10, 50);
		t[7].myskill[1].attack2 = 5;
		t[7].myskill[1].vampirism = 50;
		t[7].myskill[1].strength2200 = -15;
		t[7].myskill[1].heavyrate2 = 3;
		t[7].myskill[2] = mainsystem.toolsystem.iniskill
				.run("解析之眼", "普通系技能，高老师释放黑暗魔法，被诅咒之人将遭受无尽折磨，提升暴击伤害、破除对方防御", "普通", 10, 4, 0);
		t[7].myskill[2].attack2 = 10;
		t[7].myskill[2].heavyrate2 = 5;
		t[7].myskill[2].heavy2 = 50;
		t[7].myskill[2].defence22 = -20;
		t[7].myskill[3] = mainsystem.toolsystem.iniskill
				.run("凉凉", "黑暗系技能，本次数学卷出的难死，大家都凉了，降低对方伤害和防御，有概率使对手恐惧", "黑暗", 11, 4, 20);
		t[7].myskill[3].attack22 = -10;
		t[7].myskill[3].defence22 = -25;
		t[7].myskill[3].afraid1 = 1;
		//九号精灵
		t[8] = mainsystem.toolsystem.setsprite
				.run(9, "杨斯JOJO", "普通系精灵，普通到我实在都懒得介绍，过（手动狗头）", "普通", 
						480, 100, 20, 131, 20, 180, 3, 35, 20);
		t[8].url="sprite_9";
		t[8].myskill[0] = mainsystem.toolsystem.iniskill
				.run("JOJO重拳", "普通系技能，杨斯JO上来就是一电炮，直接给你打破防", "普通", 9, 8, 100);
		t[8].myskill[0].defence22 = -20;
		t[8].myskill[1] = mainsystem.toolsystem.iniskill
				.run("连环拳", "普通系技能，杨斯JO每出一拳，有百分之五十的概率打出下一拳，至少打一拳，至多直接把对方干死", "普通", 10, 8, 50);
		t[8].myskill[1].special = 5;
		t[8].myskill[1].strength22 = -10;
		t[8].myskill[2] = mainsystem.toolsystem.iniskill
				.run("疯卷残云", "普通系技能，杨斯JO看多了网文导致精神癫狂，直接发疯，降低自身生命，提升攻击和吸血能力，\n并使场上进入“疯癫”状态，双方攻击将各有一定概率落到自己身上，持续两回合", "普通", 11, 4, 0);
		t[8].myskill[2].attack2 = 10;
		t[8].myskill[2].strength20 = -10;
		t[8].myskill[2].special = 6;
		t[8].myskill[3] = mainsystem.toolsystem.iniskill
				.run("义薄云天", "普通系技能，傻JO乃忠义之士，进入状态“坚毅”，获得一定额度护盾，并能将对方造成的伤害存储起来，每回合仅造成一半的伤害，并免控，持续四回合", "普通", 12, 4, 20);
		t[8].myskill[3].strength22 = -30;
		t[8].myskill[3].shield = 40;
		t[8].myskill[3].lateattack1 = 5;
		t[8].myskill[3].miankong = 5;
	}
}
