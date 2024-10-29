package com.example.xigemajia_100.entity;
import java.util.Map;
import java.util.HashMap;

public class round {
	public Map<String,Integer> a;
	public int weather;
	public int rounds;
	public int weatherchanging;
	
	public round(){
		a=new HashMap<String,Integer>();
		a.put("0",0);
		a.put("1",0);
		a.put("2",0);
		a.put("3",0);
		a.put("4",0);
		a.put("5",0);
		weather=0;
		rounds=0;
		weatherchanging=0;
	}
}
