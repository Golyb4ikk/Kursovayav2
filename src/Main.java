import java.awt.*;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Выберите пункт меню:");
                printMenu();
                if (scanner.hasNextInt()) {
                    switch (menu) {
                        case 1:
                            TaskService.addObj(scanner);
                            break;
                        case 2:
                            TaskService.getObjByDay(scanner);
                            break;
                        case 3:
                            TaskService.deleteObj(scanner);
                            break;
                        case 0:
                            break label;
                    }
                }else{
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }
    private static void printMenu(){
        System.out.println(" " +
                "1.Добавить задачу " +
                "2.Получить задачи на указанный день " +
                "3.Удалить задачу " +
                "0.Выход");
    }
}