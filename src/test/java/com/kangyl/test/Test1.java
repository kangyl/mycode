/**
 * Copyright
 */
package com.kangyl.test;

import com.kangyl.test.hash.Person;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2018/10/8
 */
public class Test1 {

    @Test
    public void getValue() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("kent");

        System.out.println(person.getName());
    }
}
