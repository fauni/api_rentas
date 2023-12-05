package bo.cossmil.api.rentas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentasConDetalle {
    private String matricula;
    private String ci1;
    private Double ci2;
    private String ext_ren;
    private Double tre;
    private TipoRenta tipoRenta;
    private String mcausante;
    private String paterno;
    private String materno;
    private String prefijo;
    private String apcasada;
    private String nombre;
    private String nombre2;
    private Integer regional;
    private Regional regionalDetalle;
    private String fuerza;
    private Fuerza fuerzaDetalle;
    private String grados;
    private Grado gradoDetalle;
    private String uc;
    private String fc;
    private String um;
    private String fm;
    private Integer estado;
    private String cuenta;
    private Date fnac;
    private String estciv;
    private Date fingre;
    private String afpren;
    private String rendig;
    private String poder;
    private String codban;
    private Integer telefono;
    private Integer celular;
    private List<DetalleRenta> ingresos;
    private List<DetalleRenta> egresos;

    private Tempo tempo;
}
