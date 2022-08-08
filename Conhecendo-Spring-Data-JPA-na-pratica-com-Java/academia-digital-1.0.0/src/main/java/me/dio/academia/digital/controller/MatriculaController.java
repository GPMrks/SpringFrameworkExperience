package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll(){
        List<Matricula> matriculas = matriculaService.getAll();
        return ResponseEntity.ok().body(matriculas);
    }

    @GetMapping("/bairro")
    public ResponseEntity<List<Matricula>> getAllByBairro(@RequestParam(value = "bairro", required = false) String bairro){
        List<Matricula> matriculas = matriculaService.getAll(bairro);
        return ResponseEntity.ok().body(matriculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getById(@PathVariable Long id){
        Matricula matricula = matriculaService.getById(id);
        return ResponseEntity.ok().body(matricula);
    }

    @PostMapping
    public ResponseEntity<Matricula> create(@Valid @RequestBody MatriculaForm matriculaForm){
        Matricula matricula = matriculaService.save(matriculaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(matricula);
    }

}
