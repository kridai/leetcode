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
 * Created 06/02/21 3:38 PM
 *
 * @author Kridai
 */
public class HashSetExample {

  public static void main(String[] args) {
    Set<KeyValue> set = new HashSet<>();
    KeyValue k1 = new HashSetExample().new KeyValue(1);
    KeyValue k2 = new HashSetExample().new KeyValue(2);
    set.add(k1);
    set.add(k1);
    set.add(k2);
    set.add(k2);
    System.out.println(set.size());
    k2.i = 1;
    System.out.println(set.size());
    set.remove(k1);
    System.out.println(set.size());
    set.remove(k2);
    System.out.println(set.size());
    set.remove(k1);
    set.remove(k2);
    System.out.println(set.size());
  }

  class KeyValue {
    public int i;
    public KeyValue(int i) {
      this.i = i;
    }
    public  boolean equals(Object o) {
      return i == ((KeyValue) o).i;
    }
    public int hashCode() {
      return i;
    }
  }
}
