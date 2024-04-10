import React, { useState } from 'react'

const CharacterComponent = () => {
    const [characterBackstory, setCharacterBackstory] = useState('')
    const [characterName, setCharacterName] = useState('')
    const [characterClass, setCharacterClass] = useState('')
    const [characterSpecies, setCharacterSpecies] = useState('')
  return (
    <div>CharacterComponent</div>
  )
}

export default CharacterComponent