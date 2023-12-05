package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Regional;

public interface IRegionalRepository {
    Regional ObtenerRegionalPorCodigo(String codigo);
}
