import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {

    private StringCalc stringCalc = new StringCalc();

    @Test
    void test() throws Exception{
        assertEquals(0, stringCalc.totalS(""));assertEquals(1, stringCalc.totalS("1"));
        assertEquals(2, stringCalc.totalS("1,1"));assertEquals(10, stringCalc.totalS("1,2,3,4"));
        assertEquals(10, stringCalc.totalS("1,2,3,4"));assertEquals(6, stringCalc.totalS("1\n2,3"));
        assertEquals(3, stringCalc.totalS("//;\n1;2"));assertEquals(3, stringCalc.totalS("//4\n142"));
        assertEquals(3, stringCalc.totalS("//;\n1000;1;2"));assertEquals(6, stringCalc.totalS("//***\n1***2***3"));
        assertEquals(6, stringCalc.totalS("//[:D][%]\n1:D2%3"));assertEquals(6, stringCalc.totalS("//[***][%%%]\n1***2%%%3"));
        assertEquals(0, stringCalc.totalS("//[(-_-')][%]\n1(-_-')2%3"));assertEquals(7, stringCalc.totalS("//[abc][777][:(]\n1abc27773:(1"));
    }
    @Test
    void neg() {
        Exception exception = assertThrows(Exception.class, () -> {
            stringCalc.totalS("-1,-2,3,4"); });
        String Message = exception.getMessage();
        assertFalse(Message.contains("Error : Negatives not allowed"));
    }
    @Test
    void negVal() throws Exception {
        StringCalc.totalS("//;\n1000;1;2;");
    }
    @Test
    void negVal1() {
        Exception exception = assertThrows(Exception.class, () -> {
            StringCalc.totalS("   //;\n1000,1;2"); });
        String Message = exception.getMessage();
        assertFalse(Message.contains("Invalid Input"));
    }
    @Test
    void negVal2() {
        Exception exception = assertThrows(Exception.class, () -> {
            stringCalc.totalS("1,2,3//;\n1000,1;2"); });
        String Message = exception.getMessage();
        assertFalse(Message.contains("the value is invalid"));
    }
}