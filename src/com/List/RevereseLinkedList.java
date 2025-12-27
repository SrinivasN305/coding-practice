package com.List;

import java.util.ArrayList;
import java.util.List;

public class RevereseLinkedList
{


    public static ListNode reverseList(ListNode head) {


        List<ListNode> values = new ArrayList<>();
        ListNode current = head;
        ListNode previous = null;
        int j =0;
        while (current !=null){

            previous = new ListNode(current.val, previous);
            current = current.next;
            j++;
        }
        return previous;
    }

    static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
