package bo.cossmil.api.rentas.repositories;

import bo.cossmil.api.rentas.models.Operador;
import bo.cossmil.api.rentas.models.TokenR;
import bo.cossmil.api.rentas.services.OperadorServicio;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Repository
public class OperadorRepository implements IOperadorRepository{
    private final JdbcTemplate _jdbcTemplate;

    public OperadorRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    public List<Operador> obtenerTodos(){
        String sql = "SELECT * FROM r_operador";
        return _jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Operador.class));
    }
    public List <Operador> login(String codigo, String clave){
        String sql = "SELECT patope, matope, nomope, estope, actope, faltope,fbajope, regional,repart  \n"+
                "FROM r_operador \n"+
                "WHERE codope = ? and pasope = ?";

        List<Operador> operadores = _jdbcTemplate.query(sql, new Object[]{codigo,clave}, (resultSet, i) -> {
            Operador data = new Operador();
            String sha256="";
            String fechaHora = LocalDateTime.now().toString();
            System.out.print(fechaHora);
            String  cadena = codigo+fechaHora;
            this.logout(codigo);
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.reset();
                md.update(cadena.getBytes(StandardCharsets.UTF_8));
                sha256 = String.format("%064x", new BigInteger(1, md.digest()));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            data.setCodope("");
            data.setPasope(sha256);
            data.setPatope(resultSet.getString("patope"));
            data.setMatope(resultSet.getString("matope"));
            data.setNomope(resultSet.getString("nomope"));
            data.setEstope(resultSet.getString("estope"));
            data.setActope(resultSet.getString("actope"));
            data.setFaltope(resultSet.getDate ("faltope"));
            data.setFbajope(resultSet.getDate("fbajope"));
            data.setRegional(resultSet.getString("regional"));
            data.setRepart(resultSet.getString("repart"));

            new TokenRepository(_jdbcTemplate).create(codigo,sha256);

            return data;
        });

        return operadores;
    }
    public void logout(String usuario){
        new TokenRepository(_jdbcTemplate).cambiaEstado("0",usuario);
    }
}
