package vallegrande.edu.pe.model;

public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String ruc;
    private String contacto;
    private String direccion;
    private String tipoFlor;

    public Proveedor(int idProveedor, String nombre, String ruc, String contacto, String direccion, String tipoFlor) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.ruc = ruc;
        this.contacto = contacto;
        this.direccion = direccion;
        this.tipoFlor = tipoFlor;
    }

    // Getters y Setters
    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTipoFlor() { return tipoFlor; }
    public void setTipoFlor(String tipoFlor) { this.tipoFlor = tipoFlor; }

    // 🔹 Método toString() para mostrar los datos de forma legible
    @Override
    public String toString() {
        return "Proveedor {" +
                "ID=" + idProveedor +
                ", Nombre='" + nombre + '\'' +
                ", RUC='" + ruc + '\'' +
                ", Contacto='" + contacto + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Tipo de Flor='" + tipoFlor + '\'' +
                '}';
    }
}
