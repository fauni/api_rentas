package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.TipoRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TipoRentaRepository implements ITipoRentaRepository{
    @Autowired
    private final JdbcTemplate _jdbcTemplate;
    public TipoRentaRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TipoRenta ObtenerTipoRentaPorCodigo(Double codigo) {
        String sql = "SELECT tr.tre1, tr.detalle " +
                "FROM cossmil.dbo.r_tipren tr " +
                "WHERE tr.tre1 = ?;";
        TipoRenta tipoRenta = _jdbcTemplate.queryForObject(sql, new Object[]{codigo}, (resultSet, i) ->{
            TipoRenta data = new TipoRenta();
            data.setTre1(resultSet.getDouble("tre1"));
            data.setDetalle(resultSet.getString("detalle"));
            return data;
        });
        return  tipoRenta;
    }
}
