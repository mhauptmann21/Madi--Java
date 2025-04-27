import java.util.Random;

public class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int rndMonster = this.randomMonsterNumber();
        System.out.println("---------------------------------------");
        System.out.println("You have just reached the " + this.getName());
        System.out.println("There is a " + this.getMonster().getName() + " nearby. Be careful...");
        System.out.println("---------------------------------------");
        System.out.println("Will you FIGHT or RUN: ");
        String select = input.nextLine();
        select = select.toLowerCase().replace(" ", "");
        if (select.equals("fight") || select.equals("fights")) {
            if (combat(rndMonster)){
                System.out.println(this.getName() + " is cleared of monsters.");
                return true;
            }
        }
        else if(this.getPlayer().getHealth() <= 0) {
            return false;
        }
        return true;
    }
    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getgetDefaultHealth());
            this.playerStatus();
            this.monsterStatus(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("ATTACK or RUN: ");
                String choice = input.nextLine();
                choice = choice.toLowerCase().trim().replace(" ", "");
                if (choice.equals("attack") || choice.equals("attacks")) {
                    int playerHealth = this.getPlayer().getHealth();
                    int monsterHealth = this.getMonster().getHealth();
                    int playerAttack = this.getPlayer().getTotalDamage();
                    int monsterAttack = this.getMonster().getDamage();
                    System.out.println("You attacked the monster!");
                    this.getMonster().setHealth(monsterHealth - playerAttack);
                    afterHit();
                    if (this.getMonster().getHealth() > 0 ) {
                        System.out.println("The monster attacked you...");
                        int playerBlock = this.getPlayer().getInventory().getArmor().getBlock();
                        monsterAttack = monsterAttack - playerBlock;
                        if(monsterAttack < 0) {
                            monsterAttack = 0;
                        }
                        if (playerBlock > 0) {
                            System.out.println("Monster attack " + playerBlock + " blocked.");
                        } else {
                            System.out.println("You have no armor, the monster attack wasn't blocked. ");
                        }
                        this.getPlayer().sethealth(playerHealth - monsterAttack);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() <= 0) {
                System.out.println(i + ". " + this.getMonster().getName() + "was defeated.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("You picked up the loot : " + this.getMonster().getAward() + " money");
            } else {
                return false;
            }
        }
        return false;
    }

    public void playerStatus() {
        System.out.println("---------------------------------------");
        System.out.println(this.getPlayer().getCharacterName() + " Status: ");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Attack Power : " + this.getPlayer().getTotalDamage());
        System.out.println("Defense Power : " + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void monsterStatus(int i) {
        System.out.println("---------------------------------------");
        System.out.println(i + ". " + this.getMonster().getName() + " Status:");
        System.out.println(this.getMonster().getName() + "Monster : " + this.getMonster().getHealth());
        System.out.println("Attack Damage : " + this.getMonster().getDamage());
    }

    public void afterHit() {
        System.out.println("Your life : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "Monster : " + this.getMonster().getHealth());
        System.out.println();
    }
    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return this.monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}

