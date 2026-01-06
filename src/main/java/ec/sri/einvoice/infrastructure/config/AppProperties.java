package ec.sri.einvoice.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
  private Offline offline = new Offline();
  private Retry retry = new Retry();

  public Offline getOffline() {
    return offline;
  }

  public void setOffline(Offline offline) {
    this.offline = offline;
  }

  public Retry getRetry() {
    return retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public static class Offline {
    private boolean enabled = true;

    public boolean isEnabled() {
      return enabled;
    }

    public void setEnabled(boolean enabled) {
      this.enabled = enabled;
    }
  }

  public static class Retry {
    private int maxAttempts = 5;
    private long backoffSeconds = 30;
    private long schedulerMs = 60000;

    public int getMaxAttempts() {
      return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
      this.maxAttempts = maxAttempts;
    }

    public long getBackoffSeconds() {
      return backoffSeconds;
    }

    public void setBackoffSeconds(long backoffSeconds) {
      this.backoffSeconds = backoffSeconds;
    }

    public long getSchedulerMs() {
      return schedulerMs;
    }

    public void setSchedulerMs(long schedulerMs) {
      this.schedulerMs = schedulerMs;
    }
  }
}
