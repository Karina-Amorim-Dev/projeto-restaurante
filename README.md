# 📋 Documentação Completa - Projeto Restaurante

## O que é este projeto

**Projeto Restaurante** é um aplicativo Android desenvolvido em Kotlin que funciona como um **sistema de controle de entrada e saída de pessoas** em um restaurante. O app permite monitorar a capacidade de ocupação do estabelecimento em tempo real, indicando quando é possível receber novos clientes ou quando o local está lotado, com limite máximo de 10 pessoas.

---

## 🎨 Tela do Aplicativo

<div align="center">
  <img src="https://raw.githubusercontent.com/Karina-Amorim-Dev/projeto-restaurante/main/app/src/main/res/drawable/restaurant.png" alt="Tela Principal - Projeto Restaurante" width="350" style="border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1);" />
  
  **Tela Principal com Contador de Ocupação**
</div>

### Elementos da Interface

A tela principal apresenta:
- **Imagem de fundo** do restaurante (restaurant.png)
- **Status atual** em grande destaque ("Pode Entrar" ou "Lotado!")
- **Contador de pessoas** com número grande e legível (0-10)
- **Botão "Entrar"** (lado esquerdo) - incrementa o contador
- **Botão "Sair"** (lado direito) - decrementa o contador

---

## 📱 Stack Técnico

- **Linguagem:** Kotlin
- **Plataforma:** Android (API 24+, Target API 36)
- **Framework:** Android Studio / Gradle Build System
- **Bibliotecas principais:**
  - AndroidX Core KTX
  - AndroidX AppCompat
  - AndroidX ConstraintLayout
  - Material Design 3
  - AndroidX Activity KTX
- **Versão da aplicação:** 1.0 (Build 1)

---

## 📁 Estrutura do Projeto

```
projeto-restaurante/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/restaurante/
│   │       │   └── MainActivity.kt        # Lógica principal da aplicação
│   │       ├── res/
│   │       │   ├── drawable/
│   │       │   │   └── restaurant.png     # Imagem de fundo
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml  # Interface com botões e contador
│   │       │   └── values/
│   │       │       ├── colors.xml         # Paleta de cores
│   │       │       ├── strings.xml        # Strings da app
│   │       │       └── themes.xml         # Tema Material Design 3
│   │       └── AndroidManifest.xml        # Configuração da aplicação
│   ├── build.gradle.kts                   # Configuração de build
│   └── proguard-rules.pro                 # Regras de otimização
├── build.gradle.kts                       # Build do projeto raiz
├── settings.gradle.kts                    # Configuração de módulos
└── gradle.properties                      # Propriedades Gradle

```

### Como funciona

A aplicação é centrada na classe `MainActivity`, que gerencia a interface de usuário e a lógica de negócio. Quando iniciada, exibe uma tela com uma imagem de fundo do restaurante e os controles de entrada/saída.

A lógica valida a capacidade máxima: ao atingir 10 pessoas, o status muda para "Lotado!" e o botão "Entrar" deixa de funcionar.

---

## 🚀 Como Executar

### Pré-requisitos
- Android Studio instalado
- JDK 11 ou superior
- SDK Android com API 24+
- Emulador Android ou dispositivo físico

### Passos para executar

```bash
# 1. Clone o repositório (se não tiver feito)
git clone https://github.com/Karina-Amorim-Dev/projeto-restaurante.git
cd projeto-restaurante

# 2. Abra o projeto no Android Studio
# Arquivo > Abrir > selecione a pasta do projeto

# 3. Sincronize o Gradle
# Android Studio detectará automaticamente e pedirá para sincronizar

# 4. Execute na emuladora ou dispositivo
# Run > Run 'app' (Shift + F10)
```

### Variáveis de ambiente
Não há variáveis de ambiente ou secrets necessários para este projeto.

---

## 💻 Detalhamento Técnico

### MainActivity.kt
Principal arquivo Kotlin que contém toda a lógica da aplicação:

**Funcionalidades principais:**
- Inicializa o layout da atividade
- Captura referências dos widgets (TextViews e Buttons)
- Implementa lógica de incremento/decremento do contador
- Valida limite de capacidade (máximo 10 pessoas)
- Atualiza status visual em tempo real

**Fluxo de eventos:**
```
Botão "Entrar" clicado
  ↓
Incrementa contador
  ↓
Verifica se <= 10
  ├─ Sim: Atualiza TextView com novo valor
  └─ Não: Exibe "Lotado!" no status

Botão "Sair" clicado
  ↓
Decrementa contador
  ↓
Verifica intervalo válido (0-10)
  └─ Sim: Atualiza contador e status para "Pode Entrar"
```

### Interface (activity_main.xml)
Layout responsivo com ConstraintLayout:

| Elemento | Função |
|----------|--------|
| `ImageView` | Background com imagem do restaurante (restaurant.png) |
| `textStatus` | Texto dinâmico ("Pode Entrar" / "Lotado!") |
| `textContador` | Número de pessoas presentes (0-10) |
| `btnEntrar` | Botão para entrada de pessoa |
| `btnSair` | Botão para saída de pessoa |

---

## 🎨 Configuração Visual

**Cores (colors.xml):**
- Preto: `#FF000000`
- Branco: `#FFFFFFFF`

**Tema:** Material Design 3 (DayNight) sem Action Bar

**Textos com caracteres especiais:**
- Status: "Pode Entrar" / "Lotado!"
- Botões: "Entrar" / "Sair"

**Imagem de fundo:**
- Arquivo: `restaurant.png`
- Localização: `app/src/main/res/drawable/`
- Dimensões: Ajustada com `scaleType="centerCrop"`

---

## 📊 Limites e Capacidade

- **Capacidade máxima:** 10 pessoas
- **Valor inicial:** 0 pessoas
- **Comportamento ao atingir limite:**
  - Status muda para "Lotado!"
  - Contador não avança além de 10
  - Botão "Entrar" permanece visível mas inoperante

---

## 🔧 Possíveis Melhorias Futuras

1. **Persistência de dados:** Salvar contador em SharedPreferences ou banco de dados
2. **Notificações:** Alertar quando atingir 80% da capacidade
3. **Histórico:** Registrar horários de entrada e saída
4. **Autenticação:** Login para diferentes estabelecimentos
5. **Dashboard:** Estatísticas diárias/semanais de ocupação
6. **Integração:** Conexão com backend para múltiplas filiais
7. **Ajuste dinâmico:** Permitir mudança da capacidade máxima via admin
8. **Sensores:** Integração com leitores de cartão ou QR code

---

## 📝 Resumo de Funcionalidades

✅ Contador de pessoas em tempo real  
✅ Validação de capacidade máxima (10 lugares)  
✅ Interface intuitiva com 2 botões  
✅ Status visual dinâmico  
✅ Imagem de fundo customizada  
✅ Design responsivo (ConstraintLayout)  
✅ Compatível com Android 5.0+ (API 24)  
✅ Suporte a temas claro/escuro (Material Design 3)

---

**Repositório:** [Karina-Amorim-Dev/projeto-restaurante](https://github.com/Karina-Amorim-Dev/projeto-restaurante)  
**Criado em:** 09 de agosto de 2026  
**Versão:** 1.0
