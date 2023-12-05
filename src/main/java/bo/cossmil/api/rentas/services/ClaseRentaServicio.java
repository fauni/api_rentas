package bo.cossmil.api.rentas.services;

import bo.cossmil.api.rentas.models.ClaseRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseRentaServicio {
    private final JdbcTemplate _jdbcTemplate;

    @Autowired
    ClaseRentaServicio(JdbcTemplate jdbcTemplate){
        _jdbcTemplate = jdbcTemplate;
    }

    public List<ClaseRenta> obtenerTodos(){
        String sql = "SELECT * FROM r_clasrenta";
        return  _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ClaseRenta.class));
    }
}
