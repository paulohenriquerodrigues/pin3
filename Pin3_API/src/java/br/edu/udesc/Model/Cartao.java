package br.edu.udesc.Model;

/**
 *
 * @author paulohenrique
 */
public class Cartao {
    
    private int id;
    private String numero;
    private int digito;
    private String nome;
    private String datavalidade;

    public Cartao() {
    }

    public Cartao(int id, String numero, int digito, String nome, String datavalidade) {
        this.id = id;
        this.numero = numero;
        this.digito = digito;
        this.nome = nome;
        this.datavalidade = datavalidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }
    
    
    
    
}
