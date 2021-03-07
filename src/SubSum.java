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
 * Created 13/01/21 9:39 PM
 *
 * @author Kridai
 */
public class SubSum {

  public static void main(String[] args) {
    SubSumSolution s = new SubSumSolution();
    int A[] = new int[]{1,2,3};
    System.out.println(s.solve(A, 2));
  }
}
 class SubSumSolution {
  public int solve(int[] A, int B) {
    int suffixSum[] = new int[A.length];
    int val = 0;
    for(int i = A.length -1 ;i >=0;i--) {
      val = val + A[i];
      suffixSum[i] = val;
    }
    return findSubsequence(A,B, suffixSum, 1000, 0);
  }

  public int findSubsequence(int A[], int B, int suffixSum[], int sum, int index){
    if(B==0) {
      if(sum >= 0){
        return 1;
      }
      else {
        return 0;
      }
    }
    if((A.length - index) == B) {
      if(suffixSum[index] <= sum)  {
        return 1;
      }
      else {
        return 0;
      }
    }
    if(sum < 0 || (B > (A.length - index))) {
      return 0;
    }
    int val = findSubsequence(A, B-1, suffixSum, sum-A[index], index+1) + findSubsequence(A, B, suffixSum, sum, index+1);
    return val;
  }
}
