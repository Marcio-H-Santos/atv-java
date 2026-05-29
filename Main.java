import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;
    double peso, altura;
}

public class Main {

    public static int buscarPorNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nome)) { 
                return i;
            }
        }
        return -1;
    }

    public static double calcularIMC(Pessoa p) {
        return p.peso / (p.altura * p.altura);
    }

    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("Erro: Vetor cheio. Não é possível cadastrar.");
            return qtd;
        }
        
        Scanner teclado = new Scanner(System.in);
        v[qtd] = new Pessoa();
        String nomeDigitado;
        do {
            System.out.print("Digite o nome: ");
            nomeDigitado = teclado.nextLine();
            if (buscarPorNome(v, qtd, nomeDigitado) != -1) {
                System.out.println("Nome já cadastrado! Tente outro.");
            }
        } while (buscarPorNome(v, qtd, nomeDigitado) != -1);

        v[qtd].nome = nomeDigitado;

        System.out.print("Digite la idade: ");
        v[qtd].idade = teclado.nextInt();
        System.out.print("Digite o peso: ");
        v[qtd].peso = teclado.nextDouble();
        System.out.print("Digite a altura: ");
        v[qtd].altura = teclado.nextDouble();

        return qtd + 1;
    }

    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i]); 
            System.out.printf("Nome: %s | Idade: %d | Peso: %.2f | Altura: %.2f | IMC: %.2f\n", 
                    v[i].nome, v[i].idade, v[i].peso, v[i].altura, imc);
        }
    }

    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {
        int indiceMaisVelha = -1;
        int maiorIdade = -1;

        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i]);
            
            if (imc < 18.5) {
                if (v[i].idade > maiorIdade) {
                    maiorIdade = v[i].idade;
                    indiceMaisVelha = i;
                }
            }
        }
        return indiceMaisVelha;
    }

    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i < qtd; i++) {
            Pessoa chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].nome.compareToIgnoreCase(chave.nome) > 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    public static int contarContatos(Pessoa[] v, int qtd, int idadeAlvo) {
        int total = 0;
        for (int i = 0; i < qtd; i++) {
            if (v[i].idade == idadeAlvo) {
                total++;
            }
        }
        return total;
    }
}