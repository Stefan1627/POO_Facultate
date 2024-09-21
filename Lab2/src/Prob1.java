public class Prob1 {
    // Metoda 1: folosind substring()
    public static int numaraCuSubstring(String s1, String s2) {
        int count = 0;
        int lenS2 = s2.length();

        // Parcurgem fiecare subșir de dimensiunea lui s2 din s1
        for (int i = 0; i <= s1.length() - lenS2; i++) {
            if (s1.substring(i, i + lenS2).equals(s2)) {
                count++;
            }
        }
        return count;
    }

    // Metoda 2: folosind indexOf()
    public static int numaraCuIndexOf(String s1, String s2) {
        int count = 0;
        int pos = s1.indexOf(s2); // Căutăm prima apariție

        // Continuăm să căutăm atâta timp cât găsim șirul s2 în s1
        while (pos != -1) {
            count++;
            pos = s1.indexOf(s2, pos + 1); // Căutăm următoarea apariție
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "sir1 si cu sir2 fac un sir3";
        String s2 = "si";

        // Calculăm numărul de apariții folosind cele două metode
        int aparitiiSubstring = numaraCuSubstring(s1, s2);
        int aparitiiIndexOf = numaraCuIndexOf(s1, s2);

        // Afișăm rezultatele
        System.out.println("Număr de apariții folosind substring(): " + aparitiiSubstring);
        System.out.println("Număr de apariții folosind indexOf(): " + aparitiiIndexOf);
    }
}