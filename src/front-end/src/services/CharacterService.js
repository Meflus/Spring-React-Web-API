import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8081/api/characters';

export const listCharacters = () => axios.get(REST_API_BASE_URL);

export const createCharacter = (character) => axios.post(REST_API_BASE_URL, character);

export const getCharacter = (characterId) => axios.get(REST_API_BASE_URL + '/' + characterId);