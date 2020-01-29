import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringcalculator = new StringCalculator();

    @Test
    void testCaseForStringCalculator() throws Exception{


        assertEquals(0, stringcalculator.Sum(""));
        assertEquals(1, stringcalculator.Sum("1"));
        assertEquals(2, stringcalculator.Sum("1,1"));
        assertEquals(10, stringcalculator.Sum("1,2,3,4"));
        assertEquals(10, stringcalculator.Sum("1,2,3,4"));
        assertEquals(6, stringcalculator.Sum("1\n2,3"));
        assertEquals(3, stringcalculator.Sum("//;\n1;2"));
        assertEquals(3, stringcalculator.Sum("//4\n142"));
        assertEquals(3, stringcalculator.Sum("//;\n1000;1;2"));
        assertEquals(6, stringcalculator.Sum("//***\n1***2***3"));
        assertEquals(6, stringcalculator.Sum("//[:D][%]\n1:D2%3"));
        assertEquals(6, stringcalculator.Sum("//[***][%%%]\n1***2%%%3"));
        assertEquals(0, stringcalculator.Sum("//[(-_-')][%]\n1(-_-')2%3"));
        assertEquals(7, stringcalculator.Sum("//[abc][777][:(]\n1abc27773:(1"));

    }
    @Test
    void negativeNumbersTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            stringcalculator.Sum("-1,-2,3,4");
        });
        String actualMessage = exception.getMessage();
        assertFalse(actualMessage.contains("Error : Negatives not allowed"));
    }


    @Test
    void WrongDigit() throws Exception {
        StringCalculator.Sum("//;\n1000;1;2;");
    }
    @Test
    void WrongDigitFirst() {
        Exception exception = assertThrows(Exception.class, () -> {
            StringCalculator.Sum("   //;\n1000,1;2");
        });
        String actualMessage = exception.getMessage();
        assertFalse(actualMessage.contains("Invalid Input"));
    }
    @Test
    void WrongDigitSecond() {
        Exception exception = assertThrows(Exception.class, () -> {
            stringcalculator.Sum("1,2,3//;\n1000,1;2");
        });
        String actualMessage = exception.getMessage();
        assertFalse(actualMessage.contains("Invalid Input"));
    }
}