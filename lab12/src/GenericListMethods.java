import java.util.*;

interface GenericInterface {
    //Sterge duplicatele dintr-o lista si returneaza lista rezultata
    <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list);
    //Determina elementul maxim dintr-o lista
    <E extends Comparable<E>> E max(ArrayList<E> list);
    //Cauta o valoare in lista sortata, folosind algoritmul de cautare binara si returneaza pozitia
    <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end);
}

public class GenericListMethods implements GenericInterface {

    @Override
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        Set<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    @Override
    public <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Lista este vida sau null.");
        }
        E maxElement = list.getFirst();
        for (E element : list) {
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    @Override
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int cmp = key.compareTo(list.get(mid));
        if (cmp == 0) {
            return mid;
        } else if (cmp < 0) {
            return binarySearch(list, key, start, mid - 1);
        } else {
            return binarySearch(list, key, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        GenericListMethods glm = new GenericListMethods();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 8, 4, 5, 5, 6));
        System.out.println("Original list: " + list);

        ArrayList<Integer> noDuplicates = glm.removeDuplicates(list);
        System.out.println("List without duplicates: " + noDuplicates);

        Integer maxElement = glm.max(noDuplicates);
        System.out.println("Max element: " + maxElement);

        Collections.sort(noDuplicates);
        System.out.println("Sorted list: " + noDuplicates);

        int index = glm.binarySearch(noDuplicates, 4, 0, noDuplicates.size() - 1);
        System.out.println("Index of 4: " + index);
    }
}
