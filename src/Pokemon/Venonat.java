package Pokemon;

public class Venonat extends Pokemon{
    //Fuchsia City Catchable
    public Venonat() {
        super("Venonat", "Bug", 30, 80, 150);
        this.weakAgainst = new String[]{"Fire", "Flying", "Rock", "Psychic"};
        this.strongAgainst = new String[]{"Grass", "Fighting", "Poison", "Bug", "Fairy"};

        Moves move1 = new Moves("Confusion", 50);
        Moves move2 = new Moves("Supersonic", 40);
        this.addMove(move1);
        this.addMove(move2);
    }
}
