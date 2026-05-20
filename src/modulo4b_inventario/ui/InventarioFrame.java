package modulo4b_inventario.ui;

import utils.UITheme;
import utils.NotificationManager;
import utils.ChartUtils;
import modulo4b_inventario.dao.MaterialDAO;
import modulo4b_inventario.dao.AlmacenDAO;
import modulo4b_inventario.models.Material;
import modulo4b_inventario.models.Almacen;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Frame principal del módulo de Inventario
 */
public class InventarioFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private MaterialDAO materialDAO;
    private AlmacenDAO almacenDAO;
    private JPanel notificationPanel;
    
    public InventarioFrame() {
        setTitle("Módulo Inventario - Constructora Empresa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);
        
        materialDAO = new MaterialDAO();
        almacenDAO = new AlmacenDAO();
        
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
        
        tabbedPane.addTab("📦 Materiales", createMaterialesPanel());
        tabbedPane.addTab("🏢 Almacenes", createAlmacenesPanel());
        tabbedPane.addTab("📊 Estadísticas", createEstadisticasPanel());
        
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        
        setContentPane(mainPanel);
    }
    
    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyThemeDark(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setPreferredSize(new Dimension(0, 70));
        
        JLabel titleLabel = new JLabel("📦 Gestión de Inventario");
        UITheme.styleTitleLabel(titleLabel);
        panel.add(titleLabel, BorderLayout.WEST);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        UITheme.applyThemeDark(buttonPanel);
        
        JButton btnActualizar = new JButton("🔄 Actualizar");
        UITheme.styleButton(btnActualizar);
        btnActualizar.addActionListener(e -> recargarDatos());
        buttonPanel.add(btnActualizar);
        
        JButton btnExportar = new JButton("📥 Exportar");
        UITheme.styleButton(btnExportar);
        buttonPanel.add(btnExportar);
        
        panel.add(buttonPanel, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createMaterialesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de controles
        JPanel controlPanel = createControlPanel();
        panel.add(controlPanel, BorderLayout.NORTH);
        
        // Tabla de materiales
        JTable table = new JTable();
        UITheme.styleTable(table);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Nombre", "Unidad", "Categoría", "Proveedor"});
        table.setModel(model);
        
        // Cargar datos
        List<Material> materiales = materialDAO.obtenerTodos();
        for (Material m : materiales) {
            model.addRow(new Object[]{m.getIdMaterial(), m.getNombreMaterial(), m.getUnidadMedida(), 
                m.getIdCategoriaMaterial(), m.getIdProveedor()});
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createAlmacenesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de controles
        JPanel controlPanel = createControlPanel();
        panel.add(controlPanel, BorderLayout.NORTH);
        
        // Tabla de almacenes
        JTable table = new JTable();
        UITheme.styleTable(table);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Nombre", "Ubicación"});
        table.setModel(model);
        
        // Cargar datos
        List<Almacen> almacenes = almacenDAO.obtenerTodos();
        for (Almacen a : almacenes) {
            model.addRow(new Object[]{a.getIdAlmacen(), a.getNombreAlmacen(), a.getUbicacionAlmacen()});
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createEstadisticasPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        UITheme.applyTheme(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Gráfico de materiales
        Map<String, Integer> dataMateriales = new HashMap<>();
        dataMateriales.put("Acero", 150);
        dataMateriales.put("Concreto", 200);
        dataMateriales.put("Madera", 100);
        dataMateriales.put("Vidrio", 80);
        
        JPanel chartPanel = ChartUtils.createBarChart("Materiales por Cantidad", dataMateriales);
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
        btnNuevo.addActionListener(e -> NotificationManager.showSuccess("Nuevo registro agregado"));
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
            InventarioFrame frame = new InventarioFrame();
            frame.setVisible(true);
        });
    }
}
