package br.com.murillo.salutar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_midia")
public class Midia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    private Integer numSeq;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "link_midia", length = 255)
    private String linkMidia;

    @ManyToOne
    @JoinColumn(name = "id_ficha")
    private FichaPaciente ficha;

    public Integer getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(Integer numSeq) {
        this.numSeq = numSeq;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkMidia() {
        return linkMidia;
    }

    public void setLinkMidia(String linkMidia) {
        this.linkMidia = linkMidia;
    }

    public FichaPaciente getFicha() {
        return ficha;
    }

    public void setFicha(FichaPaciente ficha) {
        this.ficha = ficha;
    }
}
