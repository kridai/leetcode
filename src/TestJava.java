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

import com.sun.tools.javac.util.Pair;

/**
 * Created 20/03/21 11:06 PM
 *
 * @author Kridai
 */
public class TestJava {

  public static void main(String[] args) {
    HashMap<Pair<Integer, Long>, Integer> dp = new HashMap<>();
    dp.put(new Pair(12, 6), 10);
    dp.put(new Pair(9, 6), 14);
    dp.put(new Pair(9, 10), 14);
    System.out.println(dp.get(new Pair<>(9, 10)));
  }
}
