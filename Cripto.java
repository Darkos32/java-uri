import java.util.Scanner;

public class Cripto {
    public static String move3(String s) {
        char[] novo = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                novo[i] = (char) ((int) c + 3);
            } else {
                novo[i] = c;
            }
        }

        return new String(novo);
    }

    public static String inverte(String s) {
        char[] novo = new char[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            novo[s.length() - 1 - i] = s.charAt(i);
        }
        return new String(novo);

    }

    public static String moveLeft(String s) {
        int metade = (int) Math.ceil(s.length() / 2);
        char[] novo = new char[s.length()];
        for(int i = 0; i<s.length();i++){
            if(i<metade){
                novo[i] =  s.charAt(i);
            }else{
                novo[i] = (char) ((int) s.charAt(i) - 1);
            }
        }
        return new String(novo);
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int tam = Integer.parseInt( ler.nextLine());
        String palavra;
        for (int i=0;i<tam;i++){
            palavra =  ler.nextLine();
            palavra = Cripto.move3(palavra);
            palavra = Cripto.inverte(palavra);
            palavra = Cripto.moveLeft(palavra);
            System.out.println(palavra);
        }
        ler.close();
    }
}
