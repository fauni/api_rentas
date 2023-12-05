package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.TipoRenta;

public interface ITipoRentaRepository {
    TipoRenta ObtenerTipoRentaPorCodigo(Double codigo);
}
