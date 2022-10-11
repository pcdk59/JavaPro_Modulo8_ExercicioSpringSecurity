package br.com.mentorama.springsecurity.repositories;

import br.com.mentorama.springsecurity.models.Aluno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AlunoRepository {

    private Aluno aluno;

    private List<Aluno> alunos;

    public AlunoRepository(){
        this.alunos = new ArrayList<>();

        Aluno aluno1 = new Aluno(1, "André", 19);
        Aluno aluno2 = new Aluno(2, "Bruna", 20);

        alunos.add(aluno1);
        alunos.add(aluno2);
    }

    //1) Listar todos os alunos
    public List<Aluno> findAll(){
        return alunos;
    }

    //2) Buscar aluno por nome
    public List<Aluno> findByName(String nome){
        return alunos.stream()
                .filter(a-> a.getNome().contains(nome))
                .collect(Collectors.toList());
    }
    //3) Cadastrar um novo aluno:
    public void post (Aluno aluno){
        this.alunos.add(aluno);
    }
    public Integer count(){
        return alunos.size();
    }

    //4) Excluir um aluno:
    public void deleteById(Integer id){
        this.alunos.removeIf(a->a.getId().equals(id));
    }
}

