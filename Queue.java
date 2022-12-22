public class Queue<T> {
    private final LinkedList<T> data;

    public Queue() {
        this.data = new LinkedList<>();
    }

    public void enqueue(T item) {
        this.data.addFirst(item);
    }

    public T dequeue() {
        return this.data.pollLast();
    }

    public int size() {
        return this.data.size();
    }
}
