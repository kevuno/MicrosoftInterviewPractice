/**
 * Solution
 */

class Solution{
    public static Node n;
    static Node getPartition(int divider, Node head){
        Node smaller_head = null; Node smaller_end = null;
        Node bigger_head = null; Node bigger_end = null;
        
        while(head != null){
            System.out.println("Value of n: " + n.value);
            System.out.println("Value of n.next: " + n.next.value);
            //System.out.println(head.value);
            int value = head.value;
            Node next = head.next;
            //head.next = null;
            if(value < divider){
                if(smaller_head == null){
                    smaller_head = head;
                }else{
                    smaller_end.next = head;
                }
                smaller_end = head;
            }else{
                if(bigger_head == null){
                    bigger_head = head;
                }else{
                    bigger_end.next = head;
                }
                bigger_end = head;
            }
            head = next;
        }
        if(smaller_head != null){
            smaller_end.next = bigger_head;
            return smaller_head;
        }
        return bigger_head;
    }

    static Node getPartitionEficient(int divider, Node head){
        Node prev = head; Node tail = head;
        head = head.next;
        while(head != null){
            int value = head.value;
            Node next = head.next;
            head.next = null;
            if(value < divider){
                head.next = prev;
                prev = head;
            }else{
                tail.next = head;
                tail = head;
            }
            head = next;
        }
        return prev;
    }

    public static final class Node{
        protected int value;
        protected Node next;
        protected Node(int value){
            this.value = value;
        }
    }

    public static Node stuff(Node head){
        head = head.next;
        head = head.next;
        head = head.next;
        return head;
    }

    public static void main(String[] args){
        n = new Node(7);
        n.next = new Node(3);
        n.next.next = new Node(2);
        n.next.next.next = new Node(6);
        n.next.next.next.next = new Node(9);
        Node sorted_head = getPartition(6,n);
        // System.out.println("What is wrong with n");
        // while(n != null){
        //     System.out.println(n.value);
        //     n = n.next;
        // }
        System.out.println("A simple method");
        while(sorted_head != null){
            System.out.println(sorted_head.value);
            sorted_head = sorted_head.next;
        }
        // Using a different solution:" Somehow n changes after calling the first method, so we have to assign n
        n = new Node(7);
        n.next = new Node(3);
        n.next.next = new Node(2);
        n.next.next.next = new Node(6);
        n.next.next.next.next = new Node(9);
        System.out.println("A more efficient method");
        Node sorted_head_eficient = getPartitionEficient(6,n);
        while(sorted_head_eficient != null){            
            System.out.println(sorted_head_eficient.value);
            sorted_head_eficient = sorted_head_eficient.next;
        }
        // System.out.println("////////////////Testing////////////");
        // n = new Node(7);
        // n.next = new Node(3);
        // n.next.next = new Node(2);
        // n.next.next.next = new Node(6);
        // n.next.next.next.next = new Node(9);
        // Node result = stuff(n);
        // System.out.println(result.value);
        // System.out.println(n.value);
        // System.out.println(n.next.value);
        // System.out.println(n.next.next.value);
    }
}
