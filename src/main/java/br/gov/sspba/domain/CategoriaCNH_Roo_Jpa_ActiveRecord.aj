// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.CategoriaCNH;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CategoriaCNH_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager CategoriaCNH.entityManager;
    
    public static final List<String> CategoriaCNH.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager CategoriaCNH.entityManager() {
        EntityManager em = new CategoriaCNH().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    

    public static List<CategoriaCNH> CategoriaCNH.findAllCategoriaCNHs() {
        return entityManager().createQuery("SELECT o FROM CategoriaCNH o", CategoriaCNH.class).getResultList();
    }
    
    public static List<CategoriaCNH> CategoriaCNH.findAllCategoriaCNHs(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CategoriaCNH o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CategoriaCNH.class).getResultList();
    }
    
    
    
    public static List<CategoriaCNH> CategoriaCNH.findCategoriaCNHEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM CategoriaCNH o", CategoriaCNH.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<CategoriaCNH> CategoriaCNH.findCategoriaCNHEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM CategoriaCNH o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, CategoriaCNH.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void CategoriaCNH.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CategoriaCNH.remove() {
        
    }
    
    @Transactional
    public void CategoriaCNH.flush() {
        if (this.entityManager == null)this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CategoriaCNH.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public CategoriaCNH CategoriaCNH.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CategoriaCNH merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
