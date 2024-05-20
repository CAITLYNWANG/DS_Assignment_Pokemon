package Character;
import Pokemon.*;
public class GymLeader {
    private String leaderName;
    private String badgeName;
    private Pokemon leaderPokemon;
    private String dialogue;
    private boolean isDefeated;
    public GymLeader(String leaderName, String badgeName, Pokemon leaderPokemon){
        this.leaderName = leaderName;
        this.badgeName = badgeName;
        this.leaderPokemon = leaderPokemon;
        this.dialogue = null;
        this.isDefeated = false;
    }

    public GymLeader(){

    }
    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public Pokemon getLeaderPokemon() {
        return leaderPokemon;
    }

    public void setLeaderPokemon(Pokemon leaderPokemon) {
        this.leaderPokemon = leaderPokemon;
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }


    public boolean isDefeated() {
        return isDefeated;
    }

    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }

    @Override
    public String toString(){
        return (leaderPokemon == null)? "Your hometown has no Gym."
                : leaderName + " - " + leaderPokemon.getType() + " type";
    }
}
