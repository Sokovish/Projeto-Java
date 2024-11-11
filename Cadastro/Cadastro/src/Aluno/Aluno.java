public class Aluno {
    private String nome;
    private boolean presente;

    public Aluno(String nome) {
        this.nome = nome;
        this.presente = false; // Inicialmente o aluno não está presente
    }

    public String getNome() {
        return nome;
    }

    public void marcarPresenca() {
        this.presente = true; // Marca o aluno como presente
    }

    public void removerPresenca() {
        this.presente = false; // Marca o aluno como ausente
    }

    public boolean isPresente() {
        return presente;
    }
}
