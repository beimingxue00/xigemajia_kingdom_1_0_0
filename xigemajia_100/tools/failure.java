package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.sprite;
import com.example.xigemajia_100.system.mainsystem;

public class failure {
	public failure() {}
	public int run(sprite t1,sprite t2) {
		if (t2.strength <= 0||t2.gg==1)
		{
			mainsystem.outputsystem.println("敌方败阵！");
			t2.gg = 1;
			return 1;
		}
		if (t1.strength <= 0||t2.gg==1)
		{
			mainsystem.outputsystem.println("我方败阵");
			t1.gg = 1;
			return 0;
		}

		if (t2.myskill[0].quantity == 0 && t2.myskill[1].quantity == 0 && t2.myskill[2].quantity == 0 && t2.myskill[3].quantity == 0)
		{
			mainsystem.outputsystem.println("对方pp值耗尽，敌方败阵！");
			t2.gg = 1;
			t2.strength=0;
			return 1;
		}
		if (t1.myskill[0].quantity == 0 && t1.myskill[1].quantity == 0 && t1.myskill[2].quantity == 0 && t1.myskill[3].quantity == 0)
		{
			mainsystem.outputsystem.println("pp值耗尽，我方败阵");
			t1.gg = 1;
			t1.strength=0;
			return 0;
		}

		return -1;
	}
}
