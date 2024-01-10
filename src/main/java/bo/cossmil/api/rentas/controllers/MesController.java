package bo.cossmil.api.rentas.controllers;

import bo.cossmil.api.rentas.models.Login;
import bo.cossmil.api.rentas.models.Mes;
import bo.cossmil.api.rentas.models.Operador;
import bo.cossmil.api.rentas.repositories.MesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meses")
public class MesController {
    private final MesRepository mesRepository;

    public MesController(MesRepository mesRepository) {
        this.mesRepository = mesRepository;
    }
    @GetMapping
    public List<Mes> obtenerTodos(){return mesRepository.obtenerTodos();}
    @GetMapping("/{codigo}")
    public ResponseEntity meses(@PathVariable String codigo) {
        List<Mes> meses = mesRepository.mesXcodigo(codigo);
        if (!meses.isEmpty())
            return ResponseEntity.ok(meses.get(0));
        else
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/gestiones")
    public ResponseEntity gestiones() {
        List<String> gestiones = mesRepository.gestionesDistinct();
        if (!gestiones.isEmpty())
            return ResponseEntity.ok(gestiones);
        else
            return ResponseEntity.notFound().build();
    }
}
