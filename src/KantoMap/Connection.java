package KantoMap;

public class Connection{
    private String cityName;
    private  int weight;
    public Connection(String cityName, int weight){
        this.cityName = cityName;
        this.weight = weight;
    }

    public String getCityName() {
        return cityName;
    }

    public int getWeight() {
        return weight;
    }
}
