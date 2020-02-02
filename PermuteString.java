package com.verma.rishabh;

public class PermuteString {
    public void permutationOfStrings(char[] input,char[] result, int[] countArray,int level){
        if(level == input.length){
            for(char ch : result){
                System.out.print(ch);
            }
            System.out.println();
            return;
        }

        else{
            for(int i=0;i< input.length; i++){
                if(countArray[i] == 0){
                    continue;
                }
                else{
                    result[level] = input[i];
                    countArray[i]--;
                    permutationOfStrings(input,result,countArray,level+1);
                    countArray[i]++;
                }
            }
        }
    }
}
