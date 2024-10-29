package com.example.xigemajia_100.system;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xigemajia_100.R;
import com.example.xigemajia_100.entity.*;
import java.util.ArrayList;
import java.util.Iterator;

public class initsystem extends Thread{
	
	public initsystem() {}
	
	public void run() {
		try{
			this.sleep(3000);
		}catch(InterruptedException e){}

		mainsystem.outputsystem.println("由于技术受限，当前程序无法从c盘中读取文件，因此无法播放音乐和图片；"+'\n'+"请将本程序下载到d盘，感谢您的支持与理解(*·▽·*)");
		//system("pause");
		//system("cls");
		
		//子线程
		//thread a1(win, ref(win1));
		//a1.detach();
		//Sleep(5);

		//播放音乐
		//mciSendString("play luoke.mp3 repeat", NULL, 0, NULL);
		int j = 1;
		mainsystem.t=new sprite[mainsystem.numt+1];
		mainsystem.boss=new sprite[mainsystem.numtboss+1];
		mainsystem.team=new sprite[10][mainsystem.numt+1];
		sprite p,q,a;
	
		//精灵：int order, const char name[20], const char description[200], const char element[10], int strength, int attack, int defence, int speed, int heavyrate, int heavy,int electricity,int electricityrate, int miss
		//技能：const char name[20], const char description[200], const char element[10], int speed, int quantity, int attack
		//精灵产生
		mainsystem.toolsystem.createsprite.run(mainsystem.t);
		mainsystem.toolsystem.createboss.run(mainsystem.boss);
		//技能主人关系配对
		for (int i = 0; i < mainsystem.numt; i++)
		{
			mainsystem.toolsystem.ownerto.run(mainsystem.t[i]);
		}
		for (int i = 0; i < mainsystem.numtboss; i++) {
			mainsystem.toolsystem.ownerto.run(mainsystem.boss[i]);
		}
		//游戏部分
		for (;;)
		{
			mainsystem.outputsystem.println1("请选择您的三位出战精灵：（输入0退出）");
			for (int i = 0; i < mainsystem.numt; i++)
			{
				mainsystem.outputsystem.println1((i + 1)+"、");
				mainsystem.toolsystem.showingsprite.run(mainsystem.t[i]);
			}
			mainsystem.outputsystem.println1("请选择：");
			team myteam=new team();
			myteam.name="my team";
			ArrayList<sprite> a_myteam=myteam.sprites;
			Iterator<sprite> i_a=a_myteam.iterator();
			sprite b;
			int h[]=new int[7];
			int num = 0, u = 0, l = 0, useless = -1;
			String v;
			//精灵选择
			for (;;)
			{
				if (num == 3)
				{
					//std::system("cls");
					break;
				}
				v=mainsystem.inputsystem.tostring();
				l=mainsystem.toolsystem.order.run(v);
				for (int i = 0; i < num; i++)
				{
					if (l == h[i])
					{
						u = 1;
					}
				}
				if (l == -1)
				{
					mainsystem.outputsystem.println("数字有误，请重新输入：");
				}
				else if (l == -2)
				{
					//system("pause");
					//system("cls");
					return;
				}
				else if (u == 1)
				{
					mainsystem.outputsystem.println("精灵重复，请重新输入：");
					u = 0;
				}
				else
				{
					mainsystem.team[0][num]=mainsystem.t[l];
					mainsystem.team[0][num].team = 0;
					Log.i("Test",""+mainsystem.team[0][num].team);
					h[num] = l;
					num++;
				}
			}
			//状态刷新
			for (int i = 0; i < mainsystem.numt; i++)
			{
				mainsystem.toolsystem.resprite.run(mainsystem.t[i]);
				for (int j1 = 0; j1 < 4; j1++)
				{
					mainsystem.toolsystem.reskill.run(mainsystem.t[i].myskill[j1]);
				}
			}
			for (int i = 0; i < mainsystem.numtboss; i++)
			{
				mainsystem.toolsystem.resprite.run(mainsystem.boss[i]);
				for (int j1 = 0; j1 < 4; j1++)
				{
					mainsystem.toolsystem.reskill.run(mainsystem.boss[i].myskill[j1]);
				}
			}
			mainsystem.team[0][0].team=0;
			mainsystem.team[0][1].team=0;
			mainsystem.team[0][2].team=0;
			//system("cls");
			mainsystem.outputsystem.println("选择成功！您当前的阵容为："+'\n'
			        +"1、"+mainsystem.team[0][0].name+'\n'+"2、"+mainsystem.team[0][1].name+'\n'+"3、"+mainsystem.team[0][2].name+'\n'
					+"请选择游戏模式："+'\n'+"1、3v3对战"+'\n'+"2、PVE模式"+'\n'+"3、健涵生日大作战");

			for (;;)
			{
				v=mainsystem.inputsystem.tostring();
				if (v.contains("1"))
				{
					useless = 1;
					break;
				}
				else if (v.contains("2"))
				{
					useless = 2;
					break;
				}
				else if (v.contains("3"))
				{
					useless = 3;
					break;
				}
				else if (v.contains("0"))
				{
					//system("pause");
					//system("cls");
					break;
				}
				else
				{
					mainsystem.outputsystem.println("无法识别，请重新输入");
				}
			}
			//system("cls");
			//Sleep(2000);
			//战斗————————
			
			mainsystem.y1 = 0;
			mainsystem.y2 = -1;
			if (useless == 1)
			{
				mainsystem.gamesystem_1.run(h);
			}
			else if (useless == 2)
			{
				mainsystem.gamesystem_2.run();
			}
			else if (useless == 3)
			{
				mainsystem.gamesystem_3.run();
			}
			//战斗结束
			if (mainsystem.y2 == 0)
			{
				mainsystem.win1 = -1;
				mainsystem.outputsystem.println("战斗失败o(╥﹏╥)o");
			}
			else if (mainsystem.y2 == 1)
			{
				mainsystem.win1 = 1;
				mainsystem.outputsystem.println("战斗胜利！！ヾ(￣ー￣)X(^▽^)ゞ");
			}
			else if (mainsystem.y2 == 2)
			{
				int k = mainsystem.toolsystem.random.run() % 2;
				if (k == 0)
				{
					mainsystem.win1 = -1;
					mainsystem.outputsystem.println("战斗失败o(╥﹏╥)o");
				}
				else
				{
					mainsystem.win1 = 1;
					mainsystem.outputsystem.println("战斗胜利！！ヾ(￣ー￣)X(^▽^)ゞ");
				}
			}
			//std::system("pause");
			mainsystem.outputsystem.println("请问是否要重新开始？"+'\n'+"1、是"+'\n'+"2、否");
			int o = -1;
			for (;;)
			{
				v=mainsystem.inputsystem.tostring();
				if (v.contains("1"))
				{
					o = 1;
					break;
				}
				else if (v.contains("2"))
				{
					o = 0;
					break;
				}
				else
				{
					mainsystem.outputsystem.println("无法识别，请重新输入");
				}
			}
			if (o == 1)
			{
				//std::system("cls");
			}
			else
			{
				break;
			}
		}
		//结束释放
		
		//std::system("pause");
		//Sleep(3000);
	}
}
