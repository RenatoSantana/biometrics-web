// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Olho;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Olho_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Olho.entityManager;
    
    public static final List<String> Olho.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager Olho.entityManager() {
        EntityManager em = new Olho().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Olho.countOlhoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Olho o", Long.class).getSingleResult();
    }
    
    public static List<Olho> Olho.findAllOlhoes() {
        return entityManager().createQuery("SELECT o FROM Olho o", Olho.class).getResultList();
    }
    
    public static List<Olho> Olho.findAllOlhoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Olho o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Olho.class).getResultList();
    }
    
    public static Olho Olho.findOlho(Integer idOlho) {
        if (idOlho == null) return null;
        return entityManager().find(Olho.class, idOlho);
    }
    
    public static List<Olho> Olho.findOlhoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Olho o", Olho.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Olho> Olho.findOlhoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Olho o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Olho.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Olho.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Olho.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Olho attached = Olho.findOlho(this.idOlho);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Olho.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Olho.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Olho Olho.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Olho merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
