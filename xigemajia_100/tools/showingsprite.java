package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.sprite;
import com.example.xigemajia_100.system.mainsystem;

public class showingsprite {
	public showingsprite() {}
	public void run(sprite t) {
		mainsystem.outputsystem.println1("——————————————————————————");
		mainsystem.outputsystem.println1(t.name+"："+'\n'+t.description);
		mainsystem.outputsystem.print_i(t.url);
		mainsystem.outputsystem.println1("——————————————————————————");
		mainsystem.outputsystem.println1("剩余生命值："+t.strength+"/"+t.strength0+"  护盾："+t.shield+"  电量:"+t.electricity);
		mainsystem.outputsystem.print("状态：");
		//烧伤
		switch (t.fired)
		{
		case -1:
			mainsystem.outputsystem.print("烧伤免疫 ");
			break;
		case 1:
		case 2:
		case 3:
			mainsystem.outputsystem.print("烧伤 ");
			break;
		default:
			break;
		}
		//冰冻
		switch (t.frozen)
		{
		case -1:
			mainsystem.outputsystem.print("冰冻免疫 ");
			break;
		case 1:
		case 2:
			mainsystem.outputsystem.print("冰冻 ");
			break;
		default:
			break;
		}
		//睡眠
		switch (t.sleeping)
		{
		case -1:
			mainsystem.outputsystem.print("睡眠免疫 ");
			break;
		case 1:
			mainsystem.outputsystem.print("睡眠 ");
			break;
		default:
			break;
		}
		//无敌
		switch (t.wudi)
		{
		case 1:
		case 2:
			mainsystem.outputsystem.print("无敌 ");
			break;
		default:
			break;
		}
		//恐惧
		switch (t.afraid)
		{
		case -1:
			mainsystem.outputsystem.print("恐惧免疫 ");
			break;
		case 1:
		case 2:
		case 3:
			mainsystem.outputsystem.print("恐惧 ");
			break;
		default:
			break;
		}
		//寄生
		switch (t.parasitising)
		{
		case -1:
			mainsystem.outputsystem.print("寄生免疫 ");
			break;
		case 1:
		case 2:
		case 3:
			mainsystem.outputsystem.print("寄生 ");
			break;
		default:
			break;
		}
		//反伤
		switch (t.reflect)
		{
		case 1:
		case 2:
		case 3:
		case 4:
			if (t.reflect2 != 0)
			{
				mainsystem.outputsystem.print("反伤 ");
			}
			else
			{
				mainsystem.outputsystem.print("减伤 ");
			}
			break;
		default:
			break;
		}
		//免控
		switch (t.miankong)
		{

		case 0:
			break;
		default:
			mainsystem.outputsystem.print("异常免疫 ");
			break;
		}
		if (t.recovering > 0)
		{
			mainsystem.outputsystem.print("持续回复 ");
		}
		if (t.fired == 0 && t.frozen == 0 && t.sleeping == 0 && t.wudi == 0 && t.afraid == 0 && t.reflect == 0 && t.miankong == 0)
		{
			mainsystem.outputsystem.print("正常 ");
		}
		mainsystem.outputsystem.println1('\n'+"技能列表：");
		for (int i = 0; i < 4; i++)
		{
			mainsystem.toolsystem.showingskill.run(t.myskill[i], i);
		}
		mainsystem.outputsystem.println1('\n'+"——————————————————————————"+'\n');
	}
}
