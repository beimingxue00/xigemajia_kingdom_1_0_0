package com.example.xigemajia_100.tools;
import java.util.Random;

public class random {
	public int seq;
	public Random random;
	
	public random() {
		seq=0;
		random=new Random(System.currentTimeMillis()+(seq++));
	}
	public int run() {
		return random.nextInt(65535);
	}
}
