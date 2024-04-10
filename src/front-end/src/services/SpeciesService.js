import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8081/api/species';

export const listSpecies = () => axios.get(REST_API_BASE_URL);