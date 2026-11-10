package insper.prova.disciplina;

import insper.prova.professor.Professor;
import insper.prova.professor.ProfessorRepository;
import insper.prova.professor.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ProfessorService professorService;


    public List<Disciplina> list() {
        return disciplinaRepository.findAll();
    }

    public Disciplina salvar(@Valid Disciplina disciplina) {

        return disciplinaRepository.save(disciplina);
    }

    public void delete(@Valid Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }

}
