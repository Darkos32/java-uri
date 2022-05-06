import java.util.Scanner;
public class Obi {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n = Integer.parseInt(ler.nextLine());
        String frase = ler.nextLine();
        String[] vetor = frase.split(" ");
        for (int i = 0; i < n; i++) {
            if (vetor[i].length() == 3 && vetor[i].charAt(0) == 'U' && vetor[i].charAt(1) == 'R') {
                vetor[i] = "URI";
            }
            if (vetor[i].length() == 3 && vetor[i].charAt(0) == 'O' && vetor[i].charAt(1) == 'B') {
                vetor[i] = "OBI";
            }
        }
        frase = "";
        for (int i = 0; i < n; i++) {
            frase = i==0?vetor[i]:frase + " "+vetor[i];
        }
        System.out.println(frase);

        ler.close();
        
    }
}
