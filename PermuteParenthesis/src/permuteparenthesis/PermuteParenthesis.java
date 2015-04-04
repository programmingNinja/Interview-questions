/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package permuteparenthesis;

/**
 *
 * @author Rohan
 */
public class PermuteParenthesis 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        permutations test = new permutations(4);
        test.permute();
        System.out.println("Valid permutations of parenthesis \n==================");
        test.printList();
    
    }
    
}
