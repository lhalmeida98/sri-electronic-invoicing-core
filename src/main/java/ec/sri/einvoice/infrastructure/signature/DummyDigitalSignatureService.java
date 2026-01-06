package ec.sri.einvoice.infrastructure.signature;

import ec.sri.einvoice.application.port.out.DigitalSignatureService;
import org.springframework.stereotype.Component;

@Component
public class DummyDigitalSignatureService implements DigitalSignatureService {
  @Override
  public String firmar(String xml) {
    return "<Signed>" + xml + "</Signed>";
  }
}
