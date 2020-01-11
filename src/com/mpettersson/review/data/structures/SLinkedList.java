package com.mpettersson.review.data.structures;

import java.util.HashSet;
import java.util.Stack;

public class SLinkedList<E> {

    private Node<E> head = null;

    void reverse(){
        Node<E> curr = head;
        Node<E> prev_node = null;
        Node<E> next_node = null;
        while(curr != null){
            next_node = curr.next;
            curr.next = prev_node;
            prev_node = curr;
            curr = next_node;
        }
        head = prev_node;
    }

    void removeAll(E element){

        while(head != null && head.item == element){
            head = head.next;
        }
        Node<E> n = head;
        while(n != null && n.next != null){
            if(n.next.item == element){
                if(n.next.next != null){
                    n.next = n.next.next;
                }else{
                    n.next = null;
                }
            }
        }

    }

    // This will make a loop in a linked list; the last item's .next will point to the Kth element.
    boolean makeLoopToKthEntry(int k){
        Node<E> n = head;
        Node<E> tail = head;
        if(n == null || k <= 0 || k > this.length()){
            return false;       // K is too big or too small.
        }
        for(int i = 1; i < k; i++){
            n = n.next;
        }
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = n;
        return true;
    }

    void fixLoop(){
        Node<E> fast = head;
        Node<E> slow = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        while(fast != null){
            if(fast.next == slow){
                fast.next = null;
            }
            fast = fast.next;
        }

    }


    // This is Floyd’s Cycle detection algorithm
    boolean isLoop(){
        Node<E> fast = head;
        Node<E> slow = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return false;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    void remove(E element){
        Node<E> n = head;
        // If element is in the head you need to update it.
        if(n.item == element){
            head = head.next;
            return;
        }
        // If head is safe you can go on as normal.
        while(n.next != null){
            if(n.next.item == element){
                n.next = n.next.next;
                return; // Head didn't change.
            }
            n = n.next;
        }
        return;
    }

    E getKthToLastElement(int k){
        Node<E> n = head;
        int len = this.length();
        if(k >= 0 && k < len){
            int diff = len - k;
            while(diff > 1){
                n = n.next;
                diff--;
            }
            return n.item;
        }
        return null;
    }


    void deleteDups() {
        Node<E> n = head;
        HashSet<E> hash = new HashSet<>();
        Node<E> previous = null;
        while(n != null){
            if(hash.contains(n.item)){
                previous.next = n.next;
            }else{
                hash.add(n.item);
                previous = n;
            }
            n = n.next;
        }
    }

    void add(Node<E> newNode){
        Node<E> n = head;
        if(n == null){
            n = newNode;
        }else{
            while(n.next != null){
                n = n.next;
            }
            n.next = newNode;
        }
    }


    public boolean isPalindrome(){
        Node<E> n = head;
        Stack<E> stack = new Stack<>();
        int len = this.length();
        if(len <= 1){
            return true;
        }
        for(int i = 0; i < (len / 2); i++){
            stack.add(n.item);
            n = n.next;
        }
        if(len % 2 == 1){
            n = n.next;
        }
        while(! stack.empty()){
            E val = stack.pop();
            if(val != n.item){
                return false;
            }
            n = n.next;
        }
        return true;
    }

    public boolean isIntersection(SLinkedList<E> sll1, SLinkedList<E> sll2){
        Node<E> l1 = sll1.head;
        Node<E> l2 = sll2.head;
        Node<E> end1 = l1;
        Node<E> end2 = l2;
        int l1Len = 1;
        int l2Len = 1;
        while(end1.next != null){
            end1 = end1.next;
            l1Len++;
        }
        while(end2.next != null){
            end2 = end2.next;
            l2Len++;

        }
        if(end1 != end2){
            return false;
        }
        while(l1.next != null && l2.next != null){
            if(l1Len > l2Len){
                l1 = l1.next;
                l1Len--;
            }else if(l1Len < l2Len){
                l2 = l2.next;
                l2Len--;
            }else{
                if(l1 == l2){
                    return true;
                }else{
                    l1 = l1.next;
                    l1Len--;
                    l2 = l2.next;
                    l2Len--;
                }
            }
        }
        return false;

    }


    public void add(E element){
        Node<E> n = head;
        Node<E> newNode = new Node<>(element);
        if(head == null){
            head = newNode;
        }else{
            while(n.next != null){
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public int length(){
        Node<E> n = head;
        int len = 0;
        while(n != null){
            len++;
            n = n.next;
        }
        return len;
    }

    public void printList(){
        int count = 0;
        Node<E> n = head;
        System.out.print("[");
        while(n != null){
            System.out.print(" " + n.item);
            n = n.next;
            count++;
            if(count > 20){
                break;
            }
        }
        System.out.println(" ]");
    }

    public E getTail(){
        Node<E> n = head;
        while(n.next != null){
            n = n.next;
        }
        return n.item;
    }

    Node<E> makeNode(E element){
        return new Node<E>(element);
    }

    class Node<E>{
        E item;
        Node next;


        Node(E element){
            this.item = element;
            Node<E> next = null;
        }
    }



}


class SLinkedListDriver {
    public static void main(String[] args) {

        SLinkedList<String> sllReverse = new SLinkedList<>();
        sllReverse.add("A");
        sllReverse.add("B");
        sllReverse.add("C");
        sllReverse.add("D");
        sllReverse.add("E");
        sllReverse.add("F");
        sllReverse.printList();
        sllReverse.reverse();
        sllReverse.printList();


        SLinkedList<String> sllRemoveAll = new SLinkedList<>();
        sllRemoveAll.add("A");
        sllRemoveAll.add("A");
        sllRemoveAll.add("A");
        sllRemoveAll.add("A");
        sllRemoveAll.add("A");
        sllRemoveAll.add("B");


        sllRemoveAll.removeAll("A");
        sllRemoveAll.printList();
        System.exit(0);

        SLinkedList<String> sllLoop = new SLinkedList<>();
        sllLoop.add("A");
        sllLoop.add("B");
        sllLoop.add("C");
        sllLoop.add("D");
        sllLoop.add("E");

        sllLoop.makeLoopToKthEntry(2);

        sllLoop.printList();



        System.out.println(sllLoop.isLoop());

        sllLoop.fixLoop();
        sllLoop.printList();



        System.out.println(sllLoop.isLoop());


        SLinkedList<String> sll = new SLinkedList<>();
        sll.add("A");
        sll.add("B");
        sll.add("A");
        sll.add("C");

        sll.printList();
        System.out.println(sll.isLoop());

        sll.remove("C");
        sll.printList();

        System.out.println(sll.isPalindrome());

        sll.deleteDups();
        sll.printList();
        System.out.println(sll.length());


        sll.add("X");
        sll.add("Y");
        sll.add("Z");
        System.out.println(sll.getKthToLastElement(1));
        sll.printList();

        sll.printList();


        System.exit(0);

        SLinkedList<Integer> sll1 = new SLinkedList<>();
        sll1.add(1);
        SLinkedList.Node node = sll1.makeNode(2);
        sll1.add(node);
        sll1.add(3);
        sll1.add(4);

        sll1.printList();
        System.out.println(sll1.length());

        SLinkedList<Integer> sll2 = new SLinkedList<>();
        sll2.add(0);
        sll2.add(1);
        sll2.add(node);

        sll2.printList();
        System.out.println(sll2.length());

        boolean resultNode = sll1.isIntersection(sll1, sll2);
        System.out.println(resultNode);

        System.exit(0);

    }
}

