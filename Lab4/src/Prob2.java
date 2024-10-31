import java.util.Collections;
import java.util.Vector;

class Array {
    //Vectorul in care se vor retine elementele
    private Vector vector;

    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector();
    }

    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }

    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }

    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }

    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }

    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + ", ";
        }
        result += "}";
        return result;
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
        sort();
    }

    @Override
    public void addElement(Integer x, int poz) {
        addElement(x);
    }
}

class MyStack extends Array {
    private Array array;
    public MyStack() {
        array = new Array();
    }

    public void push(Integer x) {
        array.addElement(x);
    }

    public Integer pop() {
        if (array.getSize() > 0) {
            return array.remove(array.getSize() - 1);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "array=" + array +
                '}';
    }
}

public class Prob2 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        SortedArray array = new SortedArray();
        array.addElement(5);
        array.addElement(3);
        array.addElement(2);
        array.addElement(1);
        System.out.println(array);
    }
}