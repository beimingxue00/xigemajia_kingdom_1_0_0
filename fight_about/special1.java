package com.example.xigemajia_100.fight_about;
import com.example.xigemajia_100.entity.sprite;
import com.example.xigemajia_100.system.mainsystem;

public class special1 {
	public special1() {}
	public void run(sprite t1,sprite t2,sprite[] team2) {
		sprite[] team;
		team=team2;
		int u = 10,num=0;
		sprite y = team[num];
		
		for (; y != null;)
		{
			if (u <= 0)
			{
				break;
			}
			if (y.strength > 0)
			{
				if (y.wudi < 1)
				{
					if (y.elementnumber != 4)
					{
						int i;
						i = ((y.strength) * u) / 100;
						if (y.reflect > 0)
						{
							i -= (i * (y.reflect1)) / 100;
						}
						//护盾伤害免除
						if (y.shield > 0)
						{
							if (y.shield >= i)
							{
								y.shield -= i;
								i = 0;
							}
							else
							{
								i -= y.shield;
								y.shield = 0;
							}
						}
						mainsystem.outputsystem.println(y.name+"受到了"+i+"点连锁触电伤害");
						y.strength -= i;
					}
				}
				else
				{
					mainsystem.outputsystem.println(y.name+"处于无敌状态，免疫闪电伤害");
				}
			}
			u -= 2;
			num++;
			y = team[num];
		}
	}
}
