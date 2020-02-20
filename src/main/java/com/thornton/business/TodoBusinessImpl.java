package com.thornton.business;

import java.util.ArrayList;
import java.util.List;

import com.thornton.data.api.TodoService;

//TodoBusinessImpl SUT
//TodoService dependency

public class TodoBusinessImpl
{
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService)
    {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user)
    {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos)
        {
            if (todo.contains("Spring"))
            {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user)
    {
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos)
        {
            if (!todo.contains("Spring"))
            {
                todoService.deleteTodo(todo);
            }
        }
    }

    public String retrieveTodoRelatedService(String service, String input)
    {
        String getMyService = todoService.retriveService(service);

        if (getMyService.equalsIgnoreCase(input))
        {
            return getMyService;
        }
        else
        {
            return "No service is here";
        }

    }

}
