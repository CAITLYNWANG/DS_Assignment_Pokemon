package KantoMap;

public class Connection{
    private String cityName;
    private  int weight;
    public Connection(String city, int weight){
        this.cityName = city;
        this.weight = weight;
    }

    public String getCity() {
        return cityName;
    }

    public int getWeight() {
        return weight;
    }
}
