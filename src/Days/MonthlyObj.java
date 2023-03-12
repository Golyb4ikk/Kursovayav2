package Days;

import Days.MyObject;

import java.time.LocalDateTime;

public class MonthlyObj extends MyObject {
    public MonthlyObj(String title, String description, String tasktype, LocalDateTime firstDate, Integer counter, Integer id) {
        super(title, description, tasktype, firstDate, counter, id);
    }
}
