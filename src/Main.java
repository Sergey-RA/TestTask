import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a Brackets: ");
            String str = in.next();
            System.out.println(validateBracket(str));
        }
    }

    /**
     * @param brackets to be validated
     * @return string with number of brackets and valid result
     */
    private static String validateBracket(String brackets) {
        ArrayList<Integer> numberOpenBracket = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {
                result.append(bracket);
                numberOpenBracket.add(result.length() - 1);
            } else if (numberOpenBracket.size() > 0 && bracket == ')') {
                result.append(bracket);
                numberOpenBracket.remove(numberOpenBracket.size() - 1);
            }
        }
        if (numberOpenBracket.size() > 0) {
            for (int i = numberOpenBracket.size() - 1; i >= 0; i--) {
                result.deleteCharAt(numberOpenBracket.get(i));
            }
        }
        return result.length() > 0 ? result.length() + " - " + result : "0";
    }

    @Test
    public void testValidateBracket() {
        assertEquals("2 - ()", validateBracket("(()"));
        assertEquals("4 - ()()", validateBracket(")()())"));
        assertEquals("6 - (()())", validateBracket(")(()())"));
        assertEquals("0", validateBracket(")("));
        assertEquals("10 - ()(()())()", validateBracket("())(()())(()"));

    }
}