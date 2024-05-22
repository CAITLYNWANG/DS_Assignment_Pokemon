package Pokemon;

public class Squirtle extends Pokemon{
    //Trainer initial choice
    public Squirtle() {
        super("Squirtle", "Water", 5, 100, 25);
        this.weakAgainst = new String[]{"Electric", "Grass"};
        this.strongAgainst = new String[]{"Fire", "Water", "Ice", "Steel"};

        Moves move1 = new Moves("Tackle", 40);
        Moves move2 = new Moves("Tail Whip", 50);
        this.addMove(move1);
        this.addMove(move2);
    }
}
