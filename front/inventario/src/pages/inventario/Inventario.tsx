import { useEffect, useState } from "react"
import InventarioForm from "./InventarioForm"
import type { Producto } from "./intentario.interface"
import { getHttp, postHttp, putHttp } from "../../services/api"

export const Inventario = () =>{
    const [productos, setProductos] = useState<Producto[]>([])

    const [isSubmitting, setIsSubmitting] = useState(false);

    const productoNuevo = async (nuevoProducto: Omit<Producto, 'idProducto'>) => {
      setIsSubmitting(true);
      try {
        const productoGuardado = await postHttp(nuevoProducto);
        setProductos(prev => [...prev, productoGuardado]);
      } catch (error) {
        console.error('Error al guardar el producto:', error);
        throw error;
      } finally {
        setIsSubmitting(false);
      }
    };

      const [loading, setLoading] = useState<boolean>(true);
      const [error, setError] = useState<string | null>(null);
    
      useEffect(() => {
        const fetchUsers = async () => {
          try {
            const data = await getHttp('productos');
            setProductos(data);
          } catch (err) {
            setError('Error al cargar los productos');
            console.error(err);
          } finally {
            setLoading(false);
          }
        };
    
        fetchUsers();
      }, []);
    
      if (loading) return <div>Cargando usuarios...</div>;
      if (error) return <div>{error}</div>;


      const estadoProducto = async (idProducto: number) => {
        try {
          // Encuentra el producto actual para obtener el estado contrario
          const productoActual = productos.find(p => p.idProducto === idProducto);
          if (!productoActual) return;
      
          const nuevoEstado = !productoActual.estado;
      
          // 1. Optimistic UI update - actualiza el estado local primero
          setProductos(prevProductos => 
            prevProductos.map(producto => 
              producto.idProducto === idProducto
                ? { ...producto, estado: nuevoEstado }
                : producto
            )
          );
      
          // 2. Envía la petición a la API
          await putHttp(idProducto, { tipo: 'estado', valor: nuevoEstado });
      
          // 3. Si hay éxito, no necesitamos hacer nada más (ya actualizamos optimistamente)
          
        } catch (error) {
          // Si hay error, revertimos el cambio
          setProductos(prevProductos => 
            prevProductos.map(producto => 
              producto.idProducto === idProducto
                ? { ...producto, estado: !producto.estado } // Volvemos al estado anterior
                : producto
            )
          );
          
          // Puedes mostrar un mensaje de error al usuario
          console.error('Error al actualizar el estado:', error);
          alert('No se pudo actualizar el estado del producto');
        }
      };

      const aumentarCantidad = async (idProducto: number) => {
        try {
          // Optimistic UI update - actualiza primero el estado local
          setProductos(prevProductos => 
            prevProductos.map(producto => 
              producto.idProducto === idProducto
                ? { ...producto, cantidad: producto.cantidad + 1 }
                : producto
            )
          );
      
          // Envía la petición a la API
          await putHttp(idProducto, { 
            tipo: 'cantidad', 
            valor: productos.find(p => p.idProducto === idProducto)!.cantidad + 1 
          });
      
        } catch (error) {
          // Si hay error, revertimos el cambio
          setProductos(prevProductos => 
            prevProductos.map(producto => 
              producto.idProducto === idProducto
                ? { ...producto, cantidad: producto.cantidad - 1 } // Revertimos el incremento
                : producto
            )
          );
          
          console.error('Error al aumentar cantidad:', error);
          alert('No se pudo actualizar la cantidad del producto');
        }
      };

    const disminuirCantidad = () =>{
        alert('No se puede disminuir la cantidad del producto')
    }

    return (
        <div className="mx-auto mt-12">
            <InventarioForm 
              productoNuevo={productoNuevo}
              isSubmitting={isSubmitting}
            />
            <table className="table-auto w-full">
                <thead className="bg-gray-800 text-white">
                    <tr>
                        <th className="text-center px-8">ID</th>
                        <th className="text-center px-4">NOMBRE</th>
                        <th className="text-center px-4">CANTIDAD</th>
                        <th className="text-center px-4">ESTADO</th>
                        <th className="text-center px-4">Agregar</th>
                        <th className="text-center px-4">Disminuir</th>
                        <th className="text-center px-4">Baja</th>
                    </tr>
                </thead>
                <tbody>
                    {productos.map( ({idProducto, nombreProducto, cantidad, estado}:Producto, index:number) =>{
                            const estiloFila = index % 2 === 0 ? "bg-gray-300 text-center" : "bg-white text-center"
                            const estiloEstado = estado ? "bg-green-500 text-center" : "bg-yellow-500 text-center"
                            return (
                                <tr key={idProducto}>
                                <td className={estiloFila}>{idProducto}</td>
                                    <td className={estiloFila}>{nombreProducto}</td>
                                    <td className={estiloFila}>{cantidad}</td>
                                    <td className={estiloEstado}>{estado ? "Activo" : "Inactivo"}</td>
                                    <td>
                                    <button
                                            onClick={() => aumentarCantidad(idProducto)}
                                            className="bg-green-300 hover:bg-black hover:text-white text-black font-bold py-2 px-3 rounded-full mt-4">
                                            Agregar
                                        </button>
                                    
                                    </td>
                                    <td>
                                        <button
                                            onClick={disminuirCantidad}
                                            className="bg-yellow-300 hover:bg-black hover:text-white text-black font-bold py-2 px-3 rounded-full mt-4">
                                            Disminuir
                                        </button>
                                    </td>
                                    <td>
                                        <button
                                            onClick={() => estadoProducto(idProducto)}
                                            className="bg-gray-300 hover:bg-black hover:text-white text-black font-bold py-2 px-3 rounded-full mt-4">
                                            
                                            {estado ? "Desactivar" : "Activar"}
                                        </button>
                                    </td>
                                </tr>
                            )
                        })}            
                </tbody>
            </table>
        </div>
    //  ) : <div className="flex flex-col justify-center items-center">
    //         <p className="text-center mt-16">No hay elementos en la tabla</p> 
    //         <InventarioForm productoNuevo={(value) => productoNuevo(value)}/>
    //     </div>
        )
}