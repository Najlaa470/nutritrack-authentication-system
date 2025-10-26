# nutritrack-authentication-system
Application web Java EE basée sur l’architecture MVC permettant l’authentification des utilisateurs via un formulaire HTML et une base PostgreSQL. Développée avec Tomcat et Eclipse, elle illustre la gestion complète du flux de connexion à travers les servlets.

**🥗 NutriTrack**
### Description générale

**NutriTrack** est une application web développée en **Java EE**, conçue pour assurer une **authentification sécurisée des utilisateurs** dans un environnement de gestion de données de nutrition.

L’application offre une interface de connexion intuitive où chaque utilisateur peut s’identifier à l’aide de ses informations de compte. Ces données sont ensuite vérifiées en temps réel grâce à une intégration avec une base de données **PostgreSQL**.

Reposant sur une **architecture MVC (Model–View–Controller)**, NutriTrack sépare clairement la présentation (interface web), la logique métier (traitement des données) et l’accès à la base de données. Cette organisation rend le code plus lisible, maintenable et extensible pour de futures évolutions (ajout d’un tableau de bord, gestion de profils, etc.).

L’objectif de NutriTrack est de proposer une base solide pour tout projet web Java EE nécessitant une **gestion d’utilisateurs**, une **connexion à une base de données**, et un **traitement structuré via des servlets**.

### Architecture logicielle

```
NutriTrack/
│
├── WebContent/
│   ├── index.html       → Formulaire de connexion
│   └── error.html       → Page d’erreur affichée en cas d’échec d’authentification
│
└── src/
    ├── ma.ac.esi.nutritrack.model/
    │   └── User.java               → Entité représentant un utilisateur
    │
    ├── ma.ac.esi.nutritrack.repository/
    │   └── UserRepository.java     → Accès aux données et requêtes SQL
    │
    ├── ma.ac.esi.nutritrack.service/
    │   └── UserService.java        → Logique métier (validation des identifiants)
    │
    ├── ma.ac.esi.nutritrack.controleur/
    │   └── LoginController.java    → Servlet principale recevant les requêtes HTTP POST
    │
    └── ma.ac.esi.nutritrack.util/
        └── DBUtil.java             → Gestion de la connexion PostgreSQL

```

---

### Fonctionnalités principales

- **Authentification utilisateur** à partir d’un formulaire HTML.
- **Vérification des identifiants** dans la base de données PostgreSQL.
- **Redirection automatique** selon le résultat de la validation.
- **Séparation claire des responsabilités** entre la vue, la logique métier et l’accès aux données.

---

### Base de données

- **Nom** : `nutriwise_db`
- **Table** : `Users`
- **Colonnes principales** : `id`, `login`, `password`
- **Driver** : `postgresql-42.7.5.jar` (à placer dans le dossier `lib` de Tomcat)

---

### Principe de fonctionnement

1. L’utilisateur saisit son login et son mot de passe sur la page d’accueil.
2. Ces informations sont envoyées à la **servlet `LoginController`** via une requête **HTTP POST**.
3. La servlet appelle la couche **service (`UserService`)**, qui interagit avec le **repository (`UserRepository`)** pour vérifier la présence de l’utilisateur dans la base.
4. En fonction du résultat :
    - Si la connexion est réussie → redirection vers la page principale.
    - Si la connexion échoue → redirection vers `error.html`.

---

### Technologies utilisées

- **Java EE (Jakarta EE)**
- **Apache Tomcat 11**
- **PostgreSQL**
- **Eclipse IDE**
- **HTML5 / CSS3**
- **JDK 17**

---

### Exécution du projet

1. Configurer le serveur **Apache Tomcat** dans Eclipse.
2. Ajouter le **driver PostgreSQL** dans le répertoire `lib` de Tomcat.
3. Importer le projet **NutriTrack** en tant que *Dynamic Web Project*.
4. Lancer le serveur et accéder à :
    
    ```
    http://localhost:8080/NutriTrack/
    
    ```
    

---

### Résumé technique

Ce projet illustre la mise en place d’une architecture **modulaire et évolutive** avec une gestion claire des couches :

- **Vue (HTML/CSS)** pour l’interface utilisateur.
- **Contrôleur (Servlet)** pour le traitement des requêtes HTTP.
- **Service** pour la logique métier.
- **Repository et Utilitaire** pour la connexion et les opérations sur la base de données.
