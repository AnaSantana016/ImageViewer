package imageviewer.apps.mock;

import imageviewer.model.Image;
import imageviewer.view.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class MockImageLoader implements ImageLoader{
 
    @Override
    public List<Image> load(){
        List<Image> imageList = new ArrayList<>();
        imageList.add(new Image("Hola"));
        imageList.add(new Image("Mundo"));
        imageList.add(new Image("Buenvenid@"));
        return imageList;
    }
}
