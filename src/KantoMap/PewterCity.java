package KantoMap;
import Character.GymLeader;
import Pokemon.Ekans;
import Pokemon.Pidgey;
import Pokemon.Spearow;

public class PewterCity extends City{
    public PewterCity(){
        super("Pewter City");
        //Implement the map
        this.addConnection("CeruleanCity", 12);
        this.addConnection("ViridianCity", 8);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Pidgey());
        this.addCatchablePokemon(new Ekans());
        this.addCatchablePokemon(new Spearow());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new GymLeader();
    }

}
