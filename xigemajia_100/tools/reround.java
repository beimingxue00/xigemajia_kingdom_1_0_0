package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.round;
import com.example.xigemajia_100.system.mainsystem;

public class reround {
	public reround() {}
	public void run(round round) {
		round.rounds = 0;
		if (round.weatherchanging == 1)
		{
			round.weather = mainsystem.toolsystem.random.run() % 9;
			round.weatherchanging = 0;
		}
		for (int value : round.a.values()) {
			value=0;
		}
	}
}
