# Plataforma de Gestão de Freelancers

A plataforma permitirá que clientes cadastrem projetos e freelancers possam se candidatar para realizá-los. O sistema gerenciará as propostas, permitirá negociações e registrará a finalização dos trabalhos.

## Regras de Negócio
- Cadastro de Usuários:
    - Dois tipos de usuários: Cliente e Freelancer.
    - Dados obrigatórios: Nome Completo, CPF/CNPJ, E-mail (único) e Senha.
    - Um usuário pode ser cliente ou freelancer.

- Cadastro de Projetos:
  - Somente clientes podem cadastrar projetos.
  - Um projeto deve conter título, descrição, prazo e orçamento estimado.
  - Os projetos podem ter status: Aberto, Em negociação, Em andamento, Concluído ou Cancelado.


- Propostas de Freelancers:
    - Freelancers podem se candidatar aos projetos.
    - Uma proposta deve conter o valor ofertado e prazo de entrega estimado.
    - O cliente pode aceitar ou recusar propostas.
    - Após aceitar uma proposta, o projeto muda para o status Em andamento.


- Entrega do Projeto:
  - O freelancer pode marcar o projeto como Concluído quando terminar o trabalho.
  - O cliente deve validar a entrega antes de mudar o status do projeto para Finalizado.
  - O cliente pode solicitar ajustes, voltando o status para Em andamento.


- Pagamentos:
  - Simular um gateway de pagamentos para liberar o valor do projeto ao freelancer após a conclusão e aprovação.
  - Criar um mock de serviço externo para processar pagamentos (exemplo: POST /pagamento/autorizar).
  - Se o pagamento falhar, o sistema deve reter o valor e tentar processar novamente.


- Notificações:
  - Enviar notificações por e-mail ou webhook quando:
    - Um freelancer enviar uma proposta.
    - Um cliente aceitar uma proposta.
    - Um projeto for concluído.
  - Criar um mock de serviço externo para envio de notificações (exemplo: POST /notificacao/enviar).
