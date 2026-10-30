# Modèle de données — Pointage (v1)

Pas de table utilisateur : une seule personne utilise l'appli.

| Classe | Champs | Rôle |
|---|---|---|
| Transaction | id, nom, type (REVENU/DEPENSE), categorie, montant (decimal), date | Budget. Le solde = revenus − dépenses, par date du mouvement |
| Activite | id, titre, type (COURS/SHIFT/REVISION), dateDebut, dateFin | Planning. Sert au total d'heures et à l'alerte de surcharge (50 h) |
| Matiere | id, nom, coefficient | Une matière a plusieurs notes et devoirs |
| Note | id, valeur, coefficient, date, matiere | Une note appartient à une matière |
| Devoir | id, intitule, dateRendu, fait, matiere | Un devoir appartient à une matière |

Relations : Matiere 1 — 0..* Note, Matiere 1 — 0..* Devoir (clé étrangère matiere_id dans Note et Devoir).
