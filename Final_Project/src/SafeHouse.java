public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in a safe area. Your health has been restored.");
        this.getPlayer().sethealth(this.getPlayer().getDefaultHealth());
        return true;
    }
}
