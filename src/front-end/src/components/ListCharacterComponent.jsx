import React, {useEffect, useState} from 'react';
import { listCharacters } from '../services/CharacterService';
import { listClasses } from '../services/ClassService';
import { listSpecies } from '../services/SpeciesService';
import {useNavigate} from 'react-router-dom';

const ListCharacterComponent = () => {
    const [characters, setCharacters] = useState([]);
    const [classes, setClasses] = useState([]);
    const [species, setSpecies] = useState([]);
    const navigator = useNavigate();

    useEffect(() => {
        listCharacters().then((response) => {
            setCharacters(response.data);
        }).catch(error => {
            console.error(error);
        });
    }, []);

    useEffect(() => {
        listClasses().then((response) => {
            setClasses(response.data);
        }).catch(error => {
            console.error(error);
        });
    }, []);

    useEffect(() => {
        listSpecies().then((response) => {
            setSpecies(response.data);
        }).catch(error => {
            console.error(error);
        });
    }, []);
  
    function addNewCharacter() {
        navigator('/add-character');
    }

    function updateCharacter(id) {
        navigator(`/edit-character/${id}`);
    }

    return (
    <div className='container padding'>
        <h2 className='text-center'>Lista de Personagens</h2>
        <button className='btn btn-primary mb-2'
            onClick={addNewCharacter}>Adicionar Personagem</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th className='text-center'>Nome</th>
                    <th className='text-center'>Nível</th>
                    <th className='text-center'>Classe</th>
                    <th className='text-center'>Espécie</th>
                    <th className='text-center'>Ações</th>
                </tr>
            </thead>
            <tbody>
                {
                    characters.map(character =>
                        <tr key={character.id}>
                            <td className='text-center'>{character.characterName}</td>
                            <td className='text-center'>{character.characterLevel}</td>
                            <td className='text-center'>{classes.find(classe =>
                                classe.id === character.classEntityId)?.className}</td>
                            <td className='text-center'>{species.find(species =>
                                species.id === character.speciesEntityId)?.speciesName}</td>
                            <td>
                                <div className='d-grid gap-2 d-md-flex justify-content-md-center'>
                                    <button className='btn btn-info'
                                        onClick={() => updateCharacter(character.id)}>Editar</button>
                                    <button className='btn btn-danger'>Remover</button>
                                </div>
                            </td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListCharacterComponent