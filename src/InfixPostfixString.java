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

import java.util.HashMap;
import java.util.Stack;

/**
 * Created 05/02/21 4:53 PM
 *
 * @author Kridai
 */
public class InfixPostfixString {

  public static void main(String[] args) {
    Solution s = new InfixPostfixString().new Solution();
    System.out.println(s.solve("q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)"));
  }

   class Solution {
    public String solve(String A) {
      StringBuilder sb = new StringBuilder();
      HashMap<Character, Integer> priorityMap = generatePriorityMap();
      Stack<Character> stk = new Stack<>();
      for(int i=0;i< A.length();i++) {
        if(!isOperator(A.charAt(i))) {
          sb.append(A.charAt(i));
        }
        else {
          if(stk.isEmpty()) {
            stk.add(A.charAt(i));
          }
          else if(A.charAt(i) == '(') {
            stk.push('(');
          }
          else if (A.charAt(i) == ')') {
            while (stk.peek() != '(') {
              sb.append(stk.pop());
            }
            stk.pop();
          }
          else if (priorityMap.get(stk.peek()) > priorityMap.get(A.charAt(i)) || stk.peek() =='(') {
            stk.add(A.charAt(i));
          } else {
            while(!stk.isEmpty() && stk.peek()!= '(' && priorityMap.get(stk.peek()) <= priorityMap.get(A.charAt(i))) {
              sb.append(stk.pop());
            }
            stk.add(A.charAt(i));
          }
        }
      }
      while(!stk.isEmpty()) {
        sb.append(stk.pop());
      }
      return sb.toString();
    }
    public boolean isOperator(char val) {
      if(val == '^' || val == '/' || val =='*' || val == '+' || val =='-' || val == '(' || val == ')') {
        return true;
      }
      return false;
    }
    public HashMap<Character, Integer> generatePriorityMap() {
      HashMap<Character, Integer> result = new HashMap<>();
      result.put('(', 0);
      result.put('^',1);
      result.put('/',2);
      result.put('*',2);
      result.put('+',3);
      result.put('-',3);
      return result;
    }
  }

}
