import java.util.Scanner;

public class Input {
    int digit1;
    int digit2;

    public String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String getSymbolForSplit(String inputString) throws Exception {
        String symbolForSplit = "";
        if (inputString.contains("+")) {
            symbolForSplit = "[+]";
        } else if (inputString.contains("-")) {
            symbolForSplit = "[-]";
        } else if (inputString.contains("*")) {
            symbolForSplit = "[*]";
        } else if (inputString.contains("/")) {
            symbolForSplit = "[/]";
        } else throw new Exception("это выражение не соответсвует условию");
        return symbolForSplit;
    }

    public String getSymbolForOperation(String inputString) throws Exception {
        String symbol = "";
        if (inputString.contains("+")) {
            symbol = "+";
        } else if (inputString.contains("-")) {
            symbol = "-";
        } else if (inputString.contains("*")) {
            symbol = "*";
        } else if (inputString.contains("/")) {
            symbol = "/";
        } else throw new Exception("это выражение не соответсвует условию");
        return symbol;
    }

    // проврка арабские цифры
    public Boolean isArabic(String input) {
        return (input.matches("[0-9]{1,2}") && (Integer.parseInt(input)) < 11);
    }

    public Boolean isRoman(String input) {
        return (input.matches("[IVXLCDM]{1,5}"));
    }

    public boolean isParamsCorrect(String digit1, String digit2) throws Exception {
        if ((isArabic(digit1) && isArabic(digit2)) || (isRoman(digit1) && isRoman(digit2))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isArabic(String[] digits) {
        return isArabic(digits[0]) && isArabic(digits[1]);
    }

    public boolean isRoman(String[] digits) {
        return isRoman(digits[0]) && isRoman(digits[1]);
    }

    public int getDigit1(String InputString, String symbol) throws Exception {
        String[] arr = InputString.split(symbol);
        boolean isCorrect = isParamsCorrect(arr[0], arr[1]);
        if (!isCorrect) {
            throw new Exception("используются одновременно разные системы счисления");
        }
        String digit = arr[0];
        if (isArabic(arr[0])) {
            if (arr.length < 3) {
            } else
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            if (Integer.parseInt(arr[0]) <= 10 && Integer.parseInt(arr[0]) > 0) {
                digit1 = Integer.parseInt(arr[0]);
            }
        } else if (isRoman(arr[0])) {
            digit1 = RomanNumbers.romanToArabic(digit);
        }

        return digit1;
    }

    public int getDigit2(String inputString, String symbol) throws Exception {
        String[] arr = inputString.split(symbol);
        boolean isCorrect = isParamsCorrect(arr[0], arr[1]);
        if (!isCorrect) {
            throw new Exception("используются одновременно разные системы счисления");
        }
        String digit = arr[1];
        if (isArabic(arr[1])) {
            if (arr.length < 3) {
            } else
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            if (Integer.parseInt(arr[1]) <= 10 && Integer.parseInt(arr[1]) > 0) {
                digit2 = Integer.parseInt(arr[1]);
            }
        } else if (isRoman(arr[1])) {
            digit2 = RomanNumbers.romanToArabic(digit);
        }
        return digit2;
    }
}