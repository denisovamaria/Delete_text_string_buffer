import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String symbol;
        String str1 = null;
        System.out.println("Enter symbol to delete text between");
        symbol = in.nextLine();
        if (symbol.isEmpty()) {
            throw new IllegalArgumentException("You enter empty line");
        }
        if (symbol.length() != 1) {
            throw new IllegalArgumentException("You enter not a symbol");
        }

        try {
            System.out.println("Enter text (end with empty line)");
            str1 = in.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Keyboard reading error");
        } catch (NullPointerException e) {
            System.out.println("Empty line error");
        }
        String text1 = str1;
        int f = 0;
        while (!str1.isEmpty()) {
            str1 = in.nextLine();
            //text.concat(str1);
            text1 += str1;
        }
        StringBuffer text = new StringBuffer(text1);

        int openIndex;
        int closeIndex;
        switch (symbol) {
            case "(":
            case ")":
                f = 1;
                while (text.indexOf("(") != -1 && text.indexOf(")") != -1) {
                    openIndex = text.indexOf("(");
                    closeIndex = text.indexOf(")");
                    if (openIndex < closeIndex)
                        text.delete(openIndex, closeIndex + 1);
                    else
                        break;
                }
                break;

            case "[":
            case "]":
                f = 1;
                while (text.indexOf("[") != -1 && text.indexOf("]") != -1) {
                    openIndex = text.indexOf("[");
                    closeIndex = text.indexOf("]");
                    if (openIndex < closeIndex)
                        text.delete(openIndex, closeIndex + 1);
                    else
                        break;
                }
                break;

            case "<":
            case ">":
                f = 1;
                while (text.indexOf("<") != -1 && text.indexOf(">") != -1) {
                    openIndex = text.indexOf("<");
                    closeIndex = text.indexOf(">");
                    if (openIndex < closeIndex)
                        text.delete(openIndex, closeIndex + 1);
                    else
                        break;
                }
                break;

            case "{":
            case "}":
                f = 1;
                while (text.indexOf("{") != -1 && text.indexOf("}") != -1) {
                    openIndex = text.indexOf("{");
                    closeIndex = text.indexOf("}");
                    if (openIndex < closeIndex)
                        text.delete(openIndex, closeIndex + 1);
                    else
                        break;
                }
                break;

        }
        if (f == 0) {
            while (true) {
                openIndex = text.indexOf(symbol);
                if (openIndex == -1)
                    break;
                closeIndex = text.indexOf(symbol, openIndex + 1);
                if (closeIndex == -1)
                    break;
                text.delete(openIndex, closeIndex + 1);
            }
        }
        System.out.println(text);
    }
}