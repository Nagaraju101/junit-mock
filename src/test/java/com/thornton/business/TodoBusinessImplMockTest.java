package com.thornton.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import com.thornton.data.api.TodoService;

public class TodoBusinessImplMockTest
{

    @Test
    public void retrieveTodosRelatedToSpringWithMockTest()
    {
        TodoService mockTodoService = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Java");
        when(mockTodoService.retrieveTodos("dummy")).thenReturn(todos);
        TodoBuinessImpl todoBusinessImpl = new TodoBuinessImpl(mockTodoService);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");
        assertEquals(2, filteredTodos.size());
        
        
        
    }

}
