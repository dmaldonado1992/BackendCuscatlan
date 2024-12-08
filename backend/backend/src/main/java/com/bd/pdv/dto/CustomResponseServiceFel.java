package com.bd.pdv.dto;

import com.fel.validaciones.documento.RespuestaServicioFel;

public class CustomResponseServiceFel extends RespuestaServicioFel {
    private double iva;
    private double idp;
    private double totalWithoutTaxes;

    public CustomResponseServiceFel() {
    }

    public CustomResponseServiceFel(RespuestaServicioFel resp){
        setResultado(resp.getResultado());
        setFecha(resp.getFecha());
        setOrigen(resp.getOrigen());
        setDescripcion(resp.getDescripcion());
        setDescripcion_errores(resp.getDescripcion_errores());
        setAlertas_infile(resp.isAlertas_infile());
        setDescripcion_alertas_infile(resp.getDescripcion_alertas_infile());
        setAlertas_sat(resp.isAlertas_sat());
        setDescripcion_alertas_sat(resp.getDescripcion_alertas_sat());
        setCantidad_errores(resp.getCantidad_errores());
        setControl_emision(resp.getControl_emision());
        setInformacion_adicional(resp.getInformacion_adicional());
        setUuid(resp.getUuid());
        setSerie(resp.getSerie());
        setNumero(resp.getNumero());
        setXml_certificado(resp.getXml_certificado());
        setInfo(resp.getInfo());
        setJson_respuesta(resp.getJson_respuesta());
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getIdp() {
        return idp;
    }

    public void setIdp(double idp) {
        this.idp = idp;
    }

    public double getTotalWithoutTaxes() {
        return totalWithoutTaxes;
    }

    public void setTotalWithoutTaxes(double totalWithoutTaxes) {
        this.totalWithoutTaxes = totalWithoutTaxes;
    }


}
