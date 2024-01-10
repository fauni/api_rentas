package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Mes;
import bo.cossmil.api.rentas.models.Operador;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public class MesRepository {
    private final JdbcTemplate _jdbcTemplate;

    public MesRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    public List<Mes> obtenerTodos(){
        String sql = "SELECT * FROM r_mes";
        return _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mes.class));
    }

    public List <Mes> mesXcodigo(String codigo){
        String sql = "SELECT *  \n"+
                "FROM r_mes \n"+
                "WHERE cod_mes = ?";

        List<Mes> meses = _jdbcTemplate.query(sql, new Object[]{codigo}, (resultSet, i) -> {
            Mes data = new Mes();

            data.setCod_mes(resultSet.getString("cod_mes"));
            data.setDescripcion(resultSet.getString("descripcion"));
            data.setAbr_mes(resultSet.getString("abr_mes"));
            return data;
        });

        return meses;
    }

    public List <String> gestionesDistinct(){
        String sql = "select distinct (gestion_tmp1) from r_tempo1;";

        List<String> gestiones = _jdbcTemplate.query(sql, new Object[]{}, (resultSet, i) -> {
            String data = new String();

            data =  resultSet.getString("gestion_tmp1");

            return data;
        });

        return gestiones;
    }
}
