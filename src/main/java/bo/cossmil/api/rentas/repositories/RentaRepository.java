package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Repository
public class RentaRepository implements IRentaRepository {
    @Autowired
    private final JdbcTemplate _jdbcTemplate;
    @Autowired
    private TipoRentaRepository tipoRentaRepository;
    @Autowired
    private RegionalRepository regionalRepository;
    @Autowired
    private FuerzaRepository fuerzaRepository;
    @Autowired
    private GradoRepository gradoRepository;

    @Autowired
    private DetalleRentaRepository detalleRentaRepository;

    @Autowired
    private TempoRepository tempoRepository;

    public RentaRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RentasConDetalle> obtenerTodos() {
        // String sql = "SELECT top 10 * FROM r_rentas";
        String sql = "SELECT top 10 r.matricula, r.ci1, r.ci2, r.ext_ren, r.tre, r.mcausante, r.paterno, r.materno, r.prefijo, r.apcasada, r.nombre, r.nombre2, r.regional, r.fuerza, r.grados, \n" +
                "r.uc, r.fc, r.um, r.fm, r.estado, r.cuenta, r.fnac, r.estciv, r.fingre, r.afpren, r.rendig, r.poder, r.codban, r.telefono, r.celular\n" +
                "FROM cossmil.dbo.r_rentas r";

        List<RentasConDetalle> rentas = _jdbcTemplate.query(sql, (resultSet, i) -> {
            RentasConDetalle data = new RentasConDetalle();
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
            data.setFnac(resultSet.getDate("fnac"));
            data.setEstciv(resultSet.getString("estciv"));
            data.setFingre(resultSet.getDate("fingre"));
            data.setAfpren(resultSet.getString("afpren"));
            data.setRendig(resultSet.getString("rendig"));
            data.setPoder(resultSet.getString("poder"));
            data.setCodban(resultSet.getString("codban"));
            data.setTelefono(resultSet.getInt("telefono"));
            data.setCelular(resultSet.getInt("celular"));
            return data;
        });

        for (RentasConDetalle rd: rentas){
            TipoRenta tipoRenta = tipoRentaRepository.ObtenerTipoRentaPorCodigo(rd.getTre());
            Regional regional = regionalRepository.ObtenerRegionalPorCodigo(rd.getRegional().toString());
            Grado grado = gradoRepository.ObtenerGradoPorCodigo(rd.getGrados());
            Fuerza fuerza = fuerzaRepository.ObtenerFuerzaPorCodigo(rd.getFuerza());
            List<DetalleRenta> ingresos = detalleRentaRepository.ObtenerIngresosPorMatriculaMesGestion("431003GMM", 8, 2023);
            List<DetalleRenta> egresos = detalleRentaRepository.ObtenerEgresosPorMatriculaMesGestion("431003GMM", 8, 2023);
            Tempo tempo = tempoRepository.ObtenerTempoPorMatriculaMesGestion("431003GMM", 8, 2023);
            rd.setTipoRenta(tipoRenta);
            rd.setRegionalDetalle(regional);
            rd.setFuerzaDetalle(fuerza);
            rd.setGradoDetalle(grado);
            rd.setIngresos(ingresos);
            rd.setEgresos(egresos);
            rd.setTempo(tempo);
        }
        return rentas;
    }

    @Override
    public List<RentasConDetalle> ObtenerRentaPorMatricula(String matricula) {
        String sql = "SELECT r.matricula, r.ci1, r.ci2, r.ext_ren, r.tre, r.mcausante, r.paterno, r.materno, r.prefijo, r.apcasada, r.nombre, r.nombre2, r.regional, r.fuerza, r.grados, r.uc, r.fc, r.um, r.fm, r.estado, r.cuenta, r.fnac, r.estciv, r.fingre, r.afpren, r.rendig, r.poder, r.codban, r.telefono, r.celular\n" +
                "FROM cossmil.dbo.r_rentas r \n" +
                "LEFT JOIN cossmil.dbo.r_tempo1 t ON r.matricula = t.mtr_tmp1\n" +
                "where r.matricula = ?;";

        List<RentasConDetalle> rentas = _jdbcTemplate.query(sql, new Object[]{matricula},(resultSet, i) -> {
            RentasConDetalle data = new RentasConDetalle();
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
            data.setFnac(resultSet.getDate("fnac"));
            data.setEstciv(resultSet.getString("estciv"));
            data.setFingre(resultSet.getDate("fingre"));
            data.setAfpren(resultSet.getString("afpren"));
            data.setRendig(resultSet.getString("rendig"));
            data.setPoder(resultSet.getString("poder"));
            data.setCodban(resultSet.getString("codban"));
            data.setTelefono(resultSet.getInt("telefono"));
            data.setCelular(resultSet.getInt("celular"));
            return data;
        });

        for (RentasConDetalle rd: rentas){
            TipoRenta tipoRenta = tipoRentaRepository.ObtenerTipoRentaPorCodigo(rd.getTre());
            Regional regional = regionalRepository.ObtenerRegionalPorCodigo(rd.getRegional().toString());
            Grado grado = gradoRepository.ObtenerGradoPorCodigo(rd.getGrados());
            Fuerza fuerza = fuerzaRepository.ObtenerFuerzaPorCodigo(rd.getFuerza());
            List<DetalleRenta> ingresos = detalleRentaRepository.ObtenerIngresosPorMatriculaMesGestion("431003GMM", 8, 2023);
            List<DetalleRenta> egresos = detalleRentaRepository.ObtenerEgresosPorMatriculaMesGestion("431003GMM", 8, 2023);
            Tempo tempo = tempoRepository.ObtenerTempoPorMatriculaMesGestion("431003GMM", 8, 2023);
            rd.setTipoRenta(tipoRenta);
            rd.setRegionalDetalle(regional);
            rd.setFuerzaDetalle(fuerza);
            rd.setGradoDetalle(grado);
            rd.setIngresos(ingresos);
            rd.setEgresos(egresos);
            rd.setTempo(tempo);
        }
        return rentas;
    }

    @Override
    public RentasConDetalle ObtenerRentaPorMatriculaMesGestion(String matricula, int mes, int gestion) {
        String sql = "SELECT r.matricula, r.ci1, r.ci2, r.ext_ren, r.tre, r.mcausante, r.paterno, r.materno, r.prefijo, r.apcasada, r.nombre, r.nombre2, r.regional, r.fuerza, r.grados, r.uc, r.fc, r.um, r.fm, r.estado, r.cuenta, r.fnac, r.estciv, r.fingre, r.afpren, r.rendig, r.poder, r.codban, r.telefono, r.celular\n" +
                "FROM cossmil.dbo.r_rentas r \n" +
                "LEFT JOIN cossmil.dbo.r_tempo1 t ON r.matricula = t.mtr_tmp1\n" +
                "where r.matricula = ? and t.nmesproc_tmp1 = ? and t.gestion_tmp1 = ?";

        RentasConDetalle renta = _jdbcTemplate.queryForObject(sql, new Object[]{matricula, mes, gestion}, (resultSet, i)->{
            RentasConDetalle data = new RentasConDetalle();
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
            data.setFnac(resultSet.getDate("fnac"));
            data.setEstciv(resultSet.getString("estciv"));
            data.setFingre(resultSet.getDate("fingre"));
            data.setAfpren(resultSet.getString("afpren"));
            data.setRendig(resultSet.getString("rendig"));
            data.setPoder(resultSet.getString("poder"));
            data.setCodban(resultSet.getString("codban"));
            data.setTelefono(resultSet.getInt("telefono"));
            data.setCelular(resultSet.getInt("celular"));
            return data;
        });

        TipoRenta tipoRenta = tipoRentaRepository.ObtenerTipoRentaPorCodigo(renta.getTre());
        Regional regional = regionalRepository.ObtenerRegionalPorCodigo(renta.getRegional().toString());
        Grado grado = gradoRepository.ObtenerGradoPorCodigo(renta.getGrados());
        Fuerza fuerza = fuerzaRepository.ObtenerFuerzaPorCodigo(renta.getFuerza());
        List<DetalleRenta> ingresos = detalleRentaRepository.ObtenerIngresosPorMatriculaMesGestion("431003GMM", 8, 2023);
        List<DetalleRenta> egresos = detalleRentaRepository.ObtenerEgresosPorMatriculaMesGestion("431003GMM", 8, 2023);
        Tempo tempo = tempoRepository.ObtenerTempoPorMatriculaMesGestion("431003GMM", 8, 2023);
        renta.setTipoRenta(tipoRenta);
        renta.setRegionalDetalle(regional);
        renta.setFuerzaDetalle(fuerza);
        renta.setGradoDetalle(grado);
        renta.setIngresos(ingresos);
        renta.setEgresos(egresos);
        renta.setTempo(tempo);
        return renta;
    }
}

