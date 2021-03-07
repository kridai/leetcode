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
 * Created 31/01/21 4:54 PM
 *
 * @author Kridai
 */
public class MergeSortSolution {

  public static void main(String[] args) {
    Solution s = new MergeSortSolution().new Solution();
    int val[] = new int[]{45,10,15,25,50};
    s.solve(val);
    for(int i : val) {
      System.out.print(i + "\t");
    }
  }

  public class Solution {
    int mod = 1000000007;
    int sum = 0;
    public void solve(int[] A) {

      mergeSort(A, 0, A.length -1);
      System.out.println(sum);
    }

    public void  mergeSort(int A[], int l, int r) {
      if(l < r) {
        int m = l + (r - l)/2;
        mergeSort(A, l, m);
        mergeSort(A, m + 1, r);
        merge(A,l,m,r);
      }
    }
    public void merge(int arr[], int l, int m, int r) {
      int n1 = m-l+1;
      int n2 = r-m;
      int left[] = new int[n1];
      int right[] = new int[n2];
      for(int i=l;i <= m; i++) {
        left[i-l] = arr[i];
      }
      for(int i = m+1;i <= r; i++) {
        right[i-m-1] = arr[i];
      }
      int result[] = arr;
      int i =0;
      int j =0;
      int counter = l;
      while((i+j) < (n1+n2)) {
        if(i >= left.length) {
          result[counter++] = right[j++];
        }
        else if(j >= right.length) {
          result[counter++] = left[i++];
        }
        else {
          if(left[i] <= right[j]) {
            result[counter++]=left[i++];
          }
          else {
            sum  = sum + left.length - i ;
            result[counter++] = right[j++];
          }
        }

      }
    }
  }

}
