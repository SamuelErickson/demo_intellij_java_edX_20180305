import java.util.*;

public class OddsAndEvens {
    // January 2018, Samuel Erickson
    public static void main(String[] args) {
        // Part 1
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String choice = input.nextLine();
        if (choice.equals("O")) {
            System.out.print(name + " has picked odds! The computer will be evens");
            System.out.println("\n----------------------------------------");
        } else if (choice.equals("E")) {
            System.out.print(name + " has picked evens! The computer will be odds");
            System.out.println("\n----------------------------------------");
        } else {
            System.out.print(name + " has picked an invalid option! Try again");
        }
        // Part 2 & 3
        System.out.print("How many \"fingers\" do you put out? ");
        int fingers = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " fingers");
        System.out.println("\n----------------------------------------");
        int sum = fingers + computer;
        System.out.println(fingers + " + " + computer + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;
        if (oddOrEven) {
            System.out.println(sum+" is ...even!");
            if (choice.equals("E")){
                System.out.println("That means "+name+" wins!");
            }   else    {
                System.out.println("That means the computer wins!");
            }
        } else {
            System.out.println(sum+" is ...odd!");
            if (choice.equals("O")){
                System.out.println("That means "+name+" wins!");
            }   else    {
                System.out.println("That means the computer wins!");
            }
        }
        System.out.print("\n----------------------------------------");
    }



        }







