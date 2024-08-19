import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Teo442
 */

public class SelectionSort{
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<String> entrada = new ArrayList<>();
            String line;
            
            while (!(line = sc.nextLine()).equals("FIM")) {
                entrada.add(line);
            }
            
            
            for (String input : entrada) {
                String[] numbersStr = input.split(";");
                int[] numbers = new int[numbersStr.length];
                
                for (int i = 0; i < numbersStr.length; i++) {
                    numbers[i] = Integer.parseInt(numbersStr[i]);
                }
                
                int comparacoes = select(numbers);
                
                for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i]);
                    if (i < numbers.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
                
                System.out.println("Comparacoes realizadas: " + comparacoes);
            }
        }
    }

    public static int select(int[] array) {
        int n = array.length;
        int comparacoes = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return comparacoes;
    }
}
