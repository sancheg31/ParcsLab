
import java.io.*;
import java.math.*;
import java.util.*;

import parcs.*;

public class Solver implements AM
{
    public void run(AMInfo info)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int start = info.parent.readInt();
        int end = info.parent.readInt();

        for (int number = start; number < end; ++number)
        {
            if (IsPalindrome(number))
            {
                result.add(number);
            }
        }

        info.parent.write(result);
    }

    public boolean IsPalindrome(int number)
    {
        return false;
    }

}
