import java.time.LocalDateTime;

public interface Repeatable {

    void setTitle(String title);
    LocalDateTime getFirstDate();
    boolean checkOccurance(LocalDateTime LocalDateTime);
}
