
import java.util.ArrayList;

public class StringCalculator {

    private static final int LargeValue = 1_000;

    static int Sum(String stringValues) throws Exception {
        StringBuilder DELIMETER = new StringBuilder(",\n");

        if (stringValues.startsWith("//")) {
            DELIMETER = new StringBuilder(stringValues.substring(stringValues.indexOf("//") + 2, stringValues.indexOf("\n")));
            String[] arrayOfNumbers = DELIMETER.toString().split("[,]");

            for (String s : arrayOfNumbers) {
                DELIMETER.append(s);
            }
            stringValues = stringValues.substring(stringValues.indexOf("\n"));
        }
        DELIMETER = new StringBuilder("[" + DELIMETER + "]");

        return Sum(stringValues, DELIMETER.toString());
    }


    public static int Sum(final String numbers, String delimiter) throws Exception {
        int sum = 0;

        String[] arrayOfNumbers = numbers.split("[" + delimiter + "]");

        ArrayList<Integer>negValues = new ArrayList<>();
        try {

            for (String result : arrayOfNumbers) {
                if (!result.trim().isEmpty()) {
                    int numberSignCheck = Integer.parseInt(result.trim());
                    if (numberSignCheck < 0) {
                        negValues.add(numberSignCheck);
                    } else if (numberSignCheck < LargeValue) {
                        sum += numberSignCheck;
                    }
                }
            }
        }catch (NumberFormatException e){
            System.err.println("Wrong Digit");
            throw new Exception("");
        }

        if(negValues.size()>1){
            StringBuilder neg = new StringBuilder();

            for (int i = 0; i < negValues.size()-1; i++) {
                neg.append(negValues.get(i)).append(", ");
            }
            neg.append(negValues.get(negValues.size() - 1));
            System.err.println( "Error : a negative value cannot be accepted " + neg);
            throw new Exception("");
        }
        return sum;
    }
}
