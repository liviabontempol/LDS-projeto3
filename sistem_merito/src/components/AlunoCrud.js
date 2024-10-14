import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AlunoCrud = () => {
  const [alunos, setAlunos] = useState([]);
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [instituicao, setInstituicao] = useState('');
  const [curso, setCurso] = useState('');

  // Função para buscar todos os alunos
  useEffect(() => {
    fetchAlunos();
  }, []);

  const fetchAlunos = async () => {
    const response = await axios.get('http://localhost:8080/api/alunos');
    setAlunos(response.data);
  };

  // Função para criar um novo aluno
  const createAluno = async () => {
    const novoAluno = { nome, email, instituicao, curso };
    await axios.post('http://localhost:8080/api/alunos', novoAluno);
    fetchAlunos();  // Atualiza a lista de alunos
  };

  // Função para deletar um aluno
  const deleteAluno = async (id) => {
    await axios.delete(`http://localhost:8080/api/alunos/${id}`);
    fetchAlunos();  // Atualiza a lista de alunos
  };

  return (
    <div>
      <h1>Cadastro de Alunos</h1>
      <input
        type="text"
        placeholder="Nome"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="text"
        placeholder="Instituição"
        value={instituicao}
        onChange={(e) => setInstituicao(e.target.value)}
      />
      <input
        type="text"
        placeholder="Curso"
        value={curso}
        onChange={(e) => setCurso(e.target.value)}
      />
      <button onClick={createAluno}>Cadastrar Aluno</button>

      <h2>Lista de Alunos</h2>
      <ul>
        {alunos.map((aluno) => (
          <li key={aluno.id}>
            {aluno.nome} - {aluno.email} - {aluno.instituicao} - {aluno.curso}
            <button onClick={() => deleteAluno(aluno.id)}>Deletar</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AlunoCrud;
