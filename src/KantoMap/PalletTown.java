package KantoMap;
import Character.GymLeader;
import Pokemon.*;
public class PalletTown  extends City{
    public PalletTown(){
        super("Pallet Town");
        //Implement the connection
        this.addConnection("Viridian City", 5);
        this.addConnection("Cinnabar Island", 7);
        //Implement the wild pokemons
        this.addCatchablePokemon(new Pidgey());
        this.addCatchablePokemon(new Meowth());
        this.addCatchablePokemon(new Scyther());
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = new GymLeader();
        this.setGymLeader(gymLeader);
    }
}
