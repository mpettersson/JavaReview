package com.mpettersson.review.data.structures;

import java.util.EmptyStackException;

public class Stack<T> {

    private static class StackNode<T>{
        private T value;
        private StackNode<T> next = null;

        public StackNode(T value){
            this.value = value;
        }
    }

    private StackNode<T> top = null;

    // printStack
    public void printStack(){
        StackNode<T> sn = top;
        System.out.println(" - ");
        while(sn != null){
            System.out.println(" " + sn.value);
            sn = sn.next;
        }
        System.out.println(" - ");
    }

    // push
    public void push(T value){
        StackNode<T> sn = new StackNode<>(value);
        sn.next = top;
        top = sn;

    }

    // pop
    public T pop(){
        if(top == null) throw new EmptyStackException();
        T value = top.value;
        top = top.next;
        return value;
    }

    // peek
    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.value;
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }
}

class StacksDriver{
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println("myStack:");
        myStack.printStack();

        System.out.println("myStack.peek(): " + myStack.peek());

        System.out.println("myStack.isEmpty(): " + myStack.isEmpty());

        System.out.println("myStack.pop(): " + myStack.pop());

        System.out.println("myStack:");
        myStack.printStack();

    }
}
