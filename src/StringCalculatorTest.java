import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void add() {
        assertEquals(0, StringCalculator.add("") );
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(6,StringCalculator.add("1,5"));
        assertEquals(1+10+2+40+67+183+8736, StringCalculator.add("1,10,2,40,67,183,8736"));
        assertEquals(1 + 10 + 2 + 40 + 67 + 183 + 873689, StringCalculator.add("1,10,2,40,67,183,873689"));
        assertEquals(13, StringCalculator.add("1\n2,10"));
    }

}