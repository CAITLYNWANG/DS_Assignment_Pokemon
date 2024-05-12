package Pokemon;

public class Moves{
    private String moveName;
    private int attack;
    public Moves(){

    }

    public Moves(String name, int attack){
        this.moveName = name;
        this.attack = attack;
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
