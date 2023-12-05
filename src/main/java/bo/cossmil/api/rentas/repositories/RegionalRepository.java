package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Regional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegionalRepository implements IRegionalRepository{
    @Autowired
    private final JdbcTemplate _jdbcTemplate;

    public RegionalRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Regional ObtenerRegionalPorCodigo(String codigo) {
        String sql = "SELECT reg.cod_reg, reg.descripcion, reg.cod_alt, reg.abr_reg " +
                "FROM cossmil.dbo.r_regional reg " +
                "WHERE reg.cod_reg = ?";
        Regional regional = _jdbcTemplate.queryForObject(sql, new Object[]{codigo}, (resultSet, i)->{
           Regional data = new Regional();
           data.setCod_reg(resultSet.getString("cod_reg"));
           data.setDescripcion(resultSet.getString("descripcion"));
           data.setCod_alt(resultSet.getInt("cod_alt"));
           data.setAbr_reg(resultSet.getString("abr_reg"));

           return data;
        });
        return regional;
    }
}
