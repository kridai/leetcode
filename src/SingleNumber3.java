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
 * Created 15/01/21 3:27 PM
 *
 * @author Kridai
 */
public class SingleNumber3 {

  public static void main(String[] args) {
    SingleNumber3 sn3 = new SingleNumber3();
    Solution s = sn3.new Solution();
    System.out.println(s.solve(new int[]{186, 256, 102, 377, 186, 377}).toString());
  }

  public class Solution {
    public int[] solve(int[] A) {
      int xor = 0;
      for(int i = 0; i< A.length;i ++) {
        xor = xor ^ A[i];
      }
      System.out.println(Integer.toBinaryString(xor));
      int bit = 1;
      while((bit & xor) == 0) {
        bit = bit << 1;
      }
      System.out.println(Integer.toBinaryString(bit));
      int a = 0;
      int b = 0;
      for(int i = 0; i< A.length;i++) {
        if((A[i] & bit) == 0) {
          a = a ^ A[i];
        }
        else {
          b = b ^ A[i];
        }
      }
      if( a  > b) {
        a = a+b;
        b = a-b;
        a= a-b;
      }
      return new int[]{a,b};
    }
  }
}
