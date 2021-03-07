/*
 * Copyright 2006-2020 (c) Care.com, Inc.
 * 77 Fourth Avenue, 5th Floor Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */

import java.util.ArrayList;

/**
 * Created 24/12/20 4:36 PM
 *
 * @author Kridai
 */
public class LittlePony {

  public static void main(String[] args) {
    Solutions sol = new Solutions();

    int [] A = { 6, 2 };
    int val = sol.solve(A);

    System.out.println(val);
  }
}
