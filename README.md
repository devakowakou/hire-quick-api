

## Schema for all environments

## DEV
                ┌───────────────────────┐
                │       ENVIRONNEMENT    │
                ├─────────┬─────────────┤
                │   DEV   │  PostgreSQL  │
                ├─────────┼─────────────┤
                │ Hibernate: ddl-auto=update
                │    - crée/modifie les tables automatiquement
                │ Flyway: activé
                │    - teste l'application des scripts SQL versionnés
                │ Avantage: dev rapide, migration prête pour prod
                └───────────────────────┘

## PROD

                ┌───────────────────────┐
                │       PROD             │
                ├─────────┬─────────────┤
                │ PostgreSQL (Neon)     │
                ├─────────┼─────────────┤
                │ Hibernate: ddl-auto=validate
                │    - ne fait aucune modification automatique
                │    - vérifie que le schéma correspond aux entités
                │ Flyway: activé
                │    - applique tous les scripts SQL versionnés
                │ Avantage: migration sécurisée, pas de risque de casse
                └───────────────────────┘


## TEST
                ┌───────────────────────┐
                │       TEST             │
                ├─────────┬─────────────┤
                │ H2 en mémoire          │
                ├─────────┼─────────────┤
                │ Hibernate: ddl-auto=create-drop
                │    - tables créées au démarrage, supprimées à la fin
                │ Flyway: désactivé (optionnel)
                │ Avantage: tests rapides et indépendants de PostgreSQL
                └───────────────────────┘
