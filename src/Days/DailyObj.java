package Days;

import java.time.LocalDateTime;

public class DailyObj extends MyObject{
    public DailyObj(String title, String description, String tasktype, LocalDateTime firstDate, Integer counter, Integer id) {
        super(title, description, tasktype, firstDate, counter, id);
    }
}
