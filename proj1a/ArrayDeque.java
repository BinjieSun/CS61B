public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty deque. */
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = items.length/2;
        nextLast = nextFirst + 1;
        size = 0;
    }

  /** Resize the entire array */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Add an item to the front of the deque. */
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst -= 1;
    }


    /** Add an item to the rear of the deque. */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = x;
        size += 1;
        nextLast += 1;
    }


    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return size == 0;
    }


    /** Returns the size of the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last,
     *  separated by a space.
     */
    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }


    /** Removes and returns the item at the front of the
     *  deque. If no such item exists, returns null.
     */
    public Item removeFirst() {
        Item x = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        size -= 1;
        nextFirst += 1;
        return x;
    }


    /** Removes and returns the item at the back of the
     *  deque. If no such item exists, returns null.
     */
    public Item removeLast() {
        Item x = items[nextLast - 1];
        items[nextLast - 1] = null;
        size -= 1;
        nextLast -= 1;
        return x;
    }


    /** Gets the item at the given index, where 0 is the
     *  front, 1 is the next item, and so forth. If no
     *  such item exists, returns null. Must not alter the
     *  deque.
     */
    public Item get(int index) {
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque();
        A.addFirst(2);
        A.addFirst(3);
        A.addFirst(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.printDeque();
        System.out.println("Size: " + A.size());
        A.removeFirst();
        A.removeLast();
        System.out.println("Size: " + A.size());
        System.out.println(A.get(0));
    }

}
