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

/**
 * Created 05/12/20 4:09 PM
 *
 * @author Kridai
 */
public class MedianTwoArrays {

  public static void main(String[] args) {
    Solution sol = new Solution();
    double ans = sol.findMedianSortedArrays(new int[] {11, 12, 13}, new int[] { 1, 3, 4, 5, 6 });
    System.out.println(ans);
  }
}

 class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int i = n;

    while (true) {
      i = i/2;
      int leftI = nums1[i];
      int j = (n+m)/2 - (n-i);
      int leftJ = nums2[j];
      if(nums1[i] > nums2[j+1]) {
        i = (i)/2;
      }
      else {
        if ((nums2[j] < nums1[i+1]) && i != 0) {
          i = (i+n)/2;
        }
        if ( i== 0) {
          return nums2[(n+m)/2];
      }
        else {
          return  (leftI + leftJ)/2;
        }
      }
    }
  }
}