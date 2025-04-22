# FIAP Hackaton Frame
-Repositorio para infraestrutura do frameflow

## 📄 Resumo do Projeto
O FIAP Hackaton Frame é um sistema projetado para processamento de vídeos, permitindo que os usuários enviem arquivos, processem cortes e façam o download das imagens extraídas em um arquivo .zip. O projeto evoluiu a partir de um MVP e agora busca garantir escalabilidade, segurança e qualidade de software, atendendo a uma demanda crescente de usuários e volume de vídeos processados.

## 👨‍🔧👩‍🔧 Integrantes

Robson de Oliveira Arcoleze - RM 3569698 - robson.arcoleze29@gmail.com


## 🔨 Arquitetura Proposta
A solução será baseada em uma arquitetura escalável e distribuída, garantindo eficiência e alta disponibilidade. Os principais componentes incluem:
- Microsserviços para modularização e melhor manutenção do sistema.
- Mensageria (AWS SNS/SQS) para processamento assíncrono e alta performance.
- Armazenamento em nuvem para arquivos de vídeos e imagens (AWS S3) e utilização do Amazon RDS para salvar as informações de processamento dos vídeos.
- Banco de dados distribuído para persistência de metadados e status dos vídeos.
- Autenticação segura via AWS Cognito para controle de acesso.
- Escalabilidade automática com balanceamento de carga e computação serverless.

## 📁 Acesso ao Projeto

### Repositórios no GitHub

- **Infraestrutura Kubernetes com Terraform:**  
  [infra-fiap-frameflow](https://github.com/RobsonArcoleze/hackaton-fiap-infra)

- **Infraestrutura de Banco de Dados Gerenciáveis com Terraform:**  
  [infra-bd-fiap-frameflow](https://github.com/RobsonArcoleze/hackaton-fiap-db-infra)

- **Microserviço de Notificação por E-mail (Consumidor):**  
  [authframeflow](https://github.com/RobsonArcoleze/hackaton-fiap-auth)

- **Microserviço de Upload de Vídeo (Produtor):**  
  [java-spring-aws-sqs](https://github.com/RobsonArcoleze/hackaton-aws-sqs)

- **Microserviço de Processamento de Vídeo (Consumidor):**  
  [fiap-frameflow](https://github.com/RobsonArcoleze/hackaton-fiap-frame)

- **Microserviço de Notificação por E-mail (Consumidor):**  
  [fiap-notifyframeflow](https://github.com/RobsonArcoleze/hackaton-fiap-notifyFrameFlow)

## 📐 Diagramas e Documentações

- [**Diagrama da Arquitetura do Sistema**](https://drive.google.com/file/d/1tmwsMudqYLGj0Bk0klof8fA4hw1KPFEX/view)
- [**Documentação da Modelagem de Dados**]https://docs.google.com/document/d/1TKvx9MnW6Q-lvNpo60jWedmaOMdGRnL5/edit)

## ✔️ Funcionalidades do Projeto

### 🔑 Autenticação e Gerenciamento de Usuários
1. Autentica/cria usuário no Cognito.
2. Valida confirmação de código do e-mail.
3. Cadastra o usuário no banco de dados.
4. Retorna Token JWT com as credenciais.

### 📤 Upload e Gerenciamento de Vídeos
1. Carrega vídeo original para S3.
2. Listagem de status de corte por usuário.
3. Carregar vídeos para o diretório.
4. Download de frames por requisição.

### 🎞️ Processamento de Vídeos
1. Carrega vídeo para diretório `/originais raw`.
2. Baixa vídeo do S3 e começa a processar os cortes.
3. Processa cortes de vídeos e realiza carga para S3.
4. Atualiza registro de requisição de corte com status "Em Processamento".

### 📩 Notificação de Status
1. Notificação de status de erro/sucesso da requisição por e-mail.