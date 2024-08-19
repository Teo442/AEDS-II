import java.util.Scanner;

/**
 * @author Teo442
 */


public class Palindromo {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String palavra = sc.nextLine();
                if (palavra.equals("FIM")) {
                    break;
                }
                if (ePalindromo(palavra, 0, palavra.length() - 1)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }
    }

    public static boolean ePalindromo(String palavra, int i, int j) {
        if (i >= j) {
            return true; 
        }
        if (palavra.charAt(i) != palavra.charAt(j)) {
            return false; 
        }
        return ePalindromo(palavra, i + 1, j - 1); 
    }
}
