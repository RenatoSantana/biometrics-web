// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Estadocivil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Estadocivil_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Estadocivil.entityManager;
    
    public static final List<String> Estadocivil.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager Estadocivil.entityManager() {
        EntityManager em = new Estadocivil().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Estadocivil.countEstadocivils() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Estadocivil o", Long.class).getSingleResult();
    }
    
    public static List<Estadocivil> Estadocivil.findAllEstadocivils() {
        return entityManager().createQuery("SELECT o FROM Estadocivil o", Estadocivil.class).getResultList();
    }
    
    public static List<Estadocivil> Estadocivil.findAllEstadocivils(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Estadocivil o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Estadocivil.class).getResultList();
    }
    
    public static Estadocivil Estadocivil.findEstadocivil(Integer idEstadoCivil) {
        if (idEstadoCivil == null) return null;
        return entityManager().find(Estadocivil.class, idEstadoCivil);
    }
    
    public static List<Estadocivil> Estadocivil.findEstadocivilEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Estadocivil o", Estadocivil.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Estadocivil> Estadocivil.findEstadocivilEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Estadocivil o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Estadocivil.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Estadocivil.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Estadocivil.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Estadocivil attached = Estadocivil.findEstadocivil(this.idEstadoCivil);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Estadocivil.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Estadocivil.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Estadocivil Estadocivil.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Estadocivil merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
