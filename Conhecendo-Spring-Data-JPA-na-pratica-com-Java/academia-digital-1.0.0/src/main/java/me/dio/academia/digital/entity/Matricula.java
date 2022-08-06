package me.dio.academia.digital.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();

  public Matricula() {
  }

  public Matricula(Long id, Aluno aluno, LocalDateTime dataDaMatricula) {
    this.id = id;
    this.aluno = aluno;
    this.dataDaMatricula = dataDaMatricula;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Aluno getAluno() {
    return aluno;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  public LocalDateTime getDataDaMatricula() {
    return dataDaMatricula;
  }

  public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
    this.dataDaMatricula = dataDaMatricula;
  }

  @Override
  public String toString() {
    return "Matricula{" +
            "id=" + id +
            ", aluno=" + aluno +
            ", dataDaMatricula=" + dataDaMatricula +
            '}';
  }
}
