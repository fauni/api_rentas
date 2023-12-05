package bo.cossmil.api.rentas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetalleRenta {
    private String codigo;
    private String detalle;
    private Double monto;
}
