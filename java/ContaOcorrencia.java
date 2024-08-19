import java.util.Scanner;

/**
 * @author Teo442
 */


public class ContaOcorrencia {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                if (linha.equals("FIM")) {
                    break;
                }
                String[] numerosStr = linha.split(";");
                int[] vetor = new int[numerosStr.length];
                
                for (int i = 0; i < numerosStr.length; i++) {
                    vetor[i] = Integer.parseInt(numerosStr[i]);
                }
                
                int x = Integer.parseInt(sc.nextLine());
                int ocorrencias = contadorOc(vetor, vetor.length, x, 0);
                System.out.println(ocorrencias);
            }
        }
    }

    public static int contadorOc(int[] vetor, int n, int x, int i) {
        if (i == n) {
            return 0; 
        }
        if (vetor[i] == x) {
            return 1 + contadorOc(vetor, n, x, i + 1); 
        } else {
            return contadorOc(vetor, n, x, i + 1); 
        }
    }
}
