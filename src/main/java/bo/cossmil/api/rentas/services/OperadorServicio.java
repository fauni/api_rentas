package bo.cossmil.api.rentas.services;

import bo.cossmil.api.rentas.models.Operador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OperadorServicio {
     // data.setJdbcTemplate _jdbcTemplate(resultSet.getString("JdbcTemplate"));
     @Autowired
     private final JdbcTemplate _jdbcTemplate;
    public OperadorServicio(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

}
