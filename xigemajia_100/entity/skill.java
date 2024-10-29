package com.example.xigemajia_100.entity;

public class skill {
	public String name;
	public String description;
	public String element;
	public int elementnumber;
	public int vampirism;
	public int strength2;
	public int defence2;
	public int speed;
	public int speed2;
	public int heavy2;
	public int heavyrate2;
	public int quantity;
	public int quantity0;
	public int attack;
	public int attack2;
	public int miss2;

	public int strength20;//对自身按当前数据造成影响
	public int strength200;//对自身当前剩余数据造成影响
	public int strength2200;//对敌方按当前剩余数据造成影响

	public int strength22;
	public int defence22;
	public int heavy22;
	public int heavyrate22;
	public int attack22;
	public int miss22;

	public int shield;
	public int fired;//三回合
	public int frozen;//两回合
	public int sleeping;//一回合
	public int wudi;
	public int wudi1;
	public int afraid1;
	public int reflect;//反伤回合
	public int reflect1;//反伤率
	public int parasitising;//寄生回合
	public int parasitising1;//寄生率
	public int recovering;//回血回合
	public int recovering1;//回血率
	public int reflect12;//对敌方造成伤害的百分比
	public int miankong;//免伤回合
	public int special;//特殊技能
	public int electricity;//电量储蓄
	public int electricityrate0;//触电必中

	public int lateattack1;//延迟伤害启动器
	public int fired3;//额外伤害加成
	public int frozen3;
	public int sleeping3;
	public int afraid3;

	public sprite owner;
	
	public skill() {}
}
