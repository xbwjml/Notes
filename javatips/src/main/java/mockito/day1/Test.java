package mockito.day1;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = mock(LinkedList.class);

        when(list.get(0)).thenReturn("hello");

        Object o = list.get(0);
        Object o2 = list.get(10);
        return;
    }
}
