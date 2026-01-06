package ec.sri.einvoice.application.port.out;

public record SriResponse(
    SriResponseStatus status,
    String numeroAutorizacion,
    String mensaje
) {
  public static SriResponse autorizado(String numero) {
    return new SriResponse(SriResponseStatus.AUTORIZADO, numero, null);
  }

  public static SriResponse rechazado(String mensaje) {
    return new SriResponse(SriResponseStatus.RECHAZADO, null, mensaje);
  }

  public static SriResponse error(String mensaje) {
    return new SriResponse(SriResponseStatus.ERROR, null, mensaje);
  }

  public static SriResponse recibido() {
    return new SriResponse(SriResponseStatus.RECIBIDO, null, null);
  }
}
