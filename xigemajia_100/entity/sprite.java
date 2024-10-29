package com.example.xigemajia_100.entity;

public class sprite {
	public int order;
	public int team;
	public int gg;
	public String name;
	public String description;
	public String element;
	public int elementnumber;
	
	//当前值
	public int strength;
	public int attack;
	public int defence;
	public int speed;
	public int heavyrate;
	public int heavy;
	public int miss;
	public int shield;
	public int lateattack;//延迟伤害存储器
	public int lateattack1;//延迟伤害计时器

	//原始值
	public int strength0;
	public int attack0;
	public int defence0;
	public int speed0;
	public int heavyrate0;
	public int heavy0;
	public int miss0;
	public int shield0;
	public int reflect0;

	//状态值
	public int fired;
	public int fired1;//烧伤伤害
	public int recovering;//回血回合
	public int recovering1;//回血率
	public int frozen;
	public int sleeping;
	public int wudi;
	public int afraid;
	public int afraid1;//恐惧启动器
	public int reflect;
	public int reflect1;//反伤率
	public int parasitising;
	public int parasitising1;//寄生率
	public int reflect2;//受到反伤率伤害百分比
	public int miankong;
	public int electricity;//电量
	public int electricity0;//电量上限
	public int electricityrate;//触电概率
	public String url;//图片路径
	
	public skill myskill[];
	
	public sprite() {}
}
