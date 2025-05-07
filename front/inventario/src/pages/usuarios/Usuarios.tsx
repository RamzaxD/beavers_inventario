// src/components/UserList.tsx
import React, { useEffect, useState } from 'react';
import type { Usuario } from '../../interface/Users.interface';
import { getHttp } from '../../services/api';


const Usuarios: React.FC = () => {
  const [users, setUsers] = useState<Usuario[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const data = await getHttp('users');
        setUsers(data);
      } catch (err) {
        setError('Error al cargar los usuarios');
        console.error(err);
      } finally {
        setLoading(false);
      }
    };

    fetchUsers();
  }, []);

  if (loading) return <div>Cargando usuarios...</div>;
  if (error) return <div>{error}</div>;

  return (
    <div>
      <h2>Lista de Usuarios</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Rol</th>
            <th>Estatus</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.idUsuario}>
              <td>{user.idUsuario}</td>
              <td>{user.nombre}</td>
              <td>{user.correo}</td>
              <td>
                {typeof user.idRol === 'object' ? user.idRol.nombreRol : user.idRol}
              </td>
              <td>{user.estatus ? 'Activo' : 'Inactivo'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Usuarios;