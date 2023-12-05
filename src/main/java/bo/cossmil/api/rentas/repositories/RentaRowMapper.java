package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Rentas;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentaRowMapper implements RowMapper<Rentas> {
    @Override
    public Rentas mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
