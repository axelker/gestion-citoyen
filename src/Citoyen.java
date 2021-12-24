package src;
import java.util.*;
import java.lang.*;
import java.util.Scanner;


public class Citoyen {

    private Integer NumId=null;
    private String nom;
    private String prenom;
    private String naissance;
    private String sexe;
    private String EtatCivil;
    private Integer NumIdConjoint=null;

    public Citoyen()
    {

    }

    public Integer getNumId()
    {
        return this.NumId;
    }
    public String getNom()
    {
        return this.nom;
    }
    public String getPrenom()
    {
        return this.prenom;
    }
    public String getNaissance()
    {
        return this.naissance;
    }

    public String getSexe()
    {
        return this.sexe;
    }
    public String getEtatCivil()
    {
        return this.EtatCivil;
    }
    public Integer getNumIdConjoint()
    {
        return this.NumIdConjoint;
    }
    public void setNumid(Integer id)
    {
        this.NumId=id;
    }
    public void setNumidconjoint(Integer id)
    {
        this.NumIdConjoint=id;
    }

    public void setEtatCivil(String etat)
    {
        this.EtatCivil=etat;
    }
    public void setNom(String nom)
    {
        this.nom=nom;
    }
    public void setPrenom(String Prenom)
    {
        this.prenom=Prenom;
    }
    public void setDate(String date)
    {
        this.naissance=date;
    }
    public void setSexe(String s)
    {
        this.sexe=s;
    }
    

}