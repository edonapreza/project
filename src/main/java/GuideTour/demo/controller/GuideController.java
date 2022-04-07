package GuideTour.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import GuideTour.demo.model.GuideTour;
import GuideTour.demo.service.GuideService;

@RestController 
public class GuideController {
    @Autowired
    GuideService guideService;

    //when we want to update data we use the get method, only for information and after that we need to post the data thats why we post!
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides", method=RequestMethod.GET)
    public ResponseEntity<Object> getPlace() throws FileNotFoundException, IOException{
        return new ResponseEntity<>(guideService.getGuides(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id")Integer id){
        guideService.deleteGuide(id);
        return new ResponseEntity<>("Guide is deleted successfully", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides", method=RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody GuideTour GuideTour){
        guideService.createGuide(GuideTour);
        return new ResponseEntity<>("Place is created successfully", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/guides/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody GuideTour GuideTour){
        guideService.updateGuide(id,GuideTour);
        return new ResponseEntity<>("Place is updated successfully", HttpStatus.OK);
    }
}