// mingoGame.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
using namespace std;

bool checkMingo(int count)
	{
		return (count == 100);
	}
string getString(int a)
	{
		ostringstream convert;
		convert << a;
		return convert.str();
	}
map<int, int> initializeMap()
	{
	    map<int, int> maps;
		for(int u=0 ; u<100 ; u++)
			maps.insert(pair<int, int>(u,0));
		return maps;
	}
int * getCoords(string rowColStr)
	{
		int* temp = new int[2];
		int l=0;
		string tempWord;
		stringstream stream(rowColStr);
		while( getline(stream, tempWord, ',') )
        {
			temp[l] = atoi(tempWord.c_str());
			//cout<<" coord values in side function "<<tempWord.c_str()<<" ";
			l++;
		}
		return temp;
	}
void callingNumbers(vector<int> *calledNumbers, map<int, string> *board, map<int, int> *rowCnt, map<int, int> *colCnt)
	{
		int called, left=0, right=0 ;
		string rowCol ;
		int *coord = new int[2] ;
		for(int o=0 ; o < calledNumbers->size() ; o++)
			{
			called = calledNumbers->at(o);
			//cout<<"called "<<called<<" \n";
			if(!(board->find(called) == board->end()))
				{
					//ut<<"getting coord values\n";
					rowCol = board->find(called)->second;
					coord = getCoords(rowCol);
					//cout<<"converted to int values\n";

					//cout<<"coord values "<<coord[0]<<" "<<coord[1]<<"\n";
					//if(!(rowCnt->find(coord[0]) == rowCnt->end()))
					rowCnt->find(coord[0])->second +=1;
					//else
					//	cout<<"row not incremented\n";

					//if(!(colCnt->find(coord[1]) == colCnt->end()))
					colCnt->find(coord[1])->second +=1;
					//else
					//	cout<<"col not incremented\n";
					
					//cout<<"incremented value\n";
					if(checkMingo(rowCnt->find(coord[0])->second))
						cout<<"Mingo at row "<<coord[0]<<" after "<< o+1 <<" called numbers\n";

					if(checkMingo(colCnt->find(coord[1])->second))
						cout<<"Mingo at column "<<coord[1]<<" after "<< o+1 <<" called numbers\n";

					if(coord[0] == coord[1])
						{
							left++;
							//cout<<"max left diag "<<left<<"\n";
							if(checkMingo(left))
								cout<<"Mingo at top left diagonal after "<< o+1 <<" called numbers\n";
						}
					if((coord[0] + coord[1]) == 99)
						{
							//*rightDiag++;
							right++;
							//cout<<"max right diag "<<right<<"\n";
							if(checkMingo(right))
								cout<<"Mingo at top right diagonal after "<< o+1 <<" called numbers\n";
						}
				
				}
			}
	}
int main()
{
	map<int, string> boardNumbers;
	map<int, int> rowCount;
	map<int, int> colCount;
	vector<int> called;
	rowCount=initializeMap();
	colCount=initializeMap();
	//cout<<"initialized map\n";
	int t=0;
	string rowCol = "";
	for(int k=0;k<100;k++)
		{
			for(int j=0 ; j<100; j++)
				{
					t++;
					rowCol = getString(k)+","+getString(j);
					//cout<<" checking string value "<<rowCol<<"\n";
					boardNumbers[t]=rowCol;
				}
		}
	//cout<<"initialized board\n";
	for(int a=0 ; a<100000 ; a++)
		called.push_back(a+1);

	//cout<<"intialized called\n";
	cout<<"calling numbers\n";
	callingNumbers(&called, &boardNumbers, &rowCount, &colCount);
	getch();
	return 0;
}
