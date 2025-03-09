import java.util.Random;

/** 
 * MIT License
 *
 * Copyright(c) 2024-255 João Caram <caram@pucminas.br>
 *                       Eveline Alonso Veloso
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class App {
    static int[] tamanhosTesteGrande =  { 125_000, 250_000, 500_000, 1_000_000, 2_000_000 };
    static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    static Random aleatorio = new Random(42);
    static long numOperacoes = 0;

    /**
     * Código de teste 1. Este método...
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo1(int[] vetor) {
        numOperacoes = 0;
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i]%2;
            numOperacoes++;
        }
        return resposta;
    }

    /**
     * Código de teste 2. Este método...
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */
    static int codigo2(int[] vetor) {
        numOperacoes = 0;
        int contador = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
                numOperacoes++;
            }

        }
        return contador;
    }

    /**
     * Código de teste 3. Este método...
     * @param vetor Vetor com dados para teste.
     */
    static void codigo3(int[] vetor) {
        numOperacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            numOperacoes++;
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                numOperacoes++;
                if (vetor[j] < vetor[menor])
                numOperacoes++;
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
        }
    }

    /**
     * Código de teste 4 (recursivo). Este método...
     * @param n Ponto inicial do algoritmo
     * @return Um inteiro que significa...
     */
    static int codigo4(int n) {
        numOperacoes++;
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
        
    }
    public static void main(String[] args) {
        // Algoritmo 1 - Tamanhos Teste Grande
        System.out.println("Algoritmo 1:");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            long inicioNano = System.nanoTime();
            codigo1(vetor);
            long tempoExecucao = System.nanoTime() - inicioNano;
            System.out.println("Entrada: " + tamanho + " | Operações: " + numOperacoes + " | Tempo: " + tempoExecucao + " ns");
        }
        System.out.println();
        
        // Algoritmo 2 - Tamanhos Teste Grande
        System.out.println("Algoritmo 2:");
        for (int tamanho : tamanhosTesteGrande) {
            int[] vetor = gerarVetor(tamanho);
            long inicioNano = System.nanoTime();
            codigo2(vetor);
            long tempoExecucao = System.nanoTime() - inicioNano;
            System.out.println("Entrada: " + tamanho + " | Operações: " + numOperacoes + " | Tempo: " + tempoExecucao + " ns");
        }
        System.out.println();
        
        // Algoritmo 3 - Tamanhos Teste Médio
        System.out.println("Algoritmo 3:");
        for (int tamanho : tamanhosTesteMedio) {
            int[] vetor = gerarVetor(tamanho);
            long inicioNano = System.nanoTime();
            codigo3(vetor);
            long tempoExecucao = System.nanoTime() - inicioNano;
            System.out.println("Entrada: " + tamanho + " | Operações: " + numOperacoes + " | Tempo: " + tempoExecucao + " ns");
        }
        System.out.println();
        
        // Algoritmo 4 - Tamanhos Teste Pequeno
        System.out.println("Algoritmo 4:");
        for (int n : tamanhosTestePequeno) {
            numOperacoes = 0;
            long inicioNano = System.nanoTime();
            codigo4(n);
            long tempoExecucao = System.nanoTime() - inicioNano;
            System.out.println("Entrada: " + n + " | Operações: " + numOperacoes + " | Tempo: " + tempoExecucao + " ns");
        }
    }
}
