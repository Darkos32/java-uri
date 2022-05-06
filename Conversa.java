import java.util.Scanner;
public class Conversa {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String idioma="", temp="";
        boolean flag = false;
        int n = Integer.parseInt(ler.nextLine()),k;
        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(ler.nextLine());
            for (int j = 0; j < k; j++) {
                temp = ler.nextLine();
                if(j==0){
                    idioma = temp;
                }
                if (!idioma.equals(temp)) {
                    
                    flag = true;
                }
            }
            if(!flag){
                System.out.println(temp);
            }else{
                System.out.println("ingles");
            }
            flag = false;
        }
        ler.close();
    }
}