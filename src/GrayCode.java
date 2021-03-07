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
import java.util.HashSet;

/**
 * Created 13/01/21 10:04 PM
 *
 * @author Kridai
 */
public class GrayCode {

  public static void main(String[] args) {
    GrayCode gcode = new GrayCode();
    GrayCodeSolution s = gcode.new GrayCodeSolution();

    System.out.println(s.grayCode(2).toString());
  }



   class GrayCodeSolution {
    public ArrayList<Integer> grayCode(int a) {
      HashSet<Integer> uniqueVal = new HashSet<>();
      return generateGrayCode(a, 0, new ArrayList<Integer>(), 0 , uniqueVal);
    }

    public ArrayList<Integer> generateGrayCode(int a, int index, ArrayList<Integer> result, int val, HashSet<Integer>  uniqueVal) {
      if(index == a) {
          result.add(val);
        return result;
      }
      generateGrayCode( a, index+1, result, val, uniqueVal);
      generateGrayCode( a, index+1, result, val ^ (1<<index), uniqueVal);
      return result;
    }
  }

}


