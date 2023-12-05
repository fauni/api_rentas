package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.DetalleRenta;

import java.util.List;

public interface IDetalleRentaRepository {
    public List<DetalleRenta> ObtenerIngresosPorMatriculaMesGestion(String matricula, Integer mes, Integer gestion);
    public List<DetalleRenta> ObtenerEgresosPorMatriculaMesGestion(String matricula, Integer mes, Integer gestion);
}
