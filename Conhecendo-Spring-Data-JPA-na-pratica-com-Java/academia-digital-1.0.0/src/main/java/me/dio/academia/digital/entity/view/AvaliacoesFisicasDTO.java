package me.dio.academia.digital.entity.view;

import me.dio.academia.digital.entity.AvaliacaoFisica;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AvaliacoesFisicasDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long alunoId;

    private double peso;

    private double altura;

    private LocalDateTime dataDaAvaliacao;

    public AvaliacoesFisicasDTO() {
    }

    public AvaliacoesFisicasDTO(AvaliacaoFisica avaliacaoFisica) {
        this.alunoId = avaliacaoFisica.getAluno().getId();
        this.peso = avaliacaoFisica.getPeso();
        this.altura = avaliacaoFisica.getAltura();
        this.dataDaAvaliacao = avaliacaoFisica.getDataDaAvaliacao();
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public LocalDateTime getDataDaAvaliacao() {
        return dataDaAvaliacao;
    }

    public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
        this.dataDaAvaliacao = dataDaAvaliacao;
    }
}
