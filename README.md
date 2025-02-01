# Projeto: Aplicativo Wear OS - Assistência e Comunicação

Este projeto tem como objetivo desenvolver um aplicativo Wear OS que auxilia funcionários com necessidades especiais, oferecendo funcionalidades acessíveis como leitura de mensagens, comandos de voz e alertas de segurança.

## 📋 Sumário

1. [Introdução](#introducao)
2. [Objetivos](#objetivos)
3. [Requisitos do Sistema](#requisitos-do-sistema)
4. [Configuração do Ambiente](#configuracao-do-ambiente)
5. [Passo a Passo para Desenvolvimento](#passo-a-passo-para-desenvolvimento)
6. [Referências](#referencias)

---

<a name="introducao"></a>
## 📝 Introdução

A empresa fictícia "Doma" busca melhorar sua comunicação interna e eficiência através de um aplicativo para dispositivos Wear OS. Este aplicativo foi planejado para:

- Ler mensagens e notificações em voz alta.
- Responder a comandos de voz.
- Emitir alertas de segurança e instruções por áudio.

Este projeto é um exemplo prático de como utilizar tecnologias wearables para criar soluções inclusivas e acessíveis.

---

<a name="objetivos"></a>
## 🎯 Objetivos

- Configurar o ambiente de desenvolvimento utilizando o Android Studio.
- Criar um aplicativo Wear OS com funções básicas de interação.
- Implementar sensores e saídas de áudio.
- Realizar testes no emulador e capturar telas.

---

<a name="requisitos-do-sistema"></a>
## 💻 Requisitos do Sistema

Para realizar o projeto, você precisará:

- **Sistema Operacional:** Windows, macOS ou Linux.
- **Software:**
  - Android Studio (versão mais recente).
  - Navegador Web (Google Chrome, Firefox, Safari, etc.).
  - Editor de Texto/IDE (opcional, como VS Code).
- **Hardware:**
  - Processador compatível com virtualização (recomendado para emuladores).
  - Memória RAM: 8 GB ou mais (16 GB recomendado).
  - Armazenamento: 20 GB ou mais disponíveis.

---

<a name="configuracao-do-ambiente"></a>
## 🔧 Configuração do Ambiente

### 1. Instalar o Android Studio

1. Acesse a [página oficial do Android Studio](https://developer.android.com/studio?hl=pt-br#get-android-studio).

![Image](https://github.com/user-attachments/assets/d301276f-180f-4588-9d90-e59c624e54ec)

2. Baixe e instale o Android Studio seguindo as instruções específicas para o seu sistema operacional (Windows, macOS ou Linux).

![Image](https://github.com/user-attachments/assets/a5887816-8cbc-4287-9b93-d143fd7688e7)

![Image](https://github.com/user-attachments/assets/bc7028f1-c03e-45ca-a205-01bbe533a334)

![Image](https://github.com/user-attachments/assets/0a88306a-4064-4e5e-a250-8a101d3acb5c)

3. Após a instalação, escolha entre os temas claro e escuro e configure o emulador para Wear OS.

![Image](https://github.com/user-attachments/assets/e7a49e81-2659-4e10-b20a-4169e70e5a48)

### 2. Criar um Emulador Wear OS

1. No Android Studio, vá para `Tools > Device Manager`.

![Image](https://github.com/user-attachments/assets/51726903-6a8f-4a78-9c37-f737d3712d42)

2. Clique em `Create Device` e selecione a categoria Wear OS.

![Image](https://github.com/user-attachments/assets/f906e066-0476-4519-8797-334d2d334ba9)

3. Escolha o hardware e a versão do sistema operacional.

![Image](https://github.com/user-attachments/assets/5cb6f41e-dd2b-470e-8cb9-8722c9ae503d)

4. Configure as propriedades do dispositivo e finalize o processo.

---

<a name="passo-a-passo-para-desenvolvimento"></a>
## 🚀 Passo a Passo para Desenvolvimento

### Microatividade 1: Instalação e Configuração
- Configure o Android Studio e o emulador conforme descrito na seção anterior.

### Microatividade 2: Criar um Novo Projeto
1. Abra o Android Studio e acesse `File > New > New Project`.
2. Selecione `Wear OS` e escolha o template `No Activity`.
3. Nomeie o projeto como "ListaDeTarefas" e utilize a API 30 como mínimo.

![Image](https://github.com/user-attachments/assets/891b19a6-caaa-4bd5-b5b9-771a5880cfae)

### Microatividade 3: Configurações e Lógica
1. Crie a `MainActivity.java` no diretório `app`.

![Image](https://github.com/user-attachments/assets/8e2b4a6f-5c35-4812-a583-916247a31f17)

![Image](https://github.com/user-attachments/assets/8708a6b7-619a-4a11-80c6-29b7e7a6db5a)
   
3. Configure permissões no arquivo `AndroidManifest.xml`:
   ```xml
   <uses-permission android:name="android.permission.BODY_SENSORS"/>
   <uses-permission android:name="android.permission.WAKE_LOCK"/>
   ```
![Image](https://github.com/user-attachments/assets/b1ece45e-f349-471c-8490-ab9d690dce7c)

3. Adicione dependências no arquivo `build.gradle`.

![Image](https://github.com/user-attachments/assets/601ea5ca-b24b-4288-845b-c7d2d16ea2a6)

### Microatividade 4: Desenvolvimento e Testes
- Crie uma interface inicial utilizando `ListView` e `Button`.
- Teste as funcionalidades no emulador.

![Image](https://github.com/user-attachments/assets/11664081-c604-4b3c-944e-e0d3bb22395e)

### Microatividade 5: Captura de Tela
- Realize capturas de tela no emulador ou utilizando um dispositivo físico conectado.

![Image](https://github.com/user-attachments/assets/9feb3f02-fa19-4a77-a7bb-ee08e8bf4ca3)

---

<a name="referencias"></a>
## 📌 Referências

- [Android Studio Documentation](https://developer.android.com/studio?hl=pt-br)
- [Android API Reference](https://developer.android.com/reference)

---

🛠️ **Desenvolvido por

![Image](https://github.com/user-attachments/assets/aaf8c20a-4df7-4b19-86b9-d660be250da9)
