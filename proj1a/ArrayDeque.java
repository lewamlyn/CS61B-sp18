public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int cap) {
        T[] a = (T []) new Object[cap];
        int index = add(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[index];
            index = add(index);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private int add(int next) {
        return (next + 1) % items.length;
    }

    private int sub(int next) {
        return (next - 1 + items.length) % items.length;
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = sub(nextFirst);
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = add(nextLast);
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        int i;
        for (i = 0; i < items.length; i++) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
        }
    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            nextFirst = add(nextFirst);
            T removeItem = items[nextFirst];
            items[nextFirst] = null;

            if (items.length > 16 && items.length >= (4 * size)) {
                resize(items.length / 2);
            }
            return  removeItem;
        }
    }

    /* Removes and returns the item at the back of the deque.
       If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            nextLast = sub(nextLast);
            T removeItem = items[nextLast];
            items[nextLast] = null;

            if (items.length > 16 && items.length >= (4 * size)) {
                resize(items.length / 2);
            }
            return  removeItem;
        }
    }

    /* Gets the item at the given index, where 0 is the front,
       1 is the next item, and so forth.
       If no such item exists, returns null.
       Must not alter the deque! */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(add(nextFirst) + index) % items.length];
    }
}

