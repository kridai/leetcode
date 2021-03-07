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
import java.util.Stack;

/**
 * Created 02/02/21 11:24 PM
 *
 * @author Kridai
 */
public class PossibleOutcome {

  public static void main(String[] args) {
    Solution s = new PossibleOutcome().new Solution();
    System.out.println(s.solve(5));
  }
  class Solution {
    public ArrayList<String> solve(int n) {
      ArrayList<String> result = new ArrayList<>();
       createSequence(result, "", n, 0, 0);
       return  result;
    }
    public void createSequence(ArrayList<String> result, String temp, int size, int openSize, int closedSize) {
      if(temp.length() == size*2) {
        result.add(temp);
        return;
      }
      if(openSize < size) {
        createSequence(result, temp+ "(", size, openSize+1, closedSize);
      }
      if(closedSize < openSize) {
        createSequence(result, temp+ ")", size, openSize, closedSize + 1);
      }
    }
  }

}
