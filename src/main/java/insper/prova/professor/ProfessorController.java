package insper.prova.professor;

import insper.prova.disciplina.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/professores")
    public List<Professor> findAll() {
        return professorService.list();
    }

    @PostMapping("/professores")
    public void save(@RequestBody Professor professor) {
        professorService.save(professor);
    }

    @DeleteMapping("/professores")
    public void delete(@RequestBody Professor professor) {
        professorService.delete(professor);
    }



}
