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
 * Created 16/02/21 2:39 PM
 *
 * @author Kridai
 */
public class TreePathSum {

  public static void main(String[] args) {
    TreeNode A = new TreeNode(new TreeNode(null,null,1000),
        new TreeNode(null, null, 200), 5);
    Solution s = new TreePathSum().new Solution();
    System.out.println(s.hasPathSum(A, 205));
  }



   class Solution {
    public int hasPathSum(TreeNode A, int B) {
      return hasPathSumVal(A, B);
    }
    public int hasPathSumVal(TreeNode A, int B) {
      if(A == null) {
        return 0;
      }
      if(B == A.val && A.left == null && A.right ==null) {
        return 1;
      }
      if(hasPathSumVal(A.left, B-A.val) == 1) {
        return 1;
      }
      if(hasPathSumVal(A.right, B-A.val) == 1) {
        return 1;
      }
      return 0;

    }
  }
}
