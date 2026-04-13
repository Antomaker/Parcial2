# 🚌 Sistema de Transporte — Parcial POO

**Curso:** Programación Orientada a Objetos  
**Herramienta:** NetBeans (Java 11+)  
**Modalidad:** Individual

---

## 📋 Descripción

Este proyecto implementa un **sistema de gestión de transporte** que maneja
vehículos, pasajeros y reservas de viaje.

El sistema está incompleto y contiene **5 errores** distribuidos en los paquetes
`modelo`, `servicios` y `util`. Tu tarea es encontrarlos, corregirlos
y documentar cada corrección con un comentario en el código.

---

## 📁 Estructura del proyecto

```
SistemaTransporte/
├── src/
│   ├── modelo/
│   │   ├── Vehiculo.java          ← Clase abstracta base
│   │   ├── Bus.java               ← Subclase concreta
│   │   ├── TaxiAereo.java         ← Subclase concreta (referencia)
│   │   ├── Pasajero.java          ← Clase de dominio
│   │   └── PasajeroFrecuente.java ← Hereda de Pasajero
│   ├── servicios/
│   │   ├── Reservable.java        ← Interfaz
│   │   └── GestorViaje.java       ← Implementa Reservable
│   ├── util/
│   │   └── ReporteFlota.java      ← Utilidades estadísticas
│   └── ui/
│       └── Main.java              ← ⛔ NO modificar
└── nbproject/                     ← Configuración NetBeans
```

---

## 🚀 Cómo abrir en NetBeans

1. Descarga o clona el repositorio.
2. En NetBeans: **File → Open Project**.
3. Selecciona la carpeta `SistemaTransporte`.
4. Clic en **Open Project**.
5. Ejecuta con el botón ▶ o `Shift + F6` sobre `Main.java`.

---

## 🎯 Tu tarea

1. Lee el código de todos los archivos con atención.
2. Identifica los **5 errores** (no están señalados explícitamente).
3. Corrige cada error en su archivo correspondiente.
4. Agrega un **comentario** encima de cada corrección con el formato:

```java
// CORRECCIÓN: [explica qué estaba mal y por qué es un problema de POO]
```

5. El programa debe compilar y la salida debe coincidir con todos
   los valores **"Esperado"** que aparecen en `Main.java`.

---

## 📊 Criterios de evaluación

| Criterio | Puntos |
|----------|--------|
| Error encontrado y corregido (×5) | 15 pts c/u |
| Comentario explicando el concepto POO involucrado (×5) | 5 pts c/u |
| **Total** | **100 pts** |

---

## 📚 Conceptos evaluados

- Encapsulación (modificadores de acceso)
- Herencia y uso correcto de `super()`
- Clases abstractas y sobreescritura (`@Override`)
- Interfaces e implementación completa
- Polimorfismo en tiempo de ejecución
- Lógica de métodos y análisis de condiciones

---

## 📤 Entrega

1. Sube tu proyecto a **tu repositorio GitHub personal**.
2. Crea una rama con tu nombre: `git checkout -b entrega/TuNombre`
3. Comparte el enlace en el espacio de entrega del campus.

> ⚠️ Entregas sin comentarios explicativos no serán calificadas.
