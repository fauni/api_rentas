package bo.cossmil.api.rentas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenR {
    public String id ;
    public String usuario;
    public String token ;
    public String activo ;
    public String fecha_token;
}
