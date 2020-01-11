package com.mpettersson.review.data.structures;

import java.util.NoSuchElementException;

public class Queue<T> {

    private class QueueNode<T>{
        T value = null;
        QueueNode<T> next = null;

        public QueueNode(T value){
            this.value = value;
        }
    }

    QueueNode<T> first = null;
    QueueNode<T> last = null;

    // printQueue
    public void printQueue(){
        QueueNode<T> qn = first;
        System.out.print("[");
        while(qn != null){
            System.out.print(" " + qn.value);
            qn = qn.next;
        }
        System.out.println(" ]");
    }

    // add
    public void add(T value){
        QueueNode<T> qn = new QueueNode<>(value);
        if(first == null){
            first = qn;
            last = qn;
        }else{
            last.next = qn;
            last = qn;
        }
    }

    // remove
    public T remove(){
        if(first == null) throw new NoSuchElementException();
        T value = first.value;
        first = first.next;
        if(first == null) last = null;
        return value;
    }

    // Peek
    public T peek(){
        if(first == null) throw new NoSuchElementException();
        return first.value;
    }

    // isEmpty
    public boolean isEmpty(){
        return first == null;
    }
}


class QueueDriver {

    public static void main(String[] args) {

        Queue<Integer> myQueue = new Queue<>();

        System.out.println("myQueue.isEmpty(): " + myQueue.isEmpty());

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);

        System.out.println("myQueue:");
        myQueue.printQueue();

        System.out.println("myQueue.peek(): " + myQueue.peek());

        System.out.println("myQueue.isEmpty(): " + myQueue.isEmpty());

        System.out.println("myQueue.remove(): " + myQueue.remove());

        System.out.println("myQueue:");
        myQueue.printQueue();

    }
}
