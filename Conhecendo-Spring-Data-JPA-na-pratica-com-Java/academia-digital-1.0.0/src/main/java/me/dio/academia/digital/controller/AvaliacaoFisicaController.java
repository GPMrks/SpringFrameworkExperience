package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl avaliacaoFisicaService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAll(){
        List<AvaliacaoFisica> avaliacoesFisicas = avaliacaoFisicaService.getAll();
        return ResponseEntity.ok().body(avaliacoesFisicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> getById(@PathVariable Long id){
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.getById(id);
        return ResponseEntity.ok().body(avaliacaoFisica);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> save(@Valid @RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm){
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.save(avaliacaoFisicaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoFisica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm){
        AvaliacaoFisica avaliacaoFisicaUpdate = avaliacaoFisicaService.update(id, avaliacaoFisicaUpdateForm);
        return ResponseEntity.ok().body(avaliacaoFisicaUpdate);
    }

}
