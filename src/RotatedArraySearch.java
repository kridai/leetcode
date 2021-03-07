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
 * Created 18/01/21 6:42 PM
 *
 * @author Kridai
 */
public class RotatedArraySearch {

  public static void main(String[] args) {
    Solution s  = new RotatedArraySearch().new Solution();
    System.out.println(s.search(new int[] {1, 7, 67, 133, 178}, 1));
  }

   class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
      int index = binarySearch(A, 0, A.length -1, B);
      return index;
    }
    public int binarySearch(int A[], int start, int end, int B){
      if(start > end) {
        return -1;
      }
      int mid = start+ (end-start)/2;
      if(A[mid] == B) {
        return mid;
      }
      if(start == mid || end==mid ){
        if(A[start] == B) {
          return start;
        }
        if(A[end] == B) {
          return end;
        }
        return -1;
      }
      if(A[start] < A[mid]){
        if(A[mid] > B) {
          if (A[start]  <= B) {
            end = mid -1;
          }
          else {
            start = mid +1;
          }
        }
        else {
          start = mid +1;
        }
      }
      else {
        if ( A[mid] < B){
          if(A[start] <= B){
            end = mid -1;
          }
          else{
            start= mid+1;
          }
        }
        else {
          end = mid -1;
        }
      }
      return binarySearch(A, start, end, B);
    }
  }


}
