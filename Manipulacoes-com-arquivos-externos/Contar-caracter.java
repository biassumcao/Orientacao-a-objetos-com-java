import java.io.*;
import java.util.*;
public class Main {
    public static int countChar(char c, String path) throws IOException{
        int count = 0;
        FileInputStream stream = new FileInputStream(path);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        while(linha != null) {
            for (int i = 0; i < linha.length(); i++) {
                if(linha.charAt(i) == c){
                    count++;
                }
            }
            linha = br.readLine();
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String caminho = in.nextLine();
        char c = in.next().charAt(0);
        System.out.println(countChar(c, caminho));
    }
}