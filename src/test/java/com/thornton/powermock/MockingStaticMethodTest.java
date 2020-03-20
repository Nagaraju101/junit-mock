package com.thornton.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.thornton.data.api.TodoService;
import com.thornton.business.TodoBusinessImpl;

@RunWith(MockitoJUnitRunner.class)
public class MockingStaticMethodTest
{

    @Mock
    Dependency  dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void retrieveTodosRelatedToSpringWithMockTest()
    {
//        Dependency dependency = mock(Dependency.class);
//        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Java");
//        when(dependency.retrieveAllStats(5).thenReturn
//                SystemUnderTest systemUnderTest = new SystemUnderTest(dependency);
//        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");
//        assertEquals(2, filteredTodos.size());
    }

    
}
