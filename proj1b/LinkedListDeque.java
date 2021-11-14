public class LinkedListDeque<T> implements Deque<T> {

    /* Define of Node of Deque. */
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node(T i, Node b, Node n) {
            item = i;
            prev = b;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /* Create an empty Deque */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /* Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    /* Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        size += 1;
        sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
    }

    /* Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        Node p = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;

            T removeItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return removeItem;
        }
    }

    /* Removes and returns the item at the back of the deque.
       If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            size -= 1;

            T removeItem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return removeItem;
        }
    }

    /* Gets the item at the given index,but uses recursion. */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node p = sentinel.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            Node p = sentinel.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }
}
