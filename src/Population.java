package src;
import java.util.*;
import java.lang.*;
import java.util.Scanner;


public class Population {

private ArrayList<Citoyen>ListePersonneSaisie = new ArrayList<Citoyen>();
private final static String[] TabetatCivil={"Mariée","Divorcé","Célibataire","Veuve"};
Scanner scanner=new Scanner(System.in);

    public Population()
    {

    }

    // Retourne la liste population
   public ArrayList<Citoyen> ListePersonnereturn()
   {
       return this.ListePersonneSaisie;
   } 

    // Retourne le citoyen par rapport a la liste des citoyen 
    public Citoyen getCitoyen(Integer id)
    {
        Citoyen ci = new Citoyen();
        for(Citoyen c : this.ListePersonneSaisie)
        {
            if(c.getNumId().equals(id))
            {
                
                ci=c;
                return c;
            }
        }
        return ci;
    }
    //Retourne tableau sous forme de chaine de caractère 
   public String tab()
   {
       String res="";
       for(int i=0;i<4;i++)
       {
            res += this.TabetatCivil[i] + " - ";
       }
       return res;
   }



     //////////////Methode TEST ///////////////

    //Test si id est == à une personne de la liste 
    public boolean ErrorNumId(Integer id)
    {
        for(Citoyen i : this.ListePersonneSaisie)
        {
            if(i.getNumId().equals(id))
            {
                return true;
            }
        }
        return false;
    }



    // Test deja marié
    public boolean DejaMarie(Citoyen c)
    {
        if(c.getNumIdConjoint()!=null)
        {
            return true;
        }
        return false;
    }

    // Renvoi un message si la personne n'existe pas 
    public void AfficheSiExist(Integer id)
    {
        if(!ErrorNumId(id))
        {
            System.out.println("Erreur numéro d'identifiant inconnu ! \n");
            
        }
    }
    public void AfficheSiMarie(Integer id)
    {
        if(DejaMarie(getCitoyen(id)))
        {
            System.out.println("Personne deja marié ! ");
        }
    }


    public boolean TestetatCivile(String civile)
    {
        for(int i =0;i<4;i++)
        {
            if(civile==TabetatCivil[i])
            {
                return true;
            }
        }
        return false;
    }
    public boolean TestString(String mot)
    {
        for(int i=0;i<mot.length();i++)
        {
            if(Character.isDigit(mot.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
//////////////////////////////////////////////////////////////



    // Fonction mariage 
    public void Mariage(Integer pers1,Integer pers2)
    {
        //Affiche personne si pers1 existe et si marié
        AfficheSiExist(pers1);
        AfficheSiMarie(pers1);
        
        //Affiche personne si pers2 existe et si marié
        AfficheSiExist(pers2);
        AfficheSiMarie(pers2);
          

        //Si les deux existe Et non marié effectuer le mariage 
        if(ErrorNumId(pers1) && ErrorNumId(pers2) && !DejaMarie(getCitoyen(pers1)) && !DejaMarie(getCitoyen(pers2)) && !pers1.equals(pers2))
        {
        
        System.out.println("Félicitation ! " + getCitoyen(pers1).getNom() + " et " + getCitoyen(pers2).getNom() + " vous voila désormais marié ! ");
        //AJouter les valeurs des conjoints 

        getCitoyen(pers1).setNumidconjoint(pers2);
        getCitoyen(pers2).setNumidconjoint(pers1); 
        getCitoyen(pers1).setEtatCivil(TabetatCivil[0]);
        getCitoyen(pers2).setEtatCivil(TabetatCivil[0]);   
        }

    }

    // FOnction divorce 
    public void Divorce()
    {
        System.out.println("Saisir le numéro d'identifiant de la personne devant divorcer : ");
        Integer pers1=scanner.nextInt();
        AfficheSiExist(pers1);

        if(ErrorNumId(pers1) && !DejaMarie(getCitoyen(pers1)))
        {
            System.out.println("La personne saisie n'est pas marié ");
        }
        else if(ErrorNumId(pers1)){
            //Divorce marqué divorcé et enlever le numéro de conjoint 
            Integer numconjoint= getCitoyen(pers1).getNumIdConjoint();
            getCitoyen(pers1).setEtatCivil(TabetatCivil[1]);
            getCitoyen(pers1).setNumidconjoint(null);
            getCitoyen(numconjoint).setEtatCivil(TabetatCivil[1]);
            getCitoyen(numconjoint).setNumidconjoint(null);

        }
        

    }

     public String AffichagelistePers()
    {
        String res="";
        for(Citoyen c : this.ListePersonneSaisie)
        {
            res+="Numero d'identifiant : " + c.getNumId();
            res+="\n";
            res+="Nom : " + c.getNom();
            res+="\n";
            res+="Prenom : " + c.getPrenom();
            res+="\n";
            res+="Sexe : " + c.getSexe();
            res+="\n";
            res+="Date de naissance : " + c.getNaissance();
            res+="\n";
            res+="Etat civil : " + c.getEtatCivil();
            if(c.getNumIdConjoint()!=null)
            {
                res+="\n";
               res+="Numero de conjoint : " + c.getNumIdConjoint();
            }
            res+="\n";
            res+="\n";
        }
        
        return res;
    }

    public void nouveauNee()
    {
        System.out.println("Saisir le numéro d'identification des parents :  ");
        System.out.println(" Parents 1 : ");
        Integer pers1=scanner.nextInt();
        System.out.println(" Parents 2 : ");
        Integer pers2=scanner.nextInt();
        if(ErrorNumId(pers1) && ErrorNumId(pers2) && !pers1.equals(pers2))
        {
            Citoyen c = new Citoyen();
            System.out.println("Saisir les informations du nouveau née ");
            Integer num= null;
            AjouterPersonne(c,num);
            //Car naissance 
            c.setEtatCivil("Célibataire");
            ListePersonneSaisie.add(c);
            
        }
        //Sinon affiche qu'il nexiste pas    
        AfficheSiExist(pers1);
        AfficheSiExist(pers2);


    }



    public void retourEtat()
    {
        System.out.println("Saisir le numéro d'identification de la personne dont vous désirez connaitre l'état : ");
        Integer pers1=scanner.nextInt();
        if(ErrorNumId(pers1))
        {
            System.out.println("Nom : "+getCitoyen(pers1).getNom());
            System.out.println("Prenom : "+getCitoyen(pers1).getPrenom());
            System.out.println("Sexe : "+getCitoyen(pers1).getSexe());
            System.out.println("Date de naissance : "+getCitoyen(pers1).getNaissance());

            Integer pers2 = getCitoyen(pers1).getNumIdConjoint();
            if(pers2!=null)
            {

            System.out.println("Nom du conjoint : "+ getCitoyen(pers2).getNom());
            System.out.println("Prenom du conjoint : "+getCitoyen(pers2).getPrenom());
            }
            

        }
         //Affiche existe pas 
         AfficheSiExist(pers1);
 
    }


     public Integer SaisirNuméroIdentifiant(Citoyen c)
    {
        System.out.println("Saisir le numéro d'identifiant : ");
        Integer num = scanner.nextInt();
        while(ErrorNumId(num))
        {
            scanner.nextLine();
            System.out.println("Erreur ! Numéro déja attribué. Saisir le numéro d'identifiant : ");
            num = scanner.nextInt();
        }
        c.setNumid(num);
        return num;
    }
  

    
    public void AjouterPersonne(Citoyen c,Integer num)
    {
        
        num = SaisirNuméroIdentifiant(c);     
        System.out.println("Saisir le nom de la personne : ");
        String nom = scanner.next();
        while(TestString(nom))
        {
            System.out.println("Erreur ! Un nom ne contient pas de chiffre : Saisir le nom de la personne : ");
            nom = scanner.next();
        }
        c.setNom(nom);
        
        System.out.println("Saisir le prenom de la personne : ");
        String p = scanner.next();
        while(TestString(p))
        {
            System.out.println("Erreur ! Un prenom ne contient pas de chiffre : Saisir le prenom de la personne : ");
            p = scanner.next();

        }
        c.setPrenom(p);

        System.out.println("Saisir la date de naissance de la personne sous la forme XX/XX/XXXX : ");
        String date = scanner.next();
        while(date.length()!="XX/XX/XXXX".length())
        {
            System.out.println("Erreur veuillez respectez le format de la date s'il vous plait ! Saisir la date de naissance de la personne sous la forme XX/XX/XXXX : ");
            date = scanner.next();
        }
        c.setDate(date);
        
        System.out.println("Saisir le sexe de la personne correctement H ou F : ");
        String s=scanner.next();
    
        while(!s.equals("H") && !s.equals("F") && !s.equals("h") && !s.equals("f"))
        {
            System.out.println("Erreur, respectez la saisie ! Saisir le sexe de la personne H ou F : ");
            s=scanner.next();

        }
        c.setSexe(s);
    }

    //Saisie utilisateur 
    public void saisirUtilisateur(Citoyen c)
    {
        Integer num = null;
        AjouterPersonne(c,num);

        saisirEtatcivil(num,c);

        //stocker la nouvelle personne si elle n'y est pas 
        if(!this.ListePersonneSaisie.contains(c) && !ErrorNumId(num))
        {
            this.ListePersonneSaisie.add(c);
        }
    }

    //Selon les differents etat possible 
    public void saisirEtatcivil(Integer num,Citoyen c)
    {
        String civile="";
        while(!TestetatCivile(c.getEtatCivil()))
        {
            if(!TestetatCivile(c.getEtatCivil()))
            {
                System.out.println("Saisir correctement l'état civile de la personne : " + tab());              
                civile=scanner.next();
            }

            //Mariage
            if(civile.equals(TabetatCivil[0]))
            {
                ListePersonneSaisie.add(c);
                Integer numConjoint=null;
                Citoyen c1 = new Citoyen(); 
                System.out.println("Saisir le numéro d'identifiant du conjoint : ");
                numConjoint = scanner.nextInt();
                //Si num conjoint nexiste pas 
                if(!ErrorNumId(numConjoint))
                {
                    
                    System.out.println(" Numéro ID non trouvé Veuillez renseigner les informations qui vont être demandé ; Création d'une nouvelle personne ; Demande de saisie du numéro ID du conjoint : ");                
                    AjouterPersonne(c1,numConjoint);
                    numConjoint=c1.getNumId();
                    //AJout de lpersonne en cours de création pour pouvoir se marier
                    ListePersonneSaisie.add(c1);
                    Mariage(c.getNumId(),c1.getNumId()); 
                    break;
                    

                }
                // Si le numéro du conjoint existe et ne sont pas egaux 
                if(ErrorNumId(numConjoint) && !numConjoint.equals(c.getNumId()))
                {
                    c1 = getCitoyen(numConjoint);
                    Mariage(c.getNumId(),c1.getNumId()); 
                }
                // SI le numero saisie est le même que le celui renseigner demander la saisie une nouvelle fois 
                if(numConjoint.equals(c.getNumId()))
                {
                    System.out.println("Erreur num ID deja existant ! Demande de saisie du numéro ID du conjoint : ");
                    AjouterPersonne(c1,numConjoint);
                    ListePersonneSaisie.add(c1);
                    numConjoint=c1.getNumId();
                    Mariage(c.getNumId(),c1.getNumId()); 
                }
                       
            }
            for(int i=1;i<4;i++)
            {

                if(civile.equals(TabetatCivil[i]))
                {
                    c.setEtatCivil(TabetatCivil[i]);
                }
            
            }
        }

    }


}