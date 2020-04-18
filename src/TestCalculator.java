import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {
        // Kata1
        @Test
        public void testNull() throws SpliterFormatException {
            String input = null;
            int result = Calculator.add(input);
            assertEquals(0, result);
        }

        @Test
        public void testEmpty() throws SpliterFormatException {
            String input = "";
            int result = Calculator.add(input);
            assertEquals(0, result);
        }

        @Test
        public void test01() throws SpliterFormatException {
            String input = "1";
            int result = Calculator.add(input);
            assertEquals(1, result);
        }

        @Test
        public void test02() throws SpliterFormatException {
            String input = "1,2";
            int result = Calculator.add(input);
            assertEquals(3, result);
        }

        @Test
        public void test03() throws SpliterFormatException {
            String input = "4,";
            int result = Calculator.add(input);
            assertEquals(4, result);
        }

    // Kata 2
    @Test
    public void test04() throws SpliterFormatException {
        String input = "1,2,3";
        int result = Calculator.add(input);
        assertEquals(6, result);
    }
    @Test
    public void test05() throws SpliterFormatException {
        String input = "1,1,1,1";
        int result = Calculator.add(input);
        assertEquals(4, result);
    }
    @Test
    public void test06() throws SpliterFormatException {
        String input = "  1 ,  2 ";
        int result = Calculator.add(input);
        assertEquals(3, result);
    }
    @Test
    public void test07() throws SpliterFormatException {
        String input = "11,22,33";
        int result = Calculator.add(input);
        assertEquals(66, result);
    }

    // Kata 3
    // Сделать так, чтобы метод add мог
    // обрабатывать новые линии между числами (дополнительно к запятой).
    // \n - дополнительный разделитель.
    @Test
    public void test08() throws SpliterFormatException {
        String input = "1 \\n2,3";
        int result = Calculator.add(input);
        assertEquals(6, result);
    }
    @Test
    public void test09() throws SpliterFormatException {
        String input = "4\\n5\\n6";
        int result = Calculator.add(input);
        assertEquals(15, result);
    }
    @Test
    public void test10() throws SpliterFormatException {
        String input = "77\\n";
        int result = Calculator.add(input);
        assertEquals(77, result);
    }

    /*Kata 4
	Числа больше, чем 1000 в исходной строке должны  игнорироваться.
	*/
    @Test
    public void test11() throws SpliterFormatException {
        String input = "1, 1001";
        int result = Calculator.add(input);
        assertEquals(1, result);
    }

    @Test
    public void test12() throws SpliterFormatException {
        String input = "1002 \n 2";
        int result = Calculator.add(input);
        assertEquals(2, result);
    }

    @Test
    public void test13() throws SpliterFormatException {
        String input = "1, 1000";
        int result = Calculator.add(input);
        assertEquals(1001, result);
    }

    @Test
    public void test14() throws SpliterFormatException {
        String input = "1000, 1000";
        int result = Calculator.add(input);
        assertEquals(2000, result);
    }

    @Test
    public void test15() throws SpliterFormatException {
        String input = "1001\n1001";
        int result = Calculator.add(input);
        assertEquals(0, result);
    }

    /*
		 * Kata 5
	Добавить поддержку различных разделителей.
	Начало строки будет содержать подстроку,
	которая выглядит следующим образом:
	"// [разделитель] \n [числа ...]"
	Разделитель не является обязательным.
	В качестве разделителя не должны использоваться цифры.
	В случае если в строке встречается символ, который не является
	цифрой или разделителем вывести сообщение об ошибке.
	Все существующие до этого сценарии должны оставаться рабочими.
		 */
    @Test
    public void test16() throws SpliterFormatException {
        String input = "//;\n1; 2";
        int result = Calculator.add(input);
        assertEquals(3, result);
    }
    @Test
    public void test17() throws SpliterFormatException {
        String input = "//* \\n2,3";
        int result = Calculator.add(input);
        assertEquals(5, result);
    }

    @Test
    public void test18() throws SpliterFormatException {
        String input = "//#\\n3# 4";
        int result = Calculator.add(input);
        assertEquals(7, result);
    }

    @Test(expected = SpliterFormatException.class)
    public  void  test19() throws SpliterFormatException {
        String input = "//1\n1 1 1";
        int result = Calculator.add(input);
    }

    @Test(expected = SpliterFormatException.class)
    public  void test20() throws SpliterFormatException{
        String input = "//;\n1#2";
        int result  = Calculator.add(input);
    }

    /* Kata 6
    Необходимо сделать чтобы разделители  между числами могли бы быть любой длины в следующем формате:
    "// [разделитель] \n".
     */
    @Test
    public void test21() throws SpliterFormatException{
        String input =  "//[***]\n1 *** 2 *** 3";
        int result = Calculator.add(input);
        assertEquals(6, result) ;
    }

    @Test
    public void test22() throws SpliterFormatException{
        String input = "//[xy]\n3xy4xy5xy8";
        int result = Calculator.add(input);
        assertEquals(20, result);
    }

    /*
    Kata 7
    Добавить возможность добавлять несколько разделителей.
    По шаблону: "// [delim1] [delim2] \n"
    Убедитесь, что программа может работать с несколькими разделителями разной длины (более одного символа).
     */
    @Test
    public void test23() throws SpliterFormatException{
        String input = "// [*] [%] \n1*2%3";
        int result = Calculator.add(input);
        assertEquals(6, result);
    }

    @Test
    public void test24() throws SpliterFormatException{
        String input = "// [&&] [|||] \n3|||2&&3";
        int result = Calculator.add(input);
        assertEquals(8, result);
    }


}
