package com.example.xigemajia_100.tools;

public class analyse {
	public analyse() {}
	public int run(int a,int b) {
		if (a == b)
		{
			if (a == 0)
			{
				return 100;
			}
			else if (a == 8 || a == 6 || a == 7)
			{
				return 180;
			}
			else
			{
				return 80;
			}
		}
		else if (a == 0)
		{
			return 100;
		}
		else if (b == 8)
		{
			return 130;
		}

		else if (a == 1)
		{
			if (b == 2 || b == 6 || b == 7)
			{
				return 80;
			}
			else if (b == 3 || b == 5)
			{
				return 130;
			}
			else
			{
				return 100;
			}
		}
		else if (a == 2)
		{
			if (b == 3 || b == 6 || b == 7)
			{
				return 80;
			}
			else if (b == 1 || b == 5)
			{
				return 130;
			}
			else
			{
				return 100;
			}
		}
		else if (a == 3)
		{
			if (b == 1 || b == 5 || b == 6 || b == 7)
			{
				return 80;
			}
			else if (b == 2)
			{
				return 130;
			}
			else
			{
				return 100;
			}
		}
		else if (a == 4)
		{
			if (b == 5 || b == 6 || b == 7)
			{
				return 80;
			}
			else if (b == 1)
			{
				return 130;
			}
			else
			{
				return 100;
			}
		}
		else if (a == 5)
		{
			if (b == 1 || b == 2 || b == 6 || b == 7)
			{
				return 80;
			}
			else if (b == 4 || b == 3)
			{
				return 130;
			}
			else
			{
				return 100;
			}
		}
		else if (a == 6)
		{
			if (b == 0)
			{
				return 100;
			}
			else
			{
				return 160;
			}
		}
		else if (a == 7)
		{
			if (b == 0)
			{
				return 100;
			}
			else if (b == 6)
			{
				return 80;
			}
			else
			{
				return 160;
			}
		}
		else if (a == 8)
		{
			if (b == 6 || b == 7)
			{
				return 80;
			}
			else
			{
				return 130;
			}
		}
		else {
			return 100;
		}
	}
}
