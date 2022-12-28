public class Deque<T> {
    private final LinkedList<T> data;

    public Deque() {
        this.data = new LinkedList<>();
    }

    public void addFront(T item) {
        this.data.addFirst(item);
    }

    public void addTail(T item) {
        this.data.addLast(item);
    }

    public T removeFront() {
        return this.data.pollFirst();
    }

    public T removeTail() {
        return this.data.pollLast();
    }

    public int size() {
        return this.data.size();
    }
}
