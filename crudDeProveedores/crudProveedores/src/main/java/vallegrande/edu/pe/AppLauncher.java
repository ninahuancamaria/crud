package vallegrande.edu.pe;

import vallegrande.edu.pe.view.ProveedorView;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProveedorView view = new ProveedorView();
            view.setVisible(true);
        });
    }
}
