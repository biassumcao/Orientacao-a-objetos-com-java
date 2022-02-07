import java.io.*;
public class Criptography {

    public static void criptografar(String sourcePath, String destinationPath, int k) throws IOException{
        File novoArquivo = new File(destinationPath);
        File arquivo = new File(sourcePath);
        String [] textoCriptografado = new String[10]; //texto total criptografado
        String cripto = "";                            //linha criptografada
        int j = 0;

        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter(novoArquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);

        while (br.ready()) { //le e criptografa texto
            String linha = br.readLine();
            for (int i = 0; i < linha.length(); i++) {
                cripto += (char) (((int) linha.charAt(i)) + k);
            }
            textoCriptografado[j++] = cripto;
            cripto = "";
        }

        br.close();
        fr.close();

        for (int i = 0; i < j; i++) {
            bw.write(textoCriptografado[i]);
            bw.newLine();
        }

        bw.close();
        fw.close();
    }

    public static void main(String[] args) throws IOException{
        criptografar("C:\\Users\\User\\Desktop\\excel\\teste.txt", "C:\\Users\\User\\Desktop\\excel\\dest.txt",1); //sample input
    }

}
