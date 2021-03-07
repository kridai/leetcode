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
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;;

/**
 * Created 02/03/21 2:04 PM
 *
 * @author Kridai
 */
public class FreeCars {

  public static void main(String[] args) {
    Solution solution = new FreeCars().new Solution();
    ArrayList<Integer> A = new ArrayList<>();
    A.add(1);A.add(7);A.add(6);A.add(2);A.add(8);A.add(4);A.add(4);A.add(6);A.add(8);A.add(2);
    ArrayList<Integer> B = new ArrayList<>();
    B.add(8);B.add(11);B.add(7);B.add(7);B.add(10);B.add(8);B.add(7);B.add(5);B.add(4);B.add(9);
    System.out.println(solution.solve(A,B));
  }


  public class Solution {
    int mod = 1000000007;
    class Pair<K,V> {
      public K first;
      public V second;

      Pair(K first, V second) {
        this.first = first;
        this.second = second;
      }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
      ArrayList<Pair<Integer,Integer>> pairList = new ArrayList<>();
      for( int i = 0; i < A.size(); i++) {
        Pair<Integer, Integer> val = new Pair<>(A.get(i), B.get(i));
        pairList.add(val);
      }
      pairList.sort((v1, v2) -> v1.first - v2.first );
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
      int count = 0;
      for( Pair<Integer, Integer> pair : pairList) {
        if(pair.first > count) {
          priorityQueue.add(pair.second);
          count++;
        }
        else {
          if(priorityQueue.peek() < pair.second) {
            priorityQueue.remove();
            priorityQueue.add(pair.second);
          }
        }
      }
      Iterator<Integer> itr = priorityQueue.iterator();
      int sum = 0;
      while(itr.hasNext()) {
        sum = (sum % mod + itr.next() % mod) % mod;
      }
      return sum;
    }
  }

}
