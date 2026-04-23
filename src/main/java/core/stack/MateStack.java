package core.stack;

import java.util.*;

public class MateStack<T> {
    private int size = 0;
    private Object[] stack = new Object[10];

    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        if (size == stack.length) {
            resize();
        }

        stack[size++] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return (T) stack[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        T value = (T) stack[--size];
        stack[size] = null;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void resize() {
        Object[] newStack = new Object[stack.length + 10];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }
}
