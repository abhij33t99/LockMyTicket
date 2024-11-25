
import './App.css'
import { ThemeProvider } from "@/components/util/theme-provider"
import AuthPage from './app/page';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import AuthContext from './security/auth-context';
import { UserDetails } from 'types/auth';

function App() {

  const router = createBrowserRouter([
    {
      path: "/",
      element: <AuthPage />,
    },
  ]);

  return (
    <ThemeProvider defaultTheme="dark" storageKey="vite-ui-theme">
      <AuthContext.Provider value={{} as UserDetails}>
        <RouterProvider router={router} />
      </AuthContext.Provider>
    </ThemeProvider>
  )



}

export default App

