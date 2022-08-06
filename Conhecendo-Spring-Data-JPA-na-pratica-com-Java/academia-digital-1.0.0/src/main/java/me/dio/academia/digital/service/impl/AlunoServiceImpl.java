package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.view.AvaliacoesFisicasDTO;
import me.dio.academia.digital.exception.AlunoNaoEncontradoException;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno save(AlunoForm alunoForm) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoForm.getNome());
        aluno.setCpf(alunoForm.getCpf());
        aluno.setBairro(alunoForm.getBairro());
        aluno.setDataDeNascimento(alunoForm.getDataDeNascimento());
        alunoRepository.save(aluno);

        return aluno;
    }

    @Override
    public Aluno getById(Long id) {
        return verificaSeAlunoExiste(id);
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public List<Aluno> getAll(String dataDeNascimento) {
        LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
        return alunoRepository.findByDataDeNascimento(localDate);
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm alunoUpdateForm) {
        final Aluno alunoIndicado = verificaSeAlunoExiste(id);
        alunoIndicado.setNome(alunoUpdateForm.getNome());
        alunoIndicado.setBairro(alunoUpdateForm.getBairro());
        alunoIndicado.setDataDeNascimento(alunoUpdateForm.getDataDeNascimento());

        return alunoRepository.save(alunoIndicado);
    }

    @Override
    public void delete(Long id) {
        verificaSeAlunoExiste(id);
        alunoRepository.deleteById(id);
    }

    @Override
    public List<AvaliacoesFisicasDTO> getAllAvaliacoesFisicas(Long id) {
        Aluno aluno = verificaSeAlunoExiste(id);
        List<AvaliacaoFisica> avaliacoesFisicas = aluno.getAvaliacoes();
        return avaliacoesFisicas.stream().map(AvaliacoesFisicasDTO::new).toList();
    }

    protected Aluno verificaSeAlunoExiste(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        final Aluno alunoIndicado;
        if (optionalAluno.isPresent()) {
            alunoIndicado = optionalAluno.get();
        } else {
            throw new AlunoNaoEncontradoException(id);
        }
        return alunoIndicado;
    }

}
