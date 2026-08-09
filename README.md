# 📋 Documentação Completa - Projeto Restaurante

## O que é este projeto

**Projeto Restaurante** é um aplicativo Android desenvolvido em Kotlin que funciona como um **sistema de controle de entrada e saída de pessoas** em um restaurante. O app permite monitorar a capacidade de ocupação do estabelecimento em tempo real, indicando quando é possível receber novos clientes ou quando o local está lotado, com limite máximo de 10 pessoas.

---

## 🎨 Tela do Aplicativo

<div align="center">
  <img src="https://imgur.com/placeholder.png" alt="Tela Principal - Projeto Restaurante" width="300" />
  
  **Tela Principal com Contador de Ocupação**
</div>

**Visualização da interface:**
- Status: "Pode Entrar" 
- Contador: 0 pessoas
- Dois botões: "Entrar" e "Sair"
- Background: Imagem elegante do restaurante

### Elementos da Interface

A tela principal apresenta:
- **Imagem de fundo** do restaurante (restaurant.png) com tema de bar/restaurante elegante
- **Status atual** em branco, grande e destacado ("Pode Entrar" ou "Lotado!")
- **Contador de pessoas** com número em branco, gigante e bem legível (0-10)
- **Botão "Entrar"** (lado esquerdo) - incrementa o contador
- **Botão "Sair"** (lado direito) - decrementa o contador
- **Design responsivo** que se adapta a diferentes tamanhos de tela

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

```kotlin
package com.example.restaurante

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var status = findViewById<TextView>(R.id.textStatus)
        var contador = findViewById<TextView>(R.id.textContador)
        var btnEntrar = findViewById<Button>(R.id.btnEntrar)
        var btnSair = findViewById<Button>(R.id.btnSair)
        
        btnEntrar.setOnClickListener {
            var cont = contador.text.toString().toInt()
            cont++
            if(cont <= 10) {
                contador.text = cont.toString()
            }else{
                status.text = "Lotado!"
            }
        }
        
        btnSair.setOnClickListener {
            var cont = contador.text.toString().toInt()
            cont--
            if(cont >=0 && cont <=10){
                contador.text = cont.toString()
                status.text = "Pode Entrar"
            }
        }
    }
}
```

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
| `textStatus` | Texto dinâmico ("Pode Entrar" / "Lotado!") em branco, tamanho 34sp |
| `textContador` | Número de pessoas presentes (0-10) em branco, tamanho 60sp |
| `btnEntrar` | Botão para entrada de pessoa, posicionado à esquerda |
| `btnSair` | Botão para saída de pessoa, posicionado à direita |

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
- Tema: Bar/Restaurante elegante com iluminação ambiente

**Tipografia:**
- Status: Branco, negrito, tamanho 34sp
- Contador: Branco, negrito, tamanho 60sp
- Botões: Branco, tamanho 20sp, fundo semi-transparente (#A9000000)

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
9. **Temas:** Possibilidade de trocar cores e imagem de fundo
10. **Sons:** Feedback sonoro ao entrar/sair

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
✅ Botões com feedback visual  
✅ Textos em branco com excelente legibilidade

---

## 👨‍💻 Autor

**Karina Amorim**

---

**Repositório:** [Karina-Amorim-Dev/projeto-restaurante](https://github.com/Karina-Amorim-Dev/projeto-restaurante)  
**Criado em:** 09 de agosto de 2026  
**Versão:** 1.0
