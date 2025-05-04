package tp3.ejercicio4;

public class AreaEmpresa {
    private String identificacion;
    private int tardanza;

    public AreaEmpresa(String i, int t){
        this.identificacion=i;
        this.tardanza=t;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }


}
