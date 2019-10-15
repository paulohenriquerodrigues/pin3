package br.edu.udesc.Model;

import java.util.Date;

/**
 *
 * @author paulohenrique
 */
public class Produto {
    
    private int id;
    private String descricao;
    private Date datavalidade;
    private int lote;
    private String laboratorio;
    private double preco;
    private Date datafabricacao;
    private boolean usocontinuo;
    private boolean controlado;
    private int quantidade;
    private Categoria categoria;
    private String titulo;

    public Produto() {
    }

    public Produto(int id, String descricao, Date datavalidade, int lote, String laboratorio, double preco, Date datafabricacao, boolean usocontinuo, boolean controlado, int quantidade, Categoria categoria, String titulo) {
        this.id = id;
        this.descricao = descricao;
        this.datavalidade = datavalidade;
        this.lote = lote;
        this.laboratorio = laboratorio;
        this.preco = preco;
        this.datafabricacao = datafabricacao;
        this.usocontinuo = usocontinuo;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.titulo = titulo;
        this.controlado = controlado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public boolean isUsocontinuo() {
        return usocontinuo;
    }

    public void setUsocontinuo(boolean usocontinuo) {
        this.usocontinuo = usocontinuo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isControlado() {
        return controlado;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }
    
}
