package com.thornton.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.thornton.data.api.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest
{

    @Test
    public void retrieveTodosRelatedToSpringWithMockTest()
    {
        TodoService mockTodoService = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Java");
        when(mockTodoService.retrieveTodos("dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void deleteTodosNotRelatedToSpringWithMockTest()
    {
        TodoService mockTodoService = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(mockTodoService.retrieveTodos("dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("dummy");
        verify(mockTodoService).deleteTodo("Learn to Dance");
        verify(mockTodoService).retrieveTodos("dummy");
    }

    @Test
    public void retriveServiceTest()
    {
        TodoService mockTodoService = mock(TodoService.class);
        String input = "Spring";
        when(mockTodoService.retriveService("naga")).thenReturn(input);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
        todoBusinessImpl.retrieveTodoRelatedService("naga", "Spring");
        assertEquals(input, "Spring");
        verify(mockTodoService).retriveService("naga");
    }

    @Test
    public void letsTestDeleteNow()
    {

        TodoService todoService = mock(TodoService.class);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("naga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("naga");

        verify(todoService).deleteTodo("Learn to Dance");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }

}