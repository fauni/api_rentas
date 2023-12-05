package bo.cossmil.api.rentas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rentas {
    private String matricula;
    private String ci1;
    private Double ci2;
    private String ext_ren;
    private Double tre;
    private String mcausante;
    private String paterno;
    private String materno;
    private String prefijo;
    private String apcasada;
    private String nombre;
    private String nombre2;
    private Integer regional;
    private String fuerza;
    private String grados;
    private String uc;
    private String fc;
    private String um;
    private String fm;
    private Integer estado;
    private String cuenta;
    private LocalDate fnac;
    private String estciv;
    private LocalDate fingre;
    private String afpren;
    private String rendig;
    private String poder;
    private String codban;
    private Integer telefono;
    private Integer celular;
}
