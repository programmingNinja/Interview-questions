/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Problem Statement:
 * Find a bomb in a given sorted array. A bomb is defined as a three or more consecutive pair of integers.
 * For example: A = [1,1,2,2,3,3,4,5] has a bomb because it has [2,2,3,3,4,4]
 * B = [1,1,2,2,2,2,2,2,3,3,4,5] has a bomb because it has [1,1,2,2,2,2,2,2,3,3] (can have more number of pairs for a number)
 * C = [1,1,2,2,3,4,5,5] does not have a bomb
 * 
 * the size of the element can fit in an "int" data type and so can the element's value
 */
package bomb;

/**
 *
 * @author Rohan
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bomb  {
    static boolean contains_bomb(int[] arr) 
    {
        // since we reuire atleast 3 pairs, there has to be 6 or more than 6 integers in the array
        if(arr.length < 6)
            return false;
        
        // for pairs
        int count = 0;
        
        // for checking consecutive pairs
        int consecutive = 1;
        
        for(int i=0, j=1 ; j<arr.length ; i++,j++)
            {
            if(arr[j] == arr[i]) // we got a pair
            {
                count++;
                // we got 3 pairs of consecutive pairs of integers 
                if(consecutive >= 3)
                        return true;
            }
            else{
                if(arr[j]-arr[i] == 1 && count>0)
                {
                    consecutive++;
                    
                }
                else if(arr[j]-arr[i] > 1)
                {
                    consecutive=1;
                    count=0;
                }
                // for tracking the next pair
                count = 0;
                
            }
        
        }
        
        return false;
        
        /*==== Alternate solution ======
        // selected treemap because it ssorts according to the key
        // key of the treemap is the element in the array and the value is the number of times that element occurs
        
        
        TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>();
        for(int i=0 ; i<arr.length ; i++)
            {
            if(count.containsKey(arr[i]))
                count.put(arr[i], count.get(arr[i])+1);               
            else
                count.put(arr[i], 1);
        }
        
        Set<Integer> keys = count.keySet();
        
        // we dont want any keys which occurs only once, hence removing them from the treemap
        count.values().removeAll(Collections.singleton(1));
        
        // now the task is just to check consecutiveness of the keys as we have determined the pairs in the previous step.
        int prevKey = count.firstKey();
        int consecutive = 1;
        for(int key: keys){
            if(key == prevKey)
                continue;
            
            //checking consecutiveness
            if(key - prevKey == 1)
            {
                consecutive++;
                if(consecutive >= 3)
                    return true;
                
                
            }
            // we found a non consecutive element hence reinitializing the consecutive variable to 1
            else if(key - prevKey > 1)
                consecutive = 1;
            
            prevKey = key;
        }
        return false;*/
    }

public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        boolean res;
        
        int _arr_size = Integer.parseInt(in.nextLine());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine());
            _arr[_arr_i] = _arr_item;
        }
        
        res = contains_bomb(_arr);
        System.out.println("res "+res);
        //bw.write(String.valueOf(res ? 1 : 0));
        //bw.newLine();
        
        //bw.close();
    }
}