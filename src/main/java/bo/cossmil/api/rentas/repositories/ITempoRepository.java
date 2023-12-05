package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Tempo;

public interface ITempoRepository {
    Tempo ObtenerTempoPorMatriculaMesGestion(String matricula, int mes, int gestion);
}
