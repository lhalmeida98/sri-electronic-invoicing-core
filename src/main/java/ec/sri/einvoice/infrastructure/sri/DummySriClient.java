package ec.sri.einvoice.infrastructure.sri;

import ec.sri.einvoice.application.port.out.SriClient;
import ec.sri.einvoice.application.port.out.SriResponse;
import ec.sri.einvoice.domain.model.ClaveAcceso;
import ec.sri.einvoice.domain.model.Comprobante;
import org.springframework.stereotype.Component;

@Component
public class DummySriClient implements SriClient {
  @Override
  public SriResponse enviar(Comprobante comprobante, String xmlFirmado) {
    ClaveAcceso claveAcceso = comprobante.claveAcceso();
    if (claveAcceso == null) {
      return SriResponse.error("Clave de acceso faltante");
    }
    char ultimo = claveAcceso.value().charAt(claveAcceso.value().length() - 1);
    int numero = Character.getNumericValue(ultimo);
    if (numero % 2 == 0) {
      return SriResponse.autorizado("AUT-" + claveAcceso.value());
    }
    return SriResponse.rechazado("Simulacion SRI: rechazo controlado");
  }
}
