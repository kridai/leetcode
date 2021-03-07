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

import java.util.HashSet;
import java.util.Set;

/**
 * Created 05/02/21 5:31 PM
 *
 * @author Kridai
 */
public class FooBarRecursion {

  public static void main(String[] args) {
    Solution s = new FooBarRecursion().new Solution();
    System.out.println(s.foo(3, 2));
    Set<Integer> set =  new HashSet<>();
    set.remove(2);
  }

  class Solution {
    int bar(int x, int y)
    {
      if (y == 0)   return 0;
      return (x + bar(x, y-1));
    }

    int foo(int x, int y)
    {
      if (y == 0) return 1;
      return bar(x, foo(x, y-1));
    }
  }
}
