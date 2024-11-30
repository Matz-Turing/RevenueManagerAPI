# Gestão de Receitas

<img src="https://user-images.githubusercontent.com/74038190/212284115-f47cd8ff-2ffb-4b04-b5bf-4d1c14c0247f.gif" width="1000">

# Introdução à API

- A API permite realizar operações CRUD (Create, Read, Update, Delete) para gerenciar receitas financeiras.  
- Cada receita possui campos como **ID**, **ID do usuário**, **valor**, **descrição** e **data**.  
- A API utiliza o formato **JSON** para comunicação e segue as convenções **RESTful**.

# Estrutura da API

**Endereço base**: Todos os endpoints são acessados a partir de um domínio local durante o desenvolvimento:  
`http://localhost:8080/api/receitas`.

**Métodos suportados**:
- **POST**: Para criar novas receitas.
- **GET**: Para listar ou buscar receitas específicas.
- **PUT**: Para atualizar receitas existentes.
- **DELETE**: Para excluir receitas.

# Métodos testados e explicados

## a) Criar uma receita (POST)

O método **POST** adiciona uma nova receita ao sistema.  

**Exemplo de corpo de requisição**:
``` json
{
  "idUsuario": 1,
  "valor": 500.00,
  "descricao": "Receita exemplo",
  "data": "2024-11-30T12:00:00"
}
```
Dados

- **idUsuario**: Referência ao usuário dono da receita.
- **valor**: Quantia da receita (obrigatório, com até duas casas decimais).
- **descricao**: Breve descrição da receita (opcional).
- **data**: Data e hora da receita (opcional, preenche com a data atual caso ausente).

Validações

- Campos obrigatórios não podem ser omitidos.
- O **valor** deve ser positivo.

Resposta esperada

- **201 Created** em caso de sucesso.

## b) Listar todas as receitas (GET)

O método **GET** retorna todas as receitas cadastradas.

**Endpoint**:  
`http://localhost:8080/api/receitas`

**Resposta esperada**:
```json
[
  {
    "idReceita": 1,
    "idUsuario": 1,
    "valor": 500.00,
    "descricao": "Receita exemplo",
    "data": "2024-11-30T12:00:00"
  }
]
```
Uso

Ideal para verificar quais receitas estão cadastradas.

## c) Buscar receita por ID (GET)

Permite buscar uma receita específica pelo seu ID.

**Endpoint**:  
`http://localhost:8080/api/receitas/{idReceita}`

**Resposta**:
- Se encontrada, retorna os detalhes da receita.
- Caso contrário, retorna **404 Not Found**.

-

## d) Atualizar uma receita (PUT)

Atualiza os dados de uma receita existente.

**Endpoint**:  
`http://localhost:8080/api/receitas/{idReceita}`

**Exemplo de corpo de requisição**:
```json
{
  "idUsuario": 1,
  "valor": 600.00,
  "descricao": "Receita atualizada",
  "data": "2024-11-30T12:34:56"
}
```
Considerações para Atualizar uma Receita (PUT)

- O **ID** fornecido na URL deve existir, caso contrário, **404 Not Found** será retornado.
- **Resposta esperada**: **200 OK** em caso de sucesso.

-

## e) Excluir uma receita (DELETE)

Remove uma receita existente com base no ID.

**Endpoint**:  
`http://localhost:8080/api/receitas/{idReceita}`

**Considerações**:
- Verifica se não há dependências no banco de dados (como vínculos com outras tabelas).

**Resposta esperada**:
- **204 No Content**: Exclusão bem-sucedida.
- **404 Not Found**: Caso o **ID** da receita não seja encontrado.
- **500 Internal Server Error**: Se houver violação de restrições no banco de dados.

# 4. Regras de validação

## Campos obrigatórios:
- **idUsuario**: Deve estar presente em todas as requisições **POST** e **PUT**.
- **valor**: Não pode ser nulo ou negativo.

## Data:
- Se ausente, é preenchida automaticamente com a data atual.
- Deve estar em formato **ISO-8601** (**YYYY-MM-DDTHH:mm:ss**).

## ID:
- **IDs inválidos** ou inexistentes retornam erro **404 Not Found**.

## Restrições de integridade:
- O banco de dados verifica se há dependências (ex.: vínculos com outras tabelas).

# 5. Códigos de Status

- **200 OK**: Operação bem-sucedida (**GET** ou **PUT**).
- **201 Created**: Nova receita criada com sucesso.
- **204 No Content**: Exclusão bem-sucedida.
- **400 Bad Request**: Erro na requisição (ex.: campos obrigatórios ausentes).
- **404 Not Found**: ID fornecido não encontrado.
- **500 Internal Server Error**: Problema interno no servidor ou violação de restrições.

# 6. Considerações de segurança

- Requisições malformadas podem causar falhas. O cliente deve sempre enviar dados no formato correto.
- Proteções adicionais, como **autenticação**, devem ser consideradas no futuro.

# 7. Uso no Postman

O **Postman** foi usado para validar todas as operações da API.

## Configuração:
- Defina a URL base: `http://localhost:8080/api/receitas`.
- Selecione o método correto (**POST**, **GET**, **PUT**, **DELETE**).
- Para métodos **POST** e **PUT**, insira o corpo da requisição no formato **JSON**.

## Exemplos práticos:

- **Para criar uma receita**:
  - No Postman, selecione **POST**.
  - Na aba "Body", selecione **raw** e o tipo **JSON**.
  - Insira o exemplo **JSON** fornecido e clique em **"Send"**.

- **Para excluir**:
  - Selecione **DELETE**.
  - Adicione o **ID** na URL, como `http://localhost:8080/api/receitas/1`.
  - Clique em **"Send"** para enviar a requisição.

O **Postman** é uma ferramenta essencial para simular e validar todos os cenários da API, garantindo seu funcionamento esperado antes da integração com outras partes do sistema.

## Créditos

Desenvolvido por Mateus S.  
GitHub: [Matz-Turing](https://github.com/Matz-Turing)
