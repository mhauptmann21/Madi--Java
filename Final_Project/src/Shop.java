

public class Shop extends NormalLocation{
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------------------------------------");
        System.out.println("Welcome to the shop!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Weapons - 1");
            System.out.println("Armor - 2");
            System.out.println("Exit - 3");
            System.out.println("Your Choice : ");
            int choice = input.nextInt();
            while (choice < 0 || choice > 3) {
                System.out.println("Wrong choice. Try again: ");
                choice = input.nextInt();
            }
            if (choice != 0) {
                switch(choice) {
                    case 1:
                        printBows();
                        buyBow();
                        break;
                    case 2:
                        printArmors();
                        buyArmor();
                        break;
                    case 3:
                        System.out.println("Til next time...");
                        showMenu = false;
                        break;
                }
            }
        }
        return true;
    }

    public void printBows() {
        System.out.println("---------------------------------------");
        System.out.println("Weapon List : ");
        for (Bow bow : Bow.bowList()) {
            System.out.println(bow.getId() + " - " + bow.getName() + " Damage: " + bow.getDamage() + ", Price: " + bow.getPrice());
        }
        System.out.println("0 - Exit");
    }

    public void buyBow() {
        System.out.println("---------------------------------------");
        System.out.println("Buy: ");
        int choice = input.nextInt();

        while (choice < 0 || choice > Bow.bowList().length) {
            System.out.println("Wrong choice. Try again : ");
            choice = input.nextInt();
        }
        Bow selectedBow = Bow.getBowObjById(choice);
        if (selectedBow != null) {
            if (selectedBow.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You don't have enough money to buy this.");
            } else {
                System.out.println(selectedBow.getName() + " added to inventory.");
                int remain = this.getPlayer().getMoney() - selectedBow.getPrice();
                this.getPlayer().setMoney(remain);
                System.out.println("Remaining Money : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setBow(selectedBow);
            }
        }
    }

    public void printArmors() {
        System.out.println("---------------------------------------");
        System.out.println("Armor List : ");
        for (Armor armor : Armor.armorList()) {
            System.out.println(armor.getId() + " - " + armor.getName() + "Block : " + armor.getBlock() + ", Price : " + armor.getPrice());
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {
        System.out.println("---------------------------------------");
        System.out.println("Buy : ");
        int choice = input.nextInt();

        while(choice < 0 || choice > Armor.armorList().length) {
            System.out.println("Wrong answer. Try again: ");
            choice = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjById(choice);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You don't have enough money for this.");
            } else {
                System.out.println(selectedArmor.getName() + "has been added to inventory.");
                int remain = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(remain);
                System.out.println("Remaining Money : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }
}
