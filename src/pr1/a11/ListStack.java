package pr1.a11;

import java.util.ArrayList;

public class ListStack extends AbstractStack {

    protected ArrayList<Object> al;

    public ListStack(int capacity) {
        this.al = new ArrayList<Object>(capacity);
    }

    public Object pop() {
        if (!(size == 0)) {
            return al.remove(--size);
        } else {
            throw(new IllegalArgumentException("Stack is empty!"));
        }
    }

    public Object peek() {
        return al.get((size - 1));
    }

    public void push(Object o) {
        if (!(size >= capacity)) {
            al.add(o);
            size ++;
        } else {
            throw(new IllegalArgumentException("Stack is full!"));
        }
    }
}
