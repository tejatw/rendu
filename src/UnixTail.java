import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.LinkedList;

public class UnixTail {

    public static void main(String... args) {

        if (args.length < 2) {

            System.out.println("not enough arguments");
        }



        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            String line;
            int noOfLines = Integer.parseInt(args[1]);

            LinkedList<String> tailLines = new LinkedList<>();

            while (true) {

                line = bufferedReader.readLine();
                if (line != null) {
                    if (noOfLines > 0) {
                        tailLines.add(line);
                        noOfLines--;
                    }
                    else{

                        tailLines.removeFirst();
                        tailLines.add(line);
                    }


                }
                else{
                    break;
                }


            }

            tailLines.stream().forEach(tailline -> System.out.println(tailline));
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}
