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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created 26/01/21 8:40 PM
 *
 * @author Kridai
 * Compare Sorted Subarrays
 * Problem Description
 *
 * Given an array A of length N. You have to answer Q queires.
 *
 * Each query will contain 4 integers l1, r1, l2 and r2. If sorted segment from [l1, r1] is same as sorted segment from [l2 r2] then answer is 1 else 0.
 *
 * NOTE The queries are 0-indexed.
 *
 *
 *
 * Problem Constraints
 * 0 <= A[i] <= 100000
 * 1 <= N <= 100000
 * 1 <= Q <= 100000
 *
 *
 *
 * Input Format
 * First argument is an array A.
 * Second will be 2-D array B denoting queries with dimension Q * 4.
 * Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].
 *
 *
 *
 * Output Format
 * Return an array of length Q with answer of the queries in the same order in input.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 7, 11, 8, 11, 7, 1]
 *  B = [
 *        [0, 2, 4, 6]
 *      ]
 * Input 2:
 *
 *  A = [1, 3, 2]
 *  B = [
 *        [0, 1, 1, 2]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1]
 * Output 2:
 *
 *  [0]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  (0, 2) -> [1, 7, 11]
 *  (4, 6) -> [11, 7, 1]
 *  Both are same when sorted hence 1.
 * Explanation 2:
 *
 *  (0, 1) -> [1, 3]
 *  (1, 2) -> [3, 2]
 *  Both are different when sorted hence -1.
 */
public class SortedSubArray {

  public static void main(String[] args) {
    Solution s = new SortedSubArray().new Solution();
    System.out.println(s.solve(new int[] {1, 7, 11, 8, 11, 7, 1}, new int[][]{{0, 2, 4, 6}}));
  }

  public class Solution {
    public int[] solve(int[] A, int[][] B) {
      int[] result= new int[B.length];
      int max = 100000000;
      int min = -100000000;
      for(int k = 0 ; k < B.length; k++) {
        int i1 = B[k][0];
        int j1 = B[k][1];
        int i2 = B[k][2];
        int j2 = B[k][3];
        if((j1-i1) != (j2-i2)) {
          result[k] = 0;
          continue;
        }
        HashMap<Integer, Integer> valueMap =new HashMap<>();
        ArrayList<Long> prefix = new ArrayList<>();
        prefix.add(0L);
        long sum = 0L;
        for(int i : A) {
          int rand;
          if(valueMap.containsKey(i)) {
            rand = valueMap.get(i);
          }
          else {
            rand = (int) (Math.random() * (max - min + 1) + min);
            valueMap.put(i, rand);
          }
          sum+=rand;
          prefix.add(sum);
        }
        if((prefix.get(j1+1) - prefix.get(i1)) == (prefix.get(j2+1) - prefix.get(i2))){
          result[k] = 1;
        }
        else {
          result[k] = 0;
        }
      }
      return result;
    }
  }

}
