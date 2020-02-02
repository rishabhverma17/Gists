/*
Longest Substring with At Most K Distinct Characters
Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Example
Example 1:
Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"

Example 2:
Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"

Example 3:
Input S = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh" and k =16
Output: 27

Challenge
O(n) time

Solution

*/

public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
     int maxLength = 0;
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        
        int i=0;
        int j = 0;
        for( ; j <s.length(); j++){
            Character key = s.charAt(j);
            if(!map.containsKey(key)){
                map.put(key,1);
            }
            else{
                map.put(key,map.get(key)+1);
            }
            if (map.size() > k) {
                maxLength = Math.max(maxLength, j - i);
                 
                while(map.size() > k){
                    Character start = s.charAt(i);
                    // remove element i from map
                    if(map.get(start) == 1){
                        map.remove(start);
                    }
                    else{
                        map.put(start,map.get(start)-1);
                    }
                    i++;
                }
            }
            int currMax = (j - i) + 1;
            maxLength = Math.max(currMax, maxLength);
        }
        
        return maxLength;
        
    }
}