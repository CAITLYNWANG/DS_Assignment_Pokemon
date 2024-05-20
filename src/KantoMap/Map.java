package KantoMap;
import java.util.ArrayList;
import Character.Trainer;
public class Map {
    private ArrayList<City> cities;
    private boolean isInitialized = false;
    public Map(){
        if(!isInitialized){
            this.cities = new ArrayList<>();
            initializeCities();
        }else{
            //TODO:Implement saving progress here.
        }


    }
    private void initializeCities(){
        City celadonCity = new CeladonCity();
        cities.add(celadonCity);
        City ceruleanCity = new CeruleanCity();
        cities.add(ceruleanCity);
        City cinnabarIsland = new CinnabarIsland();
        cities.add(cinnabarIsland);
        City fuschiaCity = new FuschiaCity();
        cities.add(fuschiaCity);
        City lavenderTown = new LavenderTown();
        cities.add(lavenderTown);
        City palletTown = new PalletTown();
        cities.add(palletTown);
        City pewterCity = new PewterCity();
        cities.add(pewterCity);
        City saffronCity = new SaffronCity();
        cities.add(saffronCity);
        City vermillionCity = new VermillionCity();
        cities.add(vermillionCity);
        City viridianCity = new ViridianCity();
        cities.add(viridianCity);

    }

    public City findCityByName(String cityName){
        for(City city: cities){
            if(city.getName().equalsIgnoreCase(cityName)){
                return city;
            }
        }
        return null;
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
                "    |                       |       [Vermillion City]-----------------------|",
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

}
