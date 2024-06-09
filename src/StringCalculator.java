import java.util.ArrayList;

public class StringCalculator {
    private static int callCount = 0;
    public static int add(String numbers){
        callCount++;
        // Check if the input string is empty
        if(numbers.isEmpty()){
            return 0;
        }

        //create a list to store all the integers
        ArrayList<Integer> list = new ArrayList<>();

        String delimiter = "[,\n]";
        String numbersWithoutDelimiter = numbers;

        if(numbers.startsWith("//")){
            String newDelimiter = "" + numbers.charAt(2);
            delimiter = delimiter.substring(0,3) + newDelimiter + "]";
            numbersWithoutDelimiter = numbers.substring(4);
        }

        //split the string by commas, convert the split string to integers and add them to the list
        String[] numberStrings = numbersWithoutDelimiter.split(delimiter);
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int num = Integer.parseInt(numberString);
            if(num < 0){
                negativeNumbers.add(num);
            }
            list.add(num);
        }

        //check for invalid arguments (negative numbers passed)
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }


        //calculate the sum
        int sum = 0;

        for (int number : list) {
            sum += number;
        }

        return sum;
    }

    public  static  int getCalledCount(){
        return callCount;
    }

}
