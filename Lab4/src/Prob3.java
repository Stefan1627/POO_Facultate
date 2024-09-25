import java.util.Hashtable;

// Clasa HSet care mosteneste Hashtable
class HSet extends Hashtable<Object, Object> {

    // Adauga un element in multime, daca nu exista deja
    public boolean add(Object value) {
        // Verificam daca cheia deja exista in Hashtable
        if (!this.containsKey(value)) {
            // Daca nu exista, adaugam perechea (key = value, value = value)
            this.put(value, value);
            return true;
        }
        return false;  // Daca exista deja, nu facem nimic si returnam false
    }

    // Supradefinirea metodei toString pentru a afisa doar cheile (elementele multimii)
    @Override
    public String toString() {
        return this.keySet().toString();  // intoarce toate cheile sub forma de String
    }

    // Sterge perechea corespunzatoare cheii si returneaza valoarea eliminata
    @Override
    public Object remove(Object key) {
        // Apelam metoda remove a clasei Hashtable si intoarcem valoarea eliminata
        return super.remove(key);
    }
}

// Clasa Test3 pentru testarea clasei HSet
public class Prob3 {
    public static void main(String args[]) {
        HSet set = new HSet();

        // Adaugam elemente in multime
        set.add("Laborator");
        set.add("Agregare");
        set.add("Mostenire");
        System.out.println(set);  // {Laborator, Agregare, Mostenire}

        // Verificam dimensiunea multimii
        System.out.println(set.size());  // 3

        // Incercam sa adaugam un element duplicat
        set.add("Laborator");  // Nu trebuie sa fie adaugat din nou

        // Verificam daca multimea contine duplicate
        if (set.size() == 4) {
            System.out.println("Multimea nu trebuie sa contina duplicate!");
        }

        // Incercam sa stergem un element inexistent
        System.out.println(set.remove("POO"));  // null, deoarece nu exista

        // Stergem un element existent
        System.out.println(set.remove("Laborator"));  // Laborator

        // Verificam daca stergerea a functionat
        if (set.size() != 2) {
            System.out.println("Stergerea nu functioneaza!");
        }

        // Adaugam noi elemente in multime
        set.add("Supradefinire");
        set.add("Supraincarcare");
        System.out.println(set);  // {Agregare, Mostenire, Supradefinire, Supraincarcare}
    }
}

