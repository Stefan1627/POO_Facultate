class MyQueue {
    // Membri de date
    private MyArray array;
    private final int Infinit = 9500;
    private int front; // Indicele primului element
    private int rear;  // Indicele ultimului element
    private int numElements; // Numarul de elemente din coada

    // Constructor
    public MyQueue() {
        array = new MyArray(); // Coada foloseste MyArray pentru a stoca elementele
        front = 0;
        rear = -1;
        numElements = 0;
    }

    // Returneaza numarul de elemente din coada
    public int getSize() {
        return numElements;
    }

    // Adauga un element in coada
    public void enqueue(int value) {
        rear++; // Incrementam indicele ultimului element
        array.set(rear, value); // Adaugam valoarea in array
        numElements++; // Incrementam numarul de elemente
    }

    // Scoate si returneaza primul element din coada
    public int dequeue() {
        if (isEmpty()) {
            return Infinit; // Daca coada este goala, returnam Infinit
        }
        int value = array.get(front); // Preluam valoarea de la front
        front++; // Incrementam indicele primului element
        numElements--; // Decrementam numarul de elemente
        return value;
    }

    // Verifica daca coada este goala
    public boolean isEmpty() {
        return numElements == 0;
    }

    // Returneaza o reprezentare sub forma de string a cozii
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
