package averinaldoJunior.estoque;

public class Produto {
    private int codigo;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
    private double lucro;
    private int quantidade;
    private int estoqueMinimo;

    private Fornecedor fornecedor;

    public Produto(int cod, String desc, int min, double lucro, Fornecedor forn){
        this.codigo = cod;
        this.descricao = desc;
        this.estoqueMinimo = min;
        this.lucro = lucro;
        this.fornecedor = forn;
    }

    public int compra(int quant, double val){
        if(quant <= 0 || val <= 0){
            return -1;
        }

        this.setPrecoDeCompra(quant, val);
        this.quantidade += quant;

        return this.quantidade;
    }

    public double venda(int quant){
        if(quant <= 0 || quant>this.quantidade){
            return -1;
        }
        this.quantidade -= quant;

        return quant * this.precoDeVenda;
    }

    public void setPrecoDeCompra(int quantidade, double val){
        this.precoDeCompra = (this.quantidade * this.precoDeCompra + quantidade * val) / (this.quantidade + quantidade);
        this.precoDeVenda = this.precoDeCompra + (this.precoDeCompra * this.lucro);
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public boolean produtoAbaixoDoMinimo(){
        return this.quantidade < this.estoqueMinimo;
    }

    public String getDescricao() {
        return descricao;
    }
}
