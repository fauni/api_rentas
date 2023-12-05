package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Grado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradoRepository implements IGradoRepository{
    @Autowired
    private final JdbcTemplate _jdbcTemplate;

    public GradoRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Grado ObtenerGradoPorCodigo(String codigo) {
        String sql = "SELECT cod_grd , des1_grd ,abr1_grd ,abr2_grd ,des2_grd " +
                "FROM cossmil.dbo.r_grados WHERE cod_grd = ?";
        Grado grado = _jdbcTemplate.queryForObject(sql, new Object[]{codigo}, (resultSet, i)->{
           Grado data = new Grado();
           data.setCod_grd(resultSet.getString("cod_grd"));
           data.setDes1_grd(resultSet.getString("des1_grd"));
           data.setAbr1_grd(resultSet.getString("abr1_grd"));
           data.setDes2_grd(resultSet.getString("des2_grd"));
           data.setAbr2_grd(resultSet.getString("abr2_grd"));

           return data;
        });
        return grado;
    }
}
