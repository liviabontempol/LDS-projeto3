const API_BASE_URL = 'http://localhost:3000/api'; 

async function cadastrarAluno(dadosAluno) {
    try {
        const response = await fetch(`${API_BASE_URL}/alunos`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dadosAluno),
        });

        if (!response.ok) {
            throw new Error('Erro ao cadastrar aluno');
        }

        return await response.json();
    } catch (error) {
        console.error('Erro:', error);
        throw error;
    }
}

