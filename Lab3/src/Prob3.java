class MyQueue {
    private MyArray array;
    private final int Infinit = 9500;
    private int front;
    private int rear;
    private int numElements;

    public MyQueue() {
        array = new MyArray();
        front = 0;
        rear = -1;
        numElements = 0;
    }

    public int getSize() {
        return numElements;
    }

    public void enqueue(int value) {
        rear++;
        array.set(rear, value);
        numElements++;
    }

    public int dequeue() {
        if (isEmpty()) {
            return Infinit;
        }
        int value = array.get(front);
        front++;
        numElements--;
        return value;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = front; i <= rear; i++) {
            sb.append(array.get(i));
            if (i < rear) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class MyArray {
    private int v[];
    private int size;

    public MyArray() {
        this(100);
    }

    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }

    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }

    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}

public class Prob3 {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("");
        System.out.println(queue);
    }
}