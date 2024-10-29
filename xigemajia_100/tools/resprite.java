package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.*;

public class resprite {
	public resprite() {}
	public void run(sprite p) {
		p.strength = p.strength0;
		p.attack = p.attack0;
		p.defence = p.defence0;
		p.speed = p.speed0;
		p.heavyrate = p.heavyrate0;
		p.heavy = p.heavy0;
		p.miss = p.miss0;
		p.shield = p.shield0;
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
		p.parasitising = 0;
		p.recovering = 0;
		p.recovering1 = 0;
		p.electricity = 0;
		p.gg = 0;
		p.lateattack = 0;
		p.lateattack1 = 0;
		p.team=-1;

		if (p.element.equals("普通"))
		{
			p.elementnumber = 0;
		}
		else if (p.element.equals("水"))
		{
			p.elementnumber = 1;
			p.frozen = -1;
		}
		else if (p.element.equals("草"))
		{
			p.elementnumber = 2;
			p.sleeping = -1;
		}
		else if (p.element.equals("火"))
		{
			p.elementnumber = 3;
			p.fired = -1;
		}
		else if (p.element.equals("电"))
		{
			p.elementnumber = 4;
		}
		else if (p.element.equals("石"))
		{
			p.elementnumber = 5;
		}
		else if (p.element.equals("光明"))
		{
			p.elementnumber = 6;
			p.frozen = -1;
			p.sleeping = -1;
			p.fired = -1;
		}
		else if (p.element.equals("黑暗"))
		{
			p.elementnumber = 7;
			p.frozen = -1;
			p.sleeping = -1;
			p.fired = -1;
		}
		else if (p.element.equals("武"))
		{
			p.elementnumber = 8;
			p.afraid = -1;
		}
	}
}
