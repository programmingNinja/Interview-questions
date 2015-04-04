package permuteparenthesis;

import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Write a function that takes a single input integer, n, and prints all all valid (ie - properly opened and closed) combinations of n-pairs of parentheses.

EXAMPLE:
Input: 3 (e g , 3 pairs of parentheses)
Output: ()()(), ()(()), (())(), ((())), (()())
*/
/**
 *
 * @author Rohan
 */
class permutations
{
    private boolean[] used;
    private StringBuilder out = new StringBuilder();
    private String in;
    private ArrayList<String> allPermutations;
    private int noOfPairs;

    permutations(int pairs)
    {
        allPermutations = new ArrayList<String>();
        noOfPairs = pairs;
        createInput(pairs);
        out.append("");
    }
    public void printList()
    {
        if(allPermutations.isEmpty())
            System.out.println("list is empty");
        for(String str : allPermutations)
            System.out.println(str+" ");
    }
    public boolean isValidPermutation(String check)
    {
        Stack<Character> parenth = new Stack<Character>();
        if(check.length() != noOfPairs*2)
            return false;

        for(int i=0 ; i<check.length() ; i++)
        {
            if(check.charAt(i) == '(')
                parenth.push(check.charAt(i));
            if(check.charAt(i) == ')')
            {
                if(parenth.isEmpty())
                    return false;
                char temp = parenth.pop();
                if(temp == ')')
                    return false;
            }
        }
        return parenth.isEmpty();
    }
    public void permute()
    {
        if(out.length() == in.length())
        {
              if(isValidPermutation(out.toString()))
              {
                  if(!allPermutations.contains(out.toString()))
                  allPermutations.add(out.toString());
              }
              return;
        }

        for(int i=0 ; i<in.length() ; i++)
        {
              if(used[i]) continue;

              out.append(in.charAt(i));
              used[i] = true;
              permute();
              used[i] = false;
              out.setLength(out.length() - 1);
        }
    }

    private void createInput(int pairs) 
    {
        in="";
        for(int i=0 ; i<pairs ; i++)
            in+="(";
        for(int j=0 ; j<pairs ; j++)
            in+=")";
        
        
        used = new boolean[in.length()];
        
    }
}

