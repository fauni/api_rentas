package bo.cossmil.api.rentas.controllers;

import bo.cossmil.api.rentas.models.Login;
import bo.cossmil.api.rentas.models.Operador;
import bo.cossmil.api.rentas.repositories.OperadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/operador")
public class OperadorControlador {
    private final OperadorRepository operadorRepository;

    public OperadorControlador(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }
    @GetMapping
    public List<Operador>obtenerTodos(){return operadorRepository.obtenerTodos();}

    @PostMapping("login")
    public ResponseEntity login(@RequestBody Login user){
        List<Operador>users=operadorRepository.login(user.usuario ,user.clave);
        if (!users.isEmpty())
           return ResponseEntity.ok(users.get(0));
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping("logout")
    public ResponseEntity logout(@RequestBody Login user){
        operadorRepository.logout(user.usuario);
        return (ResponseEntity) ResponseEntity.ok(user);
    }
}
