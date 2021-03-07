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
import java.util.List;

/**
 * Created 24/01/21 7:29 PM
 *
 * @author Kridai
 */
public class MobilePhones {

  public static void main(String[] args) {
    Solution solution = new MobilePhones().new Solution();
    ArrayList<Integer> A = new ArrayList<>();
    A.add(3);
    A.add(4);
    A.add(4);
    A.add(6);
    ArrayList<Integer> B = new ArrayList<>();
    B.add(20);
    B.add(4);
    B.add(10);
    B.add(2);




    System.out.println(solution.solve(A,B));
  }
  public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
      List<Long> sum = new ArrayList<>();
      sum.add((long) A.get(0));
      for( int i = 1; i< A.size(); i++) {
        sum.add( sum.get(i-1)+ A.get(i));
      }
      ArrayList<Integer> result = new ArrayList<>();
      for(int i : B) {
        int val = Collections.binarySearch(sum, (long) i);
        if(val < 0) {
          val =(val * -1) -1;
        }
        result.add(val);
      }
      return result;
    }
  }

}
