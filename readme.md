## Projeto demo - OAuth com Spring Security
Neste projeto foram feitas duas formas de autenticação:
  * Utilizando cookies de sessão.
  * Utilizando um token JWT.

Essa aplicação desempenhou dois papeis:
* _client_ => Ao ser responsável por interagir com o  para autenticação.
* _resource server_ => Quando passou a saber se o token JWT estava válido ou não, se comunicando com o _Identity Provider_ (neste caso era o Google também).

## Configurações
Para rodar a aplicação é necessário informar as credenciais do _Authorization Server_ (Google):
* ``-Dgoogle.clientId``
* ``-Dgoogle.clientSecret``

Não esquecer de configurar a URL de _callback_ no formato http://localhost:8087/login/oauth2/code/google no _Authorization Server_.
Este formato de URL é o padrão formato do framework.

Créditos: https://www.youtube.com/watch?v=EQ5EwIYsgIE