#include "stdafx.h"
using namespace std;
void spiralPrint(int *arr, bool leftToRight, int startRow, int startCol, int colLength)
			{
				if(leftToRight)
					{
						for(int i=startCol ; i<colLength ; i++)
							{
								cout<<arr[i]<<" ";
							}
					}
				else
					{
						for(int j=startCol ; j>=0 ; j--)
							{
								cout<<arr[j]<<" ";
							}
					}
			}
		void wrapperSpiral(int **arr, bool leftToRight, int rowLength)
			{
				for(int k=0 ; k<rowLength ; k++)
					{
						if(!leftToRight)
							spiralPrint(arr[k], !leftToRight, k, 0, 5);
						else
							spiralPrint(arr[k], !leftToRight, k, 5-1, 5);

						leftToRight = !leftToRight;
					}
			}
int main()
	{
		int **arr ;
		arr = new int*[5];
		for(int a=0;a<5;a++)
			{
				arr[a] = new int[5];
			}
		int t=0;
		cout<<"printing arrays \n";
		for(int i=0 ; i<5 ; i++)
			{
				for(int j=0 ; j<5 ; j++)
					{
						arr[i][j] = t;
						t++;
						cout<<arr[i][j]<<" ";
					}
				cout<<"\n";
			}
		cout<<"\n";
		wrapperSpiral(arr, false, 5);
		getch();
	}
