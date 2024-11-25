export type AuthMode = 'signin' | 'signup';
export type Theme = 'light' | 'dark';

export interface AuthFormData {
  email: string;
  password: string;
}

export interface AuthResponse {
  success: boolean;
  message: string;
}

export type UserDetails = {
  username: string;
  email: string;
  firstname: string;
  lastname: string;
  logout: () => void;
  token: string;
  refreshToken: string;
  isValidToken: () => boolean;
  isUserLoggedIn: () => boolean;
}