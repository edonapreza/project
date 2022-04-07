package GuideTour.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import GuideTour.demo.model.GuideTour;



@Service
public class GuideServiceImpl implements GuideService {
    private static Map<Integer, GuideTour> guides = new HashMap<Integer, GuideTour>();
    //for auto id generation
    private final AtomicLong id = new AtomicLong();
    public GuideServiceImpl(){
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        try(BufferedReader br = new BufferedReader(new FileReader ("guide.csv"))){
            String line; 
            while ((line = br.readLine()) != null){
                String [] values = line.split(",");
                GuideTour guideTour = new GuideTour((int)id.incrementAndGet(), values[1], Integer.parseInt(values[2]), values[3], Integer.parseInt(values[4]), values[5]);
                guides.put(id.intValue(), guideTour);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    
    /*public GuideServiceImpl(){
        //loading data
        GuideTour Rome = new GuideTour();
        Rome.setId((int)counter.incrementAndGet()); 
        Rome.setPeriod(48);
        Rome.setMonument("Colosseum");
        Rome.setTour(3);
        Rome.setLanguages("English");
        guideRepo.put(Rome.getId(), Rome);

        GuideTour Wien = new GuideTour();
        Wien.setId((int)counter.incrementAndGet()); 
        Wien.setPeriod(48);
        Wien.setMonument("Schönbrunn Palace");
        Wien.setTour(2);
        Wien.setLanguages("English");
        guideRepo.put(Wien.getId(), Wien);

        GuideTour Barcelona = new GuideTour();
        Barcelona.setId((int)counter.incrementAndGet()); 
        Barcelona.setPeriod(48);
        Barcelona.setMonument("Sagrada Familia");
        Barcelona.setTour(2);
        Barcelona.setLanguages("English");
        guideRepo.put(Barcelona.getId(), Barcelona);

        GuideTour Paris = new GuideTour();
        Paris.setId((int)counter.incrementAndGet()); 
        Paris.setPeriod(48);
        Paris.setMonument("Louvre Museum");
        Paris.setTour(3);
        Paris.setLanguages("English");
        guideRepo.put(Paris.getId(), Paris);

    }*/


    @Override
    public void createGuide(GuideTour GuideTour) {
        //Map<Integer, GuideTour.demo.model.GuideTour> guides;
        // TODO Auto-generated method stub
        if(guides. containsKey(GuideTour.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existig Id ...");

        }
        guides.put(GuideTour.getId(), GuideTour);
    }


    @Override
    public void updateGuide(Integer id, GuideTour GuideTour) {
        // TODO Auto-generated method stub
        guides.remove(id);
        GuideTour.setId(id);
        guides.put(GuideTour.getId(), GuideTour);
    }


    @Override
    public void deleteGuide(Integer id) {
        // TODO Auto-generated method stub
        guides.remove(id);
    }


    @Override
    public Collection<GuideTour> getGuides() {
        // TODO Auto-generated method stub
        return guides.values();
    }
}