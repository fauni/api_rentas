package bo.cossmil.api.rentas.models;

public class ClaseRenta {
    private String codren;
    private String desren;

    public ClaseRenta(){

    }
    public ClaseRenta(String codren, String desren) {
        this.codren = codren;
        this.desren = desren;
    }

    public String getCodren() {
        return codren;
    }

    public void setCodren(String codren) {
        this.codren = codren;
    }

    public String getDesren() {
        return desren;
    }

    public void setDesren(String desren) {
        this.desren = desren;
    }
}
