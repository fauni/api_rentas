package bo.cossmil.api.rentas.controllers;

import bo.cossmil.api.rentas.models.Rentas;
import bo.cossmil.api.rentas.models.RentasConDetalle;
import bo.cossmil.api.rentas.repositories.RentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rentas")
public class RentasControlador {
    @Autowired
    private final RentaRepository rentaRepository;

    public RentasControlador(RentaRepository rentaRepository) {
        this.rentaRepository = rentaRepository;
    }

    @GetMapping
    public List<RentasConDetalle> obtenerTodos(){
        return rentaRepository.obtenerTodos();
    }

    @GetMapping("/matricula/{matricula}")
    public List<RentasConDetalle> ObtenerPorMatricula(@PathVariable String matricula){
        return rentaRepository.ObtenerRentaPorMatricula(matricula);
    }

    @GetMapping("compuesto/{matricula}/{mes}/{gestion}")
    public RentasConDetalle ObtenerPorMatriculaMesGestion(@PathVariable String matricula,@PathVariable int mes,@PathVariable int gestion){
        return rentaRepository.ObtenerRentaPorMatriculaMesGestion(matricula, mes, gestion);
    }

//    @GetMapping("/{matricula}")
//    public ResponseEntity<Rentas> obtenerRentistaPorMatricula(@PathVariable String matricula){
//        Rentas renta = rentasServicio.obtenerRentasPorMatricula(matricula);
//        if (renta != null){
//            return ResponseEntity.ok(renta);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/{matricula}/{mes}/{gestion}")
    public ResponseEntity<RentasConDetalle> obtenerRentasPorMatriculaMesGestion(@PathVariable String matricula, @PathVariable String mes,@PathVariable String gestion){
        return  ResponseEntity.ok(null);
    }
}
