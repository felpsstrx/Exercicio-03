package AlimentosSA;

public class Alimento {
    private String titulo;
    private float preco;
    private String descricao;

    public Alimento(String titulo, float preco, String descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
