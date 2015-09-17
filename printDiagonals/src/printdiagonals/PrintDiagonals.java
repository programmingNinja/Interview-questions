/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package printdiagonals;

/**
 *
 * @author Rohan
 */
public class PrintDiagonals 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int row = 6;
        int col = 6;
        int[][] input = new int[row][col];
        int data = 1;
        for(int i=0 ; i<row ; i++)
        {
            for(int j=0 ; j<col ; j++)
            {
                input[i][j] = data;
                data++;
            }
        }
        printArray(input);
        printDiagonals(input);
    }

    private static void printDiagonals(int[][] input) 
    {
        int x = 0, y=0;
        while(y<input[0].length)
        {
            printDiagonals(x, y, input);
            System.out.println("");
            y++;
        }
        y-=1;
        x++;
        while(x<input.length)
        {
            printDiagonals(x,y, input);
            System.out.println("");
            x++;
        }
        
        
    }

    private static void printDiagonals(int x, int y, int[][] in) 
    {
        //System.out.println("x "+x+" y "+y);
        if(y<0 || x>in.length-1)
            return;
        /*if(x == y)
            System.out.print(in[x][y]);*/
        else
        {
            System.out.print(in[x][y]+" ");
            printDiagonals(++x, --y, in);
        }
    }

    private static void printArray(int[][] input) {
        for(int i=0 ; i<input.length ; i++)
        {
            for(int j=0 ; j<input[0].length ; j++)
                System.out.print(input[i][j]+" ");
            System.out.println("");
        }
        System.out.println("============================");
        }
    
}
