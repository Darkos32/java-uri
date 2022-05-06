import java.util.Scanner;

class Lista {
    private Object[] vetor;
    private int tamanho;
    private int prox;// proximo a ser inserido
    private int nElementos;

    public boolean isDisponivel() {
        return nElementos == tamanho ? false : true;
    }

    public void setProx() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == null) {
                prox = i;
                return;
            }
        }

    }

    public int insere(Object elemento) {
        this.setProx();
        vetor[prox] = elemento;
        nElementos += 1;
        return prox;
    }

    public void remove(int pos) {
        vetor[pos] = null;
        nElementos -= 1;
    }

    public Object acessa(int pos) {
        return vetor[pos];
    }

    public boolean isVazio(){
        return nElementos==0?true:false;
    }

    Lista(int tam) {
        nElementos = 0;
        prox = 0;
        tamanho = tam;
        vetor = new Object[tam];
    }

}

class Fila {
    private Object[] vetor;
    private int inicio;// começo da fila
    private int tamanho;
    private int prox;

    public Object tirar() {
        Object hold = vetor[inicio];
        inicio = inicio+1;
        return hold;
    }

    public void insere(Object o) {
        vetor[prox] = o;
        prox += 1;

    }

    public boolean isVazio() {
        return inicio == tamanho? true : false;
    }

    Fila(int tam) {
        tamanho = tam;
        vetor = new Object[tamanho];
        inicio = 0;
    }
}

class Cliente {
    private int nItens;

    public int getnItens() {
        return nItens;
    }

    Cliente(int itens) {
        nItens = itens;
    }
}

class Caixa {
    private int itensPorMinuto;
    private int tempoProcesso;
    private int id;

    public void setTempoProcesso(int nItens) {
        this.tempoProcesso = itensPorMinuto * nItens;
    }

    public int getId() {
        return id;
    }

    public int getItensPorMinuto() {
        return itensPorMinuto;
    }

    public void processo(int menorTempo) {
        tempoProcesso -= menorTempo;
    }

    public boolean isTerminado() {
        return tempoProcesso <= 0 ? true : false;
    }

    Caixa(int itens) {
        itensPorMinuto = itens;
    }
}

public class Mercado {
    public static int[] parseEntrada(String s) {
        String[] partes = s.split(" ");
        int[] numerosArray = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            numerosArray[i] = Integer.parseInt(partes[i]);
        }
        return numerosArray;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int menorTempo=0,tempo = 0;
        int[] clientesCaixas = Mercado.parseEntrada(ler.nextLine());
        int[] caixasInfo = Mercado.parseEntrada(ler.nextLine());
        int[] clientesInfo = Mercado.parseEntrada(ler.nextLine());
        Fila filaCliente = new Fila(clientesCaixas[1]);
        Lista caixasEmUso = new Lista(clientesCaixas[0]);
        Caixa[] caixas = new Caixa[clientesCaixas[0]];
        for (int i = 0; i < clientesCaixas[1]; i++) {
            Cliente cliente = new Cliente(clientesInfo[i]);
            filaCliente.insere(cliente);
        }
        for (int i = 0; i < clientesCaixas[0]; i++) {
            caixas[i] = new Caixa(caixasInfo[i]);
            if (i == 0) {
                menorTempo = caixas[i].getItensPorMinuto();
            } else if (caixas[i].getItensPorMinuto() < menorTempo) {
                menorTempo = caixas[i].getItensPorMinuto();
            }
        }
        do {
            while (caixasEmUso.isDisponivel()&& !filaCliente.isVazio()) {
                Cliente temp = (Cliente) filaCliente.tirar();
                int i = caixasEmUso.insere((Object) temp);
                caixas[i].setTempoProcesso(temp.getnItens());
            }
            for (int index = 0; index < clientesCaixas[0]; index++) {
                Cliente temp = (Cliente) caixasEmUso.acessa(index);
                if (temp != null) {
                    caixas[index].processo(menorTempo);
                    if (caixas[index].isTerminado()) {
                        caixasEmUso.remove(index);
                    }
                }
            }
            tempo += menorTempo;
        } while (!filaCliente.isVazio()||!caixasEmUso.isVazio());
         
        System.out.println(tempo);
        ler.close();
    }
}

    
    
        
        
            
            
                
            
        
    




