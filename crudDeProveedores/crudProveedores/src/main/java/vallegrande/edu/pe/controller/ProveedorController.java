package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Proveedor;
import vallegrande.edu.pe.service.ProveedorService;

public class ProveedorController {

    private ProveedorService service;

    public ProveedorController() {
        service = new ProveedorService();
    }

    public boolean agregarProveedor(Proveedor proveedor) {
        try {
            service.agregarProveedor(proveedor);
            return true;
        } catch (Exception e) {
            System.out.println("❌ Error en Controller: " + e.getMessage());
            return false;
        }
    }
}
