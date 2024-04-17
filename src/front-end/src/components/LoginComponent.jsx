import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getUser, listUsers } from '../services/UserService';

const LoginComponent = () => {
    const navigator = useNavigate();
    const [users, setUsers] = useState([]);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({
        email: '',
        password: ''
    });

    useEffect(() => {
        listUsers().then((response) => {
            setUsers(response.data);
        }).catch(error => {
            console.error(error);
        });
    }, []);

    function validateForm() {
        let valid = true;
        const errorsCopy = {... errors};

        if(email.trim()) {
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'O e-mail é de preenchimento obrigatório';
            valid = false;
        }

        if(password.trim()) {
            errorsCopy.password = '';
        } else {
            errorsCopy.password = 'A senha é de preenchimento obrigatório';
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }

    function signInPage() {
        navigator('/signin');
    }

    function authenticateLogin() {
        if (validateForm()) {
            navigator('/simple-characters-list');
        }
    }

  return (
    <div className='container'>
        <br/>
        <div className='row padding'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Login</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>E-mail: </label>
                            <input
                                type="text"
                                placeholder='Digite seu e-mail...'
                                name='email'
                                value={email}
                                className={`form-control ${errors.email ? 'is-invalid': ''}`}
                                onChange={(event) => setEmail(event.target.value)}/>
                            {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Senha: </label>
                            <input
                                type="text"
                                placeholder='Digite sua senha...'
                                name='password'
                                value={password}
                                className={`form-control ${errors.password ? 'is-invalid': ''}`}
                                onChange={(event) => setPassword(event.target.value)}/>
                                {errors.password && <div className='invalid-feedback'>{errors.password}</div>}
                        </div>

                        <div className='d-grid gap-2 col-6 mx-auto'>
                            <button className='btn btn-success' onClick={authenticateLogin}>Acessar</button>
                            <button className='btn btn-info' onClick={signInPage}>Registre-se</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default LoginComponent