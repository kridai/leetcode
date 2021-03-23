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
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created 18/03/21 10:28 PM
 *
 * @author Kridai
 *
 * Binary Tree From Inorder And Postorder
 * Problem Description
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * NOTE: You may assume that duplicates do not exist in the tree.
 *
 *
 *
 * Problem Constraints
 * 1 <= number of nodes <= 105
 *
 *
 *
 * Input Format
 * First argument is an integer array A denoting the inorder traversal of the tree.
 *
 * Second argument is an integer array B denoting the postorder traversal of the tree.
 *
 *
 *
 * Output Format
 * Return the root node of the binary tree.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [2, 1, 3]
 *  B = [2, 3, 1]
 * Input 2:
 *
 *  A = [6, 1, 3, 2]
 *  B = [6, 3, 2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *    1
 *   / \
 *  2   3
 * Output 2:
 *
 *    1
 *   / \
 *  6   2
 *     /
 *    3
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Create the binary tree and return the root node of the tree.
 */
public class TreeFromPostInorder {

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayToList<>(7,5,6,2,3,1,4);
    ArrayList<Integer> B = new ArrayToList<>(5,6,3,1,4,2,7);
    Solution solution = new TreeFromPostInorder().new Solution();
    TreeNode t = solution.buildTree(A,B);
    t.inorderRec(t);
  }

  public class Solution {
    HashMap<Integer, Integer> valueMap = new HashMap<>();
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
      for (int i = 0; i < A.size(); i++) {
        valueMap.put(A.get(i), i);
      }
      return constructTree(A, B, 0, B.size()-1, 0, B.size() -1);

    }

    public TreeNode constructTree(ArrayList<Integer> A, ArrayList<Integer> B, int inStart, int inEnd, int postS, int postE) {
      if(inStart > inEnd) {
        return null;
      }

      int index = valueMap.get(B.get(postE));
      TreeNode node = new TreeNode(A.get(index));
      int lPostS = postS;
      int lPostE = postS + index - 1 - inStart;
      int rPostS = lPostE + 1;
      int rPostE = postE - 1;
      int lInoS = inStart;
      int lInoE =  index - 1;
      int rInoS = index + 1;
      int rInoE = inEnd;
      node.right = constructTree(A, B, rInoS, rInoE, rPostS, rPostE);
      node.left = constructTree(A, B, lInoS, lInoE, lPostS, lPostE);
      return node;
    }
  }

}