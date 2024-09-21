import java.util.StringTokenizer;


public class Prob5 {
    public static String replace(String text) {
        StringBuilder result = new StringBuilder(text);
        for (int i = 1; i < text.length()-1; i++) {
            result.setCharAt(i, '*');
        }
        return result.toString();
    }

    public static String cenzura(String text, String[] cuvinte) {
        String space = " ";
        StringTokenizer st = new StringTokenizer(text, space);
        StringBuilder textBuilder = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.equals(cuvinte[0]) || s.equals(cuvinte[1])) {
                System.out.println("Text suspect");
                s = replace(s);
            }
            textBuilder.append(" ").append(s);
        }
        text = textBuilder.toString();

        return text;
    }

    public static void main(String[] args) {
        String text = "Un terorist avea o bomba";
        String[] cuvinte = new String[2];
        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";
        String rezultat;
        rezultat = cenzura(text, cuvinte);
        System.out.println(rezultat);
    }
}
