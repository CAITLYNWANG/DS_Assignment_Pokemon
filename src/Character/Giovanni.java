package Character;
import Pokemon.Nidoqueen;

public class Giovanni extends GymLeader{
    public Giovanni(){
        super("Giovanni", "Earth Badge",new Nidoqueen());
        this.setDialogue("Team Rocket captures Pokémon from around the world. They're important tools for keeping our criminal enterprise going. I am the leader, Giovanni!");
    }
}
