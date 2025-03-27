# SuperStore - Web Application

SuperStore è un'applicazione web sviluppata con **Spring Boot**, progettata per la gestione dei prodotti di un negozio online. L'applicazione sfrutta un'architettura **MVC** e un database relazionale **MySQL** per la memorizzazione dei dati.

## 🚀 Funzionalità principali
- Interfaccia web per visualizzare e gestire i prodotti.
- API REST per la gestione dei prodotti tramite richieste HTTP.
- Persistenza dei dati con **Spring Data JPA** e **MySQL**.
- Struttura organizzata con controller, repository ed entità per una gestione chiara e scalabile del progetto.
- Utilizzo di **Thymeleaf** per il rendering delle pagine HTML, **Bootstrap** per lo styling e un'icona personalizzata per migliorare l'esperienza utente.

## ⚙️ Architettura
**Modalità Monolitica**
- ✅ Tutta la logica (controller, servizio, repository, UI) è contenuta in un unico progetto **Spring Boot**.
- ✅ **Backend** e **frontend** sono integrati nello stesso codice.
- ✅ Utilizzo di un database relazionale (**MySQL**) e architettura **MVC** classica.

## 🛠️ Tecnologie
- **Spring Boot** - Per la costruzione e la gestione dell'applicazione.
- **Spring Data JPA** - Per la gestione della persistenza dei dati.
- **MySQL** - Per il database relazionale.
- **Thymeleaf** - Per il rendering delle pagine HTML.
- **Bootstrap** - Per lo styling dell'interfaccia.
- **Spring Security** (facoltativo) - Per la gestione della sicurezza (se implementato).

## 📦 Setup

1. **Clonare il repository:**
   ```bash
   git clone https://github.com/tuo-utente/superstore.git
