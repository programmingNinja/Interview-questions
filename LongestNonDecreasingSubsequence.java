/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Question:
Find the length of the longest non-decreasing sequence through adjacent, non-repeating cells (including diagonals) 
in a rectangular grid of numbers in a language of your choice. The solution should handle grids of arbitrary width and height. 

For example, in the following grid, one legal path (though not the longest) that could be traced is 0->3->7->9 and its 
length would be 4. 

8 2 4 
0 7 1 
3 7 9 

The path can only connect adjacent locations (you could not connect 8 -> 9). The longest possible sequence for 
this example would be of length 6 by tracing the path 0->2->4->7->7->9 or 1->2->4->7->7->9. 

Write a method, in a language of your choice, that takes a rectangular grid of numbers as input, and returns the 
length of the longest such sequence as output.
Basic assumptions: 
1) the grid is always of integers
2) the grid is not a jagged array but always a rectangular array
3) values of the grid cannot be null

Basic Algorithm:
The algorithm is a recursive algorithm working on 8-connected points (array elements). It checks the neighboring points and goes through them
recursively. As and when it traverses through the elements, the length of the longest subsequence is noted. All the visited nodes in
a single recursive traversal are noted in another array.

Future Work:
The longest non decreasing sequence can also be stored. Strategy for it would be to use a data structure that can store an entry
with key value pair where the key can repeat. MultiKeyMap is available (https://commons.apache.org/proper/commons-collections/javadocs/api-3.2.1/org/apache/commons/collections/map/MultiKeyMap.html)
The key can be the length of the sequences and the value can be a list of the elements traversed for that length i.e the path.

*/
package longestnondecreasingsubsequence;



/**
 *
 * @author Rohan
 */
public class LongestNonDecreasingSubsequence {

    /**
     * @param args the command line arguments
     */
    // to store the length of the longest non decreasing sequence
    int resultLen = 0;
    
    // to store the row length of the grid
    int row;
    
    // to store the column length of the grid
    int col;
 
    // grids in which the non decreasing subsequence's length is to be found
     int[][] grid = {{0, -1, 1}, 
                       {1, 1, 1}, 
                       {0, 1, 0}}; 
        //int[][] grid = {{1,0},{0,1}};*/
    /*int[][] grid =  {{8, 2, 4}, 
                     {0, 7, 1}, 
                     {3, 7, 9}}; */

        
    // method to check the boundary conditions for the co-ordinate indexes of the array
    public boolean checkBoundary(int x, int y)
    {
        if( x >= 0 && x < row && y >= 0 && y < col)       
            return true; // within the boundaries
        
        else return false;
    }
    public void computeLongestSequence(int[][] grid, int startRow, int startCol, boolean[][] visited, int longestSeq)
    {
        // this is the longest sequence i.e. it covered all the elements in the grid exactly once (Hamiltonian Path)
        // hence no point in going further (minor optimization)
        if(resultLen == (row*col))
            return;
        
        //counting the current element in the sequence
        longestSeq++;
        
        //if only one element
        if(grid.length == 1 && grid[0].length == 1)
           return ;
        
        // if element already visited
        if(visited[startRow][startCol])
            return ;
        
        // marking the current element as visited
        visited[startRow][startCol] = true;
        
        // 8 connected recursive calls
        if(checkBoundary(startRow, startCol+1) && grid[startRow][startCol] <= grid[startRow][startCol+1]) // right
            computeLongestSequence(grid, startRow, startCol+1, visited,longestSeq);
        
        if(checkBoundary(startRow+1, startCol+1) && grid[startRow][startCol] <= grid[startRow+1][startCol+1]) //diagonal bottom right
            computeLongestSequence(grid, startRow+1, startCol+1, visited,longestSeq);
        
        if(checkBoundary(startRow+1, startCol) && grid[startRow][startCol] <= grid[startRow+1][startCol]) // down
            computeLongestSequence(grid, startRow+1, startCol, visited,longestSeq);
        
        if(checkBoundary(startRow+1, startCol-1) && grid[startRow][startCol] <= grid[startRow+1][startCol-1]) // diagonal bottom left
            computeLongestSequence(grid, startRow+1, startCol-1, visited,longestSeq);
        
        if(checkBoundary(startRow, startCol-1) && grid[startRow][startCol] <= grid[startRow][startCol-1]) // left
            computeLongestSequence(grid, startRow, startCol-1, visited,longestSeq);
        
        if(checkBoundary(startRow-1, startCol-1) && grid[startRow][startCol] <= grid[startRow-1][startCol-1]) // diagonal top left
            computeLongestSequence(grid, startRow-1, startCol-1, visited,longestSeq);
        
        if(checkBoundary(startRow-1, startCol) && grid[startRow][startCol] <= grid[startRow-1][startCol]) // up
            computeLongestSequence(grid, startRow-1, startCol, visited,longestSeq);
        
        if(checkBoundary(startRow-1, startCol+1) && grid[startRow][startCol] <= grid[startRow-1][startCol+1]) // diagonal up right
            computeLongestSequence(grid, startRow-1, startCol+1, visited,longestSeq);
        
        // new longest non decreasing sequence
        if(longestSeq > resultLen)
            resultLen = longestSeq;
        
        // backtracking i.e. checking new path hence marking the current element as non visited so that it is 
        // available in other paths.
        visited[startRow][startCol] = false;
      
        
    }
    public int dpsolution(int temp[][], int i, int j)
    {
        //if(i<0 || j< 0 || i>=row || j>=col) 
        //return 0; 

        if(temp[i][j] != 0) 
        return temp[i][j]; 

        int left=0,right=0,up=0,down=0; 
        int bl=0,br=0,ul=0,ur=0;
        
        if(checkBoundary(i-1, j)&&grid[i][j] <= grid[i-1][j]) 
        up = dpsolution(temp,i-1,j); 
        
        if(checkBoundary(i+1, j)&&grid[i][j] <= grid[i+1][j]) 
        down = dpsolution(temp,i+1,j); 
        
        if(checkBoundary(i, j-1) && grid[i][j] <= grid[i][j-1]) 
        left = dpsolution(temp,i,j-1); 
        
        if(checkBoundary(i, j+1)&&grid[i][j] <= grid[i][j+1]) 
        right = dpsolution(temp,i,j+1); 
        
        if(checkBoundary(i-1, j-1)&&grid[i][j] <= grid[i-1][j-1]) 
        ul = dpsolution(temp,i-1,j-1); 
        
        if(checkBoundary(i-1, j+1)&&grid[i][j] <= grid[i-1][j+1]) 
        ur = dpsolution(temp,i+1,j+1); 
        
        if(checkBoundary(i+1, j-1)&&grid[i][j] <= grid[i+1][j-1]) 
        bl = dpsolution(temp,i+1,j-1); 
        
        if(checkBoundary(i+1, j+1)&&grid[i][j] <= grid[i+1][j+1]) 
        br = dpsolution(temp,i+1,j+1); 

        temp[i][j] = Math.max(up,Math.max(down,Math.max(left,Math.max(right,Math.max(ul,Math.max(ur,Math.max(bl,br))))))) + 1; 
        return temp[i][j];
    }
    public static int longestSequence(int[][] grid, LongestNonDecreasingSubsequence test)
    {
        for(int i=0 ; i<test.row ; i++)
        {
            for(int j=0 ; j<test.col ; j++)
            {
                // sending each element and its position as a starting point for a new path
                // sending the visited array as all false because at the start nothing is visited.
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                test.computeLongestSequence(grid, i, j, visited,0);
                int [][]temp = new int[test.row][test.col];
                //System.out.println("DP "+test.dpsolution(temp, i, j));
            }
        }
        
        return test.resultLen;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        LongestNonDecreasingSubsequence test = new LongestNonDecreasingSubsequence();
        test.row = test.grid.length;
        test.col = test.grid[0].length;
        System.out.println(longestSequence(test.grid,test));
    }
    
}
