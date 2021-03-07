/*
 * Copyright 2006-2020 (c) Care.com, Inc.
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
 * Created 24/12/20 4:34 PM
 *
 * @author Kridai
 */
public class Solutions {
  public int solve(int[] A) {
    int gcd = A[0];
    for (int i = 1; i < A.length; i++){
      int a = gcd;
      int b = A[i];
      if (a < b){
        b = a + b;
        a = b - a;
        b = b - a;
      }
      while (a > 0 && b!= 0){
        a = a % b;
        b = a + b;
        a = b - a;
        b = b - a;
      }
      gcd = b;
    }
    return gcd;
  }
  public int binarySearchIndex(int []A, int B) {
    int mid = 0, start = 0;
    int end = A.length -1;
    while(start < end -1) {
      mid = (start+end)/2;
      if(A[mid] > B) {
        end = mid -1 ;
      }
      else if(A[mid] <B) {
        start = mid + 1;
      }
      else {
        end = mid;
      }
    }
    if (A[mid] == B) {
      return mid;
    }
    if(A[mid+1] <= B) {
      return mid+1;
    }
    return mid;
  }
}