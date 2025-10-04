import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Classe Aluno
class Aluno implements Comparable<Aluno> {
    private String nome;
    private String matricula;
    private String dataNascimento;

    public Aluno(String nome, String matricula, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getDataNascimento() { return dataNascimento; }

    @Override
    public int compareTo(Aluno outro) {
        return this.nome.compareTo(outro.nome);
    }

    @Override
    public String toString() {
        return nome + ";" + matricula + ";" + dataNascimento;
    }
}

public class Principal {
    private static String[] nomes = {"Ana", "João", "Carlos", "Maria", "Pedro", "Juliana", "Lucas", "Fernanda"};
    private static String[] sobrenomes = {"Silva", "Souza", "Oliveira", "Costa", "Pereira", "Rodrigues", "Almeida", "Ferreira"};
    private static Random random = new Random();

    public static void main(String[] args) {
        int totalAlunos = 350000;
        int limiteExportacao = 50000; // exportar só até 50 mil registros

        List<Aluno> arrayList = new ArrayList<>();
        List<Aluno> linkedList = new LinkedList<>();
        List<Aluno> vectorList = new Vector<>();

        long[][] tempos = new long[3][3]; // [estrutura][operação]

        // Cadastro
        tempos[0][0] = cadastrarAlunos(arrayList, totalAlunos);
        tempos[1][0] = cadastrarAlunos(linkedList, totalAlunos);
        tempos[2][0] = cadastrarAlunos(vectorList, totalAlunos);

        // Ordenação
        tempos[0][1] = ordenarLista(arrayList);
        tempos[1][1] = ordenarLista(linkedList);
        tempos[2][1] = ordenarLista(vectorList);

        // Exportação (limitada a 50.000 registros)
        tempos[0][2] = exportarCSV(arrayList, "alunos_arraylist.csv", limiteExportacao);
        tempos[1][2] = exportarCSV(linkedList, "alunos_linkedlist.csv", limiteExportacao);
        tempos[2][2] = exportarCSV(vectorList, "alunos_vector.csv", limiteExportacao);

        // Mostrar resultados
        System.out.println("\n========= TEMPOS DE EXECUÇÃO (em ms) =========");
        System.out.printf("%-12s %-15s %-15s %-15s\n", "Operação", "ArrayList", "LinkedList", "Vector");
        System.out.printf("%-12s %-15d %-15d %-15d\n", "Cadastro", tempos[0][0], tempos[1][0], tempos[2][0]);
        System.out.printf("%-12s %-15d %-15d %-15d\n", "Ordenação", tempos[0][1], tempos[1][1], tempos[2][1]);
        System.out.printf("%-12s %-15d %-15d %-15d\n", "Exportação", tempos[0][2], tempos[1][2], tempos[2][2]);
    }

    private static Aluno gerarAluno() {
        String nome = nomes[random.nextInt(nomes.length)] + " " + sobrenomes[random.nextInt(sobrenomes.length)];
        String matricula = String.format("%05d", random.nextInt(100000));
        String dataNascimento = String.format("%02d/%02d/%04d",
                random.nextInt(28) + 1,
                random.nextInt(12) + 1,
                1980 + random.nextInt(20));
        return new Aluno(nome, matricula, dataNascimento);
    }

    private static long cadastrarAlunos(List<Aluno> lista, int total) {
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < total; i++) lista.add(gerarAluno());
        return System.currentTimeMillis() - inicio;
    }

    private static long ordenarLista(List<Aluno> lista) {
        long inicio = System.currentTimeMillis();
        Collections.sort(lista);
        return System.currentTimeMillis() - inicio;
    }

    private static long exportarCSV(List<Aluno> lista, String arquivo, int limite) {
        long inicio = System.currentTimeMillis();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write("Nome;Matricula;DataNascimento\n");
            int count = 0;
            for (Aluno a : lista) {
                if (count >= limite) break; // limita exportação
                writer.write(a.toString());
                writer.newLine();
                count++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao exportar CSV: " + e.getMessage());
        }
        return System.currentTimeMillis() - inicio;
    }
}
