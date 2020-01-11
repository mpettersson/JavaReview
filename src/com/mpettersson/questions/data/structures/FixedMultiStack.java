package com.mpettersson.questions.data.structures;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) throws Exception{
        if (isFull(stackNum)){
            throw new Exception();
        }

        // increment stack pointer and then update top value
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    // pop
    public int pop(int stackNum) throws Exception{
        if(isEmpty(stackNum)){
            throw new Exception();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];   // Get top
        values[topIndex] = 0;           // Clear
        sizes[stackNum]--;
        return value;
    }

    // Peek
    public int peek(int stackNum) throws Exception{
        if(isEmpty(stackNum)){
            throw new Exception();
        }
        return values[indexOfTop(stackNum)];
    }

    // isEmpty
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    // isFull
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    // indexOfTop
    public int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }
}
