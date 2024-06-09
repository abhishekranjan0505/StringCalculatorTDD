import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void add() {
        //check for empty string and with single number
        assertEquals(0, StringCalculator.add("") );
        assertEquals(1, StringCalculator.add("1"));
        //check for comma separated numbers
        assertEquals(6,StringCalculator.add("1,5"));
        //check for an unknown amount of numbers
        assertEquals(1+10+2+40+67+183, StringCalculator.add("1,10,2,40,67,183"));
        assertEquals(1 + 10 + 2 + 40 + 67 + 183 + 87, StringCalculator.add("1,10,2,40,67,183,87"));
        //check for new lines between numbers
        assertEquals(13, StringCalculator.add("1\n2,10"));
        //check for custom delimiter - "//[delimiter]\n[numbers…]"
        assertEquals(3,StringCalculator.add("//;\n1;2"));
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add("//%\n1%2%3%4"));
        //check for custom delimiter with comma
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add("//;\n1;2;3,4"));
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add("//%\n1%2%3,4"));
        //check for negative numbers
        try {
            StringCalculator.add("//;\n1;-2;3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-2]", e.getMessage());
        }
        // multiple negative numbers
        try {
            StringCalculator.add("//;\n1;-2;-3;-5,10,0");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-2, -3, -5]", e.getMessage());
        }
        //numbers bigger than a thousand should be ignored
        assertEquals(1 + 2 + 4 + 1000, StringCalculator.add("//%\n1%2%1001,4,2000,1000"));

    }

    @Test
    public void getCalledCount(){
        //returns how many number of times add() was called
        assertEquals(0, StringCalculator.getCalledCount()); // Initial count should be 0
        StringCalculator.add("1"); // call count = 1
        assertEquals(1, StringCalculator.getCalledCount());
        StringCalculator.add("1,2"); // call count = 2
        assertEquals(2, StringCalculator.getCalledCount());
        StringCalculator.add("1,2,3"); // call count = 3
        assertEquals(3, StringCalculator.getCalledCount());
        StringCalculator.add("//;\n1;2"); // call count = 4
        assertEquals(4, StringCalculator.getCalledCount());
        //counter should increase even after throwing exception for negative numbers
        try {
            StringCalculator.add("//;\n1;-2;3");
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: [-2]", e.getMessage());
        }
        assertEquals(5, StringCalculator.getCalledCount());
    }

}