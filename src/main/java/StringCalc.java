
import java.util.ArrayList;

public class StringCalc {

    private static final int Value = 500;

    static int totalS(String x) throws Exception {
        StringBuilder delimeter = new StringBuilder(",\n");

        if (x.startsWith("//")) {
            delimeter = new StringBuilder(x.substring(x.indexOf("//") + 2, x.indexOf("\n")));
            String[] arrayOfNumbers = delimeter.toString().split("[,]");
            for (String s : arrayOfNumbers) {
                delimeter.append(s);
            }
            x = x.substring(x.indexOf("\n"));
        }
        delimeter = new StringBuilder("[" + delimeter + "]");
        return totalS(x, delimeter.toString());
    }
    public static int totalS(final String numbers, String delimiter) throws Exception {
        int sum = 0;
        String[] arrayOfNumbers = numbers.split("[" + delimiter + "]");
        ArrayList<Integer> negInt = new ArrayList<>();
        try {
            for (String result : arrayOfNumbers) {
                if (!result.trim().isEmpty()) {
                    int i = Integer.parseInt(result.trim());
                    if (i < 0) {
                        negInt.add(i);
                    } else if (i < Value) {
                        sum += i;
                    }
                }
            }
        }catch (Exception e){
            System.err.println("Wrong Digit");
            throw new Exception("");
        }

        if(negInt.size()>1){
            StringBuilder neg = new StringBuilder();

            for (int i = 0; i < negInt.size()-1; i++) {
                neg.append(negInt.get(i)).append(", ");
            }
            neg.append(negInt.get(negInt.size() - 1));
            System.err.println( "Error : no negative values " + neg);
            throw new Exception("");
        }
        return sum;
    }
}