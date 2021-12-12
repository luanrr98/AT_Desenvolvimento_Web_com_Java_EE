package br.edu.infnet.appbiblioteca.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TResponsavel")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private int idade;
    private String senha;
    private Boolean admin;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idResponsavel")
    private List<Requerente> requerentes;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idResponsavel")
    private List<Midia> midias;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idResponsavel")
    private List<Biblioteca> bibliotecas;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_ID")
    private Endereco endereco;

    public Responsavel() {

    }

    public Responsavel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Requerente> getRequerentes() {
        return requerentes;
    }

    public void setRequerentes(List<Requerente> requerentes) {
        this.requerentes = requerentes;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(nome);
        sb.append(";");
        sb.append(email);
        sb.append(";");
        sb.append(idade);

        return sb.toString();
    }


}
