package Pokemon;

public class Ponyta extends Pokemon{
    //Cinnabar Island Catchable
    public Ponyta() {
        super("Ponyta", "Fire", 30, 50, 150);
        this.weakAgainst = new String[]{"Water", "Ground", "Rock"};
        this.strongAgainst = new String[]{"Bug", "Steel", "Fire", "Grass", "Ice"};

        Moves move1 = new Moves("Ember", 40);
        Moves move2 = new Moves("Stomp", 65);
        this.addMove(move1);
        this.addMove(move2);
    }
}
