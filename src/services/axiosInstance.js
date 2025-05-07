// src/services/axiosInstance.js
import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080', // API Gateway URL
  withCredentials: true,
});

// Request interceptor to attach token
instance.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default instance;
