package Pokemon;

public class Shellder extends Pokemon{
    //Vermilion City Catchable
    public Shellder() {
        super("Shellder", "Water", 15, 30, 75);
        this.weakAgainst = new String[]{"Electric", "Grass"};
        this.strongAgainst = new String[]{"Fire", "Water", "Ice", "Steel"};

        Moves move1 = new Moves("Tackle", 25);
        Moves move2 = new Moves("Withdraw", 20);
        this.addMove(move1);
        this.addMove(move2);
    }
}
