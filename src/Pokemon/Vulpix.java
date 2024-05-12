package Pokemon;

public class Vulpix extends Pokemon{
    //Saffron City Catchable
    public Vulpix() {
        super("Vulpix", "Fire", 35, 80, 165);
        this.weakAgainst = new String[]{"Water", "Ground", "Rock"};
        this.strongAgainst = new String[]{"Bug", "Steel", "Fire", "Grass", "Ice", "Fairy"};

        Moves move1 = new Moves("Ember", 40);
        Moves move2 = new Moves("Tail Whip", 60);
        this.addMove(move1);
        this.addMove(move2);
    }
}
