import { createContext } from "react";
import { UserDetails } from '../../types/auth'

const AuthContext = createContext({} as UserDetails);

export default AuthContext;