import java.util.*;

class LinkedSet extends LinkedList<Integer> implements Set<Integer> {
    public boolean add(Integer o) {
        if (!contains(o)) {
            super.add(o);
            return true;
        }
        return false;
    }

    public void add(int index, Integer element) {
        if (!contains(element)) {
            if (index <= size()) {
                super.add(index, element);
            } else {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
            }
        } else {
            System.out.println("Element already exists");
        }
    }

    public Integer set(int index, Integer element) {
        if (!contains(element)) {
            return super.set(index, element);
        } else {
            System.out.println("Element already exists");
            return get(index);
        }
    }
}

class Prob2 {
    public static void main(String[] args) {
        LinkedSet set = new LinkedSet();

        for(int i = 5; i >= 0; i--){
            set.add(i);
            set.add(2 * i);
            set.add(3 * i);
        }

        Collections.sort(set);
        System.out.println("Got: " + set + " Correct: [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15]");

        for(int i = 4; i <= 8; i++){
            set.set(i,set.get(i-4));
        }
        Collections.sort(set);
        System.out.println("Got: " + set + " Correct: [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15]");

        //let's add to nowhere, same should be
        try{
            set.add(100, 42);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Good job! Exception! ");
            System.out.println("Got: " + set + " Correct: [0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15]");
            return;
        }
        System.out.println("Where's my Exception? :(");

    }
}
