package KantoMap;
import java.util.*;

import Character.Trainer;
public class Map {
    private ArrayList<City> cities;
    public Map(){
            this.cities = new ArrayList<>();
            initializeCities();
    }
    private void initializeCities(){
        cities.add(new PalletTown());
        cities.add(new ViridianCity());
        cities.add(new PewterCity());
        cities.add(new CeruleanCity());
        cities.add(new VermilionCity());
        cities.add(new LavenderTown());
        cities.add(new CeladonCity());
        cities.add(new FuchsiaCity());
        cities.add(new SaffronCity());
        cities.add(new CinnabarIsland());
    }

    public City findCityByName(String name) {
        for (City city : cities) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;
    }

    private int findCityIndexByName(String cityName){
        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).getName().equalsIgnoreCase(cityName)){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<City> getCities(){
        return cities;
    }
    public void displayMap(Trainer trainer) {
        String[] map = {
                "[  Pewter City  ]-------------------[  Cerulean City  ]---------------------|",
                "    |                                       |                               |",
                "    |                                       |                               |",
                "    |                                       |                               |",
                "    |                                       |                               |",
                "    |             [  Celadon City  ]----[  Saffron City  ]-----[  Lavender Town  ]",
                "    |                       |               |                               |",
                "[  Viridian City  ]         |               |                               |",
                "    |                       |               |                               |",
                "    |                       |               |                               |",
                "    |                       |       [  Vermilion City ]---------------------|",
                "    |                       |                                               |",
                "[  Pallet Town  ]           |                                               |",
                "    |                       |                                               |",
                "    |              [  Fuchsia City  ]---------------------------------------|",
                "    |                       |",
                "    |                       |",
                "[  Cinnabar Island  ]-------|"
        };
        String locationName = trainer.getLocation();
        for (int i = 0; i < map.length; i++) {
            //Remove any existing "**"
            map[i] = map[i].replace("**", "");
            if(map[i].contains(locationName)){
                map[i] = map[i].replace("  " + locationName + "  " , "**" + locationName + "**");
            }
            System.out.println(map[i]);
        }
    }

    //Rival's Race
    public City randomDestination(){
        Random random = new Random();
        City destination = null;
        boolean isNextToSaffronCity = true;
        while(destination == null && isNextToSaffronCity || destination.getName().equals("Saffron City") ) {
            destination = cities.get(random.nextInt(cities.size()));
            for (Connection adjacentCity : destination.getConnections()) {
                if (adjacentCity.getCityName().equals("Saffron City")) {
                    //If the random destination is adjacent to Saffron City, break the loop
                    //And generate another destination
                    destination = null;
                    break;
                }
            }
            //If the random destination isn't adjacent to Saffron City, set the flag to false
            if (destination != null && !destination.getName().equals("Saffron City")) {
                isNextToSaffronCity = false;
            }
        }
        return destination;
    }

    public void weightedBFS(String start, String destination){
        //Get the index of start city and destination city
        int startIndex = findCityIndexByName(start);
        int destinationIndex = findCityIndexByName(destination);

        //Store the shortest distance of each city to the start city
        int[] distances = new int[cities.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        //Distance of start city to itself is 0
        distances[startIndex] = 0;
        //Store the shortest path
        int[] prevCities = new int[cities.size()];
        Arrays.fill(prevCities, -1);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(city -> distances[city]));
        queue.offer(startIndex);

        while(!queue.isEmpty()){
            int curCityIndex = queue.poll();
            if(curCityIndex == destinationIndex){
                break;
            }

            for(Connection connection: cities.get(curCityIndex).getConnections()){
                int adjacentCityIndex = findCityIndexByName(connection.getCityName());

                if (adjacentCityIndex == -1) {
                    System.out.println("Error: City " + connection.getCityName() + " not found.");
                    continue;
                }

                int newDistance = distances[curCityIndex] + connection.getWeight();

                if(newDistance < distances[adjacentCityIndex]){
                    distances[adjacentCityIndex] = newDistance;
                    prevCities[adjacentCityIndex] = curCityIndex;

                    queue.offer(adjacentCityIndex);
                }
            }
        }

        LinkedList<String> shortestPath = new LinkedList<>();
        int curCityIndex = destinationIndex;
        while(curCityIndex != -1){
            shortestPath.addFirst(cities.get(curCityIndex).getName());
            curCityIndex = prevCities[curCityIndex];
        }

        System.out.println("Shortest Path: ");
        for(int i = 0; i < shortestPath.size(); i++){
            if(i != shortestPath.size() - 1){
                System.out.print(shortestPath.get(i) + " -> ");
            }else{
                System.out.println(shortestPath.get(i));
            }
        }
    }


}
