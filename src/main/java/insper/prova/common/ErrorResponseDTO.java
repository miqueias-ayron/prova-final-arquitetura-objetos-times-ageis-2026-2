package insper.prova.common;
import java.util.ArrayList;
import java.util.List;
public class ErrorResponseDTO {
  private int status;
  private List<String> errors = new ArrayList<>();
  private String message;
  private long timestamp = System.currentTimeMillis();
  public int getStatus() {
    return status;
  }
  public void setStatus(int s) {
    status = s;
  }
  public List<String> getErrors() {
    return errors;
  }
  public void setErrors(List<String> e) {
    errors = e;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String m) {
    message = m;
  }
  public long getTimestamp() {
    return timestamp;
  }
}
