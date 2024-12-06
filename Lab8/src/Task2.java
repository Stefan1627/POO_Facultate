import java.util.Comparator;
import java.util.TreeSet;

class Catalog extends TreeSet<Catalog.Studentt> {
    public Catalog() {
        super();
    }

    public Catalog(Comparator comparator) {
        super(comparator);
    }

    public void addStudent(String name, double media, int clazz) {
        add(new Studentt(name, media, clazz));
    }

    public void removeStudent(String name) {
        removeIf(studentt -> studentt.name.equals(name));
    }

    public Studentt getStudent(String name) {
        for (Studentt student : this) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Catalog byClass(int clazz) {
        Catalog catalog = new Catalog(Comparator.naturalOrder());
        for (Studentt student : this) {
            if (clazz == student.clazz) {
                catalog.add(student);
            }
        }
        return catalog;
    }

    class Studentt implements Comparable<Studentt> {
        String name;
        double media;
        private int clazz;

        public Studentt(String name, double media, int clazz) {
            this.name = name;
            this.media = media;
            this.clazz = clazz;
        }

        @Override
        public int compareTo(Studentt o) {
            int result = Double.compare(media, o.media);
            if (result == 0) {
                result = name.compareTo(o.name);
            }
            return result;
        }

        @Override
        public String toString() {
            return "Student{" + "name=" + name + ", media=" + media + ", clazz=" + clazz + '}';
        }
    }
}

public class Task2 {

    public static void main(String args[]) {
        Catalog catalog = new Catalog();
        catalog.addStudent("Alexandru", 7, 324);
        catalog.addStudent("Ioana", 5, 321);
        catalog.addStudent("Maria", 10, 322);
        catalog.addStudent("Ionut", 6.2, 323);
        catalog.addStudent("Diana", 7, 322);

        Catalog catalog2 = new Catalog(new Comparator<Catalog.Studentt>() {
            @Override
            public int compare(Catalog.Studentt o1, Catalog.Studentt o2) {
                // TODO: Sort by average (descending) and by name (ascending).
                int result = Double.compare(o1.media, o2.media);
                result = -result;
                if (result == 0) {
                    result = o1.name.compareTo(o2.name);
                }
                return result;
            }
        });
        catalog2.addAll(catalog);

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + catalog);
        System.out.println("Continutul colectiei: " + catalog2);

        Catalog.Studentt last = null;
        for (Catalog.Studentt o : catalog) {
            if (last == null) {
                last = o;
                continue;
            }
            int r = last.media != o.media ? Double.compare(last.media, o.media) : last.name.compareTo(o.name);
            if (r != last.compareTo(o)) {
                System.err.println("Catalog.Student.compareTo a fost implementata gresit.");
            }
        }

        if (catalog.size() != 5) {
            System.err.println("Catalog.size() a fost implementata gresit.");
        }

        catalog.removeStudent("Ionut");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }
        catalog.removeStudent("");
        if (catalog.size() != 4) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.byClass(322).size() != 2) {
            System.err.println("Catalog.byClass() a fost implementata gresit.");
        }

        catalog.removeStudent("Maria");
        if (catalog.byClass(322).size() != 1) {
            System.err.println("Catalog.remove() a fost implementata gresit.");
        }

        if (catalog.getStudent("Maria") != null) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }

        if ((catalog.getStudent("Alexandru") == null) || (catalog.getStudent("Alexandru").media != 7)) {
            System.err.println("Catalog.getStudent() a fost implementata gresit.");
        }
    }

}
