public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node previous;
        public Node next;

        public Node(Node p, T i, Node n) {
            this.previous = p;
            this.item = i;
            this.next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** Create an empty list. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }

    /** Add an item of type T to the front of the deque. */
    public void addFirst(T x) {
        Node node = new Node(sentinel, x, sentinel.next);
        sentinel.next.previous = node;
        sentinel.next = node;
        size = size + 1;
    }

    /** Add an item of type T to the end of the deque. */
    public void addLast(T x) {
        Node node = new Node(sentinel.previous, x, sentinel);
        sentinel.previous.next = node;
        sentinel.previous = node;
        size = size + 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the size of the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last,
     *  separated by a space.
     */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /** Removes and returns the item at the front of the
     *  deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (! isEmpty()) {
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size = size - 1;
            return first;
        } return null;
    }

    /** Removes and returns the item at the back of the
     *  deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (! isEmpty()) {
            T last = sentinel.previous.item;
            sentinel.previous = sentinel.previous.previous;
            size = size - 1;
            return last;
        } return null;
    }

    /** Gets the item at the given index, where 0 is the
     *  front, 1 is the next item, and so forth. If no
     *  such item exists, returns null. Must not alter the
     *  deque.
     */
    public T get(int index) {
        Node p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index = index - 1;
        } return p.item;
    }

    /** Same as get, but use recursion. */
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    public T getRecursiveHelper(int i, Node p) {
        if (i == 0) {
            return p.item;
        }
        return getRecursiveHelper(i - 1, p.next);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque();
        L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
        L.addLast(5);
        L.addLast(6);
        L.addLast(7);
        L.printDeque();
        System.out.println("Size: " + L.size());
        L.removeFirst();
        L.removeLast();
        System.out.println("Size: " + L.size());
        System.out.println(L.get(2));
        System.out.println(L.getRecursive(2));
    }

}

