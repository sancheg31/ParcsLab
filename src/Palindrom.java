
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
        int channelIndex = info.parent.readInt();

        for (int number = start; number < end; ++number)
        {
            if (IsPalindrome(number))
            {
                result.add(number);
            }
        }
        System.out.println("Worker result: " + result.size());
        info.parent.write(result);
    }

    public boolean IsPalindrome(int number)
    {
        int palindrome = Math.abs(number);
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        return number == reverse;
    }


}
