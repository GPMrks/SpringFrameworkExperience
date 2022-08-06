package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.exception.MatriculaNaoEncontradaException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Override
    public Matricula save(MatriculaForm matriculaForm) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoService.verificaSeAlunoExiste(matriculaForm.getAlunoId());
        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula getById(Long id) {
        return verificaSeMatriculaExiste(id);
    }

    @Override
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    public List<Matricula> getAll(String bairro) {
        return matriculaRepository.findMatriculasByBairroDosAlunos(bairro);
    }

    @Override
    public void delete(Long id) {
        verificaSeMatriculaExiste(id);
        matriculaRepository.deleteById(id);
    }

    protected Matricula verificaSeMatriculaExiste(Long id) {
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);
        final Matricula matriculaIndicada;
        if (optionalMatricula.isPresent()) {
            matriculaIndicada = optionalMatricula.get();
        } else {
            throw new MatriculaNaoEncontradaException(id);
        }
        return matriculaIndicada;
    }
}
