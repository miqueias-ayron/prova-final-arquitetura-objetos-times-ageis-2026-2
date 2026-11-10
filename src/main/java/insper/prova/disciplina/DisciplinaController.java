package insper.prova.disciplina;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping("/disciplinas")
    public List<Disciplina> findAll() {
        return disciplinaService.list();
    }

    @PostMapping("/disciplinas")
    public Disciplina salvar(@Valid @RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
    }

    @DeleteMapping
    public void deletar(@Valid @RequestBody Disciplina disciplina) {
        disciplinaService.delete(disciplina);
    }

}
