import { Navigate, Route, Routes } from "react-router-dom"
import { Login } from "../login/login"
import { LoginRouter } from "./LoginRouter"


export const AppRouter = () =>{
    return(
        <>
            <Routes>
                <Route path="/login" element={<Login/>}/> 
                {/* <Route path="/" element={<Navigate to="/login"/>}></Route> */}
                <Route path='/*' element={<LoginRouter/>} />
            </Routes>
        </>
    )
}