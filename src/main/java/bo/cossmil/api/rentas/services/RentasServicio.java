package bo.cossmil.api.rentas.services;

import bo.cossmil.api.rentas.models.Rentas;
import bo.cossmil.api.rentas.models.RentasConDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentasServicio {
    private final JdbcTemplate _jdbcTemplate;

    @Autowired
    public RentasServicio(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    public List<Rentas> obtenerTodos(){
        String sql = "SELECT top 10 * FROM r_rentas";
        return  _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Rentas.class));
    }


    public List<RentasConDetalle> getAll(){
        String sql = "SELECT r.matricula, r.ci1, r.ci2, r.ext_ren, r.tre, r.mcausante, r.paterno, r.materno, r.prefijo, r.apcasada, r.nombre, r.nombre2, r.regional, r.fuerza, r.grados, \n" +
                "r.uc, r.fc, r.um, r.fm, r.estado, r.cuenta, r.fnac, r.estciv, r.fingre, r.afpren, r.rendig, r.poder, r.codban, r.telefono, r.celular, tr.tre1, tr.detalle\n" +
                "FROM cossmil.dbo.r_rentas r\n" +
                "LEFT JOIN cossmil.dbo.r_tipren tr ON r.tre = tr.tre1;";

//        List<RentasConDetalle> rentas = _jdbcTemplate.query(sql, (resultSet, i) -> {
//            RentasConDetalle result = null;
//            Map<Integer, >
//        });

        return null;
    }

    public RentasConDetalle obtenerRentasPorMatriculaMesGestion(String matricula, String mes, String gestion){

        String sql_ingresos = "select mt.cdes_mti as codigo, rd.abr_dmr as detalle, mt.efec_mti as monto \n" +
                "from cossmil.dbo.r_movtit mt\n" +
                "left join cossmil.dbo.r_demoren rd on mt.cdes_mti = rd.cod_dmr \n" +
                "WHERE mt.mtr_mti = ? AND mt.mes_mti = ? and mt.gestion_mti = ? and mt.cdes_mti <= 599\n" +
                "ORDER BY mt.cdes_mti ASC;";


        String sql_egresos = "select mt.cdes_mti as codigo, rd.abr_dmr as detalle, mt.efec_mti as monto \n" +
                "from cossmil.dbo.r_movtit mt\n" +
                "left join cossmil.dbo.r_demoren rd on mt.cdes_mti = rd.cod_dmr \n" +
                "WHERE mt.mtr_mti = ? AND mt.mes_mti = ? and mt.gestion_mti = ? and mt.cdes_mti > 599\n" +
                "ORDER BY mt.cdes_mti ASC;";

//        DetalleRenta egresos = _jdbcTemplate.queryForObject(sql_egresos, new Object[]{matricula, mes, gestion}, (resultSet, i) -> {
//            DetalleRenta data = new DetalleRenta();
//            data.setCodigo(resultSet.getString("codigo"));
//            data.setDetalle(resultSet.getString("detalle"));
//            data.setMonto(resultSet.getDouble("monto"));
//            return data;
//        });

//        String sql_rentas = "select * from cossmil.dbo.r_rentas where matricula = ?";
//        RentasConDetalle renta = _jdbcTemplate.queryForObject(sql_rentas, new Object[]{matricula}, (resultSet, i) ->{
//            RentasConDetalle data = new RentasConDetalle();
//            data.setMatricula(resultSet.getString("matricula"));
//            data.setCi1(resultSet.getString("ci1"));
//            data.setCi2(resultSet.getDouble("ci2"));
//            data.setExt_ren(resultSet.getString("ext_ren"));
//            data.setTre(resultSet.getDouble("tre"));
//            data.setMcausante(resultSet.getString("mcausante"));
//            data.setPaterno(resultSet.getString("paterno"));
//            data.setMaterno(resultSet.getString("materno"));
//            data.setPrefijo(resultSet.getString("prefijo"));
//            data.setApcasada(resultSet.getString("apcasada"));
//            data.setNombre(resultSet.getString("nombre"));
//            data.setNombre2(resultSet.getString("nombre2"));
//            data.setRegional(resultSet.getInt("regional"));
//            data.setFuerza(resultSet.getString("fuerza"));
//            data.setGrados(resultSet.getString("grados"));
//            data.setUc(resultSet.getString("uc"));
//            data.setFc(resultSet.getString("fc"));
//            data.setUm(resultSet.getString("um"));
//            data.setFm(resultSet.getString("fm"));
//            data.setEstado(resultSet.getInt("estado"));
//            data.setCuenta(resultSet.getString("cuenta"));
//            data.setFnac(resultSet.getDate("fnac").toLocalDate());
//            data.setEstciv(resultSet.getString("estciv"));
//            data.setFingre(resultSet.getDate("fingre").toLocalDate());
//            data.setAfpren(resultSet.getString("afpren"));
//            data.setRendig(resultSet.getString("rendig"));
//            data.setPoder(resultSet.getString("poder"));
//            data.setCodban(resultSet.getString("codban"));
//            data.setTelefono(resultSet.getInt("telefono"));
//            data.setCelular(resultSet.getInt("celular"));
//            data.setIngresos(ingresos);
//
//            return data;
//        });
        return null;
    }
    /* TRAER RENTA POR CODIGO */
    public Rentas obtenerRentasPorMatricula(String matricula){
        String sql = "select * from cossmil.dbo.r_rentas where matricula = ?"; // 431003GMM
        Rentas renta = _jdbcTemplate.queryForObject(sql, new Object[]{matricula}, (resultSet, i) ->{
            Rentas data = new Rentas();
            data.setMatricula(resultSet.getString("matricula"));
            data.setCi1(resultSet.getString("ci1"));
            data.setCi2(resultSet.getDouble("ci2"));
            data.setExt_ren(resultSet.getString("ext_ren"));
            data.setTre(resultSet.getDouble("tre"));
            data.setMcausante(resultSet.getString("mcausante"));
            data.setPaterno(resultSet.getString("paterno"));
            data.setMaterno(resultSet.getString("materno"));
            data.setPrefijo(resultSet.getString("prefijo"));
            data.setApcasada(resultSet.getString("apcasada"));
            data.setNombre(resultSet.getString("nombre"));
            data.setNombre2(resultSet.getString("nombre2"));
            data.setRegional(resultSet.getInt("regional"));
            data.setFuerza(resultSet.getString("fuerza"));
            data.setGrados(resultSet.getString("grados"));
            data.setUc(resultSet.getString("uc"));
            data.setFc(resultSet.getString("fc"));
            data.setUm(resultSet.getString("um"));
            data.setFm(resultSet.getString("fm"));
            data.setEstado(resultSet.getInt("estado"));
            data.setCuenta(resultSet.getString("cuenta"));
            data.setFnac(resultSet.getDate("fnac").toLocalDate());
            data.setEstciv(resultSet.getString("estciv"));
            data.setFingre(resultSet.getDate("fingre").toLocalDate());
            data.setAfpren(resultSet.getString("afpren"));
            data.setRendig(resultSet.getString("rendig"));
            data.setPoder(resultSet.getString("poder"));
            data.setCodban(resultSet.getString("codban"));
            data.setTelefono(resultSet.getInt("telefono"));
            data.setCelular(resultSet.getInt("celular"));

            return data;
        });
        return renta;
    }
}
