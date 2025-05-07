// src/types.ts
export interface Rol {
    idRol: number;
    nombreRol?: string;
  }
  
  export interface Usuario {
    idUsuario: number;
    nombre: string;
    correo: string;
    contrasena?: string; // Opcional porque no deberías exponer contraseñas
    idRol: Rol | number;
    estatus: boolean;
  }