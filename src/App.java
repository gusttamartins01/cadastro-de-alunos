import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static final Scanner scanner = new Scanner(System.in);
    static final List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            mostrarMenu();
            opcao = lerInt("Digite: ");

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> lancarNotas();
                case 4 -> statusAluno();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println();
        }


    }

    // ======= Menu =======
    static void mostrarMenu() {
        System.out.println("======================");
        System.out.println("|    MENU PRINCIPAL   |");
        System.out.println("======================");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Lançar notas");
        System.out.println("4 - Status do aluno");
        System.out.println("0 - Sair");
    }

    // ======= Opções =======
    static void cadastrarAluno() {
        String nome = lerLinha("Nome do aluno: ");
        String matricula = lerLinha("Matrícula: ");
        alunos.add(new Aluno(nome, matricula));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : alunos) System.out.println(a);
    }

    static void lancarNotas() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        String mat = lerLinha("Matrícula do aluno: ");
        Aluno a = encontrarPorMatricula(mat);
        if (a == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        Double n1 = lerDoubleFlex("Nota 1 (use 7,5 ou 7.5): ");
        Double n2 = lerDoubleFlex("Nota 2 (use 7,5 ou 7.5): ");
        Double n3 = lerDoubleFlex("Nota 3 (use 7,5 ou 7.5): ");
        a.setNotas(n1, n2, n3);
        System.out.println("Notas lançadas!");
    }

    static void statusAluno() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        String mat = lerLinha("Matrícula do aluno: ");
        Aluno a = encontrarPorMatricula(mat);
        if (a == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        System.out.println(a);
    }

    // ======= Utilitários =======
    static Aluno encontrarPorMatricula(String mat) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(mat)) return a;
        }
        return null;
    }

    static int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    // Aceita "7,5" ou "7.5"
    static double lerDoubleFlex(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número (ex: 7,5 ou 7.5).");
            }
        }
    }

    static String lerLinha(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}











