import React, { useState } from 'react'

const CharacterComponent = () => {
    const [characterBackstory, setCharacterBackstory] = useState('')
    const [characterName, setCharacterName] = useState('')
    const [characterClass, setCharacterClass] = useState('')
    const [characterSpecies, setCharacterSpecies] = useState('')

    function saveCharacter(event) {
        event.preventDefault();
        const character = {characterName, characterBackstory, characterClass, characterSpecies}
        console.log(character);
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
                                onChange={(event) => setCharacterClass(parseInt(event.target.value))}
                                value={characterClass}>
                                <option value={null}>Selecione uma classe</option>
                                <option value={1}>Artificer</option>
                                <option value={2}>Barbarian</option>
                                <option value={3}>Bard</option>
                                <option value={4}>Cleric</option>
                                <option value={5}>Druid</option>
                                <option value={6}>Fighter</option>
                                <option value={7}>Monk</option>
                                <option value={8}>Paladin</option>
                                <option value={9}>Ranger</option>
                                <option value={10}>Rogue</option>
                                <option value={11}>Sorcerer</option>
                                <option value={12}>Warlock</option>
                                <option value={13}>Wizard</option>
                            </select>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Espécie do Personagem:</label>
                            <select className="form-select" aria-label="Default select example"
                                onChange={(event) => setCharacterSpecies(parseInt(event.target.value))}
                                value={characterSpecies}>
                                <option value={null}>Selecione uma espécie</option>
                                <option value={1}>Dragonborn</option>
                                <option value={2}>Dwarf</option>
                                <option value={3}>Elf</option>
                                <option value={4}>Gnome</option>
                                <option value={5}>Orc</option>
                                <option value={6}>Halfling</option>
                                <option value={7}>Human</option>
                                <option value={8}>Tiefling</option>
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