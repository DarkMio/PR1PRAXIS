package pr1.a11;

public abstract class AbstractStack {

    protected int size;
    protected int capacity;

    public AbstractStack (int capacity) {
        size = 0;
        this.capacity = capacity;
    }

    public AbstractStack () {
        this(1024);
    }

    public abstract Object pop();

    public abstract Object peek();

    public abstract void push(Object c);

    public int getSize() {
        return size;
    }
}
