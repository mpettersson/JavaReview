package com.mpettersson.questions.data.structures;

import com.mpettersson.review.data.structures.Stack;

public class SortUsingTwoStacks {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.printStack();

        stack = sortUsingTwoStack(stack);

        stack.printStack();


    }

    public static Stack<Integer> sortUsingTwoStack(Stack<Integer> stack){
        Stack<Integer> temp_stack = new Stack<>();
        while(! stack.isEmpty()){
            int v = stack.pop();
            while(! temp_stack.isEmpty() && temp_stack.peek() > v){
                stack.push(temp_stack.pop());
            }
            temp_stack.push(v);
        }
        while(! temp_stack.isEmpty()){
            stack.push(temp_stack.pop());
        }
        return stack;
    }

}
