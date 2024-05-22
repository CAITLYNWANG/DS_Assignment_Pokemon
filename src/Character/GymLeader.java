package Character;
import Pokemon.*;
public class GymLeader {
    private String leaderName;
    private String badgeName;
    private Pokemon leaderPokemon;
    private String dialogue;
    public GymLeader(String leaderName, String badgeName, Pokemon leaderPokemon){
        this.leaderName = leaderName;
        this.badgeName = badgeName;
        this.leaderPokemon = leaderPokemon;
        this.dialogue = null;
    }

    public GymLeader(){

    }
    public String getLeaderName() {
        return leaderName;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public Pokemon getLeaderPokemon() {
        return leaderPokemon;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }


    @Override
    public String toString(){
        return (leaderPokemon == null)? "[This town has no Gym.]"
                : "[" + leaderName + " - " + leaderPokemon.getType() + " type]";
    }
}
