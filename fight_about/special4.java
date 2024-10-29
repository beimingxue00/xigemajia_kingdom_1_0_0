package com.example.xigemajia_100.fight_about;
import android.util.Log;

import com.example.xigemajia_100.entity.*;
import com.example.xigemajia_100.system.mainsystem;

public class special4 {
	public special4() {}
	public void run(round round, sprite t) {
		sprite[] team=mainsystem.team[t.team];
		sprite p;
		int o,num=0;
		p = team[num];
		for (; p != null;)
		{
			if (p.gg == 0)
			{
				o = ((p.strength0) * 10) / 100;
				o = mainsystem.toolsystem.weatherto.run(round, t, o, 2);
				p.strength += o;
				mainsystem.outputsystem.println(p.name+"回复了"+o+"点生命");
			}
			num++;
			p = team[num];
		}
	}
}
