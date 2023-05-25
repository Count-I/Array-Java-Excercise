public class Persona {

    private String nombre;
    private double peso;
    private double talla;
    private double imc;
    private String estado;

    public Persona(String nombre, double peso, double talla) {
        this.nombre = nombre;
        this.peso = peso;
        this.talla = talla;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public double getTalla() {
        return talla;
    }

    public double getImc() {
        return imc;
    }

    public String getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
