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

import java.util.Stack;

/**
 * Created 04/02/21 1:16 AM
 *
 * @author Kridai
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 */
public class RPCEvaluation {

  public static void main(String[] args) {
    Solution s = new RPCEvaluation().new Solution();
    System.out.println(s.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
  }

  class Solution {
    public int evalRPN(String[] tokens) {
      Stack<String> stk =  new Stack<>();
      for(String i : tokens) {
        if(isOperator(i)) {
          int b = Integer.parseInt(stk.pop());
          int a = Integer.parseInt(stk.pop());
          int val = performOperation(a, b, i) ;
          stk.push(String.valueOf(val));
        }
        else {
          stk.push(i);
        }
      }
      return Integer.parseInt(stk.peek());
    }
    public boolean isOperator(String val) {
      if(val == "*" || val == "/" || val == "+" || val == "-") {
        return true;
      }
      return false;
    }
    public int performOperation(int a, int b, String operator) {
      switch ((int) operator.charAt(0)) {
      case 43:
        return a + b;
      case 45:
        return a - b;
      case 42:
        return a * b;
      case 47:
        return a / b;
      default:
        return -1;
      }
    }
  }

}
