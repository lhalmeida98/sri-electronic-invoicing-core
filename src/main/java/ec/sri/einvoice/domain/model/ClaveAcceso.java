package ec.sri.einvoice.domain.model;

import java.util.Objects;

public final class ClaveAcceso {
  private final String value;

  private ClaveAcceso(String value) {
    this.value = value;
  }

  public static ClaveAcceso of(String value) {
    Objects.requireNonNull(value, "value");
    if (value.length() != 49) {
      throw new IllegalArgumentException("La clave de acceso debe tener 49 digitos");
    }
    return new ClaveAcceso(value);
  }

  public String value() {
    return value;
  }
}
