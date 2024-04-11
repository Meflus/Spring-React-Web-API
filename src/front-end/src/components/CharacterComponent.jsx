import React, { useEffect, useState } from 'react';
import { createCharacter, getCharacter, updateCharacter } from '../services/CharacterService';
import { listClasses } from '../services/ClassService';
import { listSpecies } from '../services/SpeciesService';
import {useNavigate, useParams} from 'react-router-dom';

const CharacterComponent = () => {
    const [characterBackstory, setCharacterBackstory] = useState('');
    const [characterName, setCharacterName] = useState('');
    const [classEntityId, setClassEntityId] = useState();
    const [speciesEntityId, setSpeciesEntityId] = useState();
    const [classes, setClasses] = useState([]);
    const [species, setSpecies] = useState([]);
    const navigator = useNavigate();
    const {id} = useParams();

    const [errors, setErrors] = useState({
        characterName: '',
        classEntityId: '',
        speciesEntityId: ''
    })

    useEffect(() => {
        if (id) {
            getCharacter(id).then((response) => {
                setCharacterBackstory(response.data.characterBackstory);
                setCharacterName(response.data.characterName);
                setClassEntityId(response.data.classEntityId);
                setSpeciesEntityId(response.data.speciesEntityId);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id])

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

    function returnMainPage() {
        navigator('/simple-characters-list');
    }

    function saveOrUpdateCharacter(event) {
        event.preventDefault();
        if (validateForm()){
            const character = {characterName, characterBackstory, classEntityId, speciesEntityId};
            console.log(character);
            if (id) {
                updateCharacter(id, character).then((response) => {
                    console.log(response.data);
                    navigator('/simple-characters-list');
                }).catch(error => {
                    console.error(error);
                })
            } else {
                createCharacter(character).then((response) => {
                    console.log(response.data);
                    navigator('/simple-characters-list');
                }).catch(error => {
                    console.error(error);
                })
            }
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = {... errors};

        if(characterName.trim()){
            errorsCopy.characterName = '';
        } else {
            errorsCopy.characterName = 'O nome do personagem é de preenchimento obrigatório';
            valid = false;
        }

        if(classEntityId != null){
            errorsCopy.classEntityId = '';
        } else {
            errorsCopy.classEntityId = 'A classe é de seleção obrigatória';
            valid = false;
        }

        if(speciesEntityId != null){
            errorsCopy.speciesEntityId = '';
        } else {
            errorsCopy.speciesEntityId = 'A espécie é de seleção obrigatória';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    function pageTitle() {
        if (id) {
            return <h2 className='text-center'>Editar Personagem</h2>
        } else {
            return <h2 className='text-center'>Adicionar Personagem</h2>
        }
    }
  return (
    <div className='container'>
        <br />
        <div className='row padding'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                {
                    pageTitle()
                }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Nome do Personagem:</label>
                            <input 
                                type='text'
                                placeholder='Digite o nome do personagem...'
                                name='characterName'
                                value={characterName}
                                className={`form-control ${errors.characterName ? 'is-invalid': ''}`}
                                onChange={(event) => setCharacterName(event.target.value)}/>
                            {errors.characterName && <div className='invalid-feedback'>{errors.characterName}</div>}
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>História do Personagem:</label>
                            <input 
                                type='text'
                                placeholder='Digite a história do personagem...'
                                name='characterBackstory'
                                value={characterBackstory}
                                className='form-control'
                                onChange={(event) => setCharacterBackstory(event.target.value)}/>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Classe do Personagem:</label>
                            <select className={`form-select ${errors.classEntityId ? 'is-invalid': ''}`}
                                aria-label='Default select example'
                                onChange={(event) => setClassEntityId(parseInt(event.target.value))}
                                value={classEntityId}>
                                <option value={null}>Selecione uma classe</option>
                                {classes.map(classEntity => (
                                    <option key={classEntity.id} value={classEntity.id}>{classEntity.className}</option>
                                ))}
                            </select>
                            {errors.classEntityId && <div className='invalid-feedback'>{errors.classEntityId}</div>}
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Espécie do Personagem:</label>
                            <select className={`form-select ${errors.speciesEntityId ? 'is-invalid': ''}`}
                                aria-label='Default select example'
                                onChange={(event) => setSpeciesEntityId(parseInt(event.target.value))}
                                value={speciesEntityId}>
                                <option value={null}>Selecione uma espécie</option>
                                {species.map(speciesEntity => (
                                    <option key={speciesEntity.id} value={speciesEntity.id}>{speciesEntity.speciesName}</option>
                                ))}
                            </select>
                            {errors.speciesEntityId && <div className='invalid-feedback'>{errors.speciesEntityId}</div>}
                        </div>
                        <div className='d-grid gap-2 col-6 mx-auto'>
                            <button className='btn btn-success' onClick={saveOrUpdateCharacter}>Confirmar</button>
                            <button className='btn btn-secondary' onClick={returnMainPage}>cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default CharacterComponent