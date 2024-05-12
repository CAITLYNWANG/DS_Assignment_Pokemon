package Pokemon;

public class Grimer extends Pokemon{
    //Cinnabar Island Catchable
    public Grimer() {
        super("Grimer", "Poison", 40, 80, 200);
        this.weakAgainst = new String[]{"Ground", "Psychic"};
        this.strongAgainst = new String[]{"Fighting", "Poison", "Bug", "Grass"};

        Moves move1 = new Moves("Pound", 50);
        Moves move2 = new Moves("Poison Gas", 60);
        this.addMove(move1);
        this.addMove(move2);
    }
}
