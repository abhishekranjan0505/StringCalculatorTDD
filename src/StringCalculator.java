import java.util.ArrayList;

public class StringCalculator {
    public static int add(String numbers){
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

        System.out.println(delimiter);

        //split the string by commas, convert the split string to integers and add them to the list
        String[] numberStrings = numbersWithoutDelimiter.split(delimiter);
        for (String numberString : numberStrings) {
            list.add(Integer.parseInt(numberString));
        }

        //calculate the sum
        int sum = 0;

        for (int number : list) {
            sum += number;
        }

        return sum;
    }

}
