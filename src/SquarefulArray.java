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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created 13/03/21 5:03 PM
 *
 *
 * @author Kridai
 *
 *
 *
 * Problem Description
 *
 * Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 *
 * Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 *
 *
 *
 * Problem Constraints
 * 1 <= length of the array <= 12
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 *
 *
 * Output Format
 * Return the number of permutations of A that are squareful.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 2, 2]
 * Input 2:
 *
 *  A = [1, 17, 8]
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  2
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
 * Explanation 2:
 *
 *  Permutation are [1, 8, 17] and [17, 8, 1].
 */
public class SquarefulArray {

  public static void main(String[] args) {
    Solution solution = new SquarefulArray().new Solution();
    int arr[] = new int[]{428, 56, 88, 12};
    ArrayList<Integer> a1 = new ArrayList<>();
    for(int i : arr) {
      a1.add(i);
    }
    System.out.println(solution.solve(a1));
  }

  public class Solution {
    public int solve(ArrayList<Integer> A) {
      if(A.size() == 1) {
        return 0;
      }
      int res[] = new int[1];
      Collections.sort(A);
       computeSquareful(A, 0, res);
       return res[0];

    }

    public void computeSquareful(ArrayList<Integer> A, int start, int res[]) {
      if (start >= A.size()) {
        res[0]++;
      } else {
        HashSet<Integer> set = new HashSet<>();
        for (int i = start; i < A.size(); i++) {
          if (!set.contains(A.get(i)) && (start == 0 || isSquare(
              A.get(i) + A.get(start - 1)))) {
            set.add(A.get(i));
            Collections.swap(A, start, i);
            computeSquareful(A, start + 1, res);
          } else {
            Collections.swap(A, start, i);
          }
        }
      }
    }
    public boolean isSquare(int a) {
      int val =(int) Math.sqrt(a) ;
      return  (val *val) == a;
    }
  }

}
