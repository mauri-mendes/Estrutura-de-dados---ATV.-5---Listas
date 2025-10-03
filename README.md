# ListasJava

##Integrantes
- Mauricio Mendes (brisollamauricio2020@gmail.com)

## Enunciado
Nome (String)
Matrícula (String, com 5 números gerados aleatoriamente)
Data de Nascimento (dia/mês/ano)
Dados Pré-definidos:
Você poderá utilizar os seguintes vetores de nomes e sobrenomes para depois gerar os nomes dos alunos:

private static String[] nomes = {"Ana", "João", "Carlos", "Maria", "Pedro", "Juliana", "Lucas", "Fernanda"};
private static String[] sobrenomes = {"Silva", "Souza", "Oliveira", "Costa", "Pereira", "Rodrigues", "Almeida", "Ferreira"};
Se desejar, adicione outros nomes e sobrenomes a lista

Funcionalidades do Programa:
O programa deverá automaticamente gerar e preencher três listas de alunos, cada uma utilizando uma das implementações (ArrayList, LinkedList e Vector), e apresentar as seguintes funcionalidades:

Cadastrar Alunos:
O programa deve cadastrar 350.000 alunos nas três implementações de lista. Não é necessário exibir na tela os dados gerados.

Ordenar as Listas:
Após o cadastro, as três listas devem ser ordenadas por nome dos alunos.

Exportar Todos os Alunos para CSV:
Os dados de cada lista (já ordenada) devem ser exportados para arquivos CSV.
O arquivo CSV deve conter as colunas: Nome, Matrícula, Data de Nascimento.
Os arquivos CSV devem ser salvos com os seguintes nomes: alunos_arraylist.csv, alunos_linkedlist.csv e alunos_vector.csv.

Medição de Tempo:
O programa deve medir o tempo de execução das operações de inserção, ordenação e exportação para CSV para cada tipo de lista.
Ao final da execução, o programa deve apresentar uma tabela com os tempos de execução das três operações para as três listas (ArrayList, LinkedList e Vector).

========= TEMPOS DE EXECUCAO (ms) =========
Operacao     ArrayList       LinkedList      Vector         
Cadastro     388             283             246            
Ordenacao    93              136             76             
Exportacao   50              22              10     

Sistema Operacional: ex.: Windows 10 64-bit

CPU: ex.: Intel Core i5-1235U

Memória RAM: ex.: 8 GB

Java: ex.: OpenJDK 17 (javac 17)

IDE/Editor: ex.: Visual Studio Code

## Estrutura do projeto
`src/` - código fonte Java 
`docs/` - Documentação Javadoc (gerada)
`README.md` - `LICENSE.md` 

## Como compilar e executar (local)
```bash
# compliar
javac -d out src/*.java

# executar e salvar saida
java -cp out Principal > resultado.txt


