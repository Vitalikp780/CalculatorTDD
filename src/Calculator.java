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
                result = getResultWithDelimiter(number, delimiter);
                return result;
            }
        }
        number = spaceRemove(number);
        number = separatorReplacement(number);
        return result = summ(number);
    }

    public static int add(String number1, String number2) throws SpliterFormatException {
        int num = 0;
        int result = 0;
        String delimiter = "";
        String number;
        String numbers[] = {number1, number2};

        for (int x = 0; x < 2; x++) {
            number = numbers[x];

            //проверка на null и пустую строку
            if (number == null || number.isEmpty()) {
                result += 0;
                break;
            }

            //проверка на длину строки больше 5
            if (number.length() > 5) {
                delimiter = number.substring(0, 2);

                if (delimiter.equals("//")) {
                    result += getResultWithDelimiter(number, delimiter);
                }
                else
                { number = spaceRemove(number);
                    number = separatorReplacement(number);
                    result += summ(number);
                }
            }
            else {
                number = spaceRemove(number);
                number = separatorReplacement(number);
                result += summ(number);
            }
        }
        return result;
    }

    public static int add(String number1, String number2, String number3) throws SpliterFormatException {
        int num = 0;
        int result = 0;
        String delimiter = "";
        String number;
        String numbers[] = {number1, number2, number3};

        for (int x = 0; x < 3; x++) {
            number = numbers[x];

            //проверка на null и пустую строку
            if (number == null || number.isEmpty()) {
                result += 0;
                break;
            }

            //проверка на длину строки больше 5
            if (number.length() > 5) {
                delimiter = number.substring(0, 2);

                if (delimiter.equals("//")) {
                    result += getResultWithDelimiter(number, delimiter);
                }
                else
                { number = spaceRemove(number);
                number = separatorReplacement(number);
                result += summ(number);
                }
            }
            else {
                number = spaceRemove(number);
                number = separatorReplacement(number);
                result += summ(number);
            }
        }
        return result;
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

    public static boolean isCorrectSeparator(String input, String delimiter) {
        String test;
        boolean flag;

        int index = input.indexOf("\n");
        if (index == -1) {
            index = input.indexOf("n");
        }

        test = input.substring(index + 1);
        test = test.replace(delimiter, ",");
        test = spaceRemove(test);

        Pattern pattern = Pattern.compile("[^0-9+^,]");
        Matcher matcher = pattern.matcher(test);

        if (matcher.find()) {
            return false;
        } else {
            return true;
        }
    }

    public static String useDelimiter(String input, String delimiter) {
        String value;
        int index = input.indexOf("\n") + 1;
        if (index == -1) {
            index = input.indexOf("n");
        }

        value = input.replace(delimiter, ",");
        value = value.substring(index);
        return value;
    }

    public static int getQuantitySeparator(String input) {
        int result = 0;
        String temp = null;
        int first = 0;
        int last = 0;

        int index = input.indexOf("\n") + 1;
        if (index == -1) {
            index = input.indexOf("n");
        }
        input = input.substring(2, index - 1);

        for (int x = 0; x < input.length(); x++) {
            temp = input.substring(x, x + 1);
            if (temp.equals("[")) {
                first++;
            }
            if (temp.equals("]")) {
                last++;
            }
            if (last == first) {
                result++;
            }
        }
        return result;
    }

    public static int getResultWithDelimiter(String number, String delimiter) throws SpliterFormatException {
        int result = 0;

        number = spaceRemove(number);

        int endDelimiter = number.indexOf("\n");
        if (endDelimiter == -1) {
            endDelimiter = number.indexOf("n");
        }

        String delimiter1 = number.substring(2, 3);
        String delimiter2 = number.substring(endDelimiter - 1, endDelimiter);

        if (delimiter1.equals("[") && delimiter2.equals("]")) {
            int separator = 1;
            String temp;
            if (getQuantitySeparator(number) == separator) {
                int index1 = number.indexOf(delimiter1);
                int index2 = number.indexOf(delimiter2);
                delimiter = number.substring(index1 + 1, index2);
                System.out.println("delimiter");
            } else {
                separator = getQuantitySeparator(number);
                temp = number.replace("[", "");
                String sep[] = new String[separator];
                temp = temp.substring(2, endDelimiter - 1);
                temp = spaceRemove(temp);
                sep = temp.split("]");
                number = number.substring(endDelimiter + 1);
                for (int x = 0; x < sep.length; x++) {
                    number = number.replace(sep[x], ",");
                }
                number = spaceRemove(number);
                number = separatorReplacement(number);
                return result += summ(number);
            }

        } else {
            delimiter = number.substring(2, 3);
        }
        if (isNumberSeparator(delimiter) || !isCorrectSeparator(number, delimiter)) {
            System.out.println("Разделитель" + number.substring(2, 4) + " указан не верно!");
            throw new SpliterFormatException("Наше исключение перехвачено");
        } else {
            int index;
            number = number.replace(delimiter, ",");
            index = number.indexOf("\n");
            if (index == -1) {
                index = number.indexOf("n");
            }
            number = number.substring(index + 1);
        }
        number = spaceRemove(number);
        number = separatorReplacement(number);
        return result += summ(number);
    }
}