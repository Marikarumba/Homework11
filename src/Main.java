import java.time.LocalDate;

public class Main {

    public static void printSeparator() {
        System.out.println("===============================");
    }
    public static void printIssues (int issueCount) {
        System.out.println(issueCount);
    }

    public static int sumArray(int [] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        {
            System.out.println(year + " год является високосным.");
        } else {
            System.out.println(year + " год не является високосным.");
        }
    }

    public static void getPhoneLink ( int clientOS, int clientDeviceYear) {


        if ( clientOS!=0 && clientOS !=1 )
            throw new IllegalArgumentException("Нет приложения для данной ОС");

        int currentYear = LocalDate.now().getYear();
        if (clientDeviceYear > currentYear) {
            throw new IllegalArgumentException("Неправильная дата производства");
        }
        String os = clientOS == 0 ? "iOS" : "Android";

        String version = clientDeviceYear < currentYear ? "облегченную": "полную";
        System.out.printf("Установите %s версию для %s по ссылке %n", version, os);

    }

    public static int getDeliveryDays(int deliveryDistance) {
        int days=1;
        if (deliveryDistance>20)
            days=days+  Math.round ((float) deliveryDistance/40) ;
        return days;
    }

    public static void main(String[] args) {

        System.out.println(" Практика на уроке");
        printSeparator();
        int [] issuesByMonths = {4, 6, 7, 9, 2, 5, 12, 3, 7, 10, 6, 7, 1, 8};
        for (int i = 0; i < issuesByMonths.length; i++) {
            printIssues(issuesByMonths[i]);
            if ((i+1) % 3 ==0) {
                printSeparator();
            }
        }
        printSeparator();

        int total = sumArray(issuesByMonths);
        printIssues(total);

        //Задача 1
        System.out.println("Задача 1.");
        //Теперь проверку нужно обернуть в метод и использовать год, который приходит в виде параметра.
        //Результат программы выведите в консоль.
        // Если год високосный, то должно быть выведено “*номер года —* високосный год”.
        // Если год не високосный, то, соответственно: “*номер года —* не **високосный год”.

        checkLeapYear(2022);
        checkLeapYear(2024);

        //Задача 2
        System.out.println("Задача 2.");

        getPhoneLink(1, 2010);
        getPhoneLink(0,2022);

        //Задача 3
        System.out.println("Задача 3.");
        int d=getDeliveryDays(95    );
        System.out.printf("Срок доставки будет составлять %s дней%n", d);
    }
}