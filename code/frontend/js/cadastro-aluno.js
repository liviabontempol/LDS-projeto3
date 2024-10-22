document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('formCadastroAluno');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();
        console.log('Formulário submetido');

        const dadosAluno = {
            nome: document.getElementById('nome').value,
            email: document.getElementById('email').value,
            cpf: document.getElementById('cpf').value,
            rg: document.getElementById('rg').value,
            endereco: document.getElementById('endereco').value,
            instituicao: document.getElementById('instituicao').value,
            curso: document.getElementById('curso').value,
        };
        console.log('Dados do aluno:', dadosAluno);

        try {
            console.log('Iniciando cadastro do aluno');
            const alunoCadastrado = await cadastrarAluno(dadosAluno);
            console.log('Aluno cadastrado com sucesso:', alunoCadastrado);
            alert('Aluno cadastrado com sucesso!');
            form.reset();
        } catch (error) {
            console.error('Erro detalhado:', error);
            alert('Erro ao cadastrar aluno. Por favor, tente novamente.');
        }
    });
});
