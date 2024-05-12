package Pokemon;

public class Raichu extends Pokemon {
    //Lt.Surge's Pokemon(Vermilion City Gym)
    public Raichu(){
        super("Raichu", "Electric", 24, 70, 120);
        this.weakAgainst = new String[]{"Ground"};
        this.strongAgainst = new String[]{"Flying", "Steel", "Electric"};

        Moves move1 = new Moves("Nuzzle", 20);
        Moves move2 = new Moves("Feint", 30);
        this.addMove(move1);
        this.addMove(move2);

    }
}
