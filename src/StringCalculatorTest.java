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
        assertEquals(1+10+2+40+67+183+8736, StringCalculator.add("1,10,2,40,67,183,8736"));
        assertEquals(1 + 10 + 2 + 40 + 67 + 183 + 873689, StringCalculator.add("1,10,2,40,67,183,873689"));
        //check for new lines between numbers
        assertEquals(13, StringCalculator.add("1\n2,10"));
        //check for custom delimiter - "//[delimiter]\n[numbers…]"
        assertEquals(3,StringCalculator.add("//;\n1;2"));
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add("//%\n1%2%3%4"));
        //check for custom delimiter with comma
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add("//;\n1;2;3,4"));
        assertEquals(1 + 2 + 3 + 4, StringCalculator.add("//%\n1%2%3,4"));
    }

}