package averinaldoJunior.estoque;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void incluir(Produto p) {
        for (Produto produto: produtos) {
            if (produto.getCodigo() == p.getCodigo()) {
                return;
            }
        }

        this.produtos.add(p);
    }

    public void comprar(int cod, int quant, double preco) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == cod) {
                produto.compra(quant, preco);
                return;
            }
        }
    }

    public double vender(int cod, int quant) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == cod) {
                return produto.venda(quant);
            }
        }

        return -1;
    }

    public int quantidade(int cod) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == cod) {
                return produto.getQuantidade();
            }
        }

        return -1;
    }

    public Fornecedor fornecedor(int cod) {
        for (Produto produto : produtos) {
            if (produto.getFornecedor().getCnpj() == cod) {
                return produto.getFornecedor();
            }
        }

        return null;
    }

    public ArrayList<Produto> estoqueAbaixoDoMinimo() {
        ArrayList<Produto> produtosAbaixoDoMinimo = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.produtoAbaixoDoMinimo()) {
                produtosAbaixoDoMinimo.add(produto);
            }
        }

        return produtosAbaixoDoMinimo;
    }
}
