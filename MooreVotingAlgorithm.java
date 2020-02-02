package com.verma.rishabh;

/*                  ==== Boyer-Moore Vote Algorithm (Majority Element) ====
 * Basic concept is that you cant have two elements occurring more tha n n/2 times in an array.
 * So what this algorithm does is try to cancel out each element with a differing element .
 * This way, if a majority element exists, it will still persist till the end.
 */

public class MooreVotingAlgorithm {
    // Time O(n) | Space O(1)
    public Integer getMajorityElements(int[] array){
        if(array == null || array.length == 0){
            return null;
        }
        int count = 0;
        Integer majorityElement = null;
        for(int i=0; i<array.length; i++){
            if(count == 0){
                majorityElement = array[i];
                count = 1;
                continue;
            }
            else{
                if(majorityElement == array[i]){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        if(count == 0){
            return null;
        }
        count = 0;
        for(int element : array){
            if(element == majorityElement){
                count++;
            }
        }

        return (count > array.length/2) ? majorityElement : null;
    }
}
