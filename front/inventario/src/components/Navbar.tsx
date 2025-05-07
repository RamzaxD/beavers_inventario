import { NavLink, useNavigate } from 'react-router-dom';


export const Navbar = () => {
    const navigate = useNavigate()
    
    const cerrarSesion = () => {
        navigate('/login', {
            replace: true
        })
    }
    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
            <div >
                <div className="flex flex-row justify-end items-center">

                    <NavLink
                        className="m-4" 
                        to="/usuarios"
                    >
                        Usuarios
                    </NavLink>

                    <NavLink 
                        className="m-4"  
                        to="/inventario"
                    >
                        Inventario
                    </NavLink>

                    <NavLink 
                        className="m-4" 
                        to="/historial"
                    >
                        Historial
                    </NavLink>

                    <button 
                        className="m-4" 
                        onClick={cerrarSesion}
                    >
                        Cerrar Sesion
                    </button>
                </div>
            </div>
           
           
        </nav>
    )
}