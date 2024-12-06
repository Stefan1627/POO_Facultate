import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value, head);
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;


        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            } else {
                T value = current.value;
                current = current.next;
                return value;
            }
        }
    }
}

public class Task3 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.add(22);
        list.add(25);
        list.add(30);

        int last = 0;
        System.out.println("Afisare 1");
        for (Integer i : list) {
            System.out.print(i + ", ");
            if (i < last) {
                System.err.println("LinkedList a fost implementata gresit.");
            }
            last = i;
        }
        System.out.println();

        System.out.println("Afisare 2");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
    }
}