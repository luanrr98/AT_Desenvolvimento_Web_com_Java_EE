package br.edu.infnet.appbiblioteca.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "TBiblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String visibilidade;
    private String titulo;
    private LocalDateTime dataHoraCriacao;
    private String dataHoraCriacaoFormatada;
    @ManyToOne
    @JoinColumn(name = "idResponsavel")
    private Responsavel responsavel;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Midia> midias;
    @OneToOne
    @JoinColumn(name = "idRequerente")
    private Requerente requerente;

    public Biblioteca() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");

        this.dataHoraCriacao = LocalDateTime.now();
        this.dataHoraCriacaoFormatada = this.dataHoraCriacao.format(formato);
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;

    }

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

    public LocalDateTime getDataCriacao() {

        return dataHoraCriacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Requerente getRequerente() {
        return requerente;
    }

    public void setRequerente(Requerente requerente) {
        this.requerente = requerente;
    }

    public String getDataHoraCriacaoFormatada() {
        return dataHoraCriacaoFormatada;
    }

    public void setDataHoraCriacaoFormatada(String dataHoraCriacaoFormatada) {
        this.dataHoraCriacaoFormatada = dataHoraCriacaoFormatada;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        StringBuilder sb = new StringBuilder();

        sb.append(dataHoraCriacao.format(formato));
        sb.append(";");
        sb.append(visibilidade);
        sb.append(";");
        sb.append(titulo);
        sb.append(";");
        sb.append(responsavel.toString());
        sb.append(";");
        if (midias != null) {
            sb.append(midias.size());
        }

        return sb.toString();
    }


}
