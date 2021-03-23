/*
 * Copyright 2006-2021 (c) Care.com, Inc.
 * 77 Fourth Avenue, 5th Floor Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */

/**
 * Created 09/03/21 4:34 PM
 *
 * @author Kridai
 *
 * Given a string A made up of multiple brackets of type "[]" , "()" and "{}" find the length of the longest substring which forms a balanced string .
 *
 * Conditions for a string to be balanced :
 *
 * Blank string is balanced ( However blank string will not be provided as a test case ).
 * If B is balanced : (B) , [B] and {B} are also balanced.
 * If B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 and B2 is also balanced.
 *
 */
public class LongestBalancedSubstring {

  public static void main(String[] args) {
    Solution s = new LongestBalancedSubstring().new Solution();
    System.out.println(s.LBSlength("([[]]()}[]([[]]([[]]))["));
  }


  public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int LBSlength(final String A) {
      char c[] = A.toCharArray();
      int dp[] = new int[A.length()];
      dp[0] = 0;
      for(int i =1; i <c.length; i++) {
        if(isOpen(c[i])) {
          dp[i] = 0;
        }
        else {
          if(isPair(c[i-1],c[i])){
            dp[i] = 2 + ((i-2) < 0 ? 0 : dp[i-2]);
          }
          else if( dp[i-1] !=0 && (i-dp[i-1]) >0 && isPair(c[i-1-dp[i-1]],c[i])) {
            dp[i] = dp[i-1]+2;
            if((i-2-dp[i-1]) >=0){
              dp[i] += dp[i-2-dp[i-1]];
            }
          }
          else {
            dp[i] = 0;
          }
        }
      }
      int max =0;
      for( int i : dp) {
        max = Math.max(i, max);
      }
      return max;
    }
    public boolean isOpen(char c) {
      if(c =='(' || c =='{' || c=='['){
        return true;
      }
      return false;
    }
    public boolean isPair(char c1, char c2) {
      if((c1 == '(' && c2 == ')')|| (c1=='{' && c2 == '}') || (c1=='[' && c2 ==']')){
        return true;
      }
      return false;
    }
  }

}
