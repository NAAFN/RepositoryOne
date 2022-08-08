import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        Input input = new Input();
        String inputString = input.getInputString().toUpperCase(Locale.ROOT); // сканер
        String symbolForSplit = input.getSymbolForSplit(inputString); // отдельный метод для разделителя в массиве, так как split не работал с + и *
        boolean outputArabic = input.isArabic(inputString.split(symbolForSplit)); //
        boolean outputRoman = input.isRoman(inputString.split(symbolForSplit));
        String symbolForOperation = input.getSymbolForOperation(inputString);
        int digit1 = input.getDigit1(inputString, symbolForSplit);
        int digit2 = input.getDigit2(inputString, symbolForSplit);
        int result = getResult(digit1, digit2, symbolForOperation);

        if (outputArabic) {
            printResult(String.valueOf(result));
        } else if (outputRoman && result > 0) {
            printResult(RomanNumbers.arabicToRoman(result));
        } else {
            throw new Exception("в римской системе нет отрицательных чисел");
        }
    }

    public static Integer getResult(int digit1, int digit2, String symbol) throws Exception {
        int result = 0;
        switch (symbol) {
            case "-":
                result = digit1 - digit2;
                break;
            case "+":
                result = digit1 + digit2;
                break;
            case "/":
                result = digit1 / digit2;
                break;
            case "*":
                result = digit1 * digit2;
                break;
            default:
                throw new Exception("строка не является математической операцией");
        }
        return result;
    }

    public static void printResult(String value) {
        System.out.println(value);
    }
}