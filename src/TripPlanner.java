import java.util.Scanner;

public class TripPlanner {
    // By Sam Erickson, January 2018, edX Microsoft Learn to Program in Java, Module 1
    public static void main(String[] args){
        part1();
        part2();
        part3();
        part4();
        part5();
    }
    public static void part1(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner! ");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you "+name+",  Where are you travelling to? ");
        String dest = input.nextLine();
        System.out.println("Great! "+dest+" sounds like a great trip");
        System.out.println("***********\n");
    }

    public static void part2() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are your going to spend travelling? ");
        int daysTravel = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int budget = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many "+currency+" are there in 1 USD? ");
        double exchangeRatio = input.nextDouble();
        int hoursTravel = daysTravel*24;
        int minutesTravel = hoursTravel*60;
        System.out.print("If you are traveling for "+daysTravel+" days that is the same as ");
        System.out.println(hoursTravel+" hours or "+minutesTravel+" minutes");
        System.out.print("If you are going to spend $"+budget);
        double moneyPerDay = ((int)(((double)budget/daysTravel)*100))/100.0;
        double moneyPerDayCurrency = ((int)(((double)budget*exchangeRatio/daysTravel)*100))/100.0;
        System.out.println(" USD that means per day your can spend up to $"+moneyPerDay+" USD");
        System.out.println("Your total budget in "+currency+" is "+budget*exchangeRatio+" "+currency+", which per day is "+moneyPerDayCurrency+" MXC");
        System.out.println("***********\n");
    }

    public static void part3() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int differenceTime = input.nextInt();
        String destinationMidnightTime;
        String destinationNoonTime;
        destinationMidnightTime = (24+differenceTime)%24+":00";
        destinationNoonTime = (24+12+differenceTime)%24+":00";
        System.out.print("That means when it is midnight at home it will be "+destinationMidnightTime+" in your travel destination ");
        System.out.print("and when it is noon at home it will be "+destinationNoonTime+" in your travel destination");
        System.out.println("***********\n");
    }

    public static void part4() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        double areaKm2 = input.nextDouble();
        double areaMiles2 = (double)((int)(areaKm2/Math.pow(1.6093,2)*10))/10.0;
        System.out.println("In miles2 that is "+areaMiles2);
        System.out.println("***********\n");
    }
    public static void part5() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter home latitude: ");
        double lat1 = input.nextDouble();
        double lat1Rad = Math.toRadians(lat1);
        System.out.print("Enter home longitude: ");
        double lon1 = input.nextDouble();
        double lon1Rad = Math.toRadians(lon1);
        System.out.print("Enter destination latitude: ");
        double lat2 = input.nextDouble();
        double lat2Rad = Math.toRadians(lat2);
        System.out.print("Enter destination longitude: ");
        double lon2 = input.nextDouble();
        double lon2Rad = Math.toRadians(lon2);
        double earthRadiusKm = 6371;
        double inside = Math.pow(Math.sin((lat2Rad - lat1Rad) / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin((lon2Rad - lon1Rad) / 2), 2);
        double distance = 2 * earthRadiusKm * Math.asin(Math.sqrt(inside));
        distance = ((double)((int)(distance*100)))/100;
        System.out.print("The distance traveled is " + distance + " km.");
    }



}
