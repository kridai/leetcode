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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created 21/03/21 12:25 AM
 *
 * @author Kridai
 */
public class TestClass {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int T = Integer.parseInt(br.readLine().trim());
    for(int t_i = 0; t_i < T; t_i++)
    {

      int n = Integer.parseInt(br.readLine().trim());
      int[][] s = new int[n][2];
      for(int i_s = 0; i_s < n; i_s++)
      {
        String[] arr_s = br.readLine().split(" ");
        for(int j_s = 0; j_s < arr_s.length; j_s++)
        {
          s[i_s][j_s] = Integer.parseInt(arr_s[j_s]);
        }
      }

      long out_ = solve(n, s);
      System.out.println(out_);

    }

    wr.close();
    br.close();
  }
  static long solve(int n, int[][] s){
    long sum = 0;
    int arr[] = new int[2 * n];
    for(int i = 0; i < n; i++) {
      arr[i] = s[i][0];
      arr[2*n-1-i] = s[i][1];
      sum = sum + s[i][0];
      sum = sum + s[i][1];

    }
    int start = 0;
    int end = 0;
    long temp = 0;
    long min = sum;
    while(start < 2 * n && end < 2 * n) {
      temp += arr[end];
      min = Math.min(min, Math.abs((sum - temp) - temp));
      if( temp > sum -temp ) {
        temp = temp - arr[start];
        start++;
        continue;
      }
      end++;
    }
    return min;
  }
}