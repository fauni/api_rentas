package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.RentasConDetalle;

import java.util.List;

public interface IRentaRepository {
    List<RentasConDetalle> obtenerTodos();

    List<RentasConDetalle> ObtenerRentaPorMatricula(String matricula);

    RentasConDetalle ObtenerRentaPorMatriculaMesGestion(String matricula, int mes, int gestion);
}
