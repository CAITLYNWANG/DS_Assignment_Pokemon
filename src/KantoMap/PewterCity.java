package KantoMap;
import Character.Brock;
import Character.GymLeader;
import Pokemon.*;

public class PewterCity extends City{
    public PewterCity(){
        super("Pewter City");
        //Implement the connection
        this.addConnection("Cerulean City", 12);
        this.addConnection("Viridian City", 8);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Pidgey());
        this.addCatchablePokemon(new Ekans());
        this.addCatchablePokemon(new Spearow());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new Brock();
        this.setGymLeader(gymLeader);
    }

}
