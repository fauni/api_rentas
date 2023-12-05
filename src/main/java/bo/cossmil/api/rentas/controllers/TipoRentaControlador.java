package bo.cossmil.api.rentas.controllers;

import bo.cossmil.api.rentas.models.TipoRenta;
import bo.cossmil.api.rentas.services.TipoRentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tiporenta")
public class TipoRentaControlador {
    @Autowired
    private TipoRentaService tipoRentaService;

    @GetMapping
    public List<TipoRenta> obtenerTodos(){
        return tipoRentaService.obtenerTodos();
    }
}
