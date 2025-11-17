package vallegrande.edu.pe.view;

import vallegrande.edu.pe.model.Proveedor;
import vallegrande.edu.pe.service.ProveedorService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ProveedorView extends JFrame {

    private ProveedorService service = new ProveedorService();

    private JTable tabla;
    private DefaultTableModel modelo;

    private JTextField tfNombre, tfRuc, tfContacto, tfDireccion, tfTipoFlor;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnListar;

    public ProveedorView() {
        setTitle("Gestión de Proveedores");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🔹 Tabla
        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "RUC", "Contacto", "Dirección", "Tipo de Flor"}, 0);
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // 🔹 Panel de formulario
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));

        panelForm.add(new JLabel("Nombre:"));
        tfNombre = new JTextField();
        panelForm.add(tfNombre);

        panelForm.add(new JLabel("RUC:"));
        tfRuc = new JTextField();
        panelForm.add(tfRuc);

        panelForm.add(new JLabel("Contacto:"));
        tfContacto = new JTextField();
        panelForm.add(tfContacto);

        panelForm.add(new JLabel("Dirección:"));
        tfDireccion = new JTextField();
        panelForm.add(tfDireccion);

        panelForm.add(new JLabel("Tipo de Flor:"));
        tfTipoFlor = new JTextField();
        panelForm.add(tfTipoFlor);

        // 🔹 Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(panelForm, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);

        // 🔹 Acciones de botones
        btnListar.addActionListener(this::listarProveedores);
        btnAgregar.addActionListener(this::agregarProveedor);
        btnActualizar.addActionListener(this::actualizarProveedor);
        btnEliminar.addActionListener(this::eliminarProveedor);
    }

    // 🔹 Métodos de acción
    private void listarProveedores(ActionEvent e) {
        modelo.setRowCount(0); // Limpiar tabla
        List<Proveedor> lista = service.listarProveedores();
        for (Proveedor p : lista) {
            modelo.addRow(new Object[]{p.getIdProveedor(), p.getNombre(), p.getRuc(),
                    p.getContacto(), p.getDireccion(), p.getTipoFlor()});
        }
    }

    private void agregarProveedor(ActionEvent e) {
        Proveedor p = new Proveedor(0,
                tfNombre.getText(),
                tfRuc.getText(),
                tfContacto.getText(),
                tfDireccion.getText(),
                tfTipoFlor.getText());
        service.agregarProveedor(p);
        listarProveedores(null); // Refrescar tabla
    }

    private void actualizarProveedor(ActionEvent e) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int id = (int) modelo.getValueAt(fila, 0);
            Proveedor p = new Proveedor(id,
                    tfNombre.getText(),
                    tfRuc.getText(),
                    tfContacto.getText(),
                    tfDireccion.getText(),
                    tfTipoFlor.getText());
            service.actualizarProveedor(p);
            listarProveedores(null); // Refrescar tabla
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor para actualizar.");
        }
    }

    private void eliminarProveedor(ActionEvent e) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int id = (int) modelo.getValueAt(fila, 0);
            service.eliminarProveedor(id);
            listarProveedores(null); // Refrescar tabla
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un proveedor para eliminar.");
        }
    }
}
