package modulo4d_subcontratistas.ui;

import utils.UITheme;
import utils.NotificationManager;
import utils.ChartUtils;
import modulo4d_subcontratistas.dao.SubcontratistaDAO;
import modulo4d_subcontratistas.models.Subcontratista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Frame principal del módulo de Subcontratistas
 */
public class SubcontratistasFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private SubcontratistaDAO subcontratistaDAO;
    private JPanel notificationPanel;
    
    public SubcontratistasFrame() {
        setTitle("Módulo Subcontratistas - Constructora Empresa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);
        
        subcontratistaDAO = new SubcontratistaDAO();
        
        initComponents();
    }
    
    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        UITheme.applyTheme(mainPanel);
        
        // Panel de encabezado
        JPanel headerPanel = createHeaderPanel();
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Panel de notificaciones
        notificationPanel = new JPanel();
        notificationPanel.setLayout(new BoxLayout(notificationPanel, BoxLayout.Y_AXIS));
        UITheme.applyTheme(notificationPanel);
        NotificationManager.setContainerPanel(notificationPanel);
        mainPanel.add(notificationPanel, BorderLayout.PAGE_END);
        
        // Panel con pestañas
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(UITheme.COLOR_BG);
        tabbedPane.setForeground(UITheme.COLOR_TEXT);
        tabbedPane.setFont(UITheme.FONT_LABEL);
        
        tabbedPane.addTab("👷 Subcontratistas", createSubcontratistasPanel());
        tabbedPane.addTab("📋 Contratos", createContratosPanel());
        tabbedPane.addTab("💳 Pagos", createPagosPanel());
        tabbedPane.addTab("⭐ Evaluación", createEvaluacionPanel());
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        setContentPane(mainPanel);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyThemeDark(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setPreferredSize(new Dimension(0, 70));
        
        JLabel titleLabel = new JLabel("👷 Gestión de Subcontratistas");
        UITheme.styleTitleLabel(titleLabel);
        panel.add(titleLabel, BorderLayout.WEST);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        UITheme.applyThemeDark(buttonPanel);
        
        JButton btnActualizar = new JButton("🔄 Actualizar");
        UITheme.styleButton(btnActualizar);
        btnActualizar.addActionListener(e -> recargarDatos());
        buttonPanel.add(btnActualizar);
        
        JButton btnReportes = new JButton("📊 Reportes");
        UITheme.styleButton(btnReportes);
        buttonPanel.add(btnReportes);
        
        panel.add(buttonPanel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createSubcontratistasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de controles
        JPanel controlPanel = createControlPanel();
        panel.add(controlPanel, BorderLayout.NORTH);
        
        // Tabla de subcontratistas
        JTable table = new JTable();
        UITheme.styleTable(table);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Nombre", "Especialidad", "Teléfono", "Email", "CI"});
        table.setModel(model);
        
        // Cargar datos
        List<Subcontratista> subcontratistas = subcontratistaDAO.obtenerTodos();
        for (Subcontratista s : subcontratistas) {
            model.addRow(new Object[]{s.getIdSubcontratista(), s.getNombreSubcontratista(), s.getEspecialidad(),
                s.getTelefonoSubcontratista(), s.getEmailSubcontratista(), s.getCiSubcontratista()});
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createContratosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de controles
        JPanel controlPanel = createControlPanel();
        panel.add(controlPanel, BorderLayout.NORTH);
        
        // Tabla de contratos
        JTable table = new JTable();
        UITheme.styleTable(table);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Número", "Subcontratista", "Proyecto", "Inicio", "Fin", "Monto", "Estado"});
        table.setModel(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createPagosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de controles
        JPanel controlPanel = createControlPanel();
        panel.add(controlPanel, BorderLayout.NORTH);
        
        // Tabla de pagos
        JTable table = new JTable();
        UITheme.styleTable(table);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Subcontratista", "Monto", "Fecha", "Método", "Estado"});
        table.setModel(model);
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createEvaluacionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Gráfico de evaluaciones
        Map<String, Integer> dataEvaluaciones = new HashMap<>();
        dataEvaluaciones.put("Excelente", 45);
        dataEvaluaciones.put("Bueno", 30);
        dataEvaluaciones.put("Regular", 15);
        dataEvaluaciones.put("Malo", 10);
        
        JPanel chartPanel = ChartUtils.createPieChart("Evaluación de Subcontratistas", dataEvaluaciones);
        panel.add(chartPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        UITheme.applyTheme(buttonPanel);
        
        JButton btnNuevo = new JButton("➕ Nuevo");
        UITheme.styleButton(btnNuevo);
        btnNuevo.addActionListener(e -> NotificationManager.showSuccess("Nuevo subcontratista agregado"));
        buttonPanel.add(btnNuevo);
        
        JButton btnEditar = new JButton("✏️ Editar");
        UITheme.styleButton(btnEditar);
        buttonPanel.add(btnEditar);
        
        JButton btnEliminar = new JButton("🗑️ Eliminar");
        UITheme.styleButtonDanger(btnEliminar);
        buttonPanel.add(btnEliminar);
        
        JTextField searchField = new JTextField(20);
        UITheme.styleTextField(searchField);
        searchField.setPreferredSize(new Dimension(250, 30));
        buttonPanel.add(new JLabel("🔍 Buscar:"));
        buttonPanel.add(searchField);
        
        panel.add(buttonPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void recargarDatos() {
        NotificationManager.showInfo("Datos recargados");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SubcontratistasFrame frame = new SubcontratistasFrame();
            frame.setVisible(true);
        });
    }
}
