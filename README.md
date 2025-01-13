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
2. Baixe e instale o Android Studio seguindo as instruções específicas para o seu sistema operacional (Windows, macOS ou Linux).
3. Após a instalação, escolha entre os temas claro e escuro e configure o emulador para Wear OS.

### 2. Criar um Emulador Wear OS

1. No Android Studio, vá para `Tools > Device Manager`.
2. Clique em `Create Device` e selecione a categoria Wear OS.
3. Escolha o hardware e a versão do sistema operacional.
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

### Microatividade 3: Configurações e Lógica
1. Crie a `MainActivity.java` no diretório `app`.
2. Configure permissões no arquivo `AndroidManifest.xml`:
   ```xml
   <uses-permission android:name="android.permission.BODY_SENSORS"/>
   <uses-permission android:name="android.permission.WAKE_LOCK"/>
   ```
3. Adicione dependências no arquivo `build.gradle`.

### Microatividade 4: Desenvolvimento e Testes
- Crie uma interface inicial utilizando `ListView` e `Button`.
- Teste as funcionalidades no emulador.

### Microatividade 5: Captura de Tela
- Realize capturas de tela no emulador ou utilizando um dispositivo físico conectado.

---

<a name="referencias"></a>
## 📌 Referências

- [Android Studio Documentation](https://developer.android.com/studio?hl=pt-br)
- [Android API Reference](https://developer.android.com/reference)

---

🛠️ **Desenvolvido por


