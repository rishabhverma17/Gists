package com.decode.strings;

import java.util.Stack;
/*
* Given an encoded string A consisting of lowercase English alphabets, square parentheses, and digits.
* The encoding rule is X[encoded string], where the encoded_string inside the square brackets is being repeated exactly X times.
* Note that X is guaranteed to be a positive integer. Find and return the decoded string.
* Note: You may assume that the original data does not contain any digits and that digits are only for those repeat numbers, X.
* For example, there won't be input like 3a or 2[4].
* You may assume that the input string is always valid. No extra white spaces, square brackets are well-formed, etc.
* You may assume that the length of the decoded string will not exced 200000.
*
* Input 1: A = "3[a]2[bc]"
* Output 1: "aaabcbc"
* Input 2: A = "3[a2[c]]"
* Output 2: accaccacc
* Input 3: A = "2[abc]3[cd]ef"
* Output 2: abcabccdcdcdef
*
* */
public class DecodeString {
    public void caller(){
        String result = decodeString("2[ab]");
        System.out.println(result);
    }

    private String decodeString(String str){
        Stack<String> stChar = new Stack<>();
        Stack<Integer> stInt = new Stack<>();
        int strLen = str.length();
        String res = "";
        //Traverse the String
        for(int i=0; i<strLen; i++){
            int count = 0;
            // Step 1: Check if its a digit
            if(Character.isDigit(str.charAt(i))){
                // Step 1.1 If its digit and is of more than once place, then get the complete digit.
                while (Character.isDigit(str.charAt(i))){
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                stInt.push(count);
            }
            // Step 2: [ starting bracket
            else if(str.charAt(i) == '['){
                stChar.push(res);
                res = "";
            }
            else if(str.charAt(i) == ']'){
                // Step 3: Pop() the multiplier from Integer Stack
                int multiplier = stInt.pop();
                StringBuilder decodedPart = new StringBuilder(stChar.pop());
                // Step 4: keep popping from Character Stack until '[' is encountered.
                for (int counter = 0; counter < multiplier; counter++){
                    decodedPart.append(res);
                }
                res = decodedPart.toString();
            }
            else{
                res += str.charAt(i);
            }
        }
        return res;
    }
}
