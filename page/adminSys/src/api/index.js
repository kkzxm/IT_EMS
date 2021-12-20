import axios from 'axios'
import api_user from '@/api/api_user'

export const API = api_user

export const setToken = (token) => {
    sessionStorage.setItem('token', token)
    axios.defaults.headers['token'] = token
}

export const getToken = () => {
    return sessionStorage.getItem('token')
}

