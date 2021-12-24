package src;
import java.util.*;

public class Menu {
    private final static String[] TabAffichage={"1. Mariage","2. Divorce","3. Naissance","4. Etat d'une personne","5. Affichage de la liste des personnes","6. Saisie des personnes","7. Quitter le programme"};
    public Menu()
    {

    }

    public void AffichageMenu()
    {
        
       for(int i=0;i<7;i++)
       {
           System.out.println(TabAffichage[i]);
       }
        
    }
}