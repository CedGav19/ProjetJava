# ProjetJava

Projet de fin d'année pour le cours de Java

L'idée est de faire une app de coaching sportif.
Cette application va suivre a la fois vos evolution sportive et votre alimentation

SPORTIFY

Classe :

        -aliments (nom , calories , score ,nbproteine )
    	-recette( vecaliment[], sumcalorie , sumprot , moycote )
    	-exercices(id, muscle , type(polyarticulaire ou pas   (booleen)   )
    	-utilisateur( nom , prenom , poids , taille , imc (calculé)  , (allergies[]), alimentfav[]  , objectifpoids , 	(objectifstype )  )
    	-phrasesmotivante( texte , numero ) // pas sur que ca soit une classe , une liste de structure pourrait
    	-conseils( type , texte )
        -Mesexercice(idexercice , poidsmis , nbrep ,duree moyenne   )

    	-singleton app

pages :

- login : - Page de garde : - checkbox quotidenne + option ajout (envoyer vers explorer)
- objectifs - statistique - phrase motivante - recap aliment journaliere - challenge
- profil : - evolution - objectifs(tous)
  -modification - statistique - - explorer : - tous les exercices - ajout ex - creer sceance - exercice prefere - filtrer muscle
  -creer sceance

- alimentation : - liste aliment ingere - ajout aliment - creer recete - recap quotidien - aliment preferee - score



fichier , property =  poids kg , pounds 
        binaire , singleton comme les serializer en c# 
        exercice/aliment : csv ou .txt 


choses a faire : 

Logique , si la date du jour est differente de la date de derniere sauvegarde , on affiche les aliments mange a vide 

MENU :  tout 

Dans popSeance :  -       implementer les exercices dans le scrollpane   
                  -  implementer le formulaire + boutons 
 Alimentation  :  implementer aliment        CEDRIC ( 11-05-23)
                      -   implementer plats et plats mange 
                  - bindinG des checkbox 
                  - bing des boytons ( aliments , plats , plats mange ) 
                  
  Exercices  : -implement liste exercices ,µ
                -implementer liste seance , afficher les exx des seance en dessous de la                                checkbox seance 
               -  implemnter les boutons ( ex , seancces ) 
               
   Home :   - binding  des listes ( exercies de la seance + aliments + objectif + objectif realise ) 
             - bouton choisir seance +  
             - bouton fait objectifs , coche et passe dans l'autre  ( boucle pour verif les isselected ) 
             
             - pourcentage prot/kcal mange 
             
   Supprimer Main : 
   
   
   PopAjoutAliment :  - implemeent le formulaire 
                        - bouton ok , on save l'aliment quand on appuye sur ok 
                        - supprimer type de l'interface graphique 
                        
   PopAjoutPlat :    - implement la list des aliments ( checkbox) 
                        -   implementer le formulaire 
                        - on boucle en checkant sur tous les aliments si ils sont check 
                        (  ou alors quand quand on check un element on l'ajoute a une liste de nouvel recette)  
                        - bouton ok , ajout dans les recette du singleton 
   
   AjoutPlat mange  :  comnobox qui liste tous les recettes  + boutons ok
   
   
   popExercice  :  - implementer formulaire 
                           pour type de muscle faire un combobox ( dos , pec , biceps , tricpes , jambe ) 
                         - pour le temps ,si pas coche , constructeur sans le temps , si non on prend le temps 
                         - si force , on construit un exerciceForce , si non ExerciceCardio
                        - bouton ok ajoute dans la liste des exercies et sauvegarde 
   PopObjectifs : - impleter formulaire 
   
   Profile :  - supprimer mot de passe 
               - impletent "votreprofile" 
               - modifier = sauvegarder les nouvelles donnees 
               -supprimer scrool prot 
               -  implementer  les objectifs comme sur "home" + 
               - supprimer les modifs
             
   
             
                
                     
                        
