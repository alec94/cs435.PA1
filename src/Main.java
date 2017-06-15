import java.io.IOException;

/**
 * Created by Alec on 2/19/2017.
 *
 */
public class Main {
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("Usage: <input file> <output file> <profile>");
            System.exit(-1);
        }

        try {
            String profile = args[2].toLowerCase();

            switch (profile) {
                case "1a":
                    System.out.println("Running 1A");
                    cs435.nGram.Profile1A.Main.main(args);
                    break;
                case "1b":
                    System.out.println("Running 1B");
                    cs435.nGram.Profile1B.Main.main(args);
                    break;
                case "2a":
                    System.out.println("Running 2A");
                    cs435.nGram.Profile2A.Main.main(args);
                    break;
                case "2b":
                    System.out.println("Running 2B");
                    cs435.nGram.Profile2B.Main.main(args);
                    break;
                default:
                    System.out.println("Unknown profile: " + args[2]);
                    break;
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
