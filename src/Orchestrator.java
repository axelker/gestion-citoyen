package src;
import java.util.*;
import java.io.*;


public class Orchestrator {


    public Orchestrator()
    {

    }

    public void execution()
    {
        Scanner scanner=new Scanner(System.in);
        Menu m = new Menu();
        int num=0;
        Population p = new Population();
        

                

        while(num!=7)
        {
            
            m.AffichageMenu();
            num = scanner.nextInt();
            if(num==1)
            {

                
                System.out.println("Saisir le numéro d'identification des personnes à marier \nPersonne numéro 1 :");
                Integer pers1=scanner.nextInt();
                System.out.println("Personne numéro 2 :");
                Integer pers2=scanner.nextInt();
                p.Mariage(pers1,pers2);
            }
            if(num==2)
            {
                p.Divorce();
            }
            if(num==3)
            {
                p.nouveauNee();
            }
            if(num==4)
            {
                p.retourEtat();
            }
            if(num==5)
            {

                System.out.println(p.AffichagelistePers());
            }
            if(num==6)
            {
                Citoyen ci = new Citoyen();
                p.saisirUtilisateur(ci);
            }
        
        }
        File file = new File("sauvegarde.txt");
        
        if(!file.exists())
        {
            try{
                file.createNewFile();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else {
            try{
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(p.AffichagelistePers());
            bw.close();
            writer.close();

            } catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}