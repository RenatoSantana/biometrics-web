// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package br.gov.sspba.domain;

import br.gov.sspba.domain.UserPermission;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

privileged aspect UserPermission_Roo_ToString {
    
    public String UserPermission.toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).setExcludeFieldNames("userRoles").toString();
    }
    
}
