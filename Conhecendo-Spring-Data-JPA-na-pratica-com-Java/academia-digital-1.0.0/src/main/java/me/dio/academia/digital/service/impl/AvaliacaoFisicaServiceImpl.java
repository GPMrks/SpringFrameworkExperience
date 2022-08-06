package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.exception.AlunoNaoEncontradoException;
import me.dio.academia.digital.exception.AvaliacaoNaoEncontradaException;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica save(AvaliacaoFisicaForm avaliacaoFisicaForm) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(avaliacaoFisicaForm.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(avaliacaoFisicaForm.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaForm.getAltura());

        avaliacaoFisicaRepository.save(avaliacaoFisica);

        return avaliacaoFisica;
    }

    @Override
    public AvaliacaoFisica getById(Long id) {
        return verificaSeExiste(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm) {
        final AvaliacaoFisica avaliacaoFisicaIndicada = verificaSeExiste(id);
        avaliacaoFisicaIndicada.setPeso(avaliacaoFisicaUpdateForm.getPeso());
        avaliacaoFisicaIndicada.setAltura(avaliacaoFisicaUpdateForm.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisicaIndicada);
    }

    @Override
    public void delete(Long id) {
        verificaSeExiste(id);
        avaliacaoFisicaRepository.deleteById(id);
    }

    private AvaliacaoFisica verificaSeExiste(Long id) {
        Optional<AvaliacaoFisica> optionalAvaliacaoFisica = avaliacaoFisicaRepository.findById(id);
        final AvaliacaoFisica avaliacaoFisicaIndicada;
        if (optionalAvaliacaoFisica.isPresent()){
            avaliacaoFisicaIndicada = optionalAvaliacaoFisica.get();
        } else {
            throw new AvaliacaoNaoEncontradaException(id);
        }
        return avaliacaoFisicaIndicada;
    }
}
