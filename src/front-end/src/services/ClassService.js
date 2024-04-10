import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8081/api/classes';

export const listClasses = () => axios.get(REST_API_BASE_URL);