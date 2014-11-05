package app;

import java.awt.Color;
import java.util.Enumeration;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class Startup {

    public static void main(String[] args) {
        UIManager.put("OptionPane.background", new Color(60, 60, 60));
        UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
        UIManager.put("OptionPane.messageFont", new java.awt.Font("Segoe UI", 1, 16));

        UIManager.put("Panel.background", new Color(60, 60, 60));
        UIManager.put("ScrollPane.background", new Color(60, 60, 60));

        UIManager.put("Label.foreground", new Color(255, 255, 255));
        UIManager.put("Label.font", new java.awt.Font("Segoe UI", 1, 16));

        UIManager.put("TextField.font", new java.awt.Font("Segoe UI", 1, 16));

        UIManager.put("ComboBox.font", new java.awt.Font("Segoe UI", 1, 18));
        UIManager.put("ComboBox.background", new Color(255, 255, 255));

        UIManager.put("Button.font", new java.awt.Font("Segoe UI", 1, 18));
        UIManager.put("Button.foreground", new Color(255, 255, 255));

        UIManager.put("Table.font", new java.awt.Font("Segoe UI", 1, 16));
        UIManager.put("Table.foreground", new Color(255, 255, 255));
        UIManager.put("Table.background", new Color(60, 60, 60));

        UIManager.put("TableHeader.font", new java.awt.Font("Segoe UI", 1, 18));
        UIManager.put("TableHeader.foreground", new Color(255, 255, 255));

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
