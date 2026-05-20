# ✅ Módulos 4B, 4C, 4D - COMPLETADOS

## 🎨 Tema Moderno Unificado

### Características Visuales:
- **Color Principal**: Azul Profesional (#2C3E50)
- **Color Secundario**: Azul Claro (#3498DB)
- **Tipografía Uniforme**: Segoe UI en toda la aplicación
- **Notificaciones**: Sistema de notificaciones integrado
- **Gráficos**: Gráficos de barras y pastel
- **Diseño Responsivo**: Interfaz moderna y profesional

---

## 📦 Módulo 4B - Inventario

### Componentes:
- ✅ **Material.java** - Modelo de material
- ✅ **Almacen.java** - Modelo de almacén
- ✅ **InventarioMaterial.java** - Control de stock
- ✅ **MovimientoInventario.java** - Registro de movimientos
- ✅ **MaterialDAO.java** - Acceso a datos
- ✅ **AlmacenDAO.java** - Acceso a datos
- ✅ **InventarioFrame.java** - Interfaz moderna con:
  - Pestaña de materiales
  - Pestaña de almacenes
  - Pestaña de estadísticas con gráficos
  - Sistema de notificaciones

### Funcionalidades:
- Gestión de materiales con CRUD completo
- Control de almacenes
- Movimientos de entrada/salida
- Alertas de stock mínimo
- Estadísticas visuales

---

## 🏢 Módulo 4C - Proveedores

### Componentes:
- ✅ **Proveedor.java** - Modelo de proveedor
- ✅ **ProveedorDAO.java** - Acceso a datos
- ✅ **ProveedoresFrame.java** - Interfaz moderna con:
  - Pestaña de proveedores
  - Pestaña de órdenes de compra
  - Pestaña de análisis con gráficos de pastel
  - Búsqueda y filtros
  - Sistema de notificaciones

### Funcionalidades:
- Registro y gestión de proveedores
- Órdenes de compra
- Categorización de proveedores
- Histórico de compras
- Análisis gráfico de compras por proveedor

---

## 👷 Módulo 4D - Subcontratistas

### Componentes:
- ✅ **Subcontratista.java** - Modelo de subcontratista
- ✅ **SubcontratistaDAO.java** - Acceso a datos
- ✅ **SubcontratistasFrame.java** - Interfaz moderna con:
  - Pestaña de subcontratistas
  - Pestaña de contratos
  - Pestaña de pagos
  - Pestaña de evaluación con gráficos
  - Sistema de notificaciones completo

### Funcionalidades:
- Registro de subcontratistas por especialidad
- Gestión de contratos
- Control de pagos
- Sistema de evaluación de desempeño
- Análisis gráfico de evaluaciones

---

## 🛠️ Utilidades Compartidas

### UITheme.java
- Centralización de estilos
- Colores uniforme
- Fuentes Segoe UI
- Métodos para aplicar temas a componentes

### NotificationManager.java
- Sistema de notificaciones tipo Toast
- 4 tipos de notificaciones (SUCCESS, ERROR, WARNING, INFO)
- Auto-cierre después de 4 segundos
- Integración con cada módulo

### ChartUtils.java
- Gráficos de barras personalizados
- Gráficos de pastel (Pie Chart)
- Datos dinámicos
- Colores según tema

---

## 📊 Características de las Interfaces

### InventarioFrame
```
┌─────────────────────────────────────┐
│ 📦 Gestión de Inventario [Actualizar][Exportar]
├─────────────────────────────────────┤
│ [📦 Materiales] [🏢 Almacenes] [📊 Estadísticas] │
│                                     │
│  [➕ Nuevo] [✏️ Editar] [🗑️ Eliminar]  │
│  [🔍 Buscar: ________]              │
│                                     │
│ ┌─────────────────────────────────┐ │
│ │ ID │ Nombre │ Unidad │ ...     │ │
│ └─────────────────────────────────┘ │
└─────────────────────────────────────┘
```

### ProveedoresFrame
```
┌─────────────────────────────────────┐
│ 🏢 Gestión de Proveedores [Actualizar][Reportes]
├─────────────────────────────────────┤
│ [🏢 Proveedores] [📋 Órdenes] [📊 Análisis] │
│                                     │
│  [➕ Nuevo] [✏️ Editar] [🗑️ Eliminar]  │
│  [🔍 Buscar: ________]              │
│                                     │
│ ┌─────────────────────────────────┐ │
│ │ Gráfico de Pastel:              │ │
│ │ Compras por Proveedor           │ │
│ └─────────────────────────────────┘ │
└─────────────────────────────────────┘
```

### SubcontratistasFrame
```
┌─────────────────────────────────────┐
│ 👷 Gestión de Subcontratistas [Actualizar][Reportes]
├─────────────────────────────────────┤
│ [👷 Subcontratistas] [📋 Contratos] [💳 Pagos] [⭐ Evaluación] │
│                                     │
│  [➕ Nuevo] [✏️ Editar] [🗑️ Eliminar]  │
│  [🔍 Buscar: ________]              │
│                                     │
│ ┌─────────────────────────────────┐ │
│ │ Gráfico de Evaluaciones:        │ │
│ │ ⭐ Excelente: 45%               │ │
│ │ ⭐ Bueno: 30%                   │ │
│ │ ⭐ Regular: 15%                 │ │
│ │ ⭐ Malo: 10%                    │ │
│ └─────────────────────────────────┘ │
└─────────────────────────────────────┘
```

---

## 🚀 Cómo Usar

### 1. Clonar el repositorio
```bash
git clone https://github.com/melaniurena240-code/Empresa.git
cd Empresa
```

### 2. Compilar en NetBeans
```
Clean and Build
```

### 3. Ejecutar cada módulo
```bash
# Desde NetBeans, ejecutar el main() de cada Frame:
java modulo4b_inventario.ui.InventarioFrame
java modulo4c_proveedores.ui.ProveedoresFrame
java modulo4d_subcontratistas.ui.SubcontratistasFrame
```

---

## 📱 Notificaciones Disponibles

```java
// Éxito (Verde)
NotificationManager.showSuccess("Operación completada");

// Error (Rojo)
NotificationManager.showError("Ocurrió un error");

// Advertencia (Naranja)
NotificationManager.showWarning("Advertencia importante");

// Información (Azul)
NotificationManager.showInfo("Información útil");
```

---

## 🎨 Colores Disponibles

```java
UITheme.COLOR_PRIMARY       // Azul oscuro #2C3E50
UITheme.COLOR_SECONDARY     // Azul claro #3498DB
UITheme.COLOR_ACCENT        // Naranja #E67E22
UITheme.COLOR_BG            // Gris claro #ECF0F1
UITheme.COLOR_TEXT          // Texto oscuro #2C3E50
UITheme.COLOR_SUCCESS       // Verde #27AE60
UITheme.COLOR_DANGER        // Rojo #E74C3C
UITheme.COLOR_WARNING       // Naranja #F1C40F
UITheme.COLOR_INFO          // Azul #3498DB
```

---

## 📋 Base de Datos - Conexión

Asegúrate de que tu `DatabaseConnection.java` esté configurado correctamente:

```java
private static final String SERVER = "localhost";
private static final String PORT = "1433";
private static final String DATABASE = "nombre_db";
private static final String USERNAME = "sa";
private static final String PASSWORD = "tu_password";
```

---

## ✨ Características Implementadas

✅ Tema moderno y unificado
✅ Tipografía única (Segoe UI)
✅ Sistema de notificaciones
✅ Gráficos interactivos
✅ CRUD completo para cada módulo
✅ Búsqueda y filtros
✅ Integración con Base de Datos
✅ Diseño responsivo
✅ Iconos en botones
✅ Validaciones
✅ Pestañas organizadas
✅ Tabla profesional con estilos

---

## 📝 Notas Importantes

1. Todos los módulos utilizan el mismo tema para consistencia
2. La tipografía Segoe UI debe estar disponible en el sistema
3. Los DAO están preparados para SQL Server
4. Las notificaciones se cierran automáticamente
5. Los gráficos se actualizan dinámicamente

---

## 👨‍💻 Autor

**Integrante 4** - Módulos 4A, 4B, 4C, 4D

---

**Última actualización**: 2026-05-20
**Versión**: v2.0 - Módulos B, C, D completados con interfaz moderna
