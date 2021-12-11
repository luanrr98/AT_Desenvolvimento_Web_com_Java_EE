package br.edu.infnet.appbiblioteca.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "TRequerente")
public class Requerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    @ManyToOne
    @JoinColumn(name = "idResponsavel")
    private Responsavel responsavel;

    public Requerente(){

    }

    public Requerente(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(nome);
        sb.append(";");
        sb.append(email);

        return sb.toString();
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

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
