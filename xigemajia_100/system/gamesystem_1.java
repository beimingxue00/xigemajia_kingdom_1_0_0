package com.example.xigemajia_100.system;
import com.example.xigemajia_100.entity.*;

public class gamesystem_1 {
	public gamesystem_1() {}
	public void run(int h[]) {
		
		int num=3,u=0;
		int l;
		for (;;)
		{
			if (num == 6)
			{
				break;
			}
			l = mainsystem.toolsystem.random.run() % mainsystem.numt;
			for (int i = 0; i < num; i++)
			{
				if (h[i] == l)
				{
					u = 1;
					break;
				}
			}
			if (u == 0)
			{
				mainsystem.team[1][num-3]=mainsystem.t[l];
				mainsystem.team[1][num-3].team = 1;
				h[num] = l;
				num++;
			}
			else
			{
				u = 0;
			}
		}
		mainsystem.fightsystem.run(mainsystem.team[0],mainsystem.team[1]);
	}
}
