package com.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		Long subSum = (long) 0;
		Long sum = (long) 0;
		Long digit = (long) 0;
		int index = 0;
		Long num2 = num;
		String numString = num2.toString();
		int length = numString.length();
		Long[] digits = new Long[length];
		
		while(num2 > 9)
		{
			digit = (num2 % 10);
			num2 = num2 / 10;
			digits[index] = digit;
			index++;
		}
		
		digits[index] = num2;
		
		for(int i = 0; i < length; i++)
		{
			subSum = digits[i];
			for(int j = 1; j < length; j++)
			{
				subSum = subSum * digits[i];
			}
			sum += subSum;
		}
		
		if(sum == num)
		{
			return true;
		}
		
		return false;
	}
}
