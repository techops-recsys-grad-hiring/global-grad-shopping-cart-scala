# Boas Vindas, este é o Shopping Cart (Carrinho de Compras)

É aqui que você pode começar a se familiarizar com o problema e com o que você precisa para executá-lo.
Esta base de código é usada durante a sessão de pareamento do processo seletivo.
É focado em identificar más práticas de código (_code smells_), refatoração e teste da base de código legada, enquanto permite
conversar e aprendermos umas com os outras.

*Leia este texto em outro idioma: [English](README.md), [Português do Brasil](README.pt-br.md).*

## Descrição do problema
Existe uma aplicação de carrinho de compras, com um pequeno conjunto de regras de comércio eletrônico/carrinho de compras. As regras incluem cálculo de preço total, desconto e cálculo de pontos de fidelidade. A maior parte da lógica de negócios é implementada em um único método ShoppingCart.checkout. Este código foi pensado como uma biblioteca, parte de um sistema maior que não vai ser abordado nesta etapa do processo.

## Tecnologias utlizadas
* Scala
* [SBT](https://www.scala-sbt.org/)

## Antes da entrevista
Familiarize-se com a base de código! Certifique-se de ter as dependências necessárias instaladas e de poder executar os testes.

## O que você precisa para executá-lo
- [Scala 3.1.3](https://docs.scala-lang.org/getting-started/index.html)

## Construir (build)

```console
$ sbt compile
```

## Executar os testes

```console
$ sbt test 
```

## Executar a aplicação de demonstração

Para entender como essa biblioteca seria usada, você pode verificar o método `main` na classe` SampleApp`. Se você quiser ver os resultados, execute:

```console
$ sbt run
```

## Regras de negócios existentes

A biblioteca atualmente possui as seguintes regras de negócio implementadas:
* Cálculo do preço total e do total de pontos de fidelidade ganhos pelo cliente.
* Produtos com código de produto começando com DIS_10 têm um desconto de 10% aplicado.
* Produtos com código de produto começando com DIS_15 têm um desconto de 15% aplicado.
* Mais pontos de fidelidade são obtidos quando o produto não tem nenhum desconto aplicado:
    - O cliente ganha 1 ponto em cada compra de $5.
    - O cliente ganha 1 ponto a cada $ 10 gastos em um produto com 10% de desconto.
    - O cliente ganha 1 ponto a cada US $ 15 gastos em um produto com 15% de desconto.
