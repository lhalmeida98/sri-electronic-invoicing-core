package ec.sri.einvoice.domain.service;

import ec.sri.einvoice.domain.model.ClaveAcceso;
import ec.sri.einvoice.domain.model.InfoTributaria;
import ec.sri.einvoice.domain.model.TipoComprobante;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClaveAccesoGenerator {
  private static final DateTimeFormatter FECHA_FORMATO = DateTimeFormatter.ofPattern("ddMMyyyy");

  public ClaveAcceso generar(
      InfoTributaria infoTributaria,
      TipoComprobante tipoComprobante,
      String codigoNumerico,
      LocalDate fechaEmision
  ) {
    String fecha = fechaEmision.format(FECHA_FORMATO);
    String codigoDoc = tipoComprobante.codigo();
    String ruc = infoTributaria.ruc();
    String ambiente = infoTributaria.ambiente().codigo();
    String serie = padLeft(infoTributaria.estab(), 3) + padLeft(infoTributaria.ptoEmi(), 3);
    String secuencial = padLeft(infoTributaria.secuencial(), 9);
    String codigo = padLeft(codigoNumerico, 8);
    String tipoEmision = infoTributaria.tipoEmision().codigo();

    String base = fecha + codigoDoc + ruc + ambiente + serie + secuencial + codigo + tipoEmision;
    int digitoVerificador = modulo11(base);
    return ClaveAcceso.of(base + digitoVerificador);
  }

  private String padLeft(String value, int length) {
    if (value == null) {
      throw new IllegalArgumentException("Valor requerido para clave de acceso");
    }
    if (value.length() > length) {
      return value.substring(value.length() - length);
    }
    return String.format("%" + length + "s", value).replace(' ', '0');
  }

  private int modulo11(String value) {
    int suma = 0;
    int factor = 2;
    for (int i = value.length() - 1; i >= 0; i--) {
      int num = Character.getNumericValue(value.charAt(i));
      suma += num * factor;
      factor = (factor == 7) ? 2 : factor + 1;
    }
    int mod = 11 - (suma % 11);
    if (mod == 11) {
      return 0;
    }
    if (mod == 10) {
      return 1;
    }
    return mod;
  }
}
