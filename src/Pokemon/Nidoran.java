package Pokemon;

public class Nidoran extends Pokemon {
    //Viridian City Catchable
    public Nidoran() {
        super("Nidoran", "Poison", 40, 90, 200);
        this.weakAgainst = new String[]{"Ground", "Psychic"};
        this.strongAgainst = new String[]{"Fighting", "Grass", "Poison", "Bug"};

        Moves move1 = new Moves("Peck", 55);
        Moves move2 = new Moves("Focus Energy", 60);
        this.addMove(move1);
        this.addMove(move2);
    }
}
