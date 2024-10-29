package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.skill;

public class iniskill {
	public iniskill() {}
	public skill run(String name, String description, String element, int speed, int quantity, int attack) {
		skill p=new skill();
		p.name=name;
		p.description=description;
		p.element=element;
		if (p.element.contains( "普通"))
		{
			p.elementnumber = 0;
		}
		else if (p.element.contains( "水"))
		{
			p.elementnumber = 1;
		}
		else if (p.element.contains( "草"))
		{
			p.elementnumber = 2;
		}
		else if (p.element.contains( "火"))
		{
			p.elementnumber = 3;
		}
		else if (p.element.contains( "电"))
		{
			p.elementnumber = 4;
		}
		else if (p.element.contains( "石"))
		{
			p.elementnumber = 5;
		}
		else if (p.element.contains( "光明"))
		{
			p.elementnumber = 6;
		}
		else if (p.element.contains( "黑暗"))
		{
			p.elementnumber = 7;
		}
		else if (p.element.contains( "武"))
		{
			p.elementnumber = 8;
		}
		p.vampirism = 0;
		p.strength2 = 0;
		p.defence2 = 0;
		p.speed = speed;
		p.speed2 = 0;
		p.heavy2 = 0;
		p.heavyrate2 = 0;
		p.quantity0 = quantity;
		p.quantity = p.quantity0;
		p.attack = attack;
		p.attack2 = 0;
		p.miss2 = 0;
		p.fired = 0;//三回合
		p.frozen = 0;//两回合
		p.sleeping = 0;//一回合
		p.wudi = 0;
		p.afraid1 = 0;
		p.reflect = 0;
		p.reflect1 = 0;
		p.miankong = 0;//免伤回合
		p.fired3 = 0;
		p.frozen3 = 0;
		p.sleeping3 = 0;
		p.afraid3 = 0;
		p.strength22 = 0;
		p.defence22 = 0;
		p.heavy22 = 0;
		p.heavyrate22 = 0;
		p.attack22 = 0;
		p.miss22 = 0;
		p.strength20 = 0;
		p.reflect12 = 0;
		p.parasitising = 0;
		p.parasitising1 = 0;
		p.recovering = 0;
		p.recovering1 = 0;
		p.shield = 0;
		p.strength200 = 0;
		p.electricity = 0;
		p.electricityrate0 = 0;
		p.strength2200 = 0;
		p.lateattack1 = 0;
		return p;
	}
}
