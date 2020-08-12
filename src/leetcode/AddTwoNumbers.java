package leetcode;

class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(final int val) {
            this.val = val;
        }

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(final String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode ansHead = (new AddTwoNumbers().addTwoNumbers(l1, l2));
        while (ansHead != null) {
            System.out.print(ansHead.val);
            ansHead = ansHead.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ansHead = new ListNode();
        ListNode currentPlace = ansHead;
        int sum = 0, carry = 0, unit = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            unit = sum % 10;
            currentPlace.next = new ListNode(unit);
            currentPlace = currentPlace.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                sum = l1.val + carry;
                carry = sum / 10;
                unit = sum % 10;
                currentPlace.next = new ListNode(unit);
                currentPlace = currentPlace.next;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                sum = l2.val + carry;
                carry = sum / 10;
                unit = sum % 10;
                currentPlace.next = new ListNode(unit);
                currentPlace = currentPlace.next;
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            currentPlace.next = new ListNode(carry);
        }

        return ansHead.next;
    }
}