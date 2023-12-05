package bo.cossmil.api.rentas.controllers;

import bo.cossmil.api.rentas.models.ClaseRenta;
import bo.cossmil.api.rentas.services.ClaseRentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/claserenta")
public class ClaseRentaControlador {
    @Autowired
    private ClaseRentaServicio claseRentaServicio;

    @GetMapping
    public List<ClaseRenta> obtenerTodos(){
        return claseRentaServicio.obtenerTodos();
    }
}
