import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {
    public static long add(String numbers){
        // Check if the input string is empty
        if(numbers.isEmpty()){
            return 0;
        }

        //create a list to store all the integers
        ArrayList<Long> list = new ArrayList<>();

        //split the string by commas, convert the split string to integers and add them to the list
        String[] numberStrings = numbers.split(",");
        for (String numberString : numberStrings) {
            list.add(Long.parseLong(numberString));
        }

        //calculate the sum
        long sum = 0;

        for (long number : list) {
            sum += number;
        }

        return sum;
    }

}
