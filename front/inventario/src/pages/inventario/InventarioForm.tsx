import { useForm } from "react-hook-form";
import type { Producto } from "./intentario.interface";


export default function InventarioForm( {productoNuevo} : {productoNuevo: (value: Producto) => void}) {
    
    const {
        register,
        handleSubmit,
        formState: { errors },
      } = useForm();

      const onSubmit = handleSubmit(data => {
        const dataForm:Producto = {
            idProducto: 0,
            nombreProducto: data.Producto,
            cantidad:       0,
            estado:         false,
        }
        productoNuevo(dataForm)
      })
    
      return (
        <form onSubmit={onSubmit}>
          <input {...register('Producto', { required: true })} 
                className="ml-4 mb-4"
                placeholder="Producto"
          />
          {errors.lastName && <p>Nombre del producto es requerido.</p>}
          <button
                type="submit"
                className="bg-blue-300 hover:bg-black hover:text-white text-black font-bold py-2 px-3 rounded-full mt-4">
                Agregar
           </button>
        </form>
      );
}
