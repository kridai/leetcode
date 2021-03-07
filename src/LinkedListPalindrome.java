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
 * Created 14/02/21 7:25 PM
 *
 * @author Kridai
 */
public class LinkedListPalindrome {

  public static void main(String[] args) {
    ListNode A = new LinkedListPalindrome().new ListNode(8);
    A.next = new LinkedListPalindrome().new ListNode(7);
    Solution s = new LinkedListPalindrome().new Solution();
    System.out.println(s.lPalin(A));
  }


  class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
  }


   class Solution {
    public int lPalin(ListNode A) {
      ListNode L1 = A;
      ListNode L2 = findMidPointer(A);
      ListNode Aend = L2;
      if(L2.next == null) {
        if(L1.val ==L2.val) {
          return 1;
        }
        return 0;
      }
      L2 = L2.next;
      Aend.next =null;
      L2 = reverse(L2);
      while(L2 != null) {
        if(L1.val != L2.val) {
          return 0;
        }
        L1 = L1.next;
        L2 = L2.next;
      }
      return 1;

    }

    public ListNode findMidPointer(ListNode A) {
      ListNode slow = A;
      ListNode fast = A;
      while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }

    public ListNode reverse(ListNode A) {
      ListNode prev = A;
      if(A == null || A.next == null) {
        return A;
      }
      A = A.next;
      prev.next = null;
      while (A != null) {
        ListNode next = A.next;
        A.next = prev;
        prev = A;
        A = next;
      }
      return prev;
    }

  }

}
