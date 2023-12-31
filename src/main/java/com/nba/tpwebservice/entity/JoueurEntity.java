package com.nba.tpwebservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "joueur", schema = "public", catalog = "port")
public class JoueurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_joueur")
    private String idJoueur;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "date_naissance")
    private Timestamp dateNaissance;
    @Transient
    public HashMap<String, Float> hashMapState;

    @Transient
    public int nombreMatch;

    public void setNombreMatch(int nombreMatch) {
        this.nombreMatch = nombreMatch;
    }

    public int getNombreMatch() {
        return nombreMatch;
    }

    public void setHashMapState(HashMap<String, Float> hashMapState) {
        this.hashMapState = hashMapState;
    }

    public HashMap<String, Float> getHashMapState() {
        return hashMapState;
    }

    public void getStats(List<ActionEntity> actions){
        HashMap<String, Float> hashMapAction = new HashMap<>();
        for (ActionEntity action: actions) {
            hashMapAction.put(action.getNom(), (float) getActionState());
        }
        this.hashMapState = hashMapAction;
    }

    public int getActionState(){
        return 0;
    }

    public String getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(String idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Timestamp getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Timestamp dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurEntity that = (JoueurEntity) o;
        return Objects.equals(idJoueur, that.idJoueur) && Objects.equals(nom, that.nom) && Objects.equals(prenom, that.prenom) && Objects.equals(dateNaissance, that.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJoueur, nom, prenom, dateNaissance);
    }
}
