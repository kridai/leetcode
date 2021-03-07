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

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created 07/02/21 5:19 PM
 *
 * @author Kridai
 */
public class SlidingWindowMax {

  public static void main(String[] args) {
    Solution s = new SlidingWindowMax().new Solution();
    s.slidingMaximum(new int[]{648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 }, 9);
  }

  public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {
      int result[] = new int[A.length-B+1];
      Deque<Integer> queue = new LinkedList<Integer>();
      int max = Integer.MIN_VALUE;
      for(int i = 0 ;i < B-1 ; i++){
        max = Math.max(max, A[i]);
        while (!queue.isEmpty() && A[queue.peek()] <= A[i]) {
          queue.remove();
        }
        while(!queue.isEmpty() && A[queue.peekLast()] <= A[i]) {
          queue.removeLast();
        }
        queue.push(i);
      }
      result[0] = max;
      for(int i =1 ; i < result.length; i++) {
        if(queue.peekLast() < i) {
          queue.removeLast();
        }
        insertInQueue(queue, A, i+B-1);
        result[i] = A[queue.peekLast()];
      }
      return result;
    }

    public Deque<Integer> insertInQueue(Deque<Integer> queue, int A[], int i) {
      while (!queue.isEmpty() && A[queue.peek()] <= A[i]) {
        queue.remove();
      }
      while(!queue.isEmpty() && A[queue.peekLast()] <= A[i]) {
        queue.removeLast();
      }
      queue.push(i);
      return queue;
    }
  }
}
