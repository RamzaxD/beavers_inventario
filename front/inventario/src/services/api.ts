// src/services/api.ts
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:4000', // URL de tu backend
});

export const getHttp = async (ruta:string) => {
  try {
    const response = await api.get(`/${ruta}`);
    return response.data;
  } catch (error) {
    console.error(`Error fetching ${ruta}:`, error);
    throw error;
  }
};

export const putHttp = async (
  idProducto: number, 
  datoEditar: { tipo: 'estado', valor: boolean } | { tipo: 'cantidad', valor: number }
) => {
  try {
    // Crear el objeto a enviar basado en el tipo
    const payload = datoEditar.tipo === 'estado' 
      ? { estado: datoEditar.valor } 
      : { cantidad: datoEditar.valor };

    const response = await api.put(`/productos/${idProducto}`, payload);
    return response.data;
  } catch (error) {
    console.error(`Error al actualizar ${datoEditar.tipo}:`, error);
    throw error;
  }
};

