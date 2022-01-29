import java.util.*;
public class Main {
    public static int contarPrimos(int numIntervalo, int numThreads) throws InterruptedException {
        MyThread [] t = new MyThread[numThreads];
        int primosTotais = 0;

        int tam = numIntervalo / numThreads; //tamanho do subintervalo
        int cont = 2; 

        for (int i = 0; i < numThreads; i++) {
            if(i == numThreads - 1){
                t[i] = new MyThread(cont, numIntervalo, "t"+i);
            }else{
                int subIntervalo = cont + tam -1;
                t[i] = new MyThread(cont, subIntervalo, "t"+i);
            }
            cont += tam;
        }

        for (int i = 0; i < numThreads; i++) {
            t[i].join();
        }

        for (int i = 0; i < numThreads; i++) {
            primosTotais += t[i].getNumPrimos();
        }
        return primosTotais + 1;  //pois a thread verifica a partir sempre do num 2, mas 1 tbm é primo
    }

    public static void main(String[] args) throws InterruptedException {
        int n, numThreads;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o intervalo: ");
        n = ler.nextInt();
        System.out.println("Digite a quantidade de threads a serem usadas: ");
        numThreads = ler.nextInt();

        System.out.println(contarPrimos(n, numThreads));
    }
}
