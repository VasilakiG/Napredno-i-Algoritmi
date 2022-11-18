import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXML {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String [] redovi = new String[n];

        for(int i=0;i<n;i++)
            redovi[i] = br.readLine();

        int valid = 0;
        boolean error = false;


        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(redovi[i].charAt(0) == '['
                    && redovi[i].charAt(redovi[i].length()-1) == ']'){

                if(redovi[i].charAt(1) != '/'){
                    stack.push(redovi[i]);
                }else{
                    if(stack.pop()
                            .substring(1)
                            .compareTo(redovi[i]
                                    .substring(2)) != 0){
                        error = true;
                        break;
                    }
                }
            }
        }

        if(!error){
            valid = stack.isEmpty()? 1 : 0;
        }

        System.out.println(valid);

        br.close();
    }
}