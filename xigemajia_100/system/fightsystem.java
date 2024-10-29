package com.example.xigemajia_100.system;
import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.fight_about.rounding;

public class fightsystem {
	int for1break;
	sprite[] team0;
	sprite[] team1;
	rounding rounding;
	public fightsystem() {rounding=new rounding();}
	public void run(sprite[] team00,sprite[] team01) {
		
		////////////////////////////////////////////
		//round初始化
		round round = new round();
		round.weatherchanging = 1;
		//a[0]济航计时器
		round.a.put("0", 0);
		//a[1]高老师拖堂计时器
		round.a.put("1", 0);
		//a[2]高老师拖堂辅助计时器
		round.a.put("2", 0);
		//a[3]疯癫状态计时器
		round.a.put("3", 0);
		//a[4]延迟伤害储存器
		round.a.put("4", 0);
		///////////////////////////////////////////
		
		for1break = 0;
		team0=team00;
		team1=team01;
		sprite p=null;
		sprite q=null;
		
		for (;;)
		{
			//我方循环
			if (mainsystem.y1 != 2)
			{
				int num=0;
				for (;;)
				{
					if (team0[num]==null)
					{
						mainsystem.y2 = 0;
						for1break = 1;
						break;
					}
					if (team0[num].gg == 0&&team0[num].strength>0)
					{
						p=team0[num];
						break;
					}
					else
					{
						num++;
					}
				}
			}
			int num=0;
			//敌方循环
			for (;;)
			{
				if (team1[num] == null)
				{
					if (mainsystem.y2 == 0)
					{
						mainsystem.y2 = 2;
					}
					else
					{
						mainsystem.y2 = 1;
					}
					for1break = 1;
					break;
				}
				if (team1[num].gg== 0&&team1[num].strength>0)
				{
					q=team1[num];
					break;
				}
				else
				{
					num++;
				}
			}
			if (for1break == 1)
			{
				break;
			}
			//战斗循环
			for (;;)
			{
				mainsystem.tuotang=null;
				mainsystem.y1 = rounding.run(round,p,q,team0,team1);
				if (mainsystem.y1 == 2)
				{
					sprite p1 = null;
					String in;
					for (;;)
					{
						mainsystem.outputsystem.println("请选择更换的精灵：");
						in=mainsystem.inputsystem.tostring();
						if (in.contains("1"))
						{
							p1 = team0[0];
							break;
						}
						else if (in.contains("2"))
						{
							p1 = team0[1];
							break;
						}
						else if (in.contains("3"))
						{
							p1 = team0[2];
							break;
						}
						else
						{
							mainsystem.outputsystem.println("无法识别，请重新输入：");
						}
					}
					if (p1.gg == 1)
					{
						mainsystem.outputsystem.println("更换失败，"+p1.name+"已GG");
					}
					else
					{
						p = p1;
						break;
					}
				}
				else
				{
					mainsystem.tuotang = null;
					round.weatherchanging = 1;
					break;
				}
			}
			//std::system("pause");
			//std::system("cls");
		}
	}
}
