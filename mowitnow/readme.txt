Application de gestion de tondeuse automatique pour la société MowItNow

Cette application maven utilise le JDK8. Elle requière les dépendances log4J 1.2.17 et Junit 3.8.1.

Elle se décompose principalement des couches suivantes :
	- entity : le modèle de données.
	- service : toute la logique applicative + un utilitaire.
	- app : "le starter" avec pour fichier "configuration de terrain". Si non fournit alors la configuration de référence est chargée (DefaultConfig)
	- test : la couche de test de couverture avec un "suite test" et un test validant la configuration de référence

Eric D.
