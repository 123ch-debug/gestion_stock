# Application de Gestion de Stock - Java POO

Projet réalisé dans le cadre du module de Programmation Orientée Objet.

## 🎯 Objectif
Créer une application console en Java permettant de gérer :
- Les clients
- Les fournisseurs
- Les articles
- Les commandes
- La facturation

## 🛠️ Technologies utilisées
- Java
- Collections (HashMap, HashSet)
- Sérialisation
- Interface console
- NetBeans

## 📸 Aperçu
Menu principal :
![Capture du menu](images/poo-menu.png)
## 🧪 Tester l'application

### 🔧 Prérequis
- Java JDK installé (version 8 ou supérieure)
- (Optionnel) IDE comme **NetBeans** ou **IntelliJ**

### ▶️ Lancer avec NetBeans
1. Ouvrir le projet dans NetBeans (`Gestion_Stock1`)
2. Exécuter la classe `Gestion_Stock1.java` (clic droit → Exécuter)

L'application s'ouvre dans le terminal et affiche un menu :
Gestion des articles

Gestion des clients

Gestion des fournisseurs

### 💻 Lancer depuis un terminal (ligne de commande)

1. Ouvrir un terminal dans le dossier du projet
2. Compiler tous les fichiers :
```bash
javac -d bin Gestion_Stock1/src/gestion_stock1/*.java
java -cp bin gestion_stock1.Gestion_Stock1
