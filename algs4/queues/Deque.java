
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prve;
    }

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Invalid Item");
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.prve = first;
        }
        size += 1;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Invalid Item");
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.prve = oldLast;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size += 1;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;
        if (size == 1) {
            size = 0;
            return item;
        }
        first = first.next;
        first.prve = null;
        size -= 1;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = last.item;
        if (size == 1) {
            size = 0;
            return item;
        }
        last = last.prve;
        last.next = null;
        size -= 1;
        if (isEmpty()) {
            last = null;
            first = null;
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }


        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.addFirst(8);
        deque.removeFirst();
        deque.removeLast();


        Iterator it = deque.iterator();
        System.out.println(it.hasNext());
    }
}