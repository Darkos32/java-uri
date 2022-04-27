import java.util.Scanner;

public class Alfabeto {
    public static void esvaziar(boolean[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = false;
        }
    }

    public static int contar(boolean[] vetor) {
        int count = 0;
        for (boolean b : vetor) {
            if (b) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        boolean alfabeto[] = new boolean[26];
        Scanner ler = new Scanner(System.in);
        int tam = ler.nextInt();
        String frase,msg;
        int n_letras;
        for (int i = 0; i < tam; i++) {
            Alfabeto.esvaziar(alfabeto);
            frase = ler.nextLine();
            for (int j = 0; j < frase.length(); j++) {
                char letra = frase.charAt(j);
                if (Character.isLetter(letra)) {
                    int pos = (int) letra - 97;
                    alfabeto[pos] = true;    
                }
            }
            n_letras = Alfabeto.contar(alfabeto);
            if ( n_letras== 26) {
                msg = "frase completa";
            } else if (n_letras >= 13) {
                msg = "frase quase completa";
            } else {
                msg = "frase mal elaborada";
            }
            if (i == tam - 1) {
                System.out.print(msg);
            } else {
                System.out.println(msg);
            }
        }
        ler.close();
    }
}
