package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.round;
import com.example.xigemajia_100.system.mainsystem;

import java.util.Map;

public class roundgoing {
	public roundgoing() {}
	public void run(round round) {
		round.rounds++;
		mainsystem.outputsystem.print("天气： ");
		switch (round.weather)
		{
		case 0:
			mainsystem.outputsystem.println("普通");
			break;
		case 1:
			mainsystem.outputsystem.println("阴雨    水系伤害上升，火系伤害下降，草系防御加强");
			break;
		case 2:
			mainsystem.outputsystem.println("甘露    所有属性精灵回复能力增强，草系尤为显著");
			break;
		case 3:
			mainsystem.outputsystem.println("阳炎    火系伤害上升，所有属性精灵回复能力下降");
			break;
		case 4:
			mainsystem.outputsystem.println("雷暴    电系速度增加，开局满电量，触电伤害上升");
			break;
		case 5:
			mainsystem.outputsystem.println("沙尘    石系开局获得大额护盾，攻击提升，防御上升，除石系以外伤害下降");
			break;
		case 6:
			mainsystem.outputsystem.println("极昼    光明系防御上升，获得护盾，黑暗系攻击下降");
			break;
		case 7:
			mainsystem.outputsystem.println("永夜    黑暗系伤害上升，暴击率上升，暴击伤害上升，光明系防御下降");
			break;
		case 8:
			mainsystem.outputsystem.println("血怒    所有属性精灵伤害上升");
			break;
		default:
			break;
		}
		mainsystem.outputsystem.println("ROUND "+round.rounds+"：");
		mainsystem.outputsystem.println("");
		//所有数值-
		for (Map.Entry<String, Integer> entry : round.a.entrySet()) {
			if(entry.getValue()>0){
				round.a.put(entry.getKey(),entry.getValue()-1);
			}
		}
	}
}
