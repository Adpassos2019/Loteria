package loteria;

import java.util.Random;
import java.util.Scanner;

public class Loteria {

    public static void main(String[] args) {
        int[] valores = new int[]{0, 0, 0, 0, 0, 0};
        imprimeVetor(valores);
//        int[] valores2;
//        valores2 = new int[6];
//        valores2[0] = 0;
//        valores2[1] = 0;
//        valores2[2] = 0;
//        valores2[3] = 0;
//        valores2[4] = 0;
//        valores2[5] = 0;
//Pedir numero para usuarios
        Scanner in = new Scanner(System.in);
        System.out.println("Digite 6 numeros");
        for (int i = 0; i < 6; i++) {
            int num = -1;
            while (num == -1) {
                num = capNum(in, i);
                for (int j = 0; j < i; j++) {
                    if (valores[j] == num) {
                        num = -1;
                        //break;
                    }
                }
            }
            valores[i] = num;
            imprimeVetor(valores);
        }
//Sortear os numeros aleatorios        
        Random r = new Random();
        int[] bolas = new int[]{0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 6; i++) {
            int bola = -1;
            do {
                bola = (r.nextInt(60) + 1);
                for (int j = 0; j < i; j++) {
                    if (bolas[j] == bola) {
                        bola = -1;
                        break;
                    }
                }
            } while (bola == -1);

            bolas[i] = bola;
            imprimeVetor(bolas);
        }
//Comparar resultados
        int nrAcertos = 0;
        int nrErros = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (valores[i] == bolas[j]) {
                    nrAcertos++;
                    break;
                } else {
                    nrErros++;
                    break;
                }

            }

        }
        System.out.println("Quantidade acertos " + nrAcertos + "\nQuantidade erros " + nrErros);
    }

    public static int capNum(Scanner in, int i) {
        System.out.println("Digite o " + (i + 1) + "º numero");
        int num = in.nextInt();
        if (num >= 1 && num <= 60) {
            return num;
        } else {
            return -1;
        }
    }

    public static void imprimeVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + " ");
        }
        System.out.println("");
    }
}
