package b20;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class IntervalScheduling {
    public static void findOptimalJobScheule(Job[] jobs){
        StdOut.println("Input Jobs: \t");
        for(Job i : jobs)
        {
            StdOut.println(i.toString()+"\n");
        }
        //StdOut.println("Input Jobs: \t" + Arrays.toString(jobs));
        Arrays.sort(jobs);        //Sap xep lai theo tgian ket thuc

        LinkedList<Job> jobsSelected = new LinkedList<Job>();
        jobsSelected.add(jobs[0]);        //them vao job dau tien
        Job lastJobAdded = jobs[0];

        for(int i=1; i<jobs.length; i++){
            if(jobs[i].start >= lastJobAdded.finish){        //kiểm tra xem công việc có tương thích hay không (bắt đầu sau hoặc tại thời điểm công việc cuối cùng kết thúc)
                jobsSelected.add(jobs[i]);
                lastJobAdded = jobs[i];        //cập nhật cho công việc vừa được thêm vào
            }
        }

        StdOut.println("\nĐã Chọn " + jobsSelected.size() + " Jobs: ");
        for(Job job : jobsSelected){
            System.out.println(job);
        }
    }
    
    
    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 5, "job1"),
            new Job(2, 3, "job2"),
            new Job(4, 7, "job3"),
            new Job(3, 8, "job4"),
            new Job(5, 12, "job5"),
            new Job(7, 9, "job6"),
            new Job(9, 14, "job7"),
            new Job(10, 15, "jo8"),
        };
        IntervalScheduling.findOptimalJobScheule(jobs);
    }
}