# Dianome
Empresa de entregas Dianome
API para controlar os entregadores
# Requisitos
° Java 21 
° PostgreSQL
  -Database: dianome
  -Usename: postgres
  -Password: chovy

# Instalação
°Clone este projeto
°Importe para o Eclipse
°Atualize as bibliotecas com o Maven
°Inicialize

# Acesso
°Abra um gerenciador de API, como o Postman

# Utilização
Para incluir um entregador
 - URI: http://localhost:8080/dianome

 - Método: POST

 - Formulário JSON: cpf, nome, pacotes

Para listar todos os entregadores

 - URI: http://localhost:8080/dianome

 - Método: GET

Para mostrar apenas um entregador

- URI: http://localhost:8080/dianome/{id}

- Método: GET

Para excluir um entregador

- URI: http://localhost:8080/dianome/{id}

- Método: DELETE

Para alterar um entregador

- URI: http://localhost:8080/dianome/{id}

- Método: PUT

- Formulário JSON: cpf, nome, pacotes
