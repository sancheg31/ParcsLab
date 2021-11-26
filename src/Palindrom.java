
import java.io.FileNotFoundException;
import java.math.*;
import java.util.*;
import java.io.File;

import parcs.*;

public class Palindrom implements AM
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
        String intStr = String.valueOf(Math.abs(number));
        return intStr.equals(new StringBuilder(intStr).reverse().toString());
    }


}
