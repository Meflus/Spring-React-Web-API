import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';

const SigninComponent = () => {
    const navigator = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errors, setErrors] = useState({
        email: '',
        password: ''
    })

    function returnLoginPage() {
        navigator('/login');
    }

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

    function saveUser(event) {
        event.preventDefault();
        if(validateForm()) {
            const user = {email, password};
            console.log(user);
        }
    }

  return (
    <div className='container'>
        <br/>
        <div className='row padding'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Registre-se</h2>
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
                            <button className='btn btn-success' onClick={saveUser}>Registrar</button>
                            <button className='btn btn-secondary' onClick={returnLoginPage}>cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default SigninComponent