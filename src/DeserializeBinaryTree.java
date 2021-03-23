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
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created 18/03/21 10:50 PM
 *
 * @author Kridai
 */
public class DeserializeBinaryTree {

  public class Solution {
    public TreeNode solve(ArrayList<Integer> A) {
      Queue<TreeNode> q = new LinkedList<>();
      TreeNode head = null;
      if(A.get(0) == -1) {
        return null;
      }
      else {
        head= new TreeNode(A.get(0));
        q.add(head);
      }
      int i = 1;
      while(!q.isEmpty()) {
        TreeNode parent = q.remove();
        int left = A.get(i);
        int right  = A.get(i+1);
        if(left != -1) {
          parent.left = new TreeNode(left);
          q.add(parent.left);
        }
        if(right != -1) {
          parent.right = new TreeNode(right);
          q.add(parent.right);
        }
        i = i+2;
      }
      return head;
    }
  }


}
