/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo4b_inventario.dao;

import config.DatabaseConnection;
import modulo4b_inventario.models.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public List<Material> obtenerTodos() throws SQLException {
        List<Material> lista = new ArrayList<>();
        String query = "SELECT * FROM materiales";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                lista.add(new Material(
                    rs.getInt("id_material"),
                    rs.getString("nombre_material"),
                    rs.getString("unidad_medida"),
                    rs.getInt("id_categoria_material"),
                    rs.getInt("id_proveedor")
                ));
            }
        }
        return lista;
    }

    public Material obtenerPorId(int id) throws SQLException {
        String query = "SELECT * FROM materiales WHERE id_material = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Material(
                    rs.getInt("id_material"),
                    rs.getString("nombre_material"),
                    rs.getString("unidad_medida"),
                    rs.getInt("id_categoria_material"),
                    rs.getInt("id_proveedor")
                );
            }
        }
        return null;
    }

    public int crear(Material m) throws SQLException {
        String query = "INSERT INTO materiales (nombre_material, unidad_medida, id_categoria_material, id_proveedor) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, m.getNombreMaterial());
            pstmt.setString(2, m.getUnidadMedida());
            pstmt.setInt(3, m.getIdCategoriaMaterial());
            pstmt.setInt(4, m.getIdProveedor());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }

    public boolean actualizar(Material m) throws SQLException {
        String query = "UPDATE materiales SET nombre_material=?, unidad_medida=?, id_categoria_material=?, id_proveedor=? WHERE id_material=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, m.getNombreMaterial());
            pstmt.setString(2, m.getUnidadMedida());
            pstmt.setInt(3, m.getIdCategoriaMaterial());
            pstmt.setInt(4, m.getIdProveedor());
            pstmt.setInt(5, m.getIdMaterial());
            return pstmt.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String query = "DELETE FROM materiales WHERE id_material = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }
}