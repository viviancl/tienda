-- Crear la tabla de Tiendas
CREATE TABLE Tiendas (
  id_tienda INT IDENTITY PRIMARY KEY,
  nombre VARCHAR(50),
  direccion VARCHAR(100),
  telefono VARCHAR(15)
);

-- Crear la tabla de Productos
CREATE TABLE Productos (
  id_producto INT IDENTITY PRIMARY KEY,
  nombre VARCHAR(50),
  precio DECIMAL(10, 2),
  id_tienda INT,
  FOREIGN KEY (id_tienda) REFERENCES Tiendas(id_tienda)
);

-- Crear la tabla de Clientes
CREATE TABLE Clientes (
  id_cliente INT IDENTITY PRIMARY KEY,
  nombre VARCHAR(50),
  direccion VARCHAR(100),
  telefono VARCHAR(15)
);

-- Crear la tabla de Pedidos
CREATE TABLE Pedidos (
  id_pedido INT IDENTITY PRIMARY KEY,
  id_cliente INT,
  fecha_pedido DATE,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);

-- Crear la tabla de Detalle_Pedidos
CREATE TABLE Detalle_Pedidos (
  id_detalle INT IDENTITY PRIMARY KEY,
  id_pedido INT,
  id_producto INT,
  cantidad INT,
  FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);