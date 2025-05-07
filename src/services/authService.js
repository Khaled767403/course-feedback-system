// src/services/authService.js
import axios from './axiosInstance';

export const login = async (username, password) => {
  const response = await axios.post('/auth/login', { username, password });
  return response.data;
};

export const register = async (userData) => {
  return axios.post('/auth/register', userData);
};
