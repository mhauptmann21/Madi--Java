
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("They're awake! They're awake! ");
        System.out.println("Do you know your name?");
        System.out.println("Enter now: ");
        String name = input.nextLine();
        Player playerName = new Player(name);
        System.out.println("It's nice to meet you, " + playerName.getName() + "!");
        System.out.println("I am your guide! It is now time for you to choose who you will become.");
        playerName.selectChar();
        Location location;
        while (true) {
            System.out.println("---------------------------------------");
            playerName.printInfo();
            System.out.println("---------------------------------------");
            System.out.println("I know you just woke up, but our people are in grave danger. We need your help.");
            System.out.println("Monsters are taking over the lands, and must be put to an end.");
            System.out.println("To EXIT the game, ENTER : 0");
            System.out.println("To enter the SAFE HOUSE, ENTER : 1 (Health is restored. Monsters can't reach you here.) ");
            System.out.println("To enter the SHOP, ENTER : 2 (Buy armor and weapons here.) ");
            System.out.println("To head to the FOREST, ENTER : 3 (You may encounter monsters deep into the forest.) ");
            System.out.println("To head to the CAVE, ENTER : 4 (You may encounter monsters in the cave.) ");
            System.out.println("To head to the CASTLE ENTER : 5 (The strongest monsters will be found here.) ");
            System.out.println("---------------------------------------");
            System.out.println("Now ENETER the number of the place you want to travel to: ");
            int selectLocation = input.nextInt();

            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Shop(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new Cave(player);
                    break;
                case 5:
                    location = new Castle(player);
                    break;
                default:
                    System.out.println("You are now heading to the Safe House...");
                    location = new SafeHouse(player);
            }
            if (location == null) {
                System.out.println("Game Over! Thank you for playing!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("You died! Game over!");
                break;
            }

        }
    }
}
