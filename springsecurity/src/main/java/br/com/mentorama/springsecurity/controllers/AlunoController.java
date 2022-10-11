package br.com.mentorama.springsecurity.controllers;

import br.com.mentorama.springsecurity.models.Aluno;
import br.com.mentorama.springsecurity.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //1) Listar todos os alunos:
    @RolesAllowed("user")
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        return new ResponseEntity<>
                (alunoService.findAll(), HttpStatus.OK);
    }

    //2) Buscar aluno por nome:
    @RolesAllowed("user")
    @GetMapping("/{nome}")
    public  ResponseEntity<List<Aluno>> findByName(@PathVariable ("nome") String nome ){
        return new ResponseEntity<>(alunoService.findByName(nome), HttpStatus.OK);
    }

    //3) Cadastrar um novo aluno:
    @RolesAllowed("user")
    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.post(aluno), HttpStatus.CREATED);
    }

    //4) Excluir um aluno:
    @RolesAllowed("user")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable ("id") Integer id){
        alunoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

