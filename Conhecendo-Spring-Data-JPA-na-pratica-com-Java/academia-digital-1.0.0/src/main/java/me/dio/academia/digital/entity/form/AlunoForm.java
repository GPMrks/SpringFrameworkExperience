package me.dio.academia.digital.entity.form;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AlunoForm {

  @NotBlank(message = "Preencha o campo corretamente!")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente!")
  //@CPF(message = "CPF '${validatedValue}' é inválido!")
  private String cpf;

  @NotBlank(message = "Preencha o campo corretamente!")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;

  @NotNull(message = "Preencha o campo corretamente!")
  @Past(message = "Data '${validatedValue}' é inválida!")
  private LocalDate dataDeNascimento;

  public AlunoForm() {
  }

  public AlunoForm(String nome, String cpf, String bairro, LocalDate dataDeNascimento) {
    this.nome = nome;
    this.cpf = cpf;
    this.bairro = bairro;
    this.dataDeNascimento = dataDeNascimento;
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

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }
}
