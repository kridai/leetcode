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

import java.util.TreeSet;

/**
 * Created 06/02/21 3:47 PM
 *
 * @author Kridai
 */
public class RecursionByOne {

  public static void main(String[] args) {
    decreaseByOne(2);
    TreeSet<String> val = new TreeSet<>();
    val.add("1");
  }
  public  static void decreaseByOne(int num) {
    if(num >=0) {
      decreaseByOne(num - 1);
    }
    System.out.println(num);
  }

}
