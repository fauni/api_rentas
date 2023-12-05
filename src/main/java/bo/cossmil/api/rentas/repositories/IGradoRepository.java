package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Grado;

public interface IGradoRepository {
    Grado ObtenerGradoPorCodigo(String codigo);
}
