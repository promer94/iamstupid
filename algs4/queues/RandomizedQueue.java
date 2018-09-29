/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] rQ;
    private int size;

    public RandomizedQueue() {
        rQ = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            temp[i] = rQ[i];
        }
        rQ = temp;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Invalid item");
        if (size == rQ.length) resize(2 * rQ.length);
        rQ[size] = item;
        size += 1;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
        int index = StdRandom.uniform(0, size);
        Item item = rQ[index];
        rQ[index] = rQ[size - 1];
        rQ[size - 1] = null;
        size -= 1;
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
        return rQ[StdRandom.uniform(0, size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    private class RandomArrayIterator implements Iterator<Item> {
        private final Item[] r;
        private int n;

        public RandomArrayIterator() {
            r = (Item[]) new Object[size];
            n = size;
            for (int i = 0; i < size; i += 1) {
                r[i] = rQ[i];
            }
        }

        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int index = StdRandom.uniform(0, n);
            Item item = r[index];
            r[index] = r[n-1];
            r[n - 1] = null;
            n -= 1;
            return item;
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue("A");
        rq.enqueue("B");
        Iterator<String> it = rq.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
