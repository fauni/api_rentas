package bo.cossmil.api.rentas.services;

import bo.cossmil.api.rentas.models.TipoRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRentaService {
    private final JdbcTemplate _jdbcTemplate;

    @Autowired
    TipoRentaService(JdbcTemplate jdbcTemplate){
        _jdbcTemplate = jdbcTemplate;
    }

    public List<TipoRenta> obtenerTodos(){
        String sql = "SELECT tre1, detalle FROM r_tipren";
        return  _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TipoRenta.class));
    }

}
