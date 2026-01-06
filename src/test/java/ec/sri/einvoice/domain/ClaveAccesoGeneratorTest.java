package ec.sri.einvoice.domain;

import static org.assertj.core.api.Assertions.assertThat;

import ec.sri.einvoice.domain.model.Ambiente;
import ec.sri.einvoice.domain.model.InfoTributaria;
import ec.sri.einvoice.domain.model.TipoComprobante;
import ec.sri.einvoice.domain.model.TipoEmision;
import ec.sri.einvoice.domain.service.ClaveAccesoGenerator;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ClaveAccesoGeneratorTest {
  @Test
  void generaClaveAccesoConFormatoCorrecto() {
    InfoTributaria infoTributaria = new InfoTributaria(
        Ambiente.PRUEBAS,
        TipoEmision.NORMAL,
        "Empresa Demo",
        "Empresa Demo",
        "1790012345001",
        "Quito",
        "001",
        "002",
        "000000123",
        null
    );
    ClaveAccesoGenerator generator = new ClaveAccesoGenerator();

    String clave = generator.generar(infoTributaria, TipoComprobante.FACTURA, "12345678", LocalDate.of(2024, 1, 15)).value();

    assertThat(clave).hasSize(49);
    assertThat(clave).startsWith("15012024" + "01" + "1790012345001" + "1" + "001002" + "000000123" + "12345678" + "1");
  }
}
