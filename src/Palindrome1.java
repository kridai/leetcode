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

import java.util.ArrayList;

/**
 * Created 15/03/21 4:00 PM
 *
 * @author Kridai
 */
public class Palindrome1 {

  public static void main(String[] args) {
    Solution solution = new Palindrome1().new Solution();
    System.out.println(solution.partition("efe"));
  }

  public class Solution {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String a) {
      computePartition(a, 0,0, new ArrayList<String>());
      return result;
    }
    public void computePartition(String a, int start, int idx, ArrayList<String> probableResult){
      if(idx >= a.length()) {
        return;
      }
      if(isPalindrome(a, start, idx)) {
        probableResult.add(a.substring(start, idx+1));
        if(idx == a.length() -1) {
          result.add((ArrayList<String>) probableResult.clone());
        }
        computePartition(a, idx+1, idx+1, probableResult);
        probableResult.remove(probableResult.size() -1);
      }
      computePartition(a, start, idx+1, probableResult);
    }
    public boolean isPalindrome(String a, int start, int end) {
      String val = a.substring(start, end+1);
      for(int i =0 ; i < val.length()/2;i++) {
        if(val.charAt(i) != val.charAt(val.length()-i-1)) {
          return false;
        }
      }
      return true;
    }
  }
}
