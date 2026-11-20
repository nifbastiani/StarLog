package br.com.starlog.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this(null, nome, preco, estoque);
    }

    public Produto(Long id, String nome, double preco, int estoque) {
        if(nome == null || nome.trim().length() < 3){
            throw new IllegalArgumentException("O nome deve ter mais de 3 caracteres.");
        }
        if(preco <= 0.0){
            throw new IllegalArgumentException("O preco deve ser maior que zero.");
        }
        if(estoque < 0){
            throw new IllegalArgumentException("O estoque deve ser estritamente positivo.");
        }
        this.id = id;
        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto [id = " + id + ", nome = " + nome + ", preço = R$" + preco + ", estoque = " + estoque + "]";
    }
    
    
}
