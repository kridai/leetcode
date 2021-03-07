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
 * Created 19/02/21 4:31 PM
 *
 * @author Kridai
 */
public class FermatTheoram {

  public static void main(String[] args) {
    Solution s = new Solution();
   System.out.println(s.solve(2, 27));
  }

  static class Solution {
    public int solve(int A, int B) {
      if(A == 1 || B==1) {
        return 1;
      }
      int mod =1000000007;
      long bval = 1;
      int i = 1;
      while(i <=B) {
        bval = ((bval% (mod-1)) *(i++)) % (mod-1);
      }
      long result = 1;
      long aval = A;
      while (bval > 0) {
        //bval is odd
        if ((bval & 1) != 0) {
          result = (result * aval) % mod;
        }
        bval = bval >> 1;
        aval = aval % mod * aval % mod;

      }
      return (int) result;
    }
  }
}
