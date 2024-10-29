package com.example.xigemajia_100.tools;

import com.example.xigemajia_100.entity.sprite;
import com.example.xigemajia_100.entity.skill;

public class setsprite {
	public setsprite() {}
	public sprite run(int order, 
			String name, 
			String description, 
			String element,
			int strength, 
			int attack, 
			int defence, 
			int speed, 
			int heavyrate, 
			int heavy, 
			int electricity, 
			int electricityrate, 
			int miss) {
		sprite p=new sprite();
		p.order = order;
		p.name=name;
		p.description=description;
		p.element=element;

		p.gg = 0;
		p.team = -1;
		p.strength0 = strength;
		p.attack0 = attack;
		p.defence0 = defence;
		p.speed0 = speed;
		p.heavyrate0 = heavyrate;
		p.heavy0 = heavy;
		p.miss0 = miss;
		p.electricity0 = electricity;
		p.electricityrate = electricityrate;
		p.electricity = 0;
		p.shield = 0;
		p.shield0 = 0;
		p.reflect0 = 0;
		p.lateattack = 0;
		p.lateattack1 = 0;

		p.strength = p.strength0;
		p.attack = p.attack0;
		p.defence = p.defence0;
		p.speed = p.speed0;
		p.heavyrate = p.heavyrate0;
		p.heavy = p.heavy0;
		p.miss = p.miss0;


		p.fired = 0;
		p.fired1 = 0;
		p.frozen = 0;
		p.sleeping = 0;
		p.wudi = 0;
		p.afraid1 = 0;
		p.afraid = 0;
		p.reflect = 0;
		p.reflect1 = 0;
		p.reflect2 = 0;
		p.miankong = 0;
		p.parasitising = 0;
		p.parasitising1 = 0;
		p.recovering = 0;
		p.recovering1 = 0;


		if (p.element.contains( "普通"))
		{
			p.elementnumber = 0;
		}
		else if (p.element.contains( "水"))
		{
			p.elementnumber = 1;
			p.frozen = -1;
		}
		else if (p.element.contains( "草"))
		{
			p.elementnumber = 2;
			p.sleeping = -1;
			p.parasitising = -1;
		}
		else if (p.element.contains( "火"))
		{
			p.elementnumber = 3;
			p.fired = -1;
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
			p.frozen = -1;
			p.sleeping = -1;
			p.parasitising = -1;
			p.afraid = -1;
			p.fired = -1;
		}
		else if (p.element.contains( "黑暗"))
		{
			p.elementnumber = 7;
			p.frozen = -1;
			p.sleeping = -1;
			p.parasitising = -1;
			p.afraid = -1;
			p.fired = -1;
		}
		else if (p.element.contains( "武"))
		{
			p.elementnumber = 8;
			p.afraid = -1;
		}
		
		p.myskill=new skill[4];
		
		return p;
	}
}
