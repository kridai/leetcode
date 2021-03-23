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
import java.util.Collections;
import java.util.List;

/**
 * Created 21/03/21 5:44 PM
 *
 * @author Kridai
 */
public class FlipArray {

  public static void main(String[] args) {
    ArrayToList val = new ArrayToList(5, 4, 6, 8, 7, 2, 3 );
    Solution solution = new FlipArray().new Solution();
    System.out.println(solution.solve(val));
  }

  public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
      int min[] = new int[2];
      min[0] = Integer.MAX_VALUE;
      min[1] = Integer.MAX_VALUE;
      int dp[][] = new int[A.size()+1][20001];
      int val = solveRec(A, 0, 0, 0, min, dp);
      return val;
    }
    public int solveRec(List<Integer> A, int index, int sum, int count, int min[], int dp[][] ) {
      if (dp[index][sum+10000] != 0) {
        return dp[index][sum+10000];
      }
      if ( index == A.size()) {
        if ((min[0] < Math.abs(sum)) || ((min[0] == Math.abs(sum)) && (min[1] < count ))) {
          dp[index][sum+10000] = min[1];
          return Integer.MAX_VALUE;
        }
        else {
          min[0] = Math.abs(sum);
          min[1] = count;
          dp[index][sum+10000] = count;
          return count;
        }
      }
      solveRec(A, index + 1, sum - A.get(index), count + 1, min, dp);
      solveRec(A, index + 1, sum + A.get(index), count, min, dp);
      dp[index][sum+10000] = min[1];
      return min[1];
    }
  }

}
