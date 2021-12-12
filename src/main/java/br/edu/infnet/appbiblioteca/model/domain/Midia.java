package br.edu.infnet.appbiblioteca.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TMidia")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String genero;
    private boolean baseadoOutraMidia;
    private double nota;
    @ManyToOne
    @JoinColumn(name = "idResponsavel")
    private Responsavel responsavel;
    @ManyToMany(mappedBy = "midias")
    private List<Biblioteca> bibliotecas;


    public Midia() {

    }

    public Midia(String nome, String genero, boolean baseadoOutraMidia, double nota) {
        this.nome = nome;
        this.genero = genero;
        this.baseadoOutraMidia = baseadoOutraMidia;
        this.nota = nota;
    }

    public abstract int quantidadeDiasProducao();

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isBaseadoOutraMidia() {
        return baseadoOutraMidia;
    }

    public void setBaseadoOutraMidia(boolean baseadoOutraMidia) {
        this.baseadoOutraMidia = baseadoOutraMidia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(id);
        sb.append(";");
        sb.append(nome);
        sb.append(";");
        sb.append(genero);
        sb.append(";");
        sb.append(baseadoOutraMidia);
        sb.append(";");
        sb.append(nota);

        return sb.toString();
    }

}
