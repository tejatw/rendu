import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStreams {

    public static void main(String... args) {

         List<String> uuidList = new ArrayList<String>(Arrays.asList("id1", "id2", "", "id2"));

//        System.out.println(IntStream.range(1,7).count());
        System.out.println(uuidList.stream().filter(id -> id != null && id != "").distinct().collect(Collectors.joining()));
    }
}
