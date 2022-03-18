Descrizione Progetto :

Il progetto simula un sistema CRM per un'azienda fornitrice di energia, denominata "EPIC ENERGY SERVICES", che vuole gestire i contatti con i propri clienti business. Il sistema, basato su Web Service REST Spring Boot e database PostgreSQL,permettere di gestire un elenco dei clienti, che può avere fino a due indirizzi, uno per la sede legale ed uno per la sede operativa.I clienti possono essere di vario tipo: PA,SAS.SPA,SRL.

Associato ad ogni cliente c'è un insieme di fatture.Ogni fattura ha uno stato,che può essere dinamico, in quanto in base all'evoluzione del business possono essere inseriti nel sistema nuovi stati.

Gli indirizzi dei clienti sono associati ai comuni e province, gestiti attraverso un'anagrafica centralizza(importati da file in formato CSV) e sono caratterizzati da un nome e da un riferimento ad una provincia, anch'essa gestita in anagrafica centralizzata e caratterizzata da un nome ed una sigla.

L'applicazione prevede un sistema di autenticazione e autorizzazione basato su token JWT che permetta a diversi utenti di accedere alle funzioni del backend e di registrarsi al sistema, come ADMIN o USER.

Si possono eseguire tutte le funzioni necessarie a gestire le operazioni CRUD da servizio REST con l'utizizzo di SWAGGER o POSTMAN(collection presente all'interno del progetto). oppure attraverso servizio web, sviluppata con la tecnologia Thymeleaf.

All'interno del progetto sarà disponbile un backup di un database realizzato con PostgreSQL.

Il progetto è stato realizzato con il framework Spring boot utilizzando le seguenti Dependencies: Spring Web, PostgresSQL Driver , Spring Data JPA, Thymeleaf , OpenCSV, Swagger Open Api Docs, Spring Security , Lombok,

Scaletta da seguire per l'inserimento degli attributi su Postman e Swagger:

Effettuare il login : http://localhost:8080/auth/login
modello JSON:

ADMIN:

    { "userName" : "admin", "password" : "admin" }

USER:

    { "userName" : "user", "password" : "user" }

Verrà generato un token(JWT):

su Swagger dovrà essere inserito in "Authorize" (in alto a destra della pagina)

su Postman dovrà esser inserito in "Authorization" (nella toolbar delle Request, selezionando "Type" : Bearer Token)

Inserimento Cliente :

    { "ragioneSociale": "Margi", "partitaIva": "TR3252351", "email": "margi@mail.it", "dataInserimento": "2017-01-12", "dataUltimoContatto": "2022-01-14", "fatturatoAnnuale": 5464735383, "pec": "margi@mail.it", "telefono": "3334521789", "emailContatto": "thomas@mail.it", "nomeContatto": "Thomas", "cognomeContatto": "Tam", "telefonoContatto": "3347809123", "sedeLegale": { "via": "via Erbe", "civico": 1, "localita": "Roma", "cap": 39100, "comune": { "id": 3457 } }, "sedeOperativa":  { "via": "via Milano", "civico": 22, "localita": "Roma", "cap": 3457 }, "tipoCliente": "SRL" }

Inserimento fattura :

( che potrà essere associata all'id del cliente)

{ "anno": 2022, "data": "2022-01-03", "importo": 1234, "numeroFattura": 39, "stato": "PAGATA", "cliente": { "id": "1" } }

OPERAZIONI CRUD E VARIE OPERAZIONI DI RICERCA E ORDINAMENTO PRESENTI IN SWAGGER e COLLECTION di POSTMAN

SERVIZIO WEB

URL per l'accesso ai servizi web http://localhost:8080/

sarà richiesto il login (ADMIN o USER) da qui sarà possibile visulizzare le liste dei comuni e province, ed aggiugere,eliminare,modificare i clienti.

Samuel Pivetta
