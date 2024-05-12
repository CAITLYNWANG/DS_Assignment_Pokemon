package Pokemon;

public class Bulbasaur extends Pokemon{
    //Viridian City Catchable
    public Bulbasaur() {
        super("Bulbasaur", "Poison", 45, 100, 225);
        this.weakAgainst = new String[]{"Fire", "Psychic", "Flying", "Ice"};
        this.strongAgainst = new String[]{"Water", "Electric", "Grass", "Fighting", "Fairy"};

        Moves move1 = new Moves("Tackle", 80);
        Moves move2 = new Moves("Growl", 65);
        this.addMove(move1);
        this.addMove(move2);
    }
}
