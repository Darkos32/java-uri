import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * main
 */
public class Main {

    public static void main(String[] args) {
        Map<String, Float> notas = new HashMap<String, Float>();
        notas.put("W", (float) 1);
        notas.put("H", (float) 0.5);
        notas.put("Q", (float) 0.25);
        notas.put("E", (float) 0.125);
        notas.put("S", (float) 1 / 16);
        notas.put("T", (float) 1 / 32);
        notas.put("X", (float) 1 / 64);
        Scanner ler = new Scanner(System.in);
        String linha ;
        boolean flag =false;
        int corretos = 0;
        while (ler.hasNextLine()){
            linha = ler.nextLine();
            if (linha.charAt(0) == '*') {
                break;
            }
            float tempo = 0;
            for (int i = 1; i < linha.length(); i++) {
               
                if (linha.charAt(i) != '/') {
                    float hold = notas.get(String.valueOf(linha.charAt(i)));
                    tempo += hold;
                    //System.out.println(tempo);
                    if (tempo == 1 && !flag) {
                        corretos += 1;
                        flag = true;
                    }

                } else {
                    tempo = 0;
                    flag = false;
                }
            }
            System.out.println(corretos);
            corretos =  0;
            
        }

        ler.close();    
    }

}