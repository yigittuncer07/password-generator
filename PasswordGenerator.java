import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to password generator. Please pick at least one of the following 4 options (You can choose multiple)");
        boolean boo1 = true;
        while (boo1) {
            System.out.print("How long should your password be? (Minimum 4 digits): ");
            int length = scanner.nextInt();
            System.out.print("Should your password contain numbers? (1 for yes 0 for no): ");
            int a = scanner.nextInt();
            boolean isNum = a == 1;
            System.out.print("Should your password contain lowercase letters? (1 for yes 0 for no): ");
            int b = scanner.nextInt();
            boolean isLowLetter = b == 1;
            System.out.print("Should your password contain capital letters? (1 for yes 0 for no): ");
            int c = scanner.nextInt();
            boolean isCapLetter = c == 1;
            System.out.print("Should your password contain characters? (1 for yes 0 for no): ");
            int d = scanner.nextInt();
            boolean isChar = d == 1;
            if ((isChar || isCapLetter || isLowLetter || isNum) && length > 4) {
                System.out.println(generatePassword(length, isNum, isLowLetter, isCapLetter, isChar));
                boo1 = false;
            } else if (length < 4) {
                System.out.println("Please make your password longer than 4!");
            } else if (!(isChar || isCapLetter || isLowLetter || isNum)) {
                System.out.println("Please pick at least one!");
            }
        }
    }


    public static String generatePassword(int length, boolean isNum, boolean isLowLetter, boolean isCapLetter, boolean isChar) {
        int k = 0;
        if (isNum) {
            k++;
        }
        if (isLowLetter) {
            k++;
        }
        if (isCapLetter) {
            k++;
        }
        if (isChar) {
            k++;
        }
        char[] passwordArray = new char[length];
        for (int i = 0; i < length; i++) {
            if (k == 4) {
                double double1 = Math.random();
                if (double1 < 0.25) {
                    passwordArray[i] = numberGenerator();
                } else if ((0.25 < double1) && (double1 < 0.5)) {
                    passwordArray[i] = lowercaseLetterGenerator();
                } else if ((0.5 < double1) && (double1 < 0.75)) {
                    passwordArray[i] = upperLetterGenerator();
                } else if (0.75 < double1) {
                    passwordArray[i] = charGenerator();
                }
            } else if (k == 3) {
                double double1 = Math.random();
                if (!isNum) {
                    if (double1 < (1.0 / 3)) {
                        passwordArray[i] = charGenerator();
                    } else if (((1.0 / 3) < double1) && (double1 < (2.0 / 3))) {
                        passwordArray[i] = lowercaseLetterGenerator();
                    } else if (double1 > (2.0 / 3)) {
                        passwordArray[i] = upperLetterGenerator();
                    }
                }
                if (!isLowLetter) {
                    if (double1 < (1.0 / 3)) {
                        passwordArray[i] = charGenerator();
                    } else if (((1.0 / 3) < double1) && (double1 < (2.0 / 3))) {
                        passwordArray[i] = numberGenerator();
                    } else if (double1 > (2.0 / 3)) {
                        passwordArray[i] = upperLetterGenerator();
                    }
                }
                if (!isCapLetter) {
                    if (double1 < (1.0 / 3)) {
                        passwordArray[i] = charGenerator();
                    } else if (((1.0 / 3) < double1) && (double1 < (2.0 / 3))) {
                        passwordArray[i] = lowercaseLetterGenerator();
                    } else if (double1 > (2.0 / 3)) {
                        passwordArray[i] = numberGenerator();
                    }
                }
                if (!isChar) {
                    if (double1 < (1.0 / 3)) {
                        passwordArray[i] = numberGenerator();
                    } else if (((1.0 / 3) < double1) && (double1 < (2.0 / 3))) {
                        passwordArray[i] = lowercaseLetterGenerator();
                    } else if (double1 > (2.0 / 3)) {
                        passwordArray[i] = upperLetterGenerator();
                    }
                }
            }
            if (k == 2) {
                double double1 = Math.random();
                if (isCapLetter && isLowLetter) {
                    if (double1 < 0.5) {
                        passwordArray[i] = upperLetterGenerator();
                    } else {
                        passwordArray[i] = lowercaseLetterGenerator();
                    }
                } else if (isCapLetter && isChar) {
                    if (double1 < 0.5) {
                        passwordArray[i] = upperLetterGenerator();
                    } else {
                        passwordArray[i] = charGenerator();
                    }
                } else if (isCapLetter && isNum) {
                    if (double1 < 0.5) {
                        passwordArray[i] = upperLetterGenerator();
                    } else {
                        passwordArray[i] = numberGenerator();
                    }
                } else if (isNum && isChar) {
                    if (double1 < 0.5) {
                        passwordArray[i] = numberGenerator();
                    } else {
                        passwordArray[i] = charGenerator();
                    }
                } else if (isNum && isLowLetter) {
                    if (double1 < 0.5) {
                        passwordArray[i] = numberGenerator();
                    } else {
                        passwordArray[i] = lowercaseLetterGenerator();
                    }
                } else if (isLowLetter && isChar) {
                    if (double1 < 0.5) {
                        passwordArray[i] = lowercaseLetterGenerator();
                    } else {
                        passwordArray[i] = charGenerator();
                    }
                }
            }
            if (k == 1) {
                if (isCapLetter) {
                    passwordArray[i] = upperLetterGenerator();
                } else if (isLowLetter) {
                    passwordArray[i] = lowercaseLetterGenerator();
                } else if (isChar) {
                    passwordArray[i] = charGenerator();
                } else if (isNum) {
                    passwordArray[i] = numberGenerator();
                }
            }
        }
        boolean boo1 = checker(passwordArray, isChar, isLowLetter, isCapLetter, isNum);
        if (!boo1){
            generatePassword(length,isNum,isLowLetter,isCapLetter,isChar);
        }
        return String.valueOf(passwordArray);
    }
    public static char numberGenerator() {
        return (char) (Math.random() * 10 + 48);
    }
    public static char lowercaseLetterGenerator() {
        return (char) (Math.random() * 25 + 97);
    }
    public static char upperLetterGenerator() {
        return (char) (Math.random() * 25 + 65);
    }
    public static char charGenerator() {
        char[] charArray = {'.',',','-','_'};
        int randomIndex = (int)(Math.random() * 4);
        return charArray[randomIndex];
    }
    public static boolean checker(char[] array,boolean isChar,boolean isLowLetter,boolean isCapLetter,boolean isNum){
        if (isNum) {
            if (!containsNumber(array)){
                return false;
            }
        }
        if (isLowLetter){
            if (!containsLowercaseLetter(array)){
                return false;
            }
        }
        if (isCapLetter){
            if (!containsUpperCaseLetter(array)){
                return false;
            }
        }
        if (isChar){
            return containsCharacter(array);
        }
        return true;
    }
    public static boolean containsNumber(char[] array){
        for (char c : array) {
            for (int k = 48; k < 58; k++) {
                if ((int) c == k) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsLowercaseLetter(char[] array){
        for (char c : array) {
            for (int k = 97; k < 123; k++) {
                if ((int) c == k) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsUpperCaseLetter(char[] array){
        for (char c : array) {
            for (int k = 65; k < 91; k++) {
                if ((int) c == k) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsCharacter(char[] array){
        for (char c : array) {
            if (c == '.') {
                return true;
            } else if (c == ',') {
                return true;
            } else if (c == '-') {
                return true;
            } else if (c == '_') {
                return true;
            }
        }
        return false;
    }
}
