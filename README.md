# 🤖 Chatbot — Java Desktop Assistant

> A lightweight Java command-line assistant for **opening applications** on a Windows computer and **searching the web** using simple text commands.

## 📌 Overview

**Chatbot** is a Java-based desktop utility that allows users to interact with their computer through simple text commands.

Instead of manually navigating through installed applications or opening a browser and typing a search query, users can enter commands directly into the terminal:

```text
open chrome
```

or:

```text
search Java tutorials
```

The application interprets the command and performs the requested action.

The project was created as a simple exploration of **Java file handling, desktop integration, command-line interaction, recursion, and URL handling**.

---

## ✨ Features

### 🚀 Open Installed Applications

Use:

```text
open <application-name>
```

Example:

```text
open chrome
```

The application searches common Windows application directories for the corresponding `.exe` file and attempts to launch it.

The current implementation checks:

* `C:\Windows\System32`
* `C:\Program Files`

It recursively searches directories under `Program Files` when the application is not found in `System32`.

---

### 🌐 Search the Web

Use:

```text
search <query>
```

Example:

```text
search best Java tutorials
```

The application constructs a Google search URL and opens it using the system's default browser.

---

### 🛑 Exit the Application

Type:

```text
exit
```

to terminate the program.

---

## 💻 Example Session

```text
enter 'exit' to stop execution,
Type to search in browser,
type open to open an application on this computer

$ open chrome
opening application

$ search Java collections
processing request

$ search best programming languages
processing request

$ exit
```

---

## 🧠 How It Works

The application uses a simple command-processing loop.

```text
                 ┌─────────────────┐
                 │   User Input     │
                 └────────┬────────┘
                          │
                          ▼
                 ┌─────────────────┐
                 │ Command Parser  │
                 └────────┬────────┘
                          │
              ┌───────────┴───────────┐
              │                       │
              ▼                       ▼
       starts with "open"      starts with "search"
              │                       │
              ▼                       ▼
     Find application            Build Google URL
              │                       │
              ▼                       ▼
       Locate .exe               Open browser
              │
              ▼
        Launch app
```

The `Chatbot` class handles user input and determines which operation should be performed.

---

## 🏗️ Project Architecture

The project consists primarily of three classes:

```text
Chatbot
   │
   └── url
        │
        └── Application
```

### `Chatbot`

The main entry point.

Responsibilities:

* Read commands from the terminal
* Parse user input
* Detect `open`, `search`, and `exit`
* Call the appropriate functionality

The program continuously reads commands using Java's `Scanner` until the user enters `exit`.

---

### `Application`

Responsible for launching applications.

It contains functionality to:

1. Search for an executable
2. Recursively traverse directories
3. Build the executable path
4. Launch the application using `java.awt.Desktop`

The recursive search is implemented through:

```java
findFile(String name, File file)
```

while application launching is handled by:

```java
openApplication(String Name)
```

---

### `url`

Extends `Application` and adds web-search functionality.

The `search()` method:

1. Receives the user's query
2. Converts spaces into URL-compatible `+` characters
3. Creates a Google search URL
4. Opens the URL using `Desktop.browse()`

---

## 🛠️ Technologies Used

| Technology          | Purpose                           |
| ------------------- | --------------------------------- |
| **Java**            | Core programming language         |
| `java.awt.Desktop`  | Opening applications and URLs     |
| `java.io.File`      | File and directory operations     |
| `java.net.URI`      | Web URL handling                  |
| `java.net`          | Browser interaction               |
| `java.util.Scanner` | Reading terminal input            |
| Recursion           | Searching application directories |

---

## 📁 Project Structure

```text
chatbot/
│
├── chatbot/
│   ├── Chatbot.java
│   │
│   └── executable jar file/
│       └── chatbot.jar
│
└── README.md
```

The repository currently contains the Java source file and an executable JAR inside the `chatbot` directory.

---

## ⚙️ Requirements

### Operating System

The current implementation is designed for:

**Windows**

This is because the application searches Windows-specific directories such as:

```text
C:\Windows\System32
C:\Program Files
```

and searches specifically for `.exe` files.

### Java

A Java installation with support for:

* `java.awt.Desktop`
* standard Java I/O
* networking APIs

is required.

---

## 🚀 Running From Source

### 1. Clone the repository

```bash
git clone https://github.com/ROHITHAKULA-06/chatbot.git
cd chatbot
```

### 2. Navigate to the source directory

```bash
cd chatbot
```

### 3. Compile

```bash
javac Chatbot.java
```

### 4. Run

```bash
java Chatbot
```

You should see:

```text
enter 'exit' to stop execution,
Type to search in browser,
type open to open an application on this computer
```

---

## 📦 Running the Executable JAR

The repository includes a pre-built JAR file.

Navigate to the directory containing `chatbot.jar` and run:

```bash
java -jar chatbot.jar
```

This is also the execution method documented by the original project.

---

## 📝 Command Reference

| Command          | Description                            | Example                 |
| ---------------- | -------------------------------------- | ----------------------- |
| `open <name>`    | Find and open an installed application | `open chrome`           |
| `search <query>` | Search Google in the default browser   | `search Java tutorials` |
| `exit`           | Exit the program                       | `exit`                  |

---

## 🔍 Application Search Logic

When an `open` command is received, the application:

```text
open chrome
     │
     ▼
Check System32
     │
     ├── Found → Launch
     │
     └── Not Found
            │
            ▼
      Search Program Files
            │
            ▼
       Recursive search
            │
            ▼
       Find chrome.exe
            │
            ▼
       Launch application
```

The recursive search traverses directories and compares executable filenames case-insensitively.

---

## ⚠️ Current Limitations

This project is intentionally simple and has some limitations.

### Windows-specific paths

The application currently relies on hard-coded Windows directories:

```text
C:\Windows\System32\
C:\Program Files\
```

Therefore, it is not currently portable to Linux or macOS.

### Limited application search locations

Applications installed in locations such as:

```text
C:\Program Files (x86)
C:\Users\<user>\AppData\Local
```

may not be discovered.

### Command-based interaction

The application does not currently understand arbitrary natural-language requests.

For example:

```text
please open chrome
```

will not be interpreted as the same command as:

```text
open chrome
```

because command recognition is based on prefixes such as `open ` and `search `.

### Not an AI chatbot

Despite the repository name, the current implementation does **not** use:

* Large Language Models
* Machine Learning
* NLP models
* OpenAI APIs
* Generative AI

It is a rule-based command-line assistant.

---

## 🔮 Future Improvements

The project could be expanded into a much more capable desktop assistant.

### 🧠 Natural Language Commands

Instead of requiring:

```text
open chrome
```

support commands such as:

```text
Can you open Chrome?
```

or:

```text
Launch my browser
```

---

### 🔎 Smarter Application Discovery

Improve application detection by searching:

* `Program Files`
* `Program Files (x86)`
* User application directories
* Start Menu shortcuts
* Windows PATH
* Registry-installed applications

---

### 🎤 Voice Commands

Add speech recognition so users can interact with the assistant using their voice.

Example:

```text
"Open Chrome"
"Search Java tutorials"
```

---

### 🤖 AI Integration

An LLM could be added to convert natural-language requests into structured commands:

```text
User:
"Could you open Chrome and search for Java recursion?"

              ↓

AI command interpretation

              ↓

open → chrome
search → Java recursion
```

---

### 🖥️ Graphical User Interface

A GUI could replace the terminal interface and provide:

* Chat-style interaction
* Application suggestions
* Search history
* Command history
* Voice input
* Custom shortcuts

---

### 🌍 Cross-Platform Support

The application could detect the operating system and use platform-specific mechanisms:

```text
Windows → .exe / Start Menu
Linux   → PATH / .desktop files
macOS   → Applications
```

---

## 🎓 Concepts Demonstrated

This project demonstrates several fundamental Java concepts:

* Object-oriented programming
* Classes and inheritance
* Method invocation
* Recursion
* File handling
* Directory traversal
* Exception handling
* Command-line input
* String manipulation
* URL construction
* Browser integration
* Desktop application integration
* JAR packaging

---

## 📜 Project Information

**Project:** Chatbot
**Author:** AKULA N V S ROHITH
**Type:** Java Desktop Utility
**Platform:** Windows
**Original project date:** July 2, 2024

---

## ⭐ Future Vision

The long-term goal of this project can be to evolve from a simple command-based launcher into a lightweight **desktop AI assistant** capable of understanding natural-language commands and interacting with applications, browsers, files, and other system resources.

---

## 📄 License

No license is currently specified in the repository.

If you intend for others to freely use, modify, and distribute the project, consider adding an appropriate open-source license such as the **MIT License**.
