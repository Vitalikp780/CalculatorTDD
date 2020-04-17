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
        if (delimiter.equals("//")) {
            System.out.println("Разделитель" + number.substring(2, 4));
            System.out.println(number.indexOf("\n"));
        }

        Pattern pattern1 = Pattern.compile("[0-9]");
        String temp = number.substring(number.indexOf("\n") + 1);
        temp = temp.replace(number.substring(2, 3), "");
        Matcher matcher1 = pattern1.matcher(temp);
        System.out.println(temp);
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
                delimiter = number.substring(2, 3);
                if(isNumberSeparator(delimiter) || !isCorrectSeparator(number, delimiter)){
                    System.out.println("Разделитель" + number.substring(2, 4) + " указан не верно!");
                    throw new SpliterFormatException("Наше исключение перехвачено");
                }else {
                    int index = number.indexOf("\n");
                    if(index == -1){
                        index = number.indexOf("n");
                    }
                    number = number.replace(delimiter, ",");
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

        /*public static int add (String number) throws SpliterFormatException {
            int num = 0;
            int result = 0;
            String delimiter = "";

            if(number == null || number.isEmpty()) {
                result = 0;
                return result;
            }

            if(number.length()>3) {
                delimiter = number.substring(0, 2);
            }
            if(delimiter.equals("//")){
               // System.out.println("Разделитель" + number.substring(2,4));
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(number.substring(2,3));
                if(matcher.find()){
                        System.out.println("Разделитель" + number.substring(2,4));
                        throw new SpliterFormatException("Наше исключение перехвачено");
                }else {
                   // number = number.replace(number.substring(2,3), ",");
                    }

                String temp1 = number.substring(number.indexOf("\n")+1);
                String temp2 = temp1.replace(number.substring(2,3), ",");

                if(temp1.equals(temp2)){

                    if(number.contains(" ")){
                        number = number.replace(" ", "");
                    }

                    num = number.indexOf("\n");
                    if(num == -1){
                        num = number.indexOf("n");
                    }
                    number = number.replace(number.substring(0,++num), "");
                    System.out.println(number);


                    if(number.contains(",")) {
                        String numbers[] = number.split(",");
                        for(int x=0; x<numbers.length; x++){
                            if(Integer.parseInt(numbers[x]) > 1000){
                                continue;
                            }
                            result += Integer.parseInt(numbers[x]);
                        }
                        return result;
                    }

                    else{
                        result = Integer.parseInt(number);
                    }
                }

                else{
                    System.out.println("Разделитель" + number.substring(2,4) + " указан не верно!");
                    throw new SpliterFormatException("Наше исключение перехвачено");
                }


            }

            if(number.contains(" ")){
               number = number.replace(" ", "");
            }

            if(number.contains("\\n") || number.contains("\n")){
                number = number.replace("\\n", ",");
                number = number.replace("\n", ",");
            }

        if(number.contains(",")) {
                String numbers[] = number.split(",");
                for(int x=0; x<numbers.length; x++){
                    if(Integer.parseInt(numbers[x]) > 1000){
                        continue;
                    }
                    result += Integer.parseInt(numbers[x]);
                }
                return result;
            }

        else{
            result = Integer.parseInt(number);
            }
    return result;
        }*/


/*

 */












           /* Pattern pattern = Pattern.compile("[^0-9]");
            Matcher matcher = pattern.matcher(number);
            if(matcher.find()){
                String numbers[] = number.split(",");
                System.out.println("Contains symbols: " + number);
                for(int x=0; x < numbers.length; x++){
                    Pattern pattern1 = Pattern.compile("[0-9]");
                    Matcher matcher1 = pattern1.matcher(numbers[x]);
                    if(!matcher1.find() || numbers[x]==""){
                        continue;
                    }
                    else{
                        result += Integer.parseInt(numbers[x]);
                    }
                }
                return result;
            }*/



      /*          Pattern pattern1 = Pattern.compile("[0-9]");

                temp = temp.replace(number.substring(2,3), "");
                for()
                Pattern pattern1 = Pattern.compile("[0-9]");
                Matcher matcher1 = pattern1.matcher(number.substring(number.indexOf("\n")+1));
                if(matcher1.find()){
                    System.out.println("Разделитель" + number.substring(2,4));
                    throw new SpliterFormatException("Наше исключение перехвачено");
                }*/

               /* Pattern pattern1 = Pattern.compile("[0-9]");
                String temp = number.substring(number.indexOf("\n")+1);
                temp = temp.replace(number.substring(2,3), "");
                Matcher matcher1 = pattern1.matcher(temp);
*/