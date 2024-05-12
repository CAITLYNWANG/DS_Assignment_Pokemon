package Pokemon;

public class Vileplume extends Pokemon {
    //Erika's Pokemon(Celadon City Gym)
    public Vileplume(){
        super("Vileplume", "Grass", 29, 90, 145);
        this.weakAgainst = new String[]{"Flying", "Fire", "Psychic", "Ice" };
        this.strongAgainst = new String[]{"Fighting", "Grass", "Electric", "Fairy", "Water"};

        Moves move1 = new Moves("Mega Drain", 40);
        Moves move2 = new Moves("Giga Drain", 35);
        this.addMove(move1);
        this.addMove(move2);

    }
}
