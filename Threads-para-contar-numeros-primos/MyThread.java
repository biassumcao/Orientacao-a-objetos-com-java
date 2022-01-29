public class MyThread extends Thread{
    private int ini;
    private int fim;
    private int numPrimos = 0;
    private String nome;

    public MyThread(int ini, int fim, String nome) {
        this.ini = ini;
        this.fim = fim;
        this.nome = nome;
        start();
    }

    public void run(){
        int divisores = 1;
        for (int i = ini; i <= fim; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    divisores++;
                }
            }
            if(divisores == 2){
                numPrimos++;
            }
            divisores = 1;
        }
    }

    public int getNumPrimos() {
        return numPrimos;
    }
}
