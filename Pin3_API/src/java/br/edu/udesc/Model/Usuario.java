package br.edu.udesc.Model;

import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;

/**
 *
 * @author paulohenrique
 */
public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;

//    @JsonFormat(value = "yyyy-MM-dd HH:mm a z")
    private Date dataNascimento;
    private boolean administrador;
    private Endereco endereco;
    private Cartao cartao;

    public Usuario() {
    }

    public Usuario(int id, String nome, String cpf, String telefone, String email, String senha, Date dataNascimento, boolean administrador, Endereco endereco, Cartao cartao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.administrador = administrador;
        this.endereco = endereco;
        this.cartao = cartao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = (dataNascimento == null)? new Date() : new Date(dataNascimento.getTime());
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Endereco getEndereco() {
        if (endereco == null) {
            return new Endereco();
        }
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
