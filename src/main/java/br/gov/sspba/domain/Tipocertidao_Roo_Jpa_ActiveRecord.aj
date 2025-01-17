// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Tipocertidao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Tipocertidao_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Tipocertidao.entityManager;
    
    public static final List<String> Tipocertidao.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager Tipocertidao.entityManager() {
        EntityManager em = new Tipocertidao().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Tipocertidao.countTipocertidaos() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Tipocertidao o", Long.class).getSingleResult();
    }
    
    public static List<Tipocertidao> Tipocertidao.findAllTipocertidaos() {
        return entityManager().createQuery("SELECT o FROM Tipocertidao o", Tipocertidao.class).getResultList();
    }
    
    public static List<Tipocertidao> Tipocertidao.findAllTipocertidaos(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Tipocertidao o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Tipocertidao.class).getResultList();
    }
    
    public static Tipocertidao Tipocertidao.findTipocertidao(Integer idTipoCertidao) {
        if (idTipoCertidao == null) return null;
        return entityManager().find(Tipocertidao.class, idTipoCertidao);
    }
    
    public static List<Tipocertidao> Tipocertidao.findTipocertidaoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Tipocertidao o", Tipocertidao.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Tipocertidao> Tipocertidao.findTipocertidaoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Tipocertidao o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Tipocertidao.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Tipocertidao.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Tipocertidao.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Tipocertidao attached = Tipocertidao.findTipocertidao(this.idTipoCertidao);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Tipocertidao.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Tipocertidao.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Tipocertidao Tipocertidao.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Tipocertidao merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
