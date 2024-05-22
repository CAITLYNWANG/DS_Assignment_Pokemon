package Pokemon;

public class Charmander extends Pokemon {
    //Trainer initial choice
    public Charmander() {
        super("Charmander", "Fire", 5, 100, 25);
        this.weakAgainst = new String[]{"Water", "Ground", "Rock"};
        this.strongAgainst = new String[]{"Grass", "Ice", "Bug", "Steel"};

        Moves move1 = new Moves("Scratch", 40);
        Moves move2 = new Moves("Growl", 50);
        this.addMove(move1);
        this.addMove(move2);
    }
}

