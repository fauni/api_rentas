package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Fuerza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuerzaRepository implements IFuerzaRepository{
    @Autowired
    private final JdbcTemplate _jdbcTemplate;

    public FuerzaRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Fuerza ObtenerFuerzaPorCodigo(String codigo) {
        String sql = "SELECT cod_fza, des_fza " +
                "FROM cossmil.dbo.r_fuerza where cod_fza =?";
        Fuerza fuerza = _jdbcTemplate.queryForObject(sql, new Object[]{codigo}, (resultSet, i)->{
           Fuerza data = new Fuerza();
           data.setCod_fza(resultSet.getString("cod_fza"));
           data.setDes_fza(resultSet.getString("des_fza"));
           return data;
        });
        return fuerza;
    }
}
