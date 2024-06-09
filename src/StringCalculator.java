import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringCalculator {
    private static int callCount = 0;
    public static int add(String numbers){
        callCount++;
        // Check if the input string is empty
        if(numbers.isEmpty())
            return 0;

        //create a list to store all the integers
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer tokenizer = getStringTokenizer(numbers);
        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            String numberString = tokenizer.nextToken();
            if (!numberString.isEmpty()) {
                int num = Integer.parseInt(numberString);
                if(num < 0)
                    negativeNumbers.add(num);
                if(num > 1000)
                    continue;
                list.add(num);
            }
        }

        //check for invalid arguments (negative numbers passed)
        if (!negativeNumbers.isEmpty())
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);

        //calculate the sum
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static StringTokenizer getStringTokenizer(String numbers) {
        String delimiter = ",|\n";
        String numbersWithoutDelimiter = numbers;

        if(numbers.startsWith("//")){
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = delimiter + numbers.substring(2, delimiterIndex);
            numbersWithoutDelimiter = numbers.substring(delimiterIndex + 1);
        }

        //split the string by commas, convert the split string to integers and add them to the list
        return new StringTokenizer(numbersWithoutDelimiter, delimiter);
    }

    public  static  int getCalledCount(){
        return callCount;
    }

}
