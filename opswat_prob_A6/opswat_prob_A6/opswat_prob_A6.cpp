// opswat_prob_A6.cpp : Defines the entry point for the console application.


#include "stdafx.h"
#include "CyclesInPermutation.cpp"

int main()
	{
		vector<int> board;
		int max;
		CyclesInPermutation a;

		board.push_back(3);
		board.push_back(2);
		board.push_back(4);
		board.push_back(1);
		board.push_back(6);
		board.push_back(5);
		max = a.maxCycle(&board);
		cout << max<<"\n"; //3
		
		board.clear();

		board.push_back(1);
		board.push_back(2);
		board.push_back(3);
		board.push_back(4);
		board.push_back(5);
		board.push_back(6);
		max = a.maxCycle(&board);
		cout << max<<"\n"; //1
		
		board.clear();

		board.push_back(5);
		board.push_back(1);
		board.push_back(2);
		board.push_back(3);
		board.push_back(4);
		max = a.maxCycle(&board);
		cout << max<<"\n"; //5
		
		board.clear();

		board.push_back(5);
		board.push_back(7);
		board.push_back(14);
		board.push_back(6);
		board.push_back(16);
		board.push_back(10);
		board.push_back(8);
		board.push_back(17);
		board.push_back(11);
		board.push_back(12);
		board.push_back(18);
		board.push_back(3);
		board.push_back(4);
		board.push_back(13);
		board.push_back(2);
		board.push_back(15);
		board.push_back(9);
		board.push_back(1);
		board.push_back(20);
		board.push_back(19);
		max = a.maxCycle(&board);
		cout <<max<<"\n"; //11
		
		board.clear();

		getch();
		//return 0;
	}

