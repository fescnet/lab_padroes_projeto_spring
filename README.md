# Aplicando padrões de projeto com Java e Spring Boot

## Sobre a solução

### Introdução

O meu projeto é a  uma versão simplificada de uma calculadora de custos de frete para o transporte de produtos entre a Matriz e a Filial de uma empresa.  Com a API também é possível calcular os impostos aplicados em cada produto.

Criei um mock das APIs dos parceiros, está na pasta src/main/java/com/fescnet/lab_padroes_projeto_spring/mock_api_parceiros.

## Endpoints da API

| Endpoint | Query string | Corpo da requisição | Propósito |
|----------|----------|----------|----------|
| GET /produtos | | | Listar produtos |
| GET /produtos/{id} | incluirImpostos (opcional) |  | Obter um produto com ou sem impostos aplicados |
| POST /produtos |  | nome, preco, pesoEmGramas, larguraEmCm, alturaEmCm, comprimentoEmCm | Criar um produto |
| PUT /produtos/{id} |  | nome, preco, pesoEmGramas, larguraEmCm, alturaEmCm, comprimentoEmCm | Alterar um produto |
| GET /produtos/{id}/fretes |  |  | Fornecer as opções de frete para aquele produto |

## Padrões de projeto aplicados

| Padrão de projeto | Aplicação |
|----------|----------|
| Builder    | Uso para criar regras de validação dos dados que são recebidos nas requisições ([ver código](src/main/java/com/fescnet/lab_padroes_projeto_spring/validadores/ValidadorProduto.java))  |
| Decorator    | Decoro o produto com impostos ([ver código](src/main/java/com/fescnet/lab_padroes_projeto_spring/service/decorators/ProdutoComImposto.java))   |
| Strategy    | Criei um validador de requisições que usa Strategy para retornar o validador correto conforme o tipo de dados passado: String ou double ([ver código](src/main/java/com/fescnet/lab_padroes_projeto_spring/utils/validation/ValidadorContext.java)).  Também uso Strategy através do Spring no Service (conforme mostrado em aula).  |
| Facade    | Para obter as opções de entrega são consumidas APIS de 3 parceiros diferentes.  Usei Facade para ocultar essa complexidade ([ver código](src/main/java/com/fescnet/lab_padroes_projeto_spring/service/impl/ProdutoServiceImpl.java))  |
| Singleton    | Quando uso @Autowired para injetar uma dependência usando o espoco padrão no bean o Spring usa Singleton (conforme mostrado em aula)   |

## Regras de negócio

- O nome do produto deve ter entre 2 e 255 caracteres e é obrigatório;
- O preço deve ser maior ou igual a R$ 0,01 e menor ou igual a R$ 100.000,00 e é obrigatório;
- O peso deve ser maior ou igual a 10g e menor ou igual a 10.000g e é obrigatório;
- A largura deve ser maior ou igual a 5cm e menor ou igual a 200cm e é obrigatória;
- A altura deve ser maior ou igual a 5cm e menor ou igual a 200cm e é obrigatória;
- O comprimento deve ser maior ou igual a 5cm e menor ou igual a 200cm e é obrigatório.

## Observações / melhorias em relação ao projeto base

1) implementei tratamento de exceções e padronizei as respostas enviadas em caso de exception.
2) estou retornando status http 404 quando um item não é encontrado;
3) estou validando o cadastro dos itens na API.  Retorno http status 400 quando um dado é inválido.
4) estou retornando a entidade gravada nos métodos de inserção para que clientes tenham acesso ao {id} do novo registro;
5) criei a pasta de DTOs no projeto para representar as requisições e respostas das APIs dos parceiros e a response em caso de erro.
6) criei a pasta utils com utilitários que ajudam na validação dos dados recebidos nas requisições (sei que o Spring tem suporte a validação de dados, fiz "manualmente" só pelo exercício mesmo)
7) não implementei segurança no projeto porque não me pareceu ser o objetivo do desafio e achei que poderia dificultar a correção.

# Enunciado

Agora é a sua hora de brilhar! Crie uma solução que explore o conceito de Padrões de Projeto na pŕatica. Para isso, você pode reproduzir um dos projetos que criamos durante as aulas ou, caso se sinta preparado, desenvolver uma nova ideia do zero ;-)

Dica: Além dos projetos/repositórios que criamos para este desafio, caso queira explorar novos padrões de projeto digite no Google: “java design patterns github” ou “java design patterns examples”. Com isso, você conhecerá novos padrões e implementações de referência que podem ajudá-lo a dominar esse tema!

Github das aulas:

https://github.com/digitalinnovationone/lab-padroes-projeto-spring

https://github.com/digitalinnovationone/dio-springboot
