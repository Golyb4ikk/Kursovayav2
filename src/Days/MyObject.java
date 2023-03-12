package Days;

import java.lang.invoke.WrongMethodTypeException;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class MyObject {
    private String title;
    private String description;
    private String type;
    private LocalDateTime firstDate;
    private Integer counter=1;
    private Integer id;

    public MyObject(String title, String description, String type, LocalDateTime firstDate, Integer counter, Integer id)  {
        this.title = title;
        this.description = description;
        this.type = type;
        this.firstDate = firstDate;
        this.counter = counter;
        id = counter++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDateTime firstDate) {
        this.firstDate = firstDate;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyObject)) return false;
        MyObject myObject = (MyObject) o;
        return Objects.equals(getTitle(), myObject.getTitle()) && Objects.equals(getDescription(), myObject.getDescription()) && Objects.equals(getType(), myObject.getType()) && Objects.equals(getFirstDate(), myObject.getFirstDate()) && Objects.equals(getCounter(), myObject.getCounter()) && Objects.equals(getId(), myObject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, type, firstDate, counter, id);
    }

    @Override
    public String toString() {
        return "Days.MyObject{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tasktype='" + type + '\'' +
                ", firstDate=" + firstDate +
                ", counter=" + counter +
                ", id=" + id +
                '}';
    }
}
