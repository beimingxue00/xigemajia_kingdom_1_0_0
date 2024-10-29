package com.example.xigemajia_100.fight_about;

import android.util.Log;

import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.system.mainsystem;

public class to {
	special1 special1;
	special2 special2;
	special4 special4;
	public to() {
		special1=new special1();
		special2=new special2();
		special4=new special4();
	}
	public void run(round round0,skill skill0,sprite t01,sprite t02,sprite[] team00,sprite[] team01) {
		round round;
		sprite[] team1;
		sprite[] team2;
		sprite t1;
		sprite t2;
		skill skill;
		//两精灵对战
		round=round0;
		team1=team00;//本队
		team2=team01;//敌对
		t1=t01;
		t2=t02;
		skill=skill0;
		//a[0]济航计时器
		//a[1]高老师拖堂计时器
		//a[2]高老师拖堂辅助计时器
		//a[3]疯癫状态计时器
		//a[4]延迟伤害储存器
		int j = 1, placevapirism = 0;
		int qattack, pattack;
		int miss = mainsystem.toolsystem.random.run() % 50, heavy = mainsystem.toolsystem.random.run() % 50;
		//伤害延迟启动
		if (skill.lateattack1 > 0)
		{
			t1.lateattack1 = skill.lateattack1;
		}
		if (t2.lateattack1 > 0)
		{
			round.a.put("4", t2.strength);
		}
		//疯癫启动
		if (skill.special == 6)
		{
			round.a.put("3", 3);
		}
		if (round.a.get("3") > 0 && t1.order == 9)
		{
			placevapirism = skill.vampirism;
			skill.vampirism = 25;
		}
		//拖堂技能释放
		if (round.a.get("1") == 0 && round.a.get("2") == 1)
		{
			round.a.put("2", -1);
			if (mainsystem.tuotang != null&&mainsystem.tuotang.owner!=null)
			{
				if (t1.order == mainsystem.tuotang.owner.order)
				{
					run(round, mainsystem.tuotang,t1, t2, team1,team2);
				}
				else if (t2.order == mainsystem.tuotang.owner.order)
				{
					run(round, mainsystem.tuotang,t2, t1, team2,team1);
				}
			}
			else
			{
				mainsystem.outputsystem.println("空指针，无法释放");
			}
			round.a.put("2",0);
			mainsystem.tuotang = null;
		}
		//如果中了
		mainsystem.outputsystem.println0(t1.name+"发动了技能——"+skill.name);
		//Sleep(1000);
		skill.quantity--;
		//拖堂额外技能
		if (skill.special == 3)
		{
			int u;
			miss = 50;
			round.a.put("1", -1);
			mainsystem.outputsystem.println("");
			for (;;)
			{
				u = mainsystem.toolsystem.random.run() % 3;
				if (t1.myskill[u].quantity > 0)
				{
					break;
				}
			}
			run(round, t1.myskill[u], t1, t2, team1,team2);
		}
		if (round.a.get("1") == -1 && t2.elementnumber == 6)
		{
			mainsystem.tuotang = skill;
			round.a.put("1",3);
			round.a.put("2",4);
			mainsystem.outputsystem.println("，被高老师拖堂，两回合之后才可使用");
		}
		//主攻击函数
		if (skill != mainsystem.tuotang || round.a.get("2") == -1)
		{
			if (2 * miss >= t2.miss)
			{
				qattack = (t1.attack) * (skill.attack) / 100;
				if (2 * heavy < t1.heavyrate)
				{
					qattack = (qattack * t1.heavy) / 100;
					mainsystem.outputsystem.print("，打出了暴击");
				}
				if (skill.afraid3 > 0)
				{
					if (t2.afraid > 0)
					{
						qattack += (t1.attack) * (skill.afraid3) / 100;
					}
				}
				if (skill.frozen3 > 0)
				{
					if (t2.frozen > 0)
					{
						qattack += (t1.attack) * (skill.frozen3) / 100;
					}
				}
				if (skill.fired3 > 0)
				{
					if (t2.fired > 0)
					{
						qattack += (t1.attack) * (skill.fired3) / 100;
					}
				}
				if (skill.sleeping3 > 0)
				{
					if (t2.sleeping > 0)
					{
						qattack += (t1.attack) * (skill.sleeping3) / 100;
					}
				}
				pattack = (qattack * mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber)) / 100;
				//电量伤害加成
				if (t1.elementnumber == 2)
				{
					pattack += (pattack * (t1.electricity) * 6) / 100;
				}

				if (t2.reflect <= 0 && t2.wudi <= 0)
				{
					//护盾伤害免除
					if (t2.shield > 0)
					{
						if (t2.shield >= pattack)
						{
							t2.shield -= pattack;
							pattack = 0;
						}
						else
						{
							pattack -= t2.shield;
							t2.shield = 0;
						}
					}

					pattack = (pattack * (100 - mainsystem.toolsystem.weatherto.run(round, t2, t2.defence, 1))) / 100;
					pattack = mainsystem.toolsystem.weatherto.run(round, t1, pattack, 1);

					//寄生伤害下降
					if (t1.parasitising > 0)
					{
						pattack -= (pattack * 20) / 100;
					}
					//疯癫状态判定
					int reverse = 0;
					if (round.a.get("3") > 0)
					{
						reverse = mainsystem.toolsystem.random.run() % 5;
					}
					//造成伤害及反转判定
					if (reverse < 3)
					{
						t2.strength -= pattack;
						if (mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber) > 100)
						{
							mainsystem.outputsystem.print("，属性克制");
						}
						else if (mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber) < 100)
						{
							mainsystem.outputsystem.print("，受到抵抗");
						}
						mainsystem.outputsystem.print("，对"+t2.name+"造成了"+pattack+"点伤害");
					}
					else
					{
						t1.strength -= pattack;
						if (mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber) > 100)
						{
							mainsystem.outputsystem.print("，属性克制");
						}
						else if (mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber) < 100)
						{
							mainsystem.outputsystem.print("，受到抵抗");
						}
						mainsystem.outputsystem.print("，对"+t1.name+"造成了"+pattack+"点伤害");
					}

				}
				//有反弹
				else if (t2.reflect > 0 && t2.wudi <= 0)
				{

					if (mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber) > 100)
					{
						mainsystem.outputsystem.print("，属性克制");
					}
					else if (mainsystem.toolsystem.analyse.run(skill.elementnumber, t2.elementnumber) < 100)
					{
						mainsystem.outputsystem.print("，受到抵抗");
					}
					if (t2.shield > 0)
					{
						if (t2.shield >= pattack)
						{
							t2.shield -= pattack;
							pattack = 0;
						}
						else
						{
							pattack -= t2.shield;
							t2.shield = 0;
						}
					}
					pattack = (pattack * (100 - mainsystem.toolsystem.weatherto.run(round, t2, t2.defence, 1))) / 100;
					pattack = mainsystem.toolsystem.weatherto.run(round, t1, pattack, 1);
					//疯癫状态判定
					int reverse = 0;
					if (round.a.get("3") > 0)
					{
						reverse = mainsystem.toolsystem.random.run() % 5;
					}
					//造成伤害及反弹和反转判定
					if (reverse < 3)
					{
						t2.strength -= (pattack * (100 - t2.reflect1)) / 100;
						mainsystem.outputsystem.print("，对"+t2.name+"造成了"+(pattack * (100 - t2.reflect1)) / 100+"点伤害");
						if (t1.wudi <= 0)
						{
							int i;
							i = (pattack * (t2.reflect1) * (t2.reflect2)) / 10000;
							i -= (i * (t1.reflect1)) / 100;
							t1.strength -= i;
							mainsystem.outputsystem.print("，受到了"+i+"点反弹伤害");
						}
						else
						{
							mainsystem.outputsystem.print("，"+t1.name+"处于无敌状态，不受到反弹伤害");
						}
					}
					else
					{
						t1.strength -= (pattack * (100 - t2.reflect1)) / 100;
						mainsystem.outputsystem.print("，对"+t1.name+"造成了"+(pattack * (100 - t2.reflect1)) / 100+"点伤害");
					}
					//济航判定
					if (round.a.get("0") != 0 && t2.elementnumber == 5)
					{
						if (pattack == 0)
						{
							t2.strength -= ((t2.strength0) * 14) / 100;
							mainsystem.outputsystem.print("，"+t2.name+"的生命下降了");
						}
						else
						{
							t2.reflect += 3;
							t2.reflect1 = 40;
							t2.reflect2 = 0;
						}
					}

				}
				else
				{
					mainsystem.outputsystem.print("，"+t2.name+"处于无敌状态，无法造成伤害");
				}

				//Sleep(1000);
				mainsystem.outputsystem.println("");
				if (t1.electricity > 0)
				{
					if (t2.elementnumber != 4)
					{
						if (t2.wudi < 1)
						{
							int i;
							if (t1.elementnumber == 4)
							{
								i = ((t2.strength0) * (t1.electricity) * 3) / 100;
								i -= (i * (t2.reflect1)) / 100;
								i = mainsystem.toolsystem.weatherto.run(round, t1, i, 1);
								//护盾伤害免除
								if (t2.shield > 0)
								{
									if (t2.shield >= i)
									{
										t2.shield -= i;
										i = 0;
									}
									else
									{
										i -= t2.shield;
										t2.shield = 0;
									}
								}

								mainsystem.outputsystem.println(""+t2.name+"受到了"+i+"点触电伤害");
								t2.strength -= i;
							}
							else
							{

								i = ((t2.strength0) * (t1.electricity) * 1) / 100;
								i -= (i * (t2.reflect1)) / 100;
								i = mainsystem.toolsystem.weatherto.run(round, t1, i, 1);
								//护盾伤害免除
								if (t2.shield > 0)
								{
									if (t2.shield >= i)
									{
										t2.shield -= i;
										i = 0;
									}
									else
									{
										i -= t2.shield;
										t2.shield = 0;
									}
								}

								mainsystem.outputsystem.println(""+ t2.name+"受到了"+i+"点触电伤害\n");
								t2.strength -= i;
							}
						}
						else
						{
							mainsystem.outputsystem.println(""+t2.name+"处于无敌状态，无法造成触电伤害");
						}
					}
					else
					{
						mainsystem.outputsystem.println(""+t2.name+"电系免疫，无法造成触电伤害\n");
					}
				}
				if (t2.electricity > 0)
				{
					if (t1.elementnumber != 4)
					{
						if (t1.wudi < 1)
						{
							int i;
							i = ((t1.strength0) * (t2.electricity) * 1) / 100;
							i -= (i * (t1.reflect1)) / 100;
							i = mainsystem.toolsystem.weatherto.run(round, t2, i, 1);
							//护盾伤害免除
							if (t1.shield > 0)
							{
								if (t1.shield >= i)
								{
									t1.shield -= i;
									i = 0;
								}
								else
								{
									i -= t1.shield;
									t1.shield = 0;
								}
							}
							t1.strength -= i;
							mainsystem.outputsystem.println(""+t1.name+"受到了"+i+"点触电伤害");
						}
						else
						{
							mainsystem.outputsystem.println(""+t1.name+"处于无敌状态，无法造成触电伤害");
						}
					}
					else
					{
						mainsystem.outputsystem.println(""+t1.name+"电系免疫，无法造成触电伤害");
					}
				}
				if (skill.strength22 != 0)
				{
					if (skill.strength22 > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的生命上升了");
						t2.strength += mainsystem.toolsystem.weatherto.run(round, t2, skill.strength22, 2);
					}
					else if (skill.strength22 < 0)
					{
						if (t2.wudi < 1)
						{
							int i;
							i = skill.strength22;
							if (t2.reflect > 0)
							{
								i -= (i * (t2.reflect1)) / 100;
							}
							mainsystem.outputsystem.println(""+t2.name+"的生命下降了");
							t2.strength += i;
						}
						else
						{
							mainsystem.outputsystem.println(""+t2.name+"处于无敌状态，无法造成伤害");
						}
					}
				}
				if (skill.vampirism != 0)
				{
					int h = (pattack * (100 - t2.reflect1) * (skill.vampirism) / 10000);
					h = mainsystem.toolsystem.weatherto.run(round, t1, h, 2);
					mainsystem.outputsystem.println(""+t1.name+"吸取了"+h+"点生命");
					t1.strength += h;
				}
				if (skill.strength2200 != 0)
				{
					int i = (t2.strength0 - t2.strength) * (skill.strength2200) / 100;
					if (i > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的生命上升了");
						i = mainsystem.toolsystem.weatherto.run(round, t2, i, 2);
						t2.strength += i;
					}
					else if (i < 0)
					{
						if (t2.wudi < 1)
						{
							if (t2.reflect > 0)
							{
								i -= (i * (t2.reflect1)) / 100;
							}
							mainsystem.outputsystem.println(""+t2.name+"的生命下降了");
							t2.strength += i;
						}
						else
						{
							mainsystem.outputsystem.print(""+t2.name+"处于无敌状态，无法造成伤害");
						}
					}
				}
				if (skill.defence22 != 0)
				{

					if (skill.defence22 > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的防御上升了");
						t2.defence += (t2.defence) * (skill.defence22) / 100;
					}
					else if (skill.defence22 < 0)
					{
						if (t2.miankong < 1)
						{
							mainsystem.outputsystem.println(""+t2.name+"的防御下降了");
							t2.defence += (t2.defence) * (skill.defence22) / 100;
						}
						else
						{
							mainsystem.outputsystem.println(""+t2.name+"处于异常免疫状态，无法造成debuff");
						}
					}
				}
				if (skill.heavy22 != 0)
				{
					if (skill.heavy22 > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的暴击伤害上升了");
						t2.heavy += (t2.heavy) * (skill.heavy22) / 100;
					}
					else if (skill.heavy22 < 0)
					{
						if (t2.miankong < 1)
						{
							mainsystem.outputsystem.println(""+t2.name+"的暴击伤害下降了");
							t2.heavy += (t2.heavy) * (skill.heavy22) / 100;
						}
						else
						{
							mainsystem.outputsystem.println(""+t2.name+"处于异常免疫状态，无法造成debuff");
						}
					}
				}
				if (skill.heavyrate22 != 0)
				{
					t2.heavyrate += (t2.heavyrate) * (skill.heavyrate22) / 100;
					if (skill.heavyrate22 > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的暴击率上升了");
					}
					else if (skill.heavyrate22 < 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的暴击率下降了");
					}
				}
				if (skill.attack22 != 0)
				{

					if (skill.attack22 > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的攻击上升了");
						t2.attack += (t2.attack) * (skill.attack22) / 100;
					}
					else if (skill.attack22 < 0)
					{
						if (t2.miankong < 1)
						{
							mainsystem.outputsystem.println(""+t2.name+"的攻击下降了");
							t2.attack += (t2.attack) * (skill.attack22) / 100;
						}
						else
						{
							mainsystem.outputsystem.println(""+t2.name+"处于异常免疫状态，无法造成debuff");
						}
					}
				}
				if (skill.miss22 != 0)
				{
					t2.miss += (t2.miss) * (skill.miss22) / 100;
					if (skill.miss22 > 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的闪避率上升了");
					}
					else if (skill.miss22 < 0)
					{
						mainsystem.outputsystem.println(""+t2.name+"的闪避率下降了");
					}
				}
				if (skill.fired != 0)
				{
					if (t2.fired >= 0)
					{
						t2.fired = 4;
						t2.fired1 = skill.fired;
						mainsystem.outputsystem.println(""+t2.name+"进入了灼烧状态");
					}
				}
				if (skill.parasitising != 0)
				{
					if (t2.parasitising >= 0)
					{
						t2.parasitising += skill.parasitising;
						t2.parasitising1 = skill.parasitising1;
						mainsystem.outputsystem.println(""+t2.name+"进入了寄生状态");
					}
				}
				if (skill.frozen != 0)
				{
					if (t2.frozen >= 0)
					{
						int m1 = mainsystem.toolsystem.random.run() % 50;
						if (2 * m1 > 79)
						{
							t2.frozen = 3;
							mainsystem.outputsystem.println(""+t2.name+"被冰冻了");
						}
					}
				}
				if (skill.sleeping != 0)
				{
					if (t2.sleeping >= 0)
					{
						int m2 = mainsystem.toolsystem.random.run() % 50;
						if (2 * m2 > 69)
						{
							t2.sleeping = +2;
							mainsystem.outputsystem.println(""+t2.name+"进入了睡眠状态");
						}
					}
				}
				if (skill.afraid1 != 0)
				{
					if (t2.afraid >= 0)
					{
						int afraid = mainsystem.toolsystem.random.run() % 50;
						if (2 * afraid > 59)
						{
							t2.afraid1 = 1;
							mainsystem.outputsystem.println(""+t2.name+"进入了恐惧状态");
						}
					}
				}
				if (skill.special == 1)
				{
					special1.run(t1, t2, team2);
				}
			}
			else
			{
				mainsystem.outputsystem.println("，被"+t2.name+"闪避！");
			}
			//Sleep(1000);
			//对自身效果
			if (skill.strength2 != 0)
			{
				int i = (t1.strength0) * (skill.strength2) / 100;
				if (skill.strength2 > 0)
				{
					i = mainsystem.toolsystem.weatherto.run(round, t1, i, 2);
					t1.strength += i;
					mainsystem.outputsystem.println(""+t1.name+"的生命上升了");
				}
				else if (skill.strength2 < 0)
				{
					t1.strength += i;
					mainsystem.outputsystem.println(""+t1.name+"的生命下降了");
				}
			}
			if (skill.electricity != 0)
			{
				int k = mainsystem.toolsystem.random.run() % 50 + mainsystem.toolsystem.random.run() % 50 + 2;
				if (skill.electricity > 0)
				{
					if (k <= t1.electricityrate)
					{
						t1.electricity += skill.electricity;
					}
				}
				else
				{
					t1.electricity += skill.electricity;
					if (t1.electricity < 0)
					{
						t1.electricity = 0;
					}
					else
					{
						if (skill.electricityrate0 != 0)
						{
							t2.electricity -= skill.electricity;
						}
						else
						{
							k = mainsystem.toolsystem.random.run() % 50 + mainsystem.toolsystem.random.run() % 50 + 2;
							if (k <= t2.electricityrate)
							{
								t2.electricity -= skill.electricity;
							}
						}
					}
				}
			}
			if (skill.special == 2)
			{
				special2.run(round);
			}
			if (skill.strength20 != 0)
			{
				int i = (t1.strength) * (skill.strength20) / 100;
				if (skill.strength20 > 0)
				{
					i = mainsystem.toolsystem.weatherto.run(round, t1, i, 2);
					t1.strength += i;
					mainsystem.outputsystem.println(""+t1.name+"的生命上升了");
				}
				else if (skill.strength20 < 0)
				{
					t1.strength += i;
					mainsystem.outputsystem.println(""+t1.name+"的生命下降了");
				}
			}
			if (skill.strength200 != 0)
			{
				int i = (t1.strength0 - t1.strength) * (skill.strength200) / 100;
				if (skill.strength200 > 0)
				{
					i = mainsystem.toolsystem.weatherto.run(round, t1, i, 2);
					t1.strength += i;
					mainsystem.outputsystem.println(""+t1.name+"的生命上升了");
				}
				else if (skill.strength200 < 0)
				{
					t1.strength += i;
					mainsystem.outputsystem.println(""+t1.name+"的生命下降了");
				}
			}
			if (skill.defence2 != 0)
			{
				t1.defence += (t1.defence) * (skill.defence2) / 100;
				if (skill.defence2 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的防御上升了");
				}
				else if (skill.defence2 < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的防御下降了");
				}
			}
			if (skill.speed2 != 0)
			{
				t1.speed += skill.speed2;
				if (skill.speed2 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的速度提升了");
				}
				else if (skill.speed2 < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的速度下降了");
				}
			}
			if (skill.heavy2 != 0)
			{
				t1.heavy += (t1.heavy) * (skill.heavy2) / 100;
				if (skill.heavy2 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的暴击伤害上升了");
				}
				else if (skill.heavy2 < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的暴击伤害下降了");
				}
			}
			if (skill.heavyrate2 != 0)
			{
				t1.heavyrate += skill.heavyrate2;
				if (skill.heavyrate2 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的暴击率上升了");
				}
				else if (skill.heavyrate2 < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的暴击率下降了");
				}
			}
			if (skill.recovering != 0)
			{
				t1.recovering += skill.recovering;
				t1.recovering1 = skill.recovering1;
				if (skill.recovering1 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"进入持续回复状态");
				}
				else if (skill.recovering < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"进入持续掉血状态");
				}
			}
			if (skill.attack2 != 0)
			{
				t1.attack += (t1.attack) * (skill.attack2) / 100;
				if (skill.attack2 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的攻击上升了");
				}
				else if (skill.attack2 < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的攻击下降了");
				}
			}
			if (skill.miss2 != 0)
			{
				t1.miss += skill.miss2;
				if (skill.miss2 > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的闪避率上升了");
				}
				else if (skill.miss2 < 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"的闪避率下降了");
				}
			}
			if (skill.wudi != 0)
			{
				t1.wudi += skill.wudi;
				mainsystem.outputsystem.println(""+t1.name+"进入了无敌状态");
			}
			if (skill.reflect != 0)
			{
				t1.reflect += skill.reflect;
				t1.reflect1 = skill.reflect1;
				t1.reflect2 = skill.reflect12;
				mainsystem.outputsystem.println(""+t1.name+"进入了反伤状态，可反弹一定伤害");
			}
			if (skill.miankong != 0)
			{
				t1.miankong += skill.miankong;
				mainsystem.outputsystem.println(""+t1.name+"进入了免控状态，免疫一切异常状态");
			}
			if (skill.shield != 0)
			{
				t1.shield += skill.shield;
				mainsystem.outputsystem.println(""+t1.name+"获得了一个护盾");
			}
			if (skill.special == 4)
			{
				special4.run(round, t1);
			}

			//护盾设置
			if (t1.strength > t1.strength0)
			{
				t1.shield += ((t1.strength - t1.strength0) * 50) / 100;
				t1.strength = t1.strength0;
			}
			else if (t2.strength > t2.strength0)
			{
				t2.shield += ((t2.strength - t2.strength0) * 50) / 100;
				t2.strength = t2.strength0;
			}
		}
		//被拖堂
		else
		{
			mainsystem.outputsystem.println("，被高老师拖堂，无法使用");
			if (skill.quantity == 0)
			{
				skill.quantity++;
			}
		}
		//连环攻击判定
		if (skill.special == 5)
		{
			int y = mainsystem.toolsystem.random.run() % 100;
			if (y >= 35)
			{
				skill.quantity++;
				run(round, skill,t1, t2,team1,team2);
			}
		}
		//傻乔技能强化还原
		if (round.a.get("3") > 0 && t1.order == 9)
		{
			skill.vampirism = placevapirism;
		}
		//延迟伤害归还
		if (t2.lateattack1 > 0 && round.a.get("4") > t2.strength)
		{
			t2.lateattack += round.a.get("4") - t2.strength;
			mainsystem.outputsystem.println(""+t2.name+"归还"+(round.a.get("4") - t2.strength)+"点延迟伤害");
			t2.strength = round.a.get("4");
			round.a.put("4",0);
		}
		try {
			Thread.sleep(800);
		}catch(InterruptedException e){}
	}
}
