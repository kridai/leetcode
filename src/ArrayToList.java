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

/**
 * Created 18/03/21 10:51 PM
 *
 * @author Kridai
 */
public class ArrayToList<T> extends ArrayList<T> {
  public ArrayToList(T... args) {
    for(T t : args) {
      this.add(t);
    }
  }
}
