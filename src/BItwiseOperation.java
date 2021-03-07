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
 * Created 03/01/21 4:41 PM
 *
 * @author Kridai
 */
public class BItwiseOperation {

  public static void main(String[] args) {
    int A[] = new int[] {1, 2, 2, 3, 4, 3, 3, 1, 2, 1};
    //findSingleElement(A);
    //findQuotient(11, 3);
    strangeEquality(5);
    //System.out.println(2&1);

  }
  public static void strangeEquality(int A) {
    int num = 0;
    int i = 0;
    while (A > 0) {
      System.out.println("value of a: "+A);
      System.out.println((A&1)^1);
      System.out.println("num before addition: " +num);
      num = ((A&1^1) << i) + num;

      System.out.println("num after addition: " +num);
      A = A >> 1;
      i ++;
    }
    num = num | (1 << i);
  System.out.println( num);
  }

  public static void findQuotient(int A, int B) {
    short sign = 1;
    if((A<=0 && B >= 0) || (A>=0 &&B<=0)) {
      sign = -1;
    }
    if(A == Integer.MIN_VALUE && sign >0) {
      A = Integer.MAX_VALUE;
    }
    if(B == Integer.MIN_VALUE && sign  > 0) {
      B = Integer.MAX_VALUE;
    }
    A = Math.abs(A);
    B= Math.abs(B);
    if( B == 1 ) {
      System.out.println(sign * A );
    }

    int counter = 0;
    long Blong = B;
    int val = 0;
    for (int i = 30; i >= 0; i--) {
      if((Blong * (1<<i) + val) < A) {
        val += B* (1<<i);
        counter = counter + (1<<i);
      }
    }
    System.out.println( sign * (counter > Integer.MAX_VALUE ? Integer.MAX_VALUE : counter));
  }
  public static void findSingleElement(int A[]) {
    int result = 0;
    for( int i=0; i<32;i++ ){
      int count = 0;
      for (int j = 0;j < A.length; j++) {
        count = (count + ((A[j]>>i)&1));
      }
      if(count % 3 != 0) {
        count = 1;
      }
      else {
        count = 0;
      }
      result = count*(1<<i) + result;
    }
    System.out.println(result);
  }
}
