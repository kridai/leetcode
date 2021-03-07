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
 * Created 17/01/21 5:58 PM
 *
 * @author Kridai
 */
public class RotatedSortedArraySearch {

  public static void main(String[] args) {
    Solution s = new RotatedSortedArraySearch().new Solution();
    int val = s.search(new int[]{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100}, 202);
    System.out.println(val);
  }

   class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
      int index = binarySearch(A, 0, A.length -1, B);
      return index;
    }
    public int binarySearch(int A[], int start, int end, int B){
      if(start > end) {
        return  -1;
      }
      if(start == end) {
        return  (A[start] == B) ? start : -1;
      }
      int mid = start + (end - start)/2;
      if(A[mid] == B) {
        return mid;
      }
      if(A[mid] < B && (B <= A[end])) {
        start = mid + 1;
      }
      else if (A[mid] < B && B > A[end]) {
        end = mid -1;
      }
      else if (A[mid] > B && (B >= A[start])) {
        end = mid-1;
      }
      else {
        start = mid+1;
      }
      return binarySearch(A, start, end, B);
    }
  }

}
