import { useContext } from "react"
import { useNavigate } from "react-router-dom"
import { AuthContext } from "../auth/context/AuthContext"

export const Login = () =>{
    const navigate = useNavigate()
    const {iniciarSesion}= useContext(AuthContext)
    
    const onIniciarSesion = () => {
        
        iniciarSesion('Brayan Arevalo')
        navigate('/inventario', {
            replace: true
        })
    }
    return (
        <div className="py-8 container flex flex-col justify-center items-center mt-5 border-2 mx-auto">
            <h1 className="text-center">Login</h1>
            <input  className="hover:bg-gray-300 mt-6" 
                    type="text" placeholder="Usuario" />
            <input  className="hover:bg-gray-300 mt-2"
                    type="password" placeholder="Contraseña" />
            <button onClick={ onIniciarSesion }
                    className="bg-blue-500 hover:bg-black hover:text-white text-white py-1 px-2 mt-4 rounded-md">Iniciar Sesion</button>
        </div>
    )
}