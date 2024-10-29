package com.example.xigemajia_100.tools;
import com.example.xigemajia_100.entity.*;

public class weatherto {
	public weatherto() {}
	public int run(round round, sprite t, int p, int mode){//mode为0对精灵数值造成影响，mode为1对攻击和防御数据造成影响,mode为2对回复数据造成影响
		switch (round.weather)
		{
		case 0:
			break;
		case 1:
			//阴雨
			if (mode == 1)
			{
				if (t.elementnumber == 1)
				{
					return (p * 120) / 100;
				}
				if (t.elementnumber == 2)
				{
					return (p * 120) / 100;
				}
				if (t.elementnumber == 3)
				{
					return (p * 90) / 100;
				}
			}
			break;
		case 2:
			//甘露
			if (mode == 2)
			{
				if (t.elementnumber == 2)
				{
					return (p * 160) / 100;
				}
				else
				{
					return (p * 120) / 100;
				}
			}
			break;
		case 3:
			//阳炎
			if (mode == 1)
			{
				if (t.elementnumber == 3)
				{
					return (p * 120) / 100;
				}
			}
			if (mode == 2)
			{
				return (p * 70) / 100;
			}
			break;
		case 4:
			//雷暴
			if (mode == 0)
			{
				if (t.elementnumber == 4)
				{
					t.speed += 20;
					t.electricity = (t.electricity0) / 2 + 1;
				}
				else
				{
					t.electricity = 1;
				}
			}
			if (mode == 1)
			{
				if (t.elementnumber == 4)
				{
					return (p * 160) / 100;
				}
			}
			break;
		case 5:
			//沙尘
			if (mode == 0)
			{
				if (t.elementnumber == 5)
				{
					t.defence += ((t.defence0) * 30) / 100;
					t.attack += ((t.attack0) * 20) / 100;
					t.shield += 120;
				}
			}
			if (mode == 1)
			{
				if (t.elementnumber != 5)
				{
					return (p * 80) / 100;
				}
				else
				{
					return (p * 120) / 100;
				}
			}
			break;
		case 6:
			//极昼
			if (mode == 0)
			{
				if (t.elementnumber == 6)
				{
					t.defence += ((t.defence0) * 30) / 100;
					t.shield = 120;
				}
				if (t.elementnumber == 7)
				{
					t.attack -= ((t.attack0) * 25) / 100;
					t.heavy -= 30;
				}
			}
			break;
		case 7:
			//永夜
			if (mode == 0)
			{
				if (t.elementnumber == 6)
				{
					t.defence -= ((t.defence0) * 30) / 100;
				}
				if (t.elementnumber == 7)
				{
					t.attack += ((t.attack0) * 30) / 100;
					t.heavyrate += 30;
					t.heavy += 70;
				}
			}
			break;
		case 8:
			//血怒
			if (mode == 1)
			{
				return (p * 120) / 100;
			}
			break;
		}
		return p;
	}
}
