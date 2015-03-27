/**
Algorithm:
This problem can be viewed as a directed acyclic graph (DAG). The advantage of a DAG is that there is no cycle and hence we can
use a dynamic programming approach. In dynamic programming I am storing the maxCycles for each starting point in a map. I am
using recursion to go to the next index which is given by the value in the present index. If this next index is stored in the map,
I can directly read its cycle count and return. This way I save additional recursive steps.

In recursion I am incrementing the count when I step into a new number. The base case is that the current index should not be the 
starting point. The key of the map is the starting position and the value of the map is the maximum number of elements which can be 
stepped on, from that position. 

Complexity: The worst case complexity is O(n^2), where n is the number of elements in the board vector. An example of worst case is
case 3 of this example, where n is 5 and the max cycle count is 5. 

I could have defined 2 files for this class - 1) header file 2) implementation file, but due to time constraints, i did not do that way
*/

#include "stdafx.h"

class CyclesInPermutation
	{
		
		public: 
			map<int, int> maxSteps; // for storing the cycle count for each starting position
			int max ;
			int maxCycle( vector<int> *board) //wrapper
			{
				max = 0;
				maxSteps.clear();
				for(int i = 0; i<board->size() ; i++)
					{
						int temp;
						temp = this->compute(board, i, 1, board->at(i)-1);
						maxSteps.insert(pair<int, int>(i, temp)); 
					}
				
				return this->max;
			}

		public: int compute(vector<int> *board, int start, int maxC, int goToIndex)
			{
				if(goToIndex == start)
					{
						if(this->max < maxC)
							this->max = maxC;

						return maxC;
					}
				if(!(maxSteps.find(goToIndex) == maxSteps.end()))
					{
						if(goToIndex<start && maxC>1) // to not add what is already counted
							maxC = maxC;
						else
							maxC+=(this->maxSteps.find(goToIndex)->second)-1;
						if(this->max < maxC)
							this->max = maxC;

						return maxC;
					}
				

				compute(board, start, maxC+1, board->at(goToIndex)-1);
			}

	};