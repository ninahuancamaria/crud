package vallegrande.edu.pe.service;

import vallegrande.edu.pe.model.Proveedor;
import vallegrande.edu.pe.database.Conexion; // IMPORTANTE

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorService {

    public void agregarProveedor(Proveedor p) {
        String sql = "INSERT INTO proveedores(nombre, ruc, contacto, direccion, tipoFlor) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getRuc());
            ps.setString(3, p.getContacto());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTipoFlor());
            ps.executeUpdate();
            System.out.println("✅ Proveedor agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar: " + e.getMessage());
        }
    }

    public List<Proveedor> listarProveedores() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (Connection con = Conexion.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Proveedor p = new Proveedor(
                        rs.getInt("idProveedor"),
                        rs.getString("nombre"),
                        rs.getString("ruc"),
                        rs.getString("contacto"),
                        rs.getString("direccion"),
                        rs.getString("tipoFlor")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarProveedor(Proveedor p) {
        String sql = "UPDATE proveedores SET nombre=?, ruc=?, contacto=?, direccion=?, tipoFlor=? WHERE idProveedor=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getRuc());
            ps.setString(3, p.getContacto());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTipoFlor());
            ps.setInt(6, p.getIdProveedor());
            ps.executeUpdate();
            System.out.println("✅ Proveedor actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE idProveedor=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Proveedor eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar: " + e.getMessage());
        }
    }
}
