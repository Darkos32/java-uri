import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Assinatura {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n_alunos,n_classe;

        while (true) {
            int count = 0;
            n_alunos = Integer.parseInt(ler.nextLine().split(" ")[0]);
            if (n_alunos == 0) {
                break;
            }
            Map<String, String> original = new HashMap<String, String>();
            for (int i = 0; i < n_alunos; i++) {
                String[] temp = ler.nextLine().split(" ");
                original.put(temp[0], temp[1]);
            }
            n_classe = Integer.parseInt(ler.nextLine().split(" ")[0]);
            for (int i = 0; i < n_classe; i++) {
                String[] temp = ler.nextLine().split(" ");
                String assinatura = original.get(temp[0]);
                int c = 0;
                for (int j = 0; j < temp[0].length(); j++) {
                    if (assinatura.charAt(j) != temp[1].charAt(j)) {
                        c += 1;
                    }
                    if (c == 2) {
                        count += 1;
                        break;
                    }
                }
            }
            System.out.println(count);

        }
        ler.close();
    }
}
