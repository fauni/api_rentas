package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Tempo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TempoRepository implements ITempoRepository{
    @Autowired
    private final JdbcTemplate _jdbcTemplate;

    public TempoRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tempo ObtenerTempoPorMatriculaMesGestion(String matricula, int mes, int gestion) {
        String sql = "SELECT * FROM cossmil.dbo.r_tempo1 where mtr_tmp1 = ? AND nmesproc_tmp1 = ? AND gestion_tmp1 = ?;";

        Tempo tempo = _jdbcTemplate.queryForObject(sql, new Object[]{matricula, mes, gestion}, (resultQuery, i)-> {
           Tempo data = new Tempo();
           data.setMtr_tmp1(resultQuery.getString("mtr_tmp1"));
           data.setCi_tmp1(resultQuery.getDouble("ci_tmp1"));
           data.setTren_tmp1(resultQuery.getInt("tren_tmp1"));
           data.setMca_tmp1(resultQuery.getString("mca_tmp1"));
           data.setNbe_tmp1(resultQuery.getInt("nbe_tmp1"));
           data.setRref_temp1(resultQuery.getDouble("rref_tmp1"));
           data.setPor_tmp1(resultQuery.getDouble("por_tmp1"));
           data.setRbasic_tmp1(resultQuery.getDouble("rbasic_tmp1"));
           data.setTingreso_tmp1(resultQuery.getDouble("tingreso_tmp1"));
           data.setTganado_tmp1(resultQuery.getDouble("tganado_tmp1"));
           data.setTdesc_tmp1(resultQuery.getDouble("tdesc_tmp1"));
           data.setLpagable_tmp1(resultQuery.getDouble("lpagable_tmp1"));
           data.setNboleta_tmp1(resultQuery.getDouble("nboleta_tmp1"));
           data.setTipren_tmp1(resultQuery.getDouble("tipren_tmp1"));
           data.setRdignidad_tmp1(resultQuery.getDouble("rdignidad_tmp1"));
           data.setDagui_tmp1(resultQuery.getDouble("dagui_tmp1"));
           data.setMesproc_tmp1(resultQuery.getString("mesproc_tmp1"));
           data.setNmesproc_tmp1(resultQuery.getString("nmesproc_tmp1"));
           data.setFecproc_tmp1(resultQuery.getDate("fecproc_tmp1"));
           data.setGestion_tmp1(resultQuery.getString("gestion_tmp1"));
           data.setEstado_tmp1(resultQuery.getString("estado_tmp1"));
           data.setUsimp_tmp1(resultQuery.getString("usimp_tmp1"));
           data.setFecrbol_tmp1(resultQuery.getDate("fecrbol_tmp1"));
           data.setEstreim_tmp1(resultQuery.getString("estreim_tmp1"));
           data.setFecreim_tmp1(resultQuery.getDate("fecreim_tmp1"));
           data.setUsreim_tmp1(resultQuery.getString("usreim_tmp1"));
           data.setRref_temp1(resultQuery.getDouble("rref_temp1"));
           return data;
        });
        return tempo;
    }
}
