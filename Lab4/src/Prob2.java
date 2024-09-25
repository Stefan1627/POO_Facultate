import java.util.Collections;
import java.util.Vector;

class Array {
    private Vector<Integer> vector;

    public Array() {
        vector = new Vector<>();
    }

    public void addElement(Integer x) {
        vector.add(x);
    }

    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }

    public int get(int poz) {
        if(poz >= 0 && poz < vector.size()) {
            return vector.get(poz);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int getSize() {
        return vector.size();
    }

    public boolean remove(Integer x) {
        return vector.remove(x);
    }

    public Integer remove(int pos) {
        if (pos >= 0 && pos < vector.size()) {
            return vector.remove(pos);
        }
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for(int i = 0; i < vector.size(); i++) {
            result.append(get(i)).append(i < vector.size() - 1 ? ", " : "");
        }
        result.append("}");
        return result.toString();
    }

    public void sort() {
        Collections.sort(vector);
    }
}

class SortedArray extends Array {

    public SortedArray() {
        super();
    }

    @Override
    public void addElement(Integer x) {
        super.addElement(x);
        this.sort();
    }

    @Override
    public void addElement(Integer x, int poz) {
        addElement(x);
    }
}

class MyStack {
    private Array array;

    public MyStack() {
        this.array = new Array();
    }

    public void push(Integer x) {
        array.addElement(x);
    }

    public Integer pop() {
        if (array.getSize() > 0) {
            return array.remove(array.getSize() - 1);
        } else {
            return null;  // Stiva e goala
        }
    }

    @Override
    public String toString() {
        return array.toString();
    }
}

public class Prob2 {
    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray();
        sortedArray.addElement(5);
        sortedArray.addElement(2);
        sortedArray.addElement(9);
        sortedArray.addElement(1);
        System.out.println("SortedArray: " + sortedArray);

        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushes: " + stack);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
}
