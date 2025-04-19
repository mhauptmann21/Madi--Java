import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defaultHealth;
    private int money;
    private String characterName;
    private String name;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        Character[] charList = {new Samurai(), new Archer(), new Wizard()};
        System.out.println("---------------------------------------");
        System.out.println("It is time... choose who you will be.");
        for (Character c : charList) {
            System.out.println(c.getName() + "Damage: " + c.getDamage() + ", Health: " + c.getHealth() + ", Money: " + c.getMoney());
        }
        System.out.println("---------------------------------------");
        System.out.println("Samurai - 1");
        System.out.println("Archer - 2");
        System.out.println("Wizard - 3");
        System.out.println("Enter a number to selcet your character...");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Wizard());
                break;
            default:
                System.out.println("No character was chosen...you can still be a Samurai!");
                initPlayer(new Samurai());
        }
    }

    public void initPlayer(Character character) {
        this.setCharacterName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setDefaultHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }

    public void printInfo() {
        System.out.println(this.getName() + " -" + this.getCharacterName() + "-" + "(Your Weapon: " +
                this.getInventory().getGun().getName() + ", Attack Power: " + this.getTotalDamage() +
                ", Your Armor: " + this.getInventory().getArmor().getName() + ", Bloacking Power: " +
                this.getInventory().getArmor().getBlock() + ", Your Health: " + this.getMoney() + ")");
    }

    public int getTotalDamage() {
        return this.damage + this.getInventory().getGen().getDamage();
    }

    public int getDamage() {
        return this.damage + this.getInventory().getGun().getDamage();
    }

    public void setDamage(int damge) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void sethealth(int health) {
        this.health = health;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

