import { useForm } from "react-hook-form";
import type { Producto } from "./intentario.interface";

export default function InventarioForm({ 
  productoNuevo,
  isSubmitting 
}: { 
  productoNuevo: (value: Omit<Producto, 'idProducto'>) => Promise<void>,
  isSubmitting: boolean
}) {
  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm();

  const onSubmit = handleSubmit(async (data) => {
    const productoData = {
      nombreProducto: data.nombreProducto,
      cantidad: 0,       // Valor fijo
      estado: false     // Valor fijo
    };
    
    await productoNuevo(productoData);
    reset();
  });

  return (
    <form onSubmit={onSubmit} className="mb-6 p-4 bg-gray-100 rounded">
      <div className="flex items-center gap-4">
        <div>
          <input
            {...register('nombreProducto', { required: true })}
            className="p-2 border rounded"
            placeholder="Nombre del producto"
            disabled={isSubmitting}
          />
          {errors.nombreProducto && (
            <p className="text-red-500 text-sm">Nombre es requerido</p>
          )}
        </div>

        <button
          type="submit"
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          disabled={isSubmitting}
        >
          {isSubmitting ? 'Enviando...' : 'Agregar Producto'}
        </button>
      </div>
    </form>
  );
}