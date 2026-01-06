package ec.sri.einvoice.domain.model;

import java.util.Objects;

public final class InfoTributaria {
  private final Ambiente ambiente;
  private final TipoEmision tipoEmision;
  private final String razonSocial;
  private final String nombreComercial;
  private final String ruc;
  private final String dirMatriz;
  private final String estab;
  private final String ptoEmi;
  private final String secuencial;
  private final ClaveAcceso claveAcceso;

  public InfoTributaria(
      Ambiente ambiente,
      TipoEmision tipoEmision,
      String razonSocial,
      String nombreComercial,
      String ruc,
      String dirMatriz,
      String estab,
      String ptoEmi,
      String secuencial,
      ClaveAcceso claveAcceso
  ) {
    this.ambiente = Objects.requireNonNull(ambiente, "ambiente");
    this.tipoEmision = Objects.requireNonNull(tipoEmision, "tipoEmision");
    this.razonSocial = Objects.requireNonNull(razonSocial, "razonSocial");
    this.nombreComercial = Objects.requireNonNull(nombreComercial, "nombreComercial");
    this.ruc = Objects.requireNonNull(ruc, "ruc");
    this.dirMatriz = Objects.requireNonNull(dirMatriz, "dirMatriz");
    this.estab = Objects.requireNonNull(estab, "estab");
    this.ptoEmi = Objects.requireNonNull(ptoEmi, "ptoEmi");
    this.secuencial = Objects.requireNonNull(secuencial, "secuencial");
    this.claveAcceso = claveAcceso;
  }

  public Ambiente ambiente() {
    return ambiente;
  }

  public TipoEmision tipoEmision() {
    return tipoEmision;
  }

  public String razonSocial() {
    return razonSocial;
  }

  public String nombreComercial() {
    return nombreComercial;
  }

  public String ruc() {
    return ruc;
  }

  public String dirMatriz() {
    return dirMatriz;
  }

  public String estab() {
    return estab;
  }

  public String ptoEmi() {
    return ptoEmi;
  }

  public String secuencial() {
    return secuencial;
  }

  public ClaveAcceso claveAcceso() {
    return claveAcceso;
  }

  public InfoTributaria withClaveAcceso(ClaveAcceso nuevaClave) {
    return new InfoTributaria(
        ambiente,
        tipoEmision,
        razonSocial,
        nombreComercial,
        ruc,
        dirMatriz,
        estab,
        ptoEmi,
        secuencial,
        nuevaClave
    );
  }
}
