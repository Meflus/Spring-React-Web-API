import React, { useEffect, useState } from 'react';
import { createCharacter } from '../services/CharacterService';
import { listClasses } from '../services/ClassService';
import { listSpecies } from '../services/SpeciesService';
import {useNavigate} from 'react-router-dom';

const CharacterComponent = () => {
    const [characterBackstory, setCharacterBackstory] = useState('');
    const [characterName, setCharacterName] = useState('');
    const [classEntityId, setClassEntityId] = useState();
    const [speciesEntityId, setSpeciesEntityId] = useState();
    const [classes, setClasses] = useState([]);
    const [species, setSpecies] = useState([]);
    const navigator = useNavigate();

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

    function saveCharacter(event) {
        event.preventDefault();
        const character = {characterName, characterBackstory, classEntityId, speciesEntityId};
        console.log(character);

        createCharacter(character).then((response) => {
            console.log(response.data);
            navigator('/simple-characters-list')
        })
    }

  return (
    <div className='container'>
        <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Adicionar Personagem</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Nome do Personagem:</label>
                            <input 
                                type="text"
                                placeholder='Digite o nome do personagem...'
                                name='characterName'
                                value={characterName}
                                className='form-control'
                                onChange={(event) => setCharacterName(event.target.value)}/>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>História do Personagem:</label>
                            <input 
                                type="text"
                                placeholder='Digite a história do personagem...'
                                name='characterBackstory'
                                value={characterBackstory}
                                className='form-control'
                                onChange={(event) => setCharacterBackstory(event.target.value)}/>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Classe do Personagem:</label>
                            <select className="form-select" aria-label="Default select example"
                                onChange={(event) => setClassEntityId(parseInt(event.target.value))}
                                value={classEntityId}>
                                <option value={null}>Selecione uma classe</option>
                                {classes.map(classEntity => (
                                    <option key={classEntity.id} value={classEntity.id}>{classEntity.className}</option>
                                ))}
                            </select>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Espécie do Personagem:</label>
                            <select className="form-select" aria-label="Default select example"
                                onChange={(event) => setSpeciesEntityId(parseInt(event.target.value))}
                                value={speciesEntityId}>
                                <option value={null}>Selecione uma espécie</option>
                                {species.map(speciesEntity => (
                                    <option key={speciesEntity.id} value={speciesEntity.id}>{speciesEntity.className}</option>
                                ))}
                            </select>
                        </div>

                        <button className='btn btn-success' onClick={saveCharacter}>Adicionar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default CharacterComponent