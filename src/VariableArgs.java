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

/**
 * Created 23/03/21 3:20 PM
 *
 * @author Kridai
 */
public class VariableArgs {

  public static void main(String[] args) {
    Calculate_Salary();
    Calculate_Salary(12);
    Calculate_Salary(12, 10);
    Calculate_Salary(12, 10, 8);
  }
  public static void Calculate_Salary(int... args) {
    int ratio = 0; // default value;
    int vocationDays = 0; // default value;
    int travelDays = 0;
    if(args.length == 1) {
      ratio = args[0];
    }
    if(args.length == 2) {
      vocationDays = args[1];
    }
    if(args.length == 3) {
      travelDays = args[2];
    }
    System.out.println("ratio: "+ratio + "/t vocationDays: "+ vocationDays+ "/t travelDays: "+travelDays);

  }

}
