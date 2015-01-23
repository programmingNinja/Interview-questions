The question is mentioned in the solutions file and below as well.
The DP solution does not work.

Just run the problem and you shall see the output in the console. You can change the input by changing the values of the
grid. Grid is defined as a member variable.

question:
Find the length of the longest non-decreasing sequence through adjacent, non-repeating cells (including diagonals) in 
a rectangular grid of numbers in a language of your choice. The solution should handle grids of arbitrary width and height. 

For example, in the following grid, one legal path (though not the longest) that could be traced is 0->3->7->9 and its 
length would be 4. 

8 2 4 
0 7 1 
3 7 9 

The path can only connect adjacent locations (you could not connect 8 -> 9). The longest possible sequence for this example 
would be of length 6 by tracing the path 0->2->4->7->7->9 or 1->2->4->7->7->9. 

Write a method, in a language of your choice, that takes a rectangular grid of numbers as input, and returns the length 
of the longest such sequence as output.
