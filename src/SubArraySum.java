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

import java.util.Arrays;

/**
 * Created 03/02/21 4:49 PM
 *
 * @author Kridai
 */
public class SubArraySum {

   class Solution {
    public int[] solve(int[] A, int B) {
      int i =0;
      int j =0;
      long sum =A[0];
      while(j < A.length) {
        if(sum == B) {
          return Arrays.copyOfRange(A, i, j+1);
        }
        if(sum < B ) {
          if(j == A.length-1){
            break;
          }
          sum= sum+A[++j];
        }
        else if (sum > B) {
          if(i < j) {
            sum = sum - A[i++];
          }
        }
      }
      return new int[]{-1};
    }
  }

}
