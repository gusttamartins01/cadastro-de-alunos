public class Aluno {
    private String nome;
    private String matricula;
    private Double nota1;
    private Double nota2;
    private Double nota3;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = null;
        this.nota2 = null;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }

    public void setNotas(Double n1, Double n2, Double n3) {
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }

    public Double calcularMedia() {
        if (nota1 == null || nota2 == null || nota3 == null) return null;
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public String getStatus() {
        Double media = calcularMedia();
        if (media == null) return "Notas não lançadas";
        return media >= 7.0 ? "Aprovado" : "Reprovado";
    }

    @Override
    public String toString() {
        Double media = calcularMedia();
        String mediaStr = (media == null) ? "N/A" : String.format("%.2f", media);
        return "Nome: " + nome +
               " | Matrícula: " + matricula +
               " | Média: " + mediaStr +
               " | Status: " + getStatus();
    }
}
