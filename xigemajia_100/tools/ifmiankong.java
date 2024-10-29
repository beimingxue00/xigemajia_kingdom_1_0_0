package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.sprite;

public class ifmiankong {
	public ifmiankong() {}
	public void run(sprite t) {
		if (t.miankong > 0)
		{
			t.afraid1 = 0;
			if (t.afraid >= 0)
			{
				t.afraid = 0;
			}
			if (t.frozen >= 0)
			{
				t.frozen = 0;
			}
			if (t.fired >= 0)
			{
				t.fired = 0;
			}
			if (t.sleeping >= 0)
			{
				t.sleeping = 0;
			}
			if (t.parasitising >= 0)
			{
				t.parasitising = 0;
			}
		}
	}
}
