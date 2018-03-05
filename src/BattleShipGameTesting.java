import java.util.*;

// This is my second attempt to update something online

public class BattleShipGameTesting{
    public static final Scanner input = new Scanner(System.in);
    public static int playerShipCount;
    public static int computerShipCount;


    public static void main(String[] args){
        System.out.println("**** Welcome to BattleShips game ****\n");
        System.out.println("Right now, the sea is empty\n");
        int[][] map = makeMap();
        printMap(map);
        map = deployPlayersShips(map);
        playerShipCount = 5;
        map = deployComputersShips(map);
        computerShipCount = 5;
        printMap(map);
        int turnCount = 0;
        while (playerShipCount>0&&computerShipCount>0) {
            if (turnCount%2==0){
                map = playerTurn(map);
            } else {
                map = computerTurn(map);
            }
            turnCount++;
        }
        if (playerShipCount==0) {
            System.out.println("Your fleet is sunk");
        } else {
            System.out.println("The enemy fleet is sunk");
        }
        System.out.println("GAME OVER");

    }

    public static int[][] makeMap(){
        int[][] newMap = new int[10][10];
        return newMap;
    }

    public static void printMap(int[][] map) {
        /*
        On the map, the following letters represent
        0 = empty space
        1 = player ship (active)
        2 = computer ship (active)
        3 = player shot missed location
        4 = player ship (sunk)
        5 = computer ship (sunk)
        6 = computer shot missed location
        7 = player & computer shot missed location
         */
        System.out.println("   0123456789   ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++) {
                if (map[i][j]==0||map[i][j]==2||map[i][j]==6){
                    System.out.print(" ");
                } else if (map[i][j]==1) {
                    System.out.print("@");
                } else if (map[i][j]==3){
                    System.out.print("-");
                } else if (map[i][j]==4){
                    System.out.print("x");
                } else if (map[i][j]==5){
                    System.out.print("!");
                } else if (map[i][j]==7){
                    System.out.print("-");
                } else {
                    System.out.print("?");
                }
            }
            System.out.println("| " + i);
        }
    }



    public static int[][] deployPlayersShips(int                    [][] map){
        System.out.println("You must now deploy your fleet of five ships");
        for (int i =0;i<5;i++)
        {
            boolean validChoice = false;
            while(validChoice==false) {
                System.out.print("Enter X coordinate for ship " + (i + 1) + ": ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for ship " + (i + 1) + ": ");
                int y = input.nextInt();
                if (x>=0&&x<10&&y>=0&&y<10&&map[y][x]==0){
                    map[y][x]=1;
                    validChoice = true;
                    printMap(map);
                    System.out.println("Ship "+(i+1)+" launched!");
                } else {
                    System.out.println("Sorry, try again and choose a place on the ocean map that is available");
                }
            }
        }
        System.out.println("You fleet successfully deployed!");
        return map;
    }

    public static int[][] deployComputersShips(int[][] map){
        System.out.println("The computer is deploying ships!");
        for (int i =0;i<5;i++) {
            boolean validChoice = false;
            while(validChoice==false) {
                int x = (int) (Math.random()*10);
                int y = (int) (Math.random()*10);
                if (x>=0&&x<10&&y>=0&&y<10&&map[y][x]==0){
                    map[y][x]=2;
                    validChoice = true;
                    System.out.println("Enemy ship "+(i+1)+" launched!");
                }
            }
        }
        System.out.println("Enemy fleet deployed");
        return map;
    }

    public static int[][] playerTurn(int[][] map) {
        System.out.println("Your turn");
        boolean validChoice = false;
        while(validChoice==false) {
            System.out.print("Enter X Coordinate: ");
            int x = input.nextInt();
            System.out.print("Enter Y Coordinate: ");
            int y = input.nextInt();
            if (x >= 0 && x < 10 && y >= 0 && y < 10 && (map[y][x] == 0 || map[y][x] == 3)) {
                map[y][x] = 3;
                validChoice = true;
                printMap(map);
                System.out.println("You missed!");
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && (map[y][x] == 6|| map[y][x] == 7)) {
                map[y][x] = 7;
                validChoice = true;
                printMap(map);
                System.out.println("You missed!");
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && (map[y][x] == 4|| map[y][x] == 5)) {
                validChoice = true;
                printMap(map);
                System.out.println("You missed!");
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[y][x] == 1) {
                map[y][x] = 4;
                playerShipCount--;
                validChoice = true;
                printMap(map);
                System.out.println("Cease fire! That's a friendly position captain. You sunk your own ship.");
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[y][x] == 2) {
                map[y][x] = 5;
                computerShipCount--;
                validChoice = true;
                printMap(map);
                System.out.println("Hit! You sunk an enemy vessel");
            } else {
                System.out.println("Sorry, try again and choose a place on the ocean map that is available");
            }
        }
        return map;
    }

    public static int[][] computerTurn(int[][] map) {
                /*
        On the map, the following letters represent
        0 = empty space
        1 = player ship (active)
        2 = computer ship (active)
        3 = player shot missed location
        4 = player ship (sunk)
        5 = computer ship (sunk)
        6 = computer shot missed location
        7 = player & computer shot missed location
         */
        System.out.println("Computer's turn");
        boolean validChoice = false;
        while(validChoice==false) {
            int x = (int)(Math.random()*10);
            int y = (int)(Math.random()*10);
            if (x >= 0 && x < 10 && y >= 0 && y < 10 && (map[y][x] == 0)){
                map[y][x] = 6;
                validChoice = true;
                System.out.println("Computer missed");
                printMap(map);
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[y][x] == 3) {
                map[y][x] = 7;
                validChoice = true;
                System.out.println("Computer missed");
                printMap(map);
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[y][x] == 1) {
                map[y][x] = 4;
                playerShipCount--;
                validChoice = true;
                printMap(map);
                System.out.println("The Computer sunk one of your ships!");
            } else if (x >= 0 && x < 10 && y >= 0 && y < 10 && map[y][x] == 2) {
                map[y][x] = 5;
                computerShipCount--;
                validChoice = true;
                printMap(map);
                System.out.println("The computer sunk of of its own ships");
            } else {
            }
        }

        return map;
    }

}

