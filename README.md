# Estudo computação paralela da faculdade

## 🧠 Conceitos Básicos de Concorrência
### 🔒 Mutex (Mutual Exclusion)
Um Mutex é como uma chave de banheiro em um escritório:
apenas uma pessoa por vez pode usar o banheiro. Se alguém já estiver lá dentro (segurando a chave), os outros precisam esperar até que a chave seja liberada.

No código, um mutex garante que apenas uma thread por vez execute uma parte crítica do programa (ex: atualizar um valor compartilhado), evitando conflitos.

👉 Usado para evitar acesso simultâneo a um recurso compartilhado.

### 🧩 O que é Seção Crítica?
A seção crítica é a parte do código onde dados compartilhados são lidos ou modificados. Se várias threads executarem essa parte ao mesmo tempo sem controle, podem ocorrer erros como dados incorretos ou corrompidos.

#### 🔍 Como identificar uma Seção Crítica?
**Você pode considerar uma parte do código como seção crítica quando:**

- Duas ou mais threads acessam a mesma variável ou estrutura de dados.

- Pelo menos uma dessas threads escreve (modifica) esse dado.

- A execução simultânea pode causar comportamento inesperado.

Exemplo clássico: incremento de um contador global (contador++) por várias threads ao mesmo tempo.

### ⚠️ Race Condition (Condição de Corrida)
Uma Race Condition acontece quando duas ou mais threads acessam e modificam um dado ao mesmo tempo, causando resultados imprevisíveis.

Imagine duas pessoas tentando atualizar o saldo da mesma conta bancária ao mesmo tempo sem coordenação — uma pode sobrescrever a alteração da outra sem querer.

👉 É um erro de concorrência, que geralmente ocorre por falta de sincronização.

### 🚦 Semaphore (Semáforo)
Um Semaphore funciona como o estacionamento de um shopping com número limitado de vagas.
Se o estacionamento tem 3 vagas, apenas 3 carros podem entrar. Quando um carro sai (vaga liberada), outro pode entrar.

No código, um semáforo limita quantas threads podem acessar um recurso ao mesmo tempo.

👉 Ideal para controlar acesso concorrente com limite, como número máximo de conexões ou de tarefas em execução.

