import java.util.Scanner;

/**
 * @author Teo442
 */


public class AlgebraBooleana {

    public static int evaluateExpression(String expression, int[] values) {
     
        for (int i = 0; i < values.length; i++) {
            char var = (char) ('A' + i); 
            expression = expression.replace(Character.toString(var), Integer.toString(values[i]));
        }
        return evaluate(expression.trim());
    }

    private static int evaluate(String expr) {
        expr = expr.trim();

     
        if (expr.equals("1")) {
            return 1;
        }
        if (expr.equals("0")) {
            return 0;
        }

    
        if (expr.startsWith("not(")) {
            return 1 - evaluate(expr.substring(4, expr.length() - 1));
        }

    
        if (expr.startsWith("and(")) {
            String innerExpr = expr.substring(4, expr.length() - 1);
            String[] parts = splitExpression(innerExpr);
            return evaluate(parts[0].trim()) & evaluate(parts[1].trim());
        }

        // Operação OR
        if (expr.startsWith("or(")) {
            String innerExpr = expr.substring(3, expr.length() - 1);
            String[] parts = splitExpression(innerExpr);
            return evaluate(parts[0].trim()) | evaluate(parts[1].trim());
        }

        throw new IllegalArgumentException("Expressão inválida: " + expr);
    }

    private static String[] splitExpression(String expr) {
        int parenCount = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') parenCount++;
            if (c == ')') parenCount--;
            if (c == ',' && parenCount == 0) {
                return new String[] { expr.substring(0, i), expr.substring(i + 1) };
            }
        }
        return new String[] { expr };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int n = Integer.parseInt(parts[0]);
                int[] values = new int[n];
                
                for (int i = 0; i < n; i++) {
                    values[i] = Integer.parseInt(parts[i + 1]);
                }
                
                String expression = line.substring(line.indexOf(parts[n + 1]));
                int result = evaluateExpression(expression, values);
                System.out.println(result);
            }
        }
    }
}
