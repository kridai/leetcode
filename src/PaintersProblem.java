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
 * Created 11/01/21 7:27 PM
 *
 * @author Kridai
 *
 * Problem Description
 *
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of board.
 *
 * Calculate and return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. Which means a configuration where painter 1 paints board 1 and 3 but not 2 is invalid.
 *
 * Return the ans % 10000003.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 1000
 * 1 <= B <= 106
 * 1 <= N <= 105
 * 1 <= C[i] <= 106
 *
 *
 *
 * Input Format
 * The first argument given is the integer A.
 * The second argument given is the integer B.
 * The third argument given is the integer array C.
 *
 *
 *
 * Output Format
 * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 *  B = 5
 *  C = [1, 10]
 * Input 2:
 *
 *  A = 10
 *  B = 1
 *  C = [1, 8, 11, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 *  50
 * Output 2:
 *
 *  11
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Possibility 1:- One painter paints both blocks, time taken = 55 units.
 *  Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 *  There are no other distinct ways to paint boards.
 *  ans = 50%10000003
 * Explanation 2:
 *
 *  Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 *  and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 *  ans = 11%10000003
 */
public class PaintersProblem {

  public static void main(String[] args) {
    PainterSolution ps = new PainterSolution();
    int C[] = new int[]{762, 798, 592, 899, 329};
    System.out.println(ps.paint(6, 10, C));
  }


}

 class PainterSolution {
  public int paint(int A, int B, int[] C) {
    long sumArray[] = new long [C.length];
    sumArray[0] = C[0];
    for(int i =1; i< C.length;i++) {
      sumArray[i] =  sumArray[i-1] + C[i];
    }
    long val = binarySearchAnswerSpace(0, sumArray[sumArray.length -1], sumArray, A);
    return (int) ((val * B) % 10000003);
  }
  public long binarySearchAnswerSpace(long start, long end, long sumArray[], int A) {
    if(start >= end-1) {
     // if(isValuePossible(start))
      return end;
    }
    long mid = start + (end-start)/2;
    if( isValuePossible(mid,sumArray, A, 0, mid)) {
      return binarySearchAnswerSpace(start, mid, sumArray, A);
    }
    else {
      return binarySearchAnswerSpace(mid, end, sumArray, A);
    }
  }

  public boolean isValuePossible(long incVal, long sumArray[], int A, int start, long val) {
    if(A == 0 ){
      return false;
    }
    int index = binarySearch(start, sumArray.length -1, sumArray, val);
    if( (index<start)) {
      return false;
    }
      if((index == sumArray.length-1) ) {
        return true;
    }

    long indexValue = sumArray[index];

    return isValuePossible(incVal , sumArray, A-1, index +1, indexValue+incVal);
  }

  public int binarySearch(int start, int end, long sumArray[], long val) {
    if(start >= end-1) {
      if(sumArray[end] <= val) {
        return end;
      }
      if(sumArray[start] > val){
        return --start;
      }
      else {
        return start;
      }
    }
    int mid = start + (end - start)/2;
    if(sumArray[mid] == val) {
      return mid;
    }
    if(sumArray[mid] < val) {
      return binarySearch(mid, end, sumArray, val);
    }
    else {
      return binarySearch(start, mid, sumArray, val);
    }
  }

}
