import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * PilhaV2
 */
class PilhaV2 {
    private int[] vetor;
    private int[] descartados;
    private int base;
    private int nElementos;
    private int tamanho;
    private int proxDescartados;

    private void moveLeft() {
        for (int index = 0; index < base; index++) {
            vetor[index] = index != tamanho - 1 ? vetor[index + 1] : vetor[index];
        }

    }

    public void descarta() {

        descartados[proxDescartados] = vetor[0];
        proxDescartados += 1;
        this.moveLeft();
        base -= 1;
        nElementos -= 1;

    }

    public void moveBase() {

        vetor[base] = vetor[0];
        this.moveLeft();
    }

    public int GetNElementos() {
        return nElementos;
    }

    public int[] getDescartados() {
        return descartados;
    }

    public int getRemaining() {
        return tamanho==1? vetor[0]:vetor[base];
    }

    PilhaV2(int tam) {
        tamanho = tam;
        vetor = new int[tamanho];
        descartados = new int[tamanho];
        base = tamanho;
        nElementos = tamanho;
        proxDescartados = 0;
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
    }

}

public class CardStackV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int tam;
        while (true) {
            tam = Integer.parseInt(reader.readLine());
            if (tam == 0) {
                break;
            }
            PilhaV2 p = new PilhaV2(tam);
            while (p.GetNElementos() > 1) {
                p.descarta();
                p.moveBase();
            }
            writer.write("Discarded cards:");
            int[] descarte = p.getDescartados();
            for (int i = 0; i < tam - 1; i++) {
                if (i == tam - 2) {
                    writer.write(" " + Integer.toString(descarte[i]));
                } else {
                    writer.write(" " + Integer.toString(descarte[i]) + ",");
                }
                
            }
            writer.write("\n");
            writer.write("Remaining card: " + Integer.toString(p.getRemaining())+"\n");
            writer.flush();
            
        }
        writer.close();
       
    }
}