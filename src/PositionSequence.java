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
 * Created 24/01/21 5:24 PM
 *
 * @author Kridai
 */
public class PositionSequence {

  public static void main(String[] args) {
    Solution solution = new PositionSequence().new Solution();
    System.out.println(solution.solve(2, 2));
  }

  public class Solution {
    public int solve(int A, int B) {
      long sumA = A/2*(A+1);
      sumA = sumA-B;
      long start =0;
      long end = (long) Math.sqrt(sumA);
      long mid = 0;
      while(start<=end) {
        mid = start + (end-start)/2;
        if(mid*(mid+1)/2 == sumA) {
          return (int) mid;
        }

        if(mid*(mid+1)/2 < sumA) {
          start = mid+1;
        }
        else {
          end = mid -1;
        }

      }
      return (int) start;
    }
  }

}
