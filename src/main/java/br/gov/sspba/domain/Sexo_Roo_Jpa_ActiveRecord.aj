// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Sexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Sexo_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Sexo.entityManager;
    
    public static final List<String> Sexo.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager Sexo.entityManager() {
        EntityManager em = new Sexo().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Sexo.countSexoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Sexo o", Long.class).getSingleResult();
    }
    
    public static List<Sexo> Sexo.findAllSexoes() {
        return entityManager().createQuery("SELECT o FROM Sexo o", Sexo.class).getResultList();
    }
    
    public static List<Sexo> Sexo.findAllSexoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Sexo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Sexo.class).getResultList();
    }
    
    public static Sexo Sexo.findSexo(Integer idSexo) {
        if (idSexo == null) return null;
        return entityManager().find(Sexo.class, idSexo);
    }
    
    public static List<Sexo> Sexo.findSexoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Sexo o", Sexo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Sexo> Sexo.findSexoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Sexo o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Sexo.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Sexo.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Sexo.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Sexo attached = Sexo.findSexo(this.idSexo);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Sexo.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Sexo.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Sexo Sexo.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Sexo merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}