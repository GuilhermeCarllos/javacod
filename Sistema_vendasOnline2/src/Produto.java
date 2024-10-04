import java.math.BigDecimal;

public class Produto {
    private int id;
    private String nome;
    private String descricao; // Atributo descricao
    private BigDecimal preco; // Usar BigDecimal para preço

    // Construtor padrão
    public Produto() {
        // Construtor sem parâmetros
    }

    // Construtor com parâmetros (incluindo descrição)
    public Produto(int id, String nome, String descricao, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Construtor sem descrição
    public Produto(int id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = ""; // Atribua uma descrição padrão, se necessário
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() { // Getter para descricao
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) { // Usar BigDecimal
        this.preco = preco;
    }

    public void setDescricao(String descricao) { // Setter para descricao
        this.descricao = descricao;
    }
}
