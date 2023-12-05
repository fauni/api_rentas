package bo.cossmil.api.rentas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Regional {
    private String cod_reg;
    private String descripcion;
    private int cod_alt;
    private String abr_reg;
}
