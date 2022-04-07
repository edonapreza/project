package GuideTour.demo.model;

public class GuideTour {
    private Integer id;
    private String name;
    private Integer period;
    private String monument;
    private Integer tour;
    private String languages;
    
    public GuideTour(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Integer getTour() {
        return tour;
    }

    public void setTour(Integer tour) {
        this.tour = tour;
    }

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GuideTour(Integer id, String name, Integer period, String monument, Integer tour, String languages){
        this.id = id;
        this.name = name;
        this.period = period;
        this.monument = monument;
        this.tour = tour;
        this.languages = languages;
        
    }
}
