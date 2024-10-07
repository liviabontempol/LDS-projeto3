# Sistema de Moeda Estudantil
Este projeto visa desenvolver um sistema de mérito estudantil que utiliza uma moeda virtual para reconhecer e recompensar os alunos por seus desempenho. Professores podem distribuir moedas aos alunos como forma de reconhecimento por bom comportamento e participação em aula. Os alunos podem trocar essas moedas por produtos e descontos oferecidos por parceiros. O sistema permite que alunos, professores e empresas parceiras se cadastrem, gerenciem suas contas e realizem transações de forma segura e eficiente.

## Integrantes
* Francisley Magalhaes
* Livia Bontempo

## Orientadores
* Cristiano de Mâcedo Neto

## Instruções de utilização
Pretende-se desenvolver um sistema para estimular o reconhecimento do mérito estudantil através de uma moeda virtual. Essa moeda pode ser distribuída por professores aos seus alunos e trocada pelos alunos por produtos e descontos em empresas parceiras. Após a análise inicial de requisitos do sistema, foram levantadas as seguintes informações:

### Descrição do Sistema:
Os alunos que desejam ingressar no sistema de mérito devem realizar um cadastro, indicando nome, email, CPF, RG, Endereço, Instituição de Ensino e curso. As instituições participantes já estão pré-cadastradas no sistema, para que o aluno selecione.

Os professores já estarão pré-cadastrados no sistema (a instituição envia a lista no momento da parceria). Cada professor terá armazenado o seu nome, CPF e departamento que está vinculado. É necessário deixar explícito que ele faz parte de uma instituição.

A cada semestre, os professores recebe um total de mil moedas, que podem ser distribuídas aos seus alunos como forma de reconhecimento por bom comportamento, participação em aula, etcs. Esse total é acumulável no semestre (isto é, se o professor não distribuir todas as moedas num semestre, o total de 1.000 novas moedas será adicionado ao seu saldo corrente).

Para enviar moedas, o professor deve possuir saldo suficiente, indicando qual aluno deverá receber o montante, bem como o motivo pelo qual ele está sendo reconhecido (uma mensagem aberta, obrigatória).

Ao receber uma moeda, o aluno deve ser notificado por email. 

Professores e alunos devem ser capazes de consultar o extrato de sua conta, visualizando o total de moedas que ainda possui, bem como as transações que realizou (para o professor, o envio de moedas; para o aluno, recebimento ou troca de moedas).

Para trocar moedas, o aluno deve selecionar uma das vantagens cadastradas no sistema. Elas incluem, por exemplo: desconto em restaurantes da universidade, desconto de mensalidade, ou compra de materiais específicos.

Empresas que sejam realizar parceria também devem se cadastrar no sistema, incluindo as vantagens que deseja oferecer e o custo de cada uma dela (em moedas).

Para cadastrar uma vantagem, a empresa parceira deve adicionar também uma descrição e foto do produto.

Ao resgatar uma vantagem, o aluno deve ter o valor descontado do seu saldo. Um email de cupom deve ser enviado para que ele utilize na troca presencial. Um email também deve ser enviado ao parceiro, para que ele possa conferir a troca. Ambos os emails devem incluir um código gerado pelo sistema, a fim de facilitar o processo de conferência.

Por fim, alunos, professores e empresas parceiras precisam ter um login e uma senha cadastrados para acessar o sistema. Em todos os casos, um processo de autenticação é necessário para realização dos requisitos.


# Sprint 1
##  História de Usuário

## Aluno
- **Cadastro**: Como um aluno, quero me cadastrar no sistema fornecendo meus dados pessoais, para que eu possa participar do programa de mérito estudantil.
- **Notificação por Email**: Como um aluno, quero ser notificado por email quando receber moedas de um professor, para que eu saiba que fui reconhecido pelo meu desempenho.
- **Consulta de Saldo e Histórico**: Como um aluno, quero consultar meu saldo de moedas e o histórico de transações, para que eu possa acompanhar minhas recompensas e trocas.
- **Troca de Moedas**: Como um aluno, quero trocar minhas moedas por vantagens cadastradas no sistema, para que eu possa usufruir de descontos e produtos oferecidos pelas empresas parceiras.

## Professor
- **Pré-Cadastro**: Como um professor, quero estar pré-cadastrado no sistema pela minha instituição, para que eu possa distribuir moedas aos meus alunos.
- **Recebimento de Moedas**: Como um professor, quero receber um total de mil moedas a cada semestre, para que eu possa reconhecer o mérito dos meus alunos.
- **Envio de Moedas**: Como um professor, quero enviar moedas aos alunos indicando o motivo do reconhecimento, para que eu possa incentivar o bom comportamento e a participação em aula.
- **Consulta de Saldo e Histórico**: Como um professor, quero consultar meu saldo de moedas e o histórico de transações, para que eu possa acompanhar a distribuição das moedas aos alunos.

## Empresa Parceira
- **Cadastro**: Como uma empresa parceira, quero me cadastrar no sistema fornecendo meus dados e as vantagens que desejo oferecer, para que eu possa participar do programa de mérito estudantil.
- **Adição de Descrições e Fotos**: Como uma empresa parceira, quero adicionar descrições e fotos dos produtos oferecidos como vantagens, para que os alunos possam visualizar e escolher as recompensas.
- **Notificação por Email**: Como uma empresa parceira, quero receber um email com um código gerado pelo sistema quando um aluno resgatar uma vantagem, para que eu possa conferir a troca e validar o cupom.
