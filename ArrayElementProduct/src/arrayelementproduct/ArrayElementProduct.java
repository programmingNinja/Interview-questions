/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayelementproduct;

/**
 *
 * @author Rohan
 */
public class ArrayElementProduct 
{

    static void printArray(int[] arr)
    {
    for(int i=0 ; i<arr.length ; i++)
      System.out.print(arr[i]+" ");
    
    System.out.println();
  }
  
  
  static int[] getProduct(int[] input)
  {
    int multRes = 1;
    int noOfZero = 0;
    int zeroInd = -1;
    int[] output = new int[input.length];
    
    for(int i=0 ; i<input.length ; i++)
    {
      if(input[i]!=0)
        multRes*=input[i];
      else
        {
          noOfZero++;
          zeroInd = i;
        }
    }
    
    if(noOfZero == 1)
        {
          output[zeroInd] = multRes;
          return output;
        }
      if(noOfZero >= 2)
      {
        return output;
      }
    
    for(int j=0 ; j<input.length ; j++)
      {
          output[j] = multRes/input[j];
    }
    
    return output;
  }
  
  public static void main(String[] args)
  {
    int[] oneZero = {1,2,3,0,7};
    int[] twoZero = {0,1,2,0,4};
    int[] noZero = {1,2,3,4};
    
    int[] resOneZero = getProduct(oneZero);
    printArray(resOneZero);
    
    int[] resTwoZero = getProduct(twoZero);
    printArray(resTwoZero);
    
    int[] resNoZero = getProduct(noZero);
    printArray(resNoZero);
    
    
  }
    
}
