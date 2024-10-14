import React, { useState, useEffect } from 'react';
import axios from 'axios';

const EmpresaCrud = () => {
  const [empresas, setEmpresas] = useState([]);
  const [nome, setNome] = useState('');
  const [descricao, setDescricao] = useState('');

  // Função para buscar todas as empresas
  useEffect(() => {
    fetchEmpresas();
  }, []);

  const fetchEmpresas = async () => {
    const response = await axios.get('http://localhost:8080/api/empresas');
    setEmpresas(response.data);
  };

  // Função para criar uma nova empresa
  const createEmpresa = async () => {
    const novaEmpresa = { nome, descricao };
    await axios.post('http://localhost:8080/api/empresas', novaEmpresa);
    fetchEmpresas();  // Atualiza a lista de empresas
  };

  // Função para deletar uma empresa
  const deleteEmpresa = async (id) => {
    await axios.delete(`http://localhost:8080/api/empresas/${id}`);
    fetchEmpresas();  // Atualiza a lista de empresas
  };

  return (
    <div>
      <h1>Cadastro de Empresas</h1>
      <input
        type="text"
        placeholder="Nome"
        value={nome}
        onChange={(e) => setNome(e.target.value)}
      />
      <input
        type="text"
        placeholder="Descrição"
        value={descricao}
        onChange={(e) => setDescricao(e.target.value)}
      />
      <button onClick={createEmpresa}>Cadastrar Empresa</button>

      <h2>Lista de Empresas</h2>
      <ul>
        {empresas.map((empresa) => (
          <li key={empresa.id}>
            {empresa.nome} - {empresa.descricao}
            <button onClick={() => deleteEmpresa(empresa.id)}>Deletar</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EmpresaCrud;
