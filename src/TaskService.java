import Days.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskService {

    private static final Map<Integer,Repeatable>actualTasks=new HashMap<>();

    public static void addObj(Scanner scanner) {


        scanner.nextLine();
        System.out.println("Введите название задачи");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи");
        String description = scanner.nextLine();
        System.out.println("Введите тип задачи");
        Type type = Type.values()[scanner.nextInt()];
        System.out.println("Введите повторяемость задачи");
        int occurance = scanner.nextInt();
        System.out.println("Введите дату");
        scanner.nextLine();
        createEvent(scanner, title, description, type, occurance);
        System.out.println("Для выхода нажимите Enter/n");
        scanner.nextLine();

    }

    private static void createEvent(Scanner scanner, String title, String description, Type type,int occurance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Repeatable object = null;
            createEvent(scanner,title,description,type,occurance);
            System.out.println("Создана задача" + object);
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат dd.MM.yyyy HH:mm и попробуйте еще раз");
            createEvent(scanner, title, description, type, occurance);
        }
    }

    private static void printActualTasks() {
        for (Repeatable task : actualTasks.values()) {
            System.out.println(task);
        }
    }

    public static void deleteObj(Scanner scanner) {
        System.out.println("Текущие задачи\n");
        printActualTasks();
        try {
            System.out.println("Для удаления введите Id задачиn\n");
            int id = scanner.nextInt();
            if (actualTasks.containsKey(id)) {
                Repeatable removedObj = actualTasks.get(id);
                System.out.println("Задача" + id + "удалена");
            } else {
                throw new TaskNotFoundException();
            }
        }catch (TaskNotFoundException e){
            e.printStackTrace();
            System.out.println("Такой задачи не существует");
        }
    }

    public static void getObjByDay(Scanner scanner){
        System.out.println("Введите дату как dd.MM.yyyy:");
        try{
            String date=scanner.next();
            DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate=LocalDate.parse(date,dateTimeFormatter);
            List<Repeatable> foundEvents=findTasksByDate(requestedDate);
            System.out.println("События на "+requestedDate+":");
            for (Repeatable task :foundEvents){
                System.out.println(task);
            }
        }catch(DateTimeParseException e){
            System.out.println("Проверьте формат даты затем попробуйте снова");
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмите Enter\n");
    }
    private static List<Repeatable>findTasksByDate(LocalDate date){
        List<Repeatable>tasks= new ArrayList<>();
        for(Repeatable task: actualTasks.values()){
            if(task.checkOccurance(date.atStartOfDay())){
                tasks.add(task);
            }
        }
        return tasks;
    }
}
