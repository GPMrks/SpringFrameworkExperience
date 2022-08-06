package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.view.AvaliacoesFisicasDTO;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        List<Aluno> alunos = alunoService.getAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/data-de-nascimento")
    public ResponseEntity<List<Aluno>> getAllByDataDeNascimento(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
        List<Aluno> alunos = alunoService.getAll(dataDeNascimento);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id){
        Aluno aluno = alunoService.getById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("/{id}/avaliacoes-fisicas")
    public ResponseEntity<List<AvaliacoesFisicasDTO>> getAllAvaliacoesFisicas(@PathVariable Long id){
        List<AvaliacoesFisicasDTO> avaliacoesFisicasDTOS = alunoService.getAllAvaliacoesFisicas(id);
        return ResponseEntity.ok().body(avaliacoesFisicasDTOS);
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@Valid @RequestBody AlunoForm alunoForm){
        Aluno aluno = alunoService.save(alunoForm);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm alunoUpdateForm){
        Aluno alunoUpdate = alunoService.update(id, alunoUpdateForm);
        return ResponseEntity.ok().body(alunoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
