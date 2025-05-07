
export interface Producto {
    idProducto:     number,
    nombreProducto: string,
    cantidad:       number,
    estado:         boolean, //cambiar a estatus
}

export type Productos = Producto[]

export interface ProductosProps {
    productos: Productos;
}
