package com.thornton.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
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
public class TodoBusinessImplMockitoInjectMocksTest
{

    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void usingMockito()
    {

        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("naga")).thenReturn(allTodos);

        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }

    @Test
    public void usingMockito_UsingBDD()
    {
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        // given
        given(todoService.retrieveTodos("naga")).willReturn(allTodos);

        // when
        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("naga");

        // then
        assertThat(todos.size(), is(2));
    }

    @Test
    public void letsTestDeleteNow()
    {

        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoService.retrieveTodos("Rnaga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("naga");

        verify(todoService).deleteTodo("Learn to Dance");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }

    @Test
    public void captureArgument()
    {
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        Mockito.when(todoService.retrieveTodos("naga")).thenReturn(allTodos);        

        todoBusinessImpl.deleteTodosNotRelatedToSpring("naga");
        Mockito.verify(todoService).deleteTodo(stringArgumentCaptor.capture());

        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
    }
}