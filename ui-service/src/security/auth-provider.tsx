import { useState } from "react";
import AuthContext from "./auth-context"
import { UserDetails } from "types/auth";

const AppContextProvider = (children: React.ReactNode) => {

    const logoutHandler = (): void => {
        console.log('Logging out');
    };

    const tokenHandler = function (): boolean {
        throw new Error("Function not implemented.");
    }

    const emptyUserProfile: UserDetails = {
        email: '',
        firstname: '',
        lastname: '',
        logout: logoutHandler,
        username: "",
        token: '',
        refreshToken: '',
        isValidToken: tokenHandler,
        isUserLoggedIn: function (): boolean {
            return !!this.email;
        }
    }

    const [userProfile, setUserProfile] = useState(emptyUserProfile);

}

export default AppContextProvider;