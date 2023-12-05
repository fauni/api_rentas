package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.DetalleRenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetalleRentaRepository implements IDetalleRentaRepository{
    @Autowired
    private final JdbcTemplate _jdbcTemplate;

    public DetalleRentaRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DetalleRenta> ObtenerIngresosPorMatriculaMesGestion(String matricula, Integer mes, Integer gestion) {
        String sql = "select mt.cdes_mti as codigo, rd.abr_dmr as detalle, mt.efec_mti as monto \n" +
                "from cossmil.dbo.r_movtit mt\n" +
                "left join cossmil.dbo.r_demoren rd on mt.cdes_mti = rd.cod_dmr \n" +
                "WHERE mt.mtr_mti = ? AND mt.mes_mti = ? and mt.gestion_mti = ? and mt.cdes_mti <= 599\n" +
                "ORDER BY mt.cdes_mti ASC";

        List<DetalleRenta> rentas = _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DetalleRenta.class), new Object[]{matricula, mes, gestion});
        return rentas;
    }

    @Override
    public List<DetalleRenta> ObtenerEgresosPorMatriculaMesGestion(String matricula, Integer mes, Integer gestion) {
        String sql = "select mt.cdes_mti as codigo, rd.abr_dmr as detalle, mt.efec_mti as monto \n" +
                "from cossmil.dbo.r_movtit mt\n" +
                "left join cossmil.dbo.r_demoren rd on mt.cdes_mti = rd.cod_dmr \n" +
                "WHERE mt.mtr_mti = ? AND mt.mes_mti = ? and mt.gestion_mti = ? and mt.cdes_mti > 599\n" +
                "ORDER BY mt.cdes_mti ASC;";
        List<DetalleRenta> rentas = _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DetalleRenta.class), new Object[]{matricula, mes, gestion});
        return rentas;
    }
}
