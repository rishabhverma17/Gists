public ListNode rotateRight(ListNode head, int k) {
        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        int listCount = 0;
        if (k == 0) return head;
        if (head == null) return null;
        if (head.next == null) return head;

        while(temp != null){
            temp = temp.next;
            listCount++;
        }
        if(k >= listCount){
            k = k%listCount;
        }
        
	    if (k == 0){return start;}
        
        while(k != 0 && fast.next != null){
            fast = fast.next;
            k--;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        start = slow.next;
        fast.next = head;
        slow.next = null;
        head = start;
        return head;
    }