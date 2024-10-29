package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.system.mainsystem;

public class statechanging {
	public statechanging() {}
	public void run(sprite t1,sprite t2,round round) {
		//延迟伤害
		if (t1.lateattack1 == 0 && t1.lateattack > 0)
		{
			if (t1.reflect == 0 && t1.wudi == 0)
			{
				t1.strength -= t1.lateattack;
				mainsystem.outputsystem.println(""+t1.name+"受到"+t1.lateattack+"点延迟伤害");
				t1.lateattack = 0;
			}
			else if (t1.wudi == 0)
			{
				int i;
				i = t1.lateattack;
				t1.lateattack = 0;
				i -= (i * (t1.reflect1)) / 100;
				t1.strength -= i;
				mainsystem.outputsystem.println(""+t1.name+"受到"+i+"点延迟伤害");
			}
			else
			{
				t1.lateattack = 0;
				mainsystem.outputsystem.println(""+t1.name+"处于无敌状态，无法造成延迟伤害");
			}
		}
		if (t1.lateattack1 > 0)
		{
			t1.lateattack1--;
			if (t1.reflect == 0 && t1.wudi == 0)
			{
				t1.strength -= (t1.lateattack) / 2;
				mainsystem.outputsystem.println(""+t1.name+"受到"+ (t1.lateattack) / 2+"点延迟伤害");
				t1.lateattack -= (t1.lateattack) / 2;
			}
			else if (t1.wudi == 0)
			{
				int i;
				i = (t1.lateattack) / 2;
				t1.lateattack -= i;
				i -= (i * (t1.reflect1)) / 100;
				t1.strength -= i;
				mainsystem.outputsystem.println(""+t1.name+"受到"+i+"点延迟伤害");
			}
			else
			{
				t1.lateattack -= (t1.lateattack) / 2;
				mainsystem.outputsystem.println(""+t1.name+"处于无敌状态，无法造成延迟伤害");
			}
		}
		//静电爆炸
		if (t1.electricity >= t1.electricity0)
		{
			if (t1.elementnumber == 4)
			{
				t1.electricity = t1.electricity0;
			}
			else
			{
				t1.electricity = 0;
				mainsystem.outputsystem.println("静电爆炸，");
				if (t1.wudi > 0)
				{
					mainsystem.outputsystem.println(""+t1.name+"处于无敌状态，无法造成伤害");
				}
				else
				{
					int i;
					if (round.weather != 4)
					{
						i = ((t1.strength0) * 40) / 100;
					}
					else
					{
						i = ((t1.strength0) * 65) / 100;
					}
					//i -= (i * (t1.reflect1)) / 100;
					t1.strength -= i;
					mainsystem.outputsystem.println(""+t1.name+"受到了"+i+"点爆炸伤害");
				}
			}
		}
		//恐惧启动
		if (t1.afraid1 > 0)
		{
			t1.afraid1 = 0;
			int m = mainsystem.toolsystem.random.run() % 4;
			t1.afraid += 1 + m;
			mainsystem.outputsystem.println(""+t1.name+"被恐惧了，无法行动！");
		}
		//恐惧计数器
		if (t1.afraid > 0)
		{
			t1.afraid--;
		}
		//灼烧计数器
		if (t1.fired > 0)
		{
			t1.fired--;
			if (t1.wudi < 1)
			{
				int i = t1.fired1;
				mainsystem.outputsystem.println(""+i);
				if (t1.reflect > 0)
				{
					i -= (i * (t1.reflect1)) / 100;
				}
				mainsystem.outputsystem.println(""+i);
				t1.strength -= i;
				mainsystem.outputsystem.println(""+t1.name+"受到了"+i+"点灼烧伤害！");
			}
			else
			{
				mainsystem.outputsystem.println(""+t1.name+"处于无敌状态，不受灼烧伤害！");
			}
		}
		//睡眠计数器
		if (t1.sleeping > 0)
		{
			mainsystem.outputsystem.println(""+t1.name+"进入了睡眠状态，无法行动！");
			t1.sleeping--;
		}
		//寄生计数器
		if (t1.parasitising > 0)
		{
			t1.parasitising--;
			if (t1.wudi < 1)
			{
				int i = ((t1.strength) * (t1.parasitising1)) / 100;
				if (t1.reflect > 0)
				{
					i -= (i * (t1.reflect1)) / 100;
				}
				int p = mainsystem.toolsystem.weatherto.run(round, t2, i, 2);
				//护盾伤害免除
				int u = i;
				if (t1.shield > 0)
				{

					if (t1.shield >= i)
					{
						t1.shield -= i;
						u = 0;
					}
					else
					{
						u -= t1.shield;
						t1.shield = 0;

					}
				}
				mainsystem.outputsystem.println(""+t1.name+"被吸取"+u+"点生命，"+t2.name+"回复了"+p+"点生命");
				t1.strength -= u;
				t2.strength += p;
			}
			else
			{
				mainsystem.outputsystem.println(""+t1.name+"处于无敌状态，不受寄生影响！");
			}
		}
		//反弹计数器
		if (t1.reflect > 0)
		{
			t1.reflect--;
			if (t1.reflect == 0)
			{
				t1.reflect1 = 0;
				t1.reflect2 = 0;
			}
		}
		//无敌计数器
		if (t1.wudi > 0)
		{
			t1.wudi--;
		}
		//免控计数器
		if (t1.miankong > 0)
		{
			t1.miankong--;
		}
		//恢复计数器
		if (t1.recovering > 0)
		{
			int j = (t1.strength0) * (t1.recovering1) / 100;
			j = mainsystem.toolsystem.weatherto.run(round, t1, j, 2);
			t1.strength += j;
			mainsystem.outputsystem.println(""+t1.name+"回复了"+j+"点生命");
			t1.recovering--;
		}
		//济航判定
		if (round.a.get("0") != 0 && t1.elementnumber == 5)
		{
			t1.reflect1 = 50;
			t1.reflect2 = 0;
		}
	}
}
