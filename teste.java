class T {
    public int id;
    T(int ident){
        id = ident;
    }    
}
public class teste {
    public static void main(String[] args) {
        T teste  = new T(0);
        Object hold = (Object) teste;
        T novo = (T) hold;
        System.out.println(novo.id);
    }
}
