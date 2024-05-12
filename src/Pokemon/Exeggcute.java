package Pokemon;

public class Exeggcute extends Pokemon{
    //Fuchsia City Catchable
    public Exeggcute() {
        super("Exeggcute", "Grass", 25, 60, 125);
        this.weakAgainst = new String[]{"Bug", "Ghost", "Dark", "Fire", "Ice", "Flying", "Poison"};
        this.strongAgainst = new String[]{"Water", "Ground", "Grass", "Electric", "Fighting", "Psychic"};

        Moves move1 = new Moves("Confusion", 50);
        Moves move2 = new Moves("Hypnosis", 45);
        this.addMove(move1);
        this.addMove(move2);
    }
}
