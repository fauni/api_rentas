package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Fuerza;

public interface IFuerzaRepository {
    Fuerza ObtenerFuerzaPorCodigo(String codigo);
}
