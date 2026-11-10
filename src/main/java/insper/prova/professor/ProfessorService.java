package insper.prova.professor;

import insper.prova.disciplina.Disciplina;
import insper.prova.disciplina.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> list() {
        return professorRepository.findAll();
    }

    public Disciplina associarProfessorEDisciplina(Disciplina disciplina, Professor professor) {
        disciplina.setProfessor(professor);
        professor.getDisciplinas().add(disciplina);
        disciplinaRepository.save(disciplina);
        return disciplina;
    }
    public void delete(Professor professor) {
        if (professor.getDisciplinas().size() == 0) {
            professorRepository.delete(professor);
        }
    }

}
