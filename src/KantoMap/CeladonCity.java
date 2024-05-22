package KantoMap;
import Character.GymLeader;
import Pokemon.*;
import Character.Erika;
public class CeladonCity extends City{
    public CeladonCity(){
        super("Celadon City");
        //Implement the connection
        this.addConnection("Saffron City", 4);
        this.addConnection("Fuchsia City", 10);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Meowth());
        this.addCatchablePokemon(new Eevee());
        this.addCatchablePokemon(new Scyther());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new Erika();
        this.setGymLeader(gymLeader);
    }
}
