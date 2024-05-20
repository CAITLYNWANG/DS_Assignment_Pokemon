package KantoMap;
import Character.GymLeader;
import Pokemon.*;
import Character.Giovanni;
public class ViridianCity extends City{
    public ViridianCity(){
        super("Viridian City");
        //Implement the connection
        this.addConnection("Pewter City", 8);
        this.addConnection("Pallet Town", 5);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Bulbasaur());
        this.addCatchablePokemon(new Squirtle());
        this.addCatchablePokemon(new Nidoran());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new Giovanni();
        this.setGymLeader(gymLeader);
    }
}
