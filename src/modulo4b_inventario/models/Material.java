package modulo4b_inventario.models;

import java.io.Serializable;

public class Material implements Serializable {

    private int idMaterial;
    private String nombreMaterial;
    private String unidadMedida;
    private int idCategoriaMaterial;
    private int idProveedor;

    public Material() {
    }

    public Material(
            int idMaterial,
            String nombreMaterial,
            String unidadMedida,
            int idCategoriaMaterial,
            int idProveedor
    ) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.unidadMedida = unidadMedida;
        this.idCategoriaMaterial = idCategoriaMaterial;
        this.idProveedor = idProveedor;
    }

    // GETTERS Y SETTERS

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getIdCategoriaMaterial() {
        return idCategoriaMaterial;
    }

    public void setIdCategoriaMaterial(int idCategoriaMaterial) {
        this.idCategoriaMaterial = idCategoriaMaterial;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
}
