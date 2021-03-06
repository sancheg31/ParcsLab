
import java.io.*;
import java.math.*;
import java.util.*;

import parcs.*;

public class Solver implements AM
{
    public static void main(String[] args) throws Exception {

        task currentTask = new task();
        currentTask.addJarFile("Solver.jar");
        currentTask.addJarFile("Palindrom.jar");

        System.out.println("Waiting for result...");

        Solver solver = new Solver();
        solver.run(new AMInfo(currentTask, null));

        System.out.println("Result: ");

        currentTask.end();
    }

    public void run(AMInfo info)
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int threads = scanner.nextInt();
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        long startTime = System.nanoTime();
        List<Integer> palindromes = solve(info, threads, start, end);
        long endTime = System.nanoTime();

        System.out.println("Palindromes count: " + palindromes.size());
        System.out.println("Time: " + ((endTime - startTime) / 1000000) + "ms");
    }

    public List<Integer> solve(AMInfo info, int threads, int start, int end)
    {
        List<point> points = new ArrayList<>();
        List<channel> channels = new ArrayList<>();

        int remainder = (end - start) % threads;
        int length = (end - start) / threads;

        for (int index = 0; index < threads; ++index)
        {
            int currentStart = index * length;
            int currentEnd = (index + 1) * length + ((threads - index - 1 < remainder) ? 1 : 0);

            System.out.println(index + " worker range: " + currentStart + " - " + currentEnd);

            point newPoint = info.createPoint();
            channel newChannel = newPoint.createChannel();

            channels.add(newChannel);
            points.add(newPoint);

            newPoint.execute("Palindrom");
            newChannel.write(currentStart);
            newChannel.write(currentEnd);
            newChannel.write(index);


        }

        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < threads; ++index)
        {
            ArrayList<Integer> threadResult = (ArrayList<Integer>) channels.get(index).readObject();
            System.out.println("Worker result: " + threadResult.size());
            for (int j = 0; j < threadResult.size(); ++j)
            {
                result.add(threadResult.get(j));
            }
        }

        return result;
    }



}
