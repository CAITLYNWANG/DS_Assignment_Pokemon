package KantoMap;
import Character.GymLeader;

public class LavenderTown extends City{
    public LavenderTown(){
        super("Lavender Town");
        //Implement the connection
        this.addConnection("Cerulean City", 9);
        this.addConnection("Saffron City", 3);
        this.addConnection("Vermillion City", 5);
        this.addConnection("Fuschia City", 7);
        //Implement the Challenge Gym Leader
        GymLeader gymLeader = null;
        this.setGymLeader(gymLeader);
    }
}
