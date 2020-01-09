/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author samuel
 */
public class Vehiculo {
    
    private String marca, modelo, matricula, tipoRevision, fechaUltimaRevision, fechaUltimoSeguro;
    private double precioSeguro;
    
    public Vehiculo(String marcaInicial, String modeloInicial, String matriculaInicial, String tipoRevisionInicial, String fechaUltimaRevisionInicial, String fechaUltimoSeguroInicial, double precioSeguroInicial){
        this.marca = marcaInicial;
        this.modelo = modeloInicial;
        this.matricula = matriculaInicial;
        this.tipoRevision = tipoRevisionInicial;
        this.fechaUltimaRevision = fechaUltimaRevisionInicial;
        this.fechaUltimoSeguro = fechaUltimoSeguroInicial;
        this.precioSeguro = precioSeguroInicial;
    }
    
    public Vehiculo(String matriculaInicial){
        this.matricula = matriculaInicial;
        
    }
    
    public Vehiculo(){
        
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public String getFechaUltimaRevision() {
        return fechaUltimaRevision;
    }

    public String getFechaUltimoSeguro() {
        return fechaUltimoSeguro;
    }

    public double getPrecioSeguro() {
        return precioSeguro;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public void setFechaUltimaRevision(String fechaUltimaRevision) {
        this.fechaUltimaRevision = fechaUltimaRevision;
    }

    public void setFechaUltimoSeguro(String fechaUltimoSeguro) {
        this.fechaUltimoSeguro = fechaUltimoSeguro;
    }

    public void setPrecioSeguro(double precioSeguro) {
        this.precioSeguro = precioSeguro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", tipoRevision=" + tipoRevision + ", fechaUltimaRevision=" + fechaUltimaRevision + ", fechaUltimoSeguro=" + fechaUltimoSeguro + ", precioSeguro=" + precioSeguro + '}';
    }
    
    
    
}
