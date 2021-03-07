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
 * Created 16/02/21 2:41 PM
 *
 * @author Kridai
 */
public class TreeNode {
  TreeNode left, right;
  int val;
  TreeNode(TreeNode left,TreeNode right,int  val) {
    this.left = left;
    this.right = right;
    this.val = val;
  }
}