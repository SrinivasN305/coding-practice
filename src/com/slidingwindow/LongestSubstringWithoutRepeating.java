package com.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {


    public static void main(String args[]) {


        String input = "abbc";
        int max=   findMaxLength(input);
        String  output =   findMaxLengthSubstring(input);

        int distinctKmax=    findMaxLengthSubstringWithDistinctK(input,2);
        System.out.println("max legth "+ max);
        System.out.println("max legth  string "+ output);
        System.out.println("distinctKmax legth "+ distinctKmax);


    }

    private static int findMaxLengthSubstringWithDistinctK(String input, int k) {
        int left =0 ,  max =0;

        Map<Character,Integer> map = new HashMap<>();

        for (int right = 0 ; right < input.length();right++){

            char c = input.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);

            while (map.size() >k){

                char leftChar = input.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar)==0)
                map.remove(input.charAt(left));
                left++;

            }

            max= Math.max(max, right-left+1);


        }

        return max;
    }

    private static String findMaxLengthSubstring(String input) {
        int left =0 , right =0,  max =0;
        String output = "";
        Set<Character> set = new HashSet<>();

        while (right < input.length()){

            if(!set.contains(input.charAt(right))){
                set.add(input.charAt(right));

                if(right-left +1 > max){
                    max = right-left +1;
                    output= input.substring(left,right+1);
                }
                right ++;
            } else{
                set.remove(input.charAt(left));
                left++;
            }

        }
        return output;

    }

    private static int findMaxLength(String input) {

        int left =0 , right =0,  max =0;

        Set<Character> set = new HashSet<>();

        while (right < input.length()){

            if(!set.contains(input.charAt(right))){
                set.add(input.charAt(right));
                max = Math.max(max , right-left +1) ;
                right ++;
            } else{
                set.remove(input.charAt(left));
                left++;
            }

        }
        return max;
    }
}
