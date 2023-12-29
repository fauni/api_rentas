package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.TokenR;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TokenRepository {
    private final JdbcTemplate _jdbcTemplate;

    public TokenRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }
    public void create (String usuario,String token){
            String sql = "insert into r_token\n" +
                         "values('"+usuario+"','"+token+"',1,GETDATE());";
            _jdbcTemplate.execute(sql);
    }
    public void cambiaEstado(String estado, String usuario){
        String sql = "UPDATE r_token SET activo = '"+estado+"' WHERE usuario = '"+usuario+"' ";
        _jdbcTemplate.execute(sql);
    }
}
