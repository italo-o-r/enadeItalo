/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COREI7
 */
@Entity
@Table(name = "TipoUsuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByIdTipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByNomeTipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.nomeTipoUsuario = :nomeTipoUsuario")})
public class TipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoUsuario")
    private Integer idTipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "nomeTipoUsuario")
    private String nomeTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuarioidTipoUsuario")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TipoUsuario(Integer idTipoUsuario, String nomeTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.nomeTipoUsuario = nomeTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNomeTipoUsuario() {
        return nomeTipoUsuario;
    }

    public void setNomeTipoUsuario(String nomeTipoUsuario) {
        this.nomeTipoUsuario = nomeTipoUsuario;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.enade.model.TipoUsuario[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
