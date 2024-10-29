package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.*;

public class ownerto {
	public ownerto() {}
	public void run(sprite t) {
		for (int i = 0; i < 4; i++)
		{
			t.myskill[i].owner = t;
		}
	}
}
