/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Longest Monotonic Subsequence in 2D
 * 
 * Algorithm:
 * Since the data contains in the form of (SATi, GPAi), and the output wanted should be such that 
 * sat1 < sat2 < … < satk and gpa1 > gpa2 > … > gpak, i sorted the given data based on GPAs. After sorting
 * I incorporated the caterpillar method and went through the sorted data. As going through the sorted data,
 * if the it matched the condition given above, i incremented the count of the length of the monotonic subsequence
 * . if the condition above is not satisfied, i start with the next data element making the length zero and 
 * counting the monotonic subsequence from there on. 
 * 
 * Data structure:
 * I selected a TreeMap because i wanted to sort the GPAs in ascending order and TreeMap does exactly that.  
 */

package longestmonotonicsubs;

import java.util.TreeMap;

/**
 *
 * @author Rohan
 */
public class LongestMonoTonicSubs 
{
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        TreeMap data = new TreeMap();
        
        // stores the starting key and ending key. prevKey stores the previous key. 
        Object fromKey, toKey, prevKey;
        
        // stores the starting key and ending keys for the longest monotonic subsequence
        Object maxFromKey, maxToKey;
        
        // length of the monotonic subsequence
        int length = 0;
        
        // length of the longest monotonic subsequence
        int maxLength = Integer.MIN_VALUE;
        
        // stores the longest monotonic subsequence
        TreeMap monotonicSeq = new TreeMap();
        
        data.put(1000, 1.0);
        data.put(1001, 1.1);
        data.put(1002, 1.2);
        data.put(1003, 0.9);
        data.put(1200, 3.0);
        data.put(1201, 2.9);
        data.put(1202, 2.8);
        data.put(1203, 2.7);
        data.put(1204, 2.6);
        data.put(500,3.5);
        data.put(300,3.4);
        data.put(400,3.3);
        data.put(450,3.2);
        data.put(475,3.1);
        data.put(480,3.05);
        fromKey = data.firstKey();
        maxFromKey = fromKey;
        maxToKey = fromKey;
        prevKey = fromKey;
        for(Object key : data.keySet())
        {
            // starting from the second element
            if(key != data.firstKey())
            {
                // checking if GPA(i) < GPA(i-1)
                // no need to check SAT scores as it is already sorted because of treemap
                if((double)data.get(key) < (double)data.get(prevKey))
                {
                    // it is a monotonic subsequence hence increase the length
                    length++;
                    toKey = key;
                    
                    // longest monotonic subsequence calculation
                    if(length > maxLength)
                    {
                        maxLength = length;
                        maxFromKey = fromKey;
                        maxToKey = toKey;
                    }
                }
                // monotonic subsequence ends here
                else
                {
                    length=0;
                    fromKey = key;
                    toKey = key;
                }
                prevKey = key;
            }
        }
        // stores the longest monotonic subsequence in the result TreeMap
        monotonicSeq.putAll(data.subMap(maxFromKey, true, maxToKey, true));        
        for(Object key : monotonicSeq.keySet())
            System.out.println("SAT score "+key+" GPA "+monotonicSeq.get(key)); 
        
        System.out.println("No of Elements in the longest monotonic subsequence is "+monotonicSeq.size() +" and the number of data elements is "+data.size());
    }    
}
