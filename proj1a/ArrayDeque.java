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
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private int renext(int next){
        if(next < 0){
            return next + items.length;
        }
        if(next >= items.length){
            return next - items.length;
        }
        return next;
    }

    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = nextFirst - 1;
        renext(nextFirst);
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = nextLast + 1;
        renext(nextLast);
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else
            return false;
    }

    /* Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        int i;
        for(i=0;i<size-1;i++){
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println(items[i]);
    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst(){
        nextFirst = nextFirst + 1;
        renext(nextFirst);
        T removeItem = items[nextFirst];
        items[nextFirst] = null;
        return  removeItem;
    }

    /* Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast(){
        nextLast = nextLast - 1;
        renext(nextLast);
        T removeItem = items[nextLast];
        items[nextLast] = null;
        return  removeItem;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
    public T get(int index){
        return items[index];
    }
}
