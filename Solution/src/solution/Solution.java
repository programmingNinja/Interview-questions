/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

/**
 *
 * @author Rohan
 */
public class Solution {
    static int colLength;
    static int rowLength;
   public static void printRowCol(int[][] a, int start, boolean row)
    {
        if(start == Math.max(colLength, rowLength)  && row)
            return;
        
        if(start == Math.max(colLength, rowLength) && !row)
            return;
        if(row)
        {
            if(start<rowLength)
            {
                for(int i=0 ; i<colLength ; i++)
                    System.out.print(a[start][i]+" ");
            }
        }
        else
        {
            if(start<colLength)
            {
                for(int i=0 ; i<rowLength ; i++)
                    System.out.print(a[i][start]+" ");
            }
            start+=1;
        }
        System.out.println();
        printRowCol(a, start, !row);
    }
    
    public static void main(String[] args)
    {
        int[][] a = {
                    {1, 2,3,0} ,  
                    {3, 6, 7,0}// ,    
                    //{2, 3, 5,0},
                    //{1 ,2,3,0}
                 };
        colLength = a[0].length;
        rowLength = a.length;
        printRowCol(a, 0, true);
    }
    
}
