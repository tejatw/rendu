package algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class MaximumJobs {

    public static void main(String... args) {

        List<Job> listOfJobs = new ArrayList<Job>();

        listOfJobs.add(new Job(1, 3));
        listOfJobs.add(new Job(4, 9));
        listOfJobs.add(new Job(5, 8));
        listOfJobs.add(new Job(7, 12));
        listOfJobs.add(new Job(9, 19));
    }

}

@Data
@AllArgsConstructor
class Job{

    private int startTime;
    private int endTime;
}
