package OtherFunction;
import KantoMap.*;
import util.StructureService;

public class RivalRace {
    public void rivalRaceChallenge(){
        Map map = new Map();
        System.out.print("The battle has begun! Your rival Gary has challenged you to a race to ");
        City destination = map.randomDestination();
        System.out.println(destination.getName());

        map.weightedBFS("Saffron City", destination.getName());

        System.out.println("Goodluck on your race!");
        StructureService.lineSeperator();
    }
}
