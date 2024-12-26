# Pal API

![Pal API](https://github.com/QuickoAbdul/palapi/blob/pal-default/src/main/resources/static/images/swagger-ui.png)
## Description

**Pal API** est une application Spring Boot développée pour gérer une collection de "Pals" et leurs attributs associés. Ce projet met en pratique l'utilisation de Spring Boot, Spring JPA, et les principes REST pour construire une API robuste et évolutive.

L'objectif est de fournir des fonctionnalités CRUD (Create, Read, Update, Delete) ainsi que des opérations avancées pour manipuler les données des Pals et leurs relations complexes.

---

## Fonctionnalités Principales

### Gestion des Pals
- **GET par ID** : Récupérer un Pal par son identifiant unique.
- **GET par nom** : Récupérer un Pal par son nom.
- **GET par type** : Récupérer une liste de Pals par type.
- **SAVE** : Ajouter un nouveau Pal dans la base de données.

### Gestion des Skills
- **GET skills** : Récupérer la liste des compétences (skills) d'un Pal.
- **ADD skill** : Ajouter une compétence à un Pal.
- **MODIFY skill** : Modifier une compétence existante d'un Pal.

### Gestion des Types
- **GET types** : Récupérer les types associés à un Pal.
- **ADD type** : Ajouter un type à un Pal.
- **REMOVE type** : Supprimer un type d'un Pal.

### Fonctions Bonus
- **GET x Pals SORTED BY rarity** : Récupérer une liste de Pals triée par rareté.
- **GET x Pals SORTED BY price** : Récupérer une liste de Pals triée par prix.

---

## Architecture du Projet

Le projet suit les bonnes pratiques de conception et implémente :

### 1. **Pattern MVC (Controller / Service / Repository)**
- **Controller** : Gère les points d'entrée HTTP.
- **Service** : Contient la logique métier.
- **Repository** : Gère les interactions avec la base de données via JPA.

### 2. **Clean Architecture (Application / Domain / Infrastructure)**
- **Application Layer** : Contient les services et points d'entrée (Controllers).
- **Domain Layer** : Décrit les entités et la logique métier.
- **Infrastructure Layer** : Fournit l'accès à la base de données et autres systèmes externes.

---

## Configuration

### Prérequis
- **Java 17** ou version supérieure
- **Maven** (ou tout autre outil de build Java compatible)
- **H2 Database** (intégrée)

### Installation
1. Clonez le dépôt :
   ```bash
   git clone <repository_url>
   ```
2. Accédez au répertoire du projet :
   ```bash
   cd pal-api
   ```
3. Compilez et packagez l'application :
   ```bash
   mvn clean install
   ```

### Lancer l'application
1. Exécutez l'application :
   ```bash
   mvn spring-boot:run
   ```
2. Accédez à l'application sur [http://localhost:8080/api/v1/pals](http://localhost:8080/api/v1/pals).

---

## Base de Données

### Import des Données
- Les données initiales des Pals sont automatiquement importées depuis le fichier `pals.json` dans la base de données H2 à chaque démarrage de l'application.

### Accéder à la Console H2
- URL : [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL : `jdbc:h2:mem:testdb`
- User : `sa`
- Password : `password`

---

## Swagger-UI
- Intellij : `Installer le plugin Swagger UI` 

---

## API Endpoints

| Méthode | Endpoint                      | Description                         |
|---------|-------------------------------|-------------------------------------|
| GET     | `/pals/{id}`                  | Récupérer un Pal par ID             |
| GET     | `/pals/name/{name}`           | Récupérer un Pal par nom            |
| GET     | `/pals/type/{type}`           | Récupérer des Pals par type         |
| POST    | `/pals`                       | Ajouter un nouveau Pal              |
| GET     | `/pals/{id}/skills`           | Récupérer les skills d'un Pal       |
| POST    | `/pals/{id}/skills`           | Ajouter un skill à un Pal           |
| PUT     | `/pals/{id}/skills/{skillId}` | Modifier un skill d'un Pal          |
| GET     | `/pals/{id}/types`            | Récupérer les types d'un Pal        |
| POST    | `/pals/{id}/types`            | Ajouter un type à un Pal            |
| DELETE  | `/pals/{id}/types/{typeId}`   | Supprimer un type d'un Pal          |
| DELETE  | `/{id}`                       | Supprimer un Pal par ID             |
| GET     | `/pals/sorted/rarity`         | Récupérer des Pals triés par rareté |
| GET     | `/pals/sorted/price`          | Récupérer des Pals triés par prix   |

---

## Contribution

Les contributions sont les bienvenues !

1. Forkez le projet.
2. Créez une branche pour votre fonctionnalité/correctif :
   ```bash
   git checkout -b feature/nouvelle-fonctionnalite
   ```
3. Committez vos changements :
   ```bash
   git commit -m "Ajout d'une nouvelle fonctionnalité"
   ```
4. Poussez votre branche :
   ```bash
   git push origin feature/nouvelle-fonctionnalite
   ```
5. Ouvrez une Pull Request.
