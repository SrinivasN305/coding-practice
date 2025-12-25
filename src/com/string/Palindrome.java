package com.string;

public class Palindrome {


    public static void main(String args[]) {

      String  s ="Was it a car or a cat I saw?";


    System.out.println( isPalindrome(s));


    }

    private static boolean isPalindrome(String s) {

        int i=0;
        int j = s.length()-1;


        while (i< j)
        {
            char char1= s.charAt(i);
            char char2 = s.charAt(j);

            if(Character.isLetterOrDigit(char1) && Character.isLetterOrDigit(char2))
            {
                if( Character.toLowerCase(char1) != Character.toLowerCase(char2) ) return false;
                else{
                    i++;
                    j--;
                }

            }
            else
            {
                if( ! Character.isLetterOrDigit(char1)){
                    i++;
                }
                if( ! Character.isLetterOrDigit(char2)){
                    j--;
                }
            }
        }
        return true;
    }
}
