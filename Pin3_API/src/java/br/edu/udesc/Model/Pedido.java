package br.edu.udesc.Model;

import java.util.List;

/**
 *
 * @author paulohenrique
 */
public class Pedido {
    
    private int id;
    private Usuario usuario;
    private Endereco endereco;
    private Cartao cartao;
    private Boleto boleto;
    private String status;
    private List<Produto> produtos;

    public Pedido() {
    }

    public Pedido(int id, Usuario usuario, Endereco endereco, Cartao cartao, Boleto boleto, String status, List<Produto> produtos) {
        this.id = id;
        this.usuario = usuario;
        this.endereco = endereco;
        this.cartao = cartao;
        this.boleto = boleto;
        this.status = status;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    
}
