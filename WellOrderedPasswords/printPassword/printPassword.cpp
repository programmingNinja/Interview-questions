// printPassword.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
 
void printPass(string digits, int startInd, string res,int length)
	{
		if(res.length() == 4)
			{
				cout<<res<<"\n";
				res="";
			}
		if(startInd == length)
			return;

		printPass(digits, startInd+1, res+digits[startInd], length);
		printPass(digits, startInd+1, res, length);
	}
int main()
{
	string digs = "0123456789";
	printPass(digs, 0, "", 10);
	getch();
	return 0;

}

