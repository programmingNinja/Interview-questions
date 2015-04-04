/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fizzbuzz;

/**
 *
 * @author Rohan
 */
public class FizzBuzz 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String output = "";
        for(int i=1 ; i<50 ; i++)
        {
            System.out.print(i+" ");
            if(i%3==0)
                output+="Fizz";
            if(i%5==0)
                output+="Buzz";
           /* if(output.equals(""))
                output+="number";*/
            
            System.out.println(output);
            output = "";
        }
    }
    
}
