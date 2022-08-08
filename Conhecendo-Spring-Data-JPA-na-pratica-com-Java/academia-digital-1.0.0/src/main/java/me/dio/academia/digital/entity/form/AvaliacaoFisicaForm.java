package me.dio.academia.digital.entity.form;

import me.dio.academia.digital.entity.Aluno;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AvaliacaoFisicaForm {

  private Long alunoId;

  @Positive(message = "Peso inválido.")
  @NotNull(message = "Preencha os campos corretamente!")
  private double peso;

  @Positive(message = "Altura inválida.")
  @NotNull(message = "Preencha os campos corretamente!")
  private double altura;

  public AvaliacaoFisicaForm() {
  }

  public AvaliacaoFisicaForm(Long alunoId, double peso, double altura) {
    this.alunoId = alunoId;
    this.peso = peso;
    this.altura = altura;
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
}
