package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Operador;

import java.util.List;

public interface IOperadorRepository {
    List<Operador> obtenerTodos();
}
