package bo.cossmil.api.rentas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operador {
    private String codope;
    private String patope;
    private String matope;
    private String nomope;
    private String estope;
    private String actope;
    private Date faltope;
    private Date fbajope;
    private  String pasope;
    private String regional;
    private String repart;

}
