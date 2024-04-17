import './App.css'
import HeaderComponent from './components/Static Components/HeaderComponent'
import ListCharacterComponent from './components/ListCharacterComponent'
import FooterComponent from './components/Static Components/FooterComponent'
import LoginComponent from './components/LoginComponent'
import SigninComponent from './components/SigninComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import CharacterComponent from './components/CharacterComponent'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
        <Routes>
          <Route path='/' element = {<LoginComponent/>}></Route>
          <Route path='/login' element = {<LoginComponent/>}></Route>
          <Route path='/signin' element = {<SigninComponent/>}></Route>
          <Route path='/simple-characters-list' element = {<ListCharacterComponent/>}></Route>
          <Route path='/add-character' element = {<CharacterComponent/>}></Route>
          <Route path='/edit-character/:id' element = {<CharacterComponent/>}></Route>
        </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App
