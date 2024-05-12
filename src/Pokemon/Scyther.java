package Pokemon;

public class Scyther extends Pokemon{
    //Celandor City Catchable
    public Scyther() {
        super("Scyther", "Bug", 25, 70, 125);
        this.weakAgainst = new String[]{"Rock", "Electric", "Fire", "Flying", "Ice"};
        this.strongAgainst = new String[]{"Grass", "Fighting", "Ground", "Bug"};

        Moves move1 = new Moves("Wing Attack", 35);
        Moves move2 = new Moves("Quick Attack", 40);
        this.addMove(move1);
        this.addMove(move2);
    }
}
