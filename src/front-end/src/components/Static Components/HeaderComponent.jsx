import React from 'react'

const HeaderComponent = () => {
  return (
    <div>
      <header className='header-fixed'>
        <nav className='navbar navbar-dark bg-dark'>
          <div className='header-text'>
            <a className="navbar-brand" href="http://localhost:1000/simple-characters-list">Character Management System</a>
          </div>
        </nav>
      </header>
    </div>
  )
}

export default HeaderComponent