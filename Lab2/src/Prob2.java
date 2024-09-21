import java.util.StringTokenizer;

public class Prob2 {
    public static void main(String[] args) {
        int nr;
        String s2 = "ce";
        String s1 = "Marius, de ce nu l-ai ajutat pe George? Era de datoria ta sa vezi ce poti face.";
        System.out.println(s2);
        nr = splitMethod(s1, s2);
        System.out.println(nr);
        nr = stringToken(s1, s2);
        System.out.println(nr);
    }

    public static int splitMethod(String s1, String s2) {
        s2 = s2 + " ";
        int nr = 0;
        String[] arrOfStr = s1.split(s2);

        for (String _ : arrOfStr){
            //System.out.println(a);
            nr++;
        }
        return nr - 1;
    }

    public static int stringToken(String s1, String s2) {
        int nr = 0;
        String s3 = ": , . - ?";
        StringTokenizer st = new StringTokenizer(s1, s3);

        while (st.hasMoreTokens()){
            if (st.nextToken().equals(s2))
                nr++;
        }
        return nr;
    }
}
