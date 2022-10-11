package br.com.mentorama.springsecurity.services;


import br.com.mentorama.springsecurity.models.Aluno;
import br.com.mentorama.springsecurity.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    //1) Listar todos os alunos:
    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    //2) Buscar por nome de aluno:
    public List<Aluno> findByName(String nome){
        if(alunoRepository.findByName(nome).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return alunoRepository.findByName(nome);
    }

    //3) Cadastrar um novo aluno:
    public Integer post(Aluno aluno){
        if (aluno.getId()==null){
            aluno.setId(alunoRepository.count()+1);
        }
        alunoRepository.post(aluno);
        return aluno.getId();
    }

    //Excluir um aluno:
    public void deleteById(Integer id){
        alunoRepository.deleteById(id);

    }
}

