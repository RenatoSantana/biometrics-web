// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.Graudeinstrucao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Graudeinstrucao_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Graudeinstrucao.entityManager;
    
    public static final List<String> Graudeinstrucao.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager Graudeinstrucao.entityManager() {
        EntityManager em = new Graudeinstrucao().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Graudeinstrucao.countGraudeinstrucaos() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Graudeinstrucao o", Long.class).getSingleResult();
    }
    
    public static List<Graudeinstrucao> Graudeinstrucao.findAllGraudeinstrucaos() {
        return entityManager().createQuery("SELECT o FROM Graudeinstrucao o", Graudeinstrucao.class).getResultList();
    }
    
    public static List<Graudeinstrucao> Graudeinstrucao.findAllGraudeinstrucaos(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Graudeinstrucao o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Graudeinstrucao.class).getResultList();
    }
    
    public static Graudeinstrucao Graudeinstrucao.findGraudeinstrucao(Integer idGrauDeInstrucao) {
        if (idGrauDeInstrucao == null) return null;
        return entityManager().find(Graudeinstrucao.class, idGrauDeInstrucao);
    }
    
    public static List<Graudeinstrucao> Graudeinstrucao.findGraudeinstrucaoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Graudeinstrucao o", Graudeinstrucao.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Graudeinstrucao> Graudeinstrucao.findGraudeinstrucaoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Graudeinstrucao o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Graudeinstrucao.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Graudeinstrucao.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Graudeinstrucao.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Graudeinstrucao attached = Graudeinstrucao.findGraudeinstrucao(this.idGrauDeInstrucao);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Graudeinstrucao.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Graudeinstrucao.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Graudeinstrucao Graudeinstrucao.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Graudeinstrucao merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}