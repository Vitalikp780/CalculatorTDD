import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        String hello = "Hello world";
        String test;
        test = hello.substring(0, 2);
        System.out.println("hello");
        System.out.println(test);
        String delimiter = "";
        String number = "//;\n1;2";
        delimiter = number.substring(0, 2);
        int endDelimiter = number.indexOf("\n");
        if (delimiter.equals("//")) {
            System.out.println("Разделитель" + number.substring(2, 4));
            System.out.println(endDelimiter);
        }

        /*Pattern pattern1 = Pattern.compile("[0-9]");
        String temp = number.substring(number.indexOf("\n") + 1);
        temp = temp.replace(number.substring(2, 3), "");
        Matcher matcher1 = pattern1.matcher(temp);
        //System.out.println(temp);*/
    }

    public static int add(String number) throws SpliterFormatException {
        int num = 0;
        int result = 0;
        String delimiter = "";

        //проверка на null и пустую строку
        if (number == null || number.isEmpty()) {
            return result = 0;
        }

        //проверка на длину строки больше 5
        if (number.length() > 5) {
            delimiter = number.substring(0, 2);

            if (delimiter.equals("//")) {
                int endDelimiter = number.indexOf("\n");
                if(endDelimiter == -1){
                    endDelimiter = number.indexOf("n");
                }
                String delimiter1 = number.substring(2,3);
                String delimiter2 = number.substring(endDelimiter-1, endDelimiter);

                if(delimiter1.equals("[") && delimiter2.equals("]")){
                    int index1 = number.indexOf(delimiter1);
                    int index2 = number.indexOf(delimiter2);
                    delimiter = number.substring(index1+1, index2);
                    System.out.println("delimiter");

                }else{
                    delimiter = number.substring(2, 3);
                }
                if(isNumberSeparator(delimiter) || !isCorrectSeparator(number, delimiter)){
                    System.out.println("Разделитель" + number.substring(2, 4) + " указан не верно!");
                    throw new SpliterFormatException("Наше исключение перехвачено");
                }
                else {
                    int index;
                    number = number.replace(delimiter, ",");
                    index = number.indexOf("\n");
                    if(index == -1){
                        index = number.indexOf("n");
                    }
                    number = number.substring(index + 1);
                }
            }
        }
        number = spaceRemove(number);
        number = separatorReplacement(number);
        return result = summ(number);
    }

    public static String spaceRemove(String input) {
        return input.replace(" ", "");
    }

    public static String separatorReplacement(String input) {
        if (input.contains("\\n") || input.contains("\n")) {
            input = input.replace("\\n", ",");
            input = input.replace("\n", ",");
        }
        return input;
    }

    public static int summ(String input) {
        int value = 0;

        if (input.contains(",")) {
            String numbers[] = input.split(",");
            for (int x = 0; x < numbers.length; x++) {
                if (Integer.parseInt(numbers[x]) > 1000) {
                    continue;
                }
                value += Integer.parseInt(numbers[x]);
            }
            return value;
        } else {
            return Integer.parseInt(input);
        }
    }

    public static boolean isNumberSeparator(String delimiter) {

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(delimiter);

        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isCorrectSeparator(String input, String delimiter){
        String test;
        boolean flag;

        int index = input.indexOf("\n");
        if(index == -1){
            index = input.indexOf("n");
        }

        test = input.substring(index + 1);
        test = test.replace(delimiter, ",");
        test = spaceRemove(test);

        Pattern pattern = Pattern.compile("[^0-9+^,]");
        Matcher matcher = pattern.matcher(test);

        if(matcher.find()){
            return false;
        }else{
            return true;
        }
    }

    public static String useDelimiter(String input, String delimiter){
        String value;
        int index = input.indexOf("\n") + 1;
        if(index == -1){
            index = input.indexOf("n");
        }

        value = input.replace(delimiter, ",");
        value = value.substring(index);
        return value;
    }
}