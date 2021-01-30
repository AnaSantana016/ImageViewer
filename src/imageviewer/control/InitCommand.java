package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class InitCommand implements Command{
    
    private final Map<String, Command>  commands;
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public InitCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.commands = new HashMap<>();
        this.images = images;
        this.imageDisplay = imageDisplay;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
    
    @Override
    public void execute(){
        imageDisplay.display(images.get(0));
        createCommands();
    }
    
    private void createCommands() {
        commands.put("N", new NextImageCommand(images, imageDisplay));
        commands.put("P", new PrevImageCommand(images, imageDisplay));
        commands.put("Q", new ExitCommand());
    }
}
