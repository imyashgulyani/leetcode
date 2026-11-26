/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int i;
        if(lists==null || lists.length==0)
        {
            return null;
        }
        int k=1;
        while(k<lists.length)
        {
            for(i=0;i+k<lists.length;i=i+k*2)
            {
                lists[i]=merge_list(lists[i],lists[i+k]);
            }
            k=k*2;
        }
        return lists[0];
    }
    ListNode merge_list(ListNode list1,ListNode list2)
    {
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                temp.next=list1;
                list1=list1.next;
            }
            else
            {
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null)
        {
            temp.next=list1;
        }
        else
        {
            temp.next=list2;
        }
        return dummy.next;
    }
}