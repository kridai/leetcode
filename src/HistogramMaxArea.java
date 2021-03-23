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

import java.util.Stack;

/**
 * Created 22/03/21 5:37 PM
 *
 * @author Kridai
 */
public class HistogramMaxArea {

  public static void main(String[] args) {
    Solution s = new HistogramMaxArea().new Solution();
    s.largestRectangleArea(new int[]{90, 58, 69, 70, 82, 100, 13, 57, 47, 18});

  }


  public class Solution {
    public int largestRectangleArea(int[] A) {
      Stack<Integer> stk = new Stack<>();
      stk.add(0);
      int left[] = new int[A.length];
      left[0] = 0;
      for(int i=1; i<A.length ; i++){
        while(!stk.isEmpty() && (A[stk.peek()] >= A[i])) {
          stk.pop();
        }
        if(stk.isEmpty()) {
          left[i] = 0;
        }
        else {
          left[i] = stk.peek()+1;
        }
        stk.push(i);
      }
      int right[] = new int[A.length];
      stk.clear();
      stk.push(A.length-1);
      right[A.length-1] = A.length-1;
      for(int i = A.length -2; i>=0; i--) {
        while(!stk.isEmpty() && (A[stk.peek()] >= A[i])) {
          stk.pop();
        }
        if(stk.isEmpty()) {
          right[i] = A.length -1;
        }
        else {
          right[i] = stk.peek() - 1;
        }
        stk.push(i);
      }
      int max = Integer.MIN_VALUE;
      for(int i=0; i < A.length; i++ ) {
        int area = (right[i] - left[i] +1 ) * A[i];
        max = Math.max(area, max);
      }
      return max;
    }


  }

}
