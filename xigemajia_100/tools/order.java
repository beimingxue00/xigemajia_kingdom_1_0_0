package com.example.xigemajia_100.tools;

public class order {
	public order() {}
	public int run(String v) {
		if (v.contains( "9"))
		{
			return 8;
		}
		else if (v.contains( "*"))
		{
			return 7;
		}
		else if (v.contains( "&"))
		{
			return 6;
		}
		else if (v.contains( "6"))
		{
			return 5;
		}
		else if (v.contains( "5"))
		{
			return 4;
		}
		else if (v.contains( "4"))
		{
			return 3;
		}
		else if (v.contains( "3"))
		{
			return 2;
		}
		else if (v.contains( "2"))
		{
			return 1;
		}
		else if (v.contains( "1"))
		{
			return 0;
		}
		else if (v.contains( "0"))
		{
			return -2;
		}
		else
		{
			return -1;
		}
	}
}
