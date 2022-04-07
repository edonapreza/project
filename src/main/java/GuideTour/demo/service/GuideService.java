package GuideTour.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import GuideTour.demo.model.GuideTour;

public interface GuideService {
    public abstract void createGuide(GuideTour GuideTour);
    public abstract void updateGuide(Integer id,GuideTour GuideTour);
    public abstract void deleteGuide(Integer id);
    public abstract Collection<GuideTour> getGuides() throws FileNotFoundException, IOException;
}
