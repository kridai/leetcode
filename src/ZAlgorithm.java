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
 * Created 07/03/21 3:40 PM
 *used to find repeating pattern in string
 *
 * @author Kridai
 */
public class ZAlgorithm {

  public static void main(String[] args) {
    String s = "abababab";
    char[] cArray = s.toCharArray();
    ArrayList<Integer> zarray = computeZ(cArray);
    System.out.println(zarray.toString());
  }

  private static ArrayList<Integer> computeZ(char[] cArray) {
    ArrayList<Integer> zarray = new ArrayList<>();
    zarray.add(0);
    int left = 0;
    int right = 0;
    for(int k= 1;  k < cArray.length; k++) {
      if ( k  >  right) {
        left = right = k;
        while((right < cArray.length) && (cArray[right] == cArray[right - left])) {
          right++;
        }
        zarray.add(right - left);
        right--;
      }
      else {
        if (zarray.get(k - left) <= (right - k)) {
          zarray.add(zarray.get(k - left));
        }
        else {
          left = k;
          while((right < cArray.length) && (cArray[right] == cArray[right - left])) {
            right++;
          }
          zarray.add(right - left);
          right--;
        }
      }
    }
    return zarray;
  }

}
