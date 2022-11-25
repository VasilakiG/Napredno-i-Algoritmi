import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka
        int sum = 0;
        int product = 1;
        
        String [] pluses = expression.split("\\+");
        
        Stack<Integer> sumStack = new Stack<Integer>();

        for (int i = 0; i < pluses.length; i++) {
            product = 1;
            String [] asterisks = pluses[i].split("\\*");

            for (int j = 0; j < asterisks.length; j++) {
                product *= Integer.parseInt(asterisks[j]);
            }
            sumStack.push(product);
        }

        while(!sumStack.isEmpty()){
            sum += sumStack.pop();
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}



//               ==========BLOOPERS==========
//    int length = expression.length();
//    int []result = new int[length];
//
//    for (int i = 0; i < length; i++) {
//        result[i] = 1;
//    }
//
//    int sum = 0;
//    int product = 1;
//
//    for (int i = 0; i < length; i++) {
//        if (expression.charAt(i) == '+'){
//            for (int j = 0; j < i; j++) {
//                if(expression.charAt(j) != '*'){
//                      product *= expression.charAt(j);
//                }
//            }
//        }else{
//          sum += product;
//        }
//    }
//
//    return sum;
//
