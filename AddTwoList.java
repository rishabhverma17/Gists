class AddTwoList {
    ListNode head1, head2;

    public static void main(String[] args) {
        AddTwoList list = new AddTwoList();

        // creating first list
        list.head1 = new ListNode(7);
        list.head1.next = new ListNode(5);
        list.head1.next.next = new ListNode(9);
        list.head1.next.next.next = new ListNode(4);
        list.head1.next.next.next.next = new ListNode(6);
        System.out.print("First List is ");
        list.printList(list.head1);

        // creating seconnd list
        list.head2 = new ListNode(8);
        list.head2.next = new ListNode(4);
        System.out.print("Second List is ");
        list.printList(list.head2);

        ListNode rs = list.addTwoNumbers(list.head1, list.head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode prev = null;
        ListNode temp = null;
        int carry = 0, sum;
        while (l1 != null || l2 != null) // while both lists exist
        {
            // Calculate sum for next node
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            // Update Carry for next calculation
            carry = (sum >= 10) ? 1 : 0;

            // Update sum if carry is 1.
            // sum = sum % 10;
            if (carry > 0) {
                sum = sum % 10;
            }

            temp = new ListNode(sum);

            if (result == null) {
                result = temp;
            } else {
                prev.next = temp;
            }

            // Update Prev
            prev = temp;

            // Go to next node of l1 and l2
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}