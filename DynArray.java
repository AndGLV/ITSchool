public class DynArray<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double FILL_FACTOR = 0.5;
    private static final int INCREASE_COEFFICIENT = 2;
    private static final double DECREASE_COEFFICIENT = 1.5;
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        this.clazz = clz;
        this.count = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) Array.newInstance(this.clazz, this.capacity);
    }

    public void makeArray(int new_capacity) {
        if (new_capacity > this.capacity) {
            increaseCapacity();
            return;
        }
        if (checkFillFactor(new_capacity)) {
            decreaseCapacity();
        }
    }

    private void increaseCapacity() {
        this.capacity *= INCREASE_COEFFICIENT;
        this.array = Arrays.copyOf(this.array, this.capacity);
    }

    private void decreaseCapacity() {
        int newEvalCapacity = (int) (this.capacity / DECREASE_COEFFICIENT);
        this.capacity = Math.max(newEvalCapacity, DEFAULT_CAPACITY);
        this.array = Arrays.copyOf(this.array, this.capacity);
    }

    private boolean checkFillFactor(int newCapacity) {
        int fillFactorCapacity = (int) (this.capacity * FILL_FACTOR);
        return newCapacity < fillFactorCapacity;
    }

    public T getItem(int index) {
        checkGetIndex(index);
        return this.array[index];
    }

    public void append(T itm) {
        makeArray(this.count + 1);
        this.array[this.count++] = itm;
    }

    public void insert(T itm, int index) {
        checkInsertIndex(index);
        makeArray(this.count + 1);
        T[] temp = Arrays.copyOfRange(this.array, index, this.count);
        this.array[index] = itm;
        System.arraycopy(temp, 0, this.array, (index + 1), temp.length);
        this.count++;
    }

    public void remove(int index) {
        checkRemoveIndex(index);
        System.arraycopy(this.array, index + 1, this.array, index, (--this.count - index));
        this.array[this.count] = null;
        makeArray(this.count);
    }

    private void checkRemoveIndex(int index) {
        if (index < 0 || index >= this.count) throw new IndexOutOfBoundsException();
    }

    private void checkInsertIndex(int index) {
        if (index < 0 || index > this.count) throw new IndexOutOfBoundsException();
    }

    private void checkGetIndex(int index) {
        if (index < 0 || index >= this.count) throw new IndexOutOfBoundsException();
    }
}
