package pr1.a11;

public class Stack extends pr1.a11.AbstractStack {

    protected Object[] ob;

    public Stack (int capacity) {
        ob = new Object[capacity];
    }

    public Object pop() {
        Object o = null;
        boolean underflow = size == 0;
        if (!underflow) {
            o = ob[--size];
        } else {
            throw(new IllegalArgumentException("Stack is empty!"));
        }
        return o;
    }

    public Object peek() {
        if (!(size == 0)) {
            return ob[size - 1];
        } else {
            throw(new IllegalArgumentException("Stack is empty!"));
        }
    }

    public void push(Object o) {
        if (!(size >= capacity)) {
            ob[size++] = o;
        } else {
            throw(new IllegalArgumentException("Stack is full!"));
        }
    }
}
