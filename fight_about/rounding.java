package com.example.xigemajia_100.fight_about;
import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.system.mainsystem;

public class rounding {
	round round;
	sprite[] team0;
	sprite[] team1;
	sprite t1;
	sprite t2;
	to to;
	public rounding() {to=new to();}
	public int run(round round0,sprite t01,sprite t02,sprite[] team00,sprite[] team01) {
		//两精灵对战
		round=round0;
		team0=team00;
		team1=team01;
		t1=t01;
		t2=t02;
		
		//对战过程
		//刷新状态
		mainsystem.tuotang = null;
		if (t1.parasitising > 0)
		{
			t1.parasitising = 0;
		}
		if (t2.parasitising > 0)
		{
			t2.parasitising = 0;
		}

		int t1skill=0, t2skill=0, t1move = 0, strengthbottleuse = 0, energybottleuse = 0, result, useless = 0;
		mainsystem.toolsystem.reround.run(round);
		useless = mainsystem.toolsystem.weatherto.run(round, t1, 0, 0);
		useless = mainsystem.toolsystem.weatherto.run(round, t2, 0, 0);
		for (;;)
		{
			mainsystem.toolsystem.roundgoing.run(round);
			mainsystem.toolsystem.showingsprite.run(t1);
			mainsystem.toolsystem.showingsprite.run(t2);
			//Sleep(1000);
			if (t1.afraid <= 0 && t1.frozen <= 0 && t1.sleeping <= 0)
			{
				for (;;)
				{
					mainsystem.outputsystem.println("请选择技能：(5、吃药 6、回蓝 7、换精灵)");
					String d;
					d=mainsystem.inputsystem.tostring();
					if (d.contains("1"))
					{
						t1skill = 0;
						t1move = 1;
					}
					else if (d.contains("2"))
					{
						t1skill = 1;
						t1move = 1;
					}
					else if (d.contains("3"))
					{
						t1skill = 2;
						t1move = 1;
					}
					else if (d.contains("4"))
					{
						t1skill = 3;
						t1move = 1;
					}
					else if (d.contains("5"))
					{
						if (mainsystem.strengthbottle > 0)
						{
							mainsystem.strengthbottle--;
							t1.strength += t1.strength0 / 2;
							if (t1.strength > t1.strength0)
							{
								t1.strength = t1.strength0;
							}
							strengthbottleuse = 1;
							t1move = 0;
							break;
						}
						else
						{
							mainsystem.outputsystem.println("暂无药剂，请重新输入");
						}
					}
					else if (d.contains("6"))
					{
						if (mainsystem.energybottle > 0)
						{
							mainsystem.energybottle--;
							for (int i = 0; i < 4; i++)
							{
								t1.myskill[i].quantity = t1.myskill[i].quantity0;
							}
							energybottleuse = 1;
							t1move = 0;
							break;
						}
						else
						{
							mainsystem.outputsystem.println("暂无魔瓶，请重新输入");
						}
					}
					else if (d.contains("7"))
					{
						return 2;
					}
					else
					{
						mainsystem.outputsystem.println("无法识别指令，请重新输入");
					}
					if (t1move > 0)
					{
						if (t1.myskill[t1skill].quantity > 0)
						{
							break;
						}
						else
						{
							mainsystem.outputsystem.println("该技能蓝条耗尽，请重新输入");
						}
					}

				}
				//Sleep(1000);
				//::system("cls");
				//Sleep(1000);
				if (t1move == 1)
				{
					if (t2.afraid > 0 || t2.frozen > 0 || t2.sleeping > 0)
					{
						to.run(round,t1.myskill[t1skill], t1,t2,team0,team1);
						mainsystem.toolsystem.ifmiankong.run(t2);
						//Sleep(1000);
						mainsystem.outputsystem.println(t2.name+"被控，无法出招");
					}
					else
					{
						for (;;)
						{
							t2skill = mainsystem.toolsystem.random.run() % 4;
							if (t2.myskill[t2skill].quantity != 0)
							{
								break;
							}

						}
						if (t1.myskill[t1skill].speed > t2.myskill[t2skill].speed)
						{
							to.run(round, t1.myskill[t1skill],t1, t2,team0,team1);
							mainsystem.toolsystem.ifmiankong.run(t2);
							//Sleep(1000);
							//死亡判断
							result = mainsystem.toolsystem.failure.run(t1, t2);
							if (result > -1)
							{
								break;
							}
							//死亡判断结束
							if (t2.afraid <= 0 && t2.frozen <= 0 && t2.sleeping <= 0)
							{
								to.run(round, t2.myskill[t2skill],t2, t1, team1,team0);
							}
							else
							{
								mainsystem.outputsystem.println(t2.name+"被控，无法出招");
							}
						}
						else if (t1.myskill[t1skill].speed < t2.myskill[t2skill].speed)
						{
							to.run(round, t2.myskill[t2skill],t2, t1, team1,team0);
							mainsystem.toolsystem.ifmiankong.run(t1);
							//Sleep(1000);
							//死亡判断
							result = mainsystem.toolsystem.failure.run(t1, t2);
							if (result > -1)
							{
								break;
							}
							//死亡判断结束

							if (t1.afraid <= 0 && t1.frozen <= 0 && t1.sleeping <= 0)
							{
								to.run(round, t1.myskill[t1skill], t1,t2, team0,team1);
							}
							else
							{
								mainsystem.outputsystem.println(t1.name+"被控，无法出招");
							}
						}
						else
						{
							if (t1.speed < t2.speed)
							{
								to.run(round, t2.myskill[t2skill], t2,t1, team1,team0);
								mainsystem.toolsystem.ifmiankong.run(t1);
								//Sleep(1000);
								//死亡判断
								result = mainsystem.toolsystem.failure.run(t1, t2);
								if (result > -1)
								{
									break;
								}
								//死亡判断结束

								if (t1.afraid <= 0 && t1.frozen <= 0 && t1.sleeping <= 0)
								{
									to.run(round, t1.myskill[t1skill],t1, t2,team0,team1);
								}
								else
								{
									mainsystem.outputsystem.println(t1.name+"被控，无法出招");
								}
							}
							else
							{
								to.run(round, t1.myskill[t1skill],t1, t2,team0,team1);
								mainsystem.toolsystem.ifmiankong.run(t2);
								//Sleep(1000);
								//死亡判断
								result = mainsystem.toolsystem.failure.run(t1, t2);
								if (result > -1)
								{
									break;
								}
								//死亡判断结束
								if (t2.afraid <= 0 && t2.frozen <= 0 && t2.sleeping <= 0)
								{
									to.run(round, t2.myskill[t2skill],t2, t1,team1,team0);
								}
								else
								{
									mainsystem.outputsystem.println(t2.name+"被控，无法出招");
								}
							}

						}
					}
				}
				else
				{
					for (;;)
					{
						t2skill = mainsystem.toolsystem.random.run() % 4;
						if (t2.myskill[t2skill].quantity != 0)
						{
							break;
						}

					}
					if (strengthbottleuse > 0)
					{
						mainsystem.outputsystem.println("使用了生命药剂瓶，回复了一定血量");
						strengthbottleuse = 0;
					}
					if (energybottleuse > 0)
					{
						mainsystem.outputsystem.println("使用了魔力药剂瓶，回复了一定魔力");
						energybottleuse = 0;
					}
					mainsystem.toolsystem.ifmiankong.run(t2);
					//Sleep(1000);
					if (t2.afraid <= 0 && t2.frozen <= 0 && t2.sleeping <= 0)
					{
						to.run(round, t2.myskill[t2skill], t2,t1, team1,team0);
					}
					else
					{
						mainsystem.outputsystem.println(t2.name+"被控，无法出招");
					}

				}
			}
			else
			{
				mainsystem.outputsystem.println(t1.name+"被控，无法出招");
				//Sleep(1000);
				//std::system("cls");
				//Sleep(1000);
				for (;;)
				{
					t2skill = mainsystem.toolsystem.random.run() % 4;
					if (t2.myskill[t2skill].quantity != 0)
					{
						break;
					}

				}
				to.run(round, t2.myskill[t2skill],t2, t1, team1,team0);
			}

			//免控重置
			mainsystem.toolsystem.ifmiankong.run(t1);
			mainsystem.toolsystem.ifmiankong.run(t2);
			//t1控制数据变化
			mainsystem.toolsystem.statechanging.run(t1, t2, round);
			//t2数据变化
			mainsystem.toolsystem.statechanging.run(t2, t1, round);
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
			//死亡判断
			result = mainsystem.toolsystem.failure.run(t1, t2);
			if (result > -1)
			{
				break;
			}
			//死亡判断结束
			//std::system("pause");
			//std::system("cls");
		}
		if (result == 0)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}
