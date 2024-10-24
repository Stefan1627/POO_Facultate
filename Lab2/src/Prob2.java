import java.util.StringTokenizer;

public class Prob2 {
    public static int splitMethod(String s1, String s2) {
        s2 = s2 + " ";
        int nr = 0;
        String[] arrOfStr = s1.split(s2);

        for (String _ : arrOfStr){
            nr++;
        }
        return nr - 1;
    }

    public static int stringTokenizerMethod(String s1, String s2) {
        int nr = 0;
        String s3 = ": , . - ?";
        StringTokenizer st = new StringTokenizer(s1, s3);

        while (st.hasMoreTokens()){
            if (st.nextToken().equals(s2))
                nr++;
        }
        return nr;
    }

    public static void main(String[] args) {
        int nr;
        String s1 = new String("sir1 si sir2 sunt 2 siruri");
        String s2 = new String("si");

        nr = splitMethod(s1, s2);
        System.out.println(nr);
        System.out.println(stringTokenizerMethod(s1, s2));

    }
}