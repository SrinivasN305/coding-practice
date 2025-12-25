package com.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String args[]) {

        String s = "racecar";
        String t = "carrace";

        boolean b1 = isAnagramUsingArraySort(s, t);
        boolean b2 = isAnagramUsingMap(s, t);
        boolean b3 = isAnagramUsingMapImproved(s, t);
        boolean b4 = isAnagramUsingArray(s, t);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }

    private static boolean isAnagramUsingArray(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int [] count = new int [20];

        for(int i = 0 ; i < s.length(); i++){
            count[s.charAt(i) -'a']++;
            count[t.charAt(i)-'a']--;

        }

        for ( int i : count){
            if ( i !=0){
                return false;
            }
        }
return true;
    }

    private static boolean isAnagramUsingMapImproved(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        }
        return sMap.equals(tMap);
    }

    private static boolean isAnagramUsingMap(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (Character c : s1) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }


        for (Character c : t1) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }


        return sMap.equals(tMap);
    }

    private static boolean isAnagramUsingArraySort(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);


    }


}
