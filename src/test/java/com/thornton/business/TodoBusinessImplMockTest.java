package com.thornton.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.thornton.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest
{
    @Mock
    TodoService mockTodoService;
    //TodoService mockTodoService = mock(TodoService.class);
    
    
    @InjectMocks
    TodoBuinessImpl todoBusinessImpl;
  //TodoBuinessImpl todoBusinessImpl = new TodoBuinessImpl(mockTodoService);
    

    @Test
    public void retrieveTodosRelatedToSpringWithMockTest()
    {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Java");
        when(mockTodoService.retrieveTodos("dummy")).thenReturn(todos);        
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void deleteTodosNotRelatedToSpringWithMockTest()
    {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(mockTodoService.retrieveTodos("dummy")).thenReturn(todos);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("dummy");
        verify(mockTodoService).deleteTodo("Learn to Dance");
    }

    @Test
    public void retriveServiceTest()
    {
        when(mockTodoService.retriveService("naga")).thenReturn("Spring");
        assertEquals("Spring", "Spring");
    }

}