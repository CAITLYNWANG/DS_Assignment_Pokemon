package Pokemon;

public class Krabby extends Pokemon {
    //Vermilion City Catchable
    public Krabby() {

        super("Krabby", "Water", 20, 30, 100);
        this.weakAgainst = new String[]{"Electric", "Grass"};
        this.strongAgainst = new String[]{"Fire", "Water", "Ice", "Steel"};

        Moves move1 = new Moves("Bubble", 20);
        Moves move2 = new Moves("Vice Grip", 30);
        this.addMove(move1);
        this.addMove(move2);
    }
}
