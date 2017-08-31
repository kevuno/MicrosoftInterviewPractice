/*
    Author: Kevin Bastian
 */

class Node{
    int val;
    Node next;
    public Node(int value){
        this.val = value;
    }
}

class Solution{    
    static public void printNextNodes(Node n){
        if (n == null){
            System.out.print(" null\n");
            return;
        }
        System.out.print(" " + n.val + " =>");
        printNextNodes(n.next);
    }

    static Node insertIntoOrderedList(Node head, int val){
        if (head == null || val <= head.val){
            Node new_node = new Node(val);
            new_node.next = head;
            return new_node;
        }
        Node originalHead = head;
        while (head != null){
            if (head.next == null || (head.val < val && val <= head.next.val)){
                Node temp = head.next;
                head.next = new Node(val);
                head.next.next = temp;
                break;
            }
            head = head.next;
        }
        return originalHead;
    }

    static public void main(String[] args){
        // Args should be in the form of " 1 2 3 6 7 4" where 1 2 3 6 7 are the elmements of the list and 4 is the element to add to the list

        // Get Head of the list
        Node head = new Node(Integer.parseInt(args[0]));

        // Get last element which is what will be added to the list
        int element_to_add = Integer.parseInt(args[args.length-1]);
        int count = 0;
        Node trueHead = null;
        for(String s : args){
            // Do not add last elemetn
            if (count == args.length -1){
                break;
            }
            if (count == 0){
                trueHead = head;
            }else{
                head. next = new Node(Integer.parseInt(s));;
                head = head.next;
            }
            count ++;
        }

        printNextNodes(trueHead);
        Node result = insertIntoOrderedList(trueHead,element_to_add);
        printNextNodes(result);

    }
}