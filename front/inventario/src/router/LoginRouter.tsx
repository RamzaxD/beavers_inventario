import { Route, Routes } from "react-router-dom"
import { Inventario } from "../pages/inventario/Inventario"
import { Historial } from "../pages/historial/Historial"
import { Navbar } from '../components/Navbar';
import Usuarios from "../pages/usuarios/Usuarios";


export const LoginRouter = () =>{
    return(
        <>
            <Navbar />
            <Routes>
           
                <Route path="/historial" element={<Historial/>}/> 
                <Route path="/inventario" element={<Inventario/>}/>
                <Route path="/usuarios" element={<Usuarios/>}/> 
             
            </Routes>
        </>
    )
}