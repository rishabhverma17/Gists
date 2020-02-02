/*
Question : Find the length of the longest substring T of a given string (consists of lowercase letters only) 
such that every character in T appears no less than k times.

Example
Example 1:

Input:
s = "aaabb", k = 3
Output:
3
Explanation:
The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2
Output:
5
Explanation:
The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

*/

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: return an integer
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        
        // record the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;;
        }
        
        boolean flag = true;
        
        for (int i = 0; i < chars.length; i++) {
            // If we find any character which appears less than K times in string.
            if (chars[i] < k && chars[i] > 0){
                flag = false;
            }
        }
        
        // return the length of string if this string is a valid string
        // Valid meaning count of all characters appearing in string is greater than K
        if (flag == true){
            return s.length();
        }
        
        int result = 0;
        int start = 0, cur = 0;
        
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                // Split the string and recurse over the left part from start till current
                // and keep the maximum count
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                // set start to curr+1 and now process the right substring
                start = cur + 1;
            }
            // keep incrementing the right pointer.
            cur++;
        }
        
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}