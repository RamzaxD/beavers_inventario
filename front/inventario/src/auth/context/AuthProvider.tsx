import { useReducer } from "react";
import { AuthContext } from "./AuthContext";
import { authReducer } from "./authReducer";

export default function AuthProvider({ children }:any ) {
    const [state, dispatch] = useReducer( authReducer, {
        logged: false
    })
    const iniciarSesion = () => {
        dispatch({
            type: '[Auth] Iniciar Sesion'
        })
    }
    const cerrarSesion = () => {
        dispatch({
            type: '[Auth] Cerrar Sesion'
        })
    }
    return (
    <AuthContext.Provider value={{
        logged: state.logged,
        iniciarSesion,
        cerrarSesion
    }}>
        { children }
    </AuthContext.Provider>
  )
}
