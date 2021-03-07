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
 * Created 14/01/21 6:58 PM
 *
 * @author Kridai
 */

import java.util.Arrays;

/**
 * Special Integer
 * Problem Description
 *
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with sum of elements greater than B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 *
 * 1 <= B <= 10^9
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is integer B.
 *
 *
 *
 * Output Format
 * Return the maximum value of K (sub array length).
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 *
 * A = [5, 17, 100, 11]
 * B = 130
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 *
 * Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {

  public static void main(String[] args) {
    SpecialInteger sp = new SpecialInteger();
    Solution s = sp.new Solution();
   int result = s.solve(new int[]{ 1,2,3,4,5 }, 10);
   System.out.println(result);
  }
  public class Solution {

    public int solve(int[] A, int B) {
      long prefixSum[] = new long[A.length+1];
      prefixSum[0] = 0;
      for(int i= 0; i < A.length; i++) {
        prefixSum[i+1] = A[i] + prefixSum[i];
      }
      int start = 1;
      int end = A.length;
      int result = -1;
      while(start <= end) {
        int mid = (start+end)/2;
        int i;
        for(i = mid; i <= A.length;i++) {
          long prefixSumDiff;
            prefixSumDiff = prefixSum[i]-prefixSum[i-mid];
          if(prefixSumDiff > B) {
            break;
          }
        }
        if(i == A.length+1) {
          result = mid;
          start = mid+1;
        }
        else {
          end = mid-1;
        }
      }
      return result;
    }
  }


}
