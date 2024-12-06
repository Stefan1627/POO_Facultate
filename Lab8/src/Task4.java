//import java.util.ArrayList;
//import java.util.List;
//
//class Table {
//    private List<List<Object>> data = new ArrayList<>();
//
//    public void addRow(Object[] row) {
//        data.add(List.of(row));
//    }
//
//    public interface Printer {
//        void print(Table table);
//    }
//
//    public void print(Printer printer) {
//        printer.print(this);
//    }
//
//    public List<List<Object>> getData() {
//        return data;
//    }
//}
//
//public class Task4 {
//
//    public static void main(String[] args) {
//        Object rows[][] = new Object[][] {
//                {"#", "Materie", "An", "Semestru", "Credite"},
//                {1, "Programarea calculatoarelor", 1, 1, 6},
//                {2, "Structuri de date", 1, 2, 6},
//                {3, "Programare Orientata pe Obiecte", 2, 1, 6},
//        };
//        Table t = new Table(rows);
//        t.print(t.new CsvPrinter());
//        t.print(t.new AsciiPrinter(new int[] {2, 32, 8, 8, 8}));
//    }
//
//}