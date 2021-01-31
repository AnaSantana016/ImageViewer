package imageviewer.apps.mock;

import imageviewer.control.Command;
import imageviewer.control.InitCommand;
import imageviewer.model.Image;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final Command NullCommand = new Command.Null();
    private final Map<String, Command> commands;

    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main(){
        InitCommand init = new InitCommand(loadImages(),createImageDisplay());
        init.execute();
        commands = init.getCommands();
    }
    
    private static MockImageDisplay createImageDisplay(){
        return new MockImageDisplay();
    } 
    
    private static List<Image> loadImages(){
        return new MockImageLoader().load();
    }
    
    private void execute(){       
        while (true)  commands.getOrDefault(input(), NullCommand).execute();
    }
    
    private String input(){
        return scanner.next().toUpperCase();
    }
}
