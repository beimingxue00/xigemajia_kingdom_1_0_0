package com.example.xigemajia_100.tools;

import com.example.xigemajia_100.entity.skill;
import com.example.xigemajia_100.system.mainsystem;

public class showingskill {
	public showingskill() {}
	public void run(skill t,int i) {
		mainsystem.outputsystem.println1((i+1)+"、"+t.name+"  速度："+t.speed+"  pp："+t.quantity+"/"+t.quantity0+"  伤害："+t.attack);
		mainsystem.outputsystem.println1(t.description);
	}
}