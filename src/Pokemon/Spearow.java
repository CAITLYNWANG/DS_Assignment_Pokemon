package Pokemon;

public class Spearow extends Pokemon{
    //Pewter City and Vermilion City Catchable
    public Spearow(){
        super("Spearow", "Flying", 13, 30, 65);
        this.weakAgainst = new String[]{"Electric", "Ice", "Rock"};
        this.strongAgainst = new String[]{"Ground", "Grass", "Ghost", "Bug"};

        Moves move1 = new Moves("Peck", 20);
        Moves move2 = new Moves("Leer", 10);
        this.addMove(move1);
        this.addMove(move2);

    }
}
