import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Noel {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String pais;
        Map<String, String> tradutor = new HashMap<String, String>();
        tradutor.put("brasil", "Feliz Natal!");
        tradutor.put("alemanha", "Frohliche Weihnachten!");
        tradutor.put("austria", "Frohe Weihnacht!");
        tradutor.put("coreia", "Chuk Sung Tan!");
        tradutor.put("espanha", "Feliz Navidad!");
        tradutor.put("grecia", "Kala Christougena!");
        tradutor.put("estados-unidos", "Merry Christmas!");
        tradutor.put("inglaterra", "Merry Christmas!");
        tradutor.put("australia", "Merry Christmas!");
        tradutor.put("portugal", "Feliz Natal!");
        tradutor.put("suecia", "God Jul!");
        tradutor.put("turquia", "Mutlu Noeller");
        tradutor.put("argentina", "Feliz Navidad!");
        tradutor.put("chile", "Feliz Navidad!");
        tradutor.put("mexico", "Feliz Navidad!");
        tradutor.put("antardida", "Merry Christmas!");
        tradutor.put("canada", "Merry Christmas!");
        tradutor.put("irlanda", "Nollaig Shona Dhuit!");
        tradutor.put("belgica", "Zalig Kerstfeest!");
        tradutor.put("italia", "Buon Natale!");
        tradutor.put("libia", "Buon Natale!");
        tradutor.put("siria", "Milad Mubarak!");
        tradutor.put("marrocos", "Milad Mubarak!");
        tradutor.put("japao", "Merii Kurisumasu!");
        while(ler.hasNextLine()){
            pais = ler.nextLine();
            if (tradutor.containsKey(pais)){
                System.out.println(tradutor.get(pais));
            } else {
                System.out.println("--- NOT FOUND ---");
            }
        }
        ler.close();
    }
   
}
