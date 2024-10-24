public class Prob1 {
    public static int numaraCuSubstring(String s1, String s2) {
        int count = 0;
        int lenS2 = s2.length();

        for (int i = 0; i <= s1.length() - lenS2; i++) {
            if (s1.substring(i, i + lenS2).equals(s2)) {
                count++;
            }
        }
        return count;
    }

    public static int numaraCuIndexOf(String s1, String s2) {
        int count = 0;
        int pos = s1.indexOf(s2);

        while (pos != -1) {
            count++;
            pos = s1.indexOf(s2, pos + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = new String("sir1");
        String s2 = new String("si1");

        int aparitiiSubstring = numaraCuSubstring(s1, s2);
        int aparitiiIndexOf = numaraCuIndexOf(s1, s2);

        System.out.println(aparitiiSubstring + " " + aparitiiIndexOf);
    }
}