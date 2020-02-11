package com.thornton.business;

import java.util.ArrayList;
import java.util.List;

import com.thornton.data.api.TodoService;

//TodoBusinessImpl SUT
//TodoService dependency

public class TodoBuinessImpl
{
    private TodoService todoService;

    public TodoBuinessImpl(TodoService todoService)
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

    public String retrieveTodoRelatedService(String user)
    {
        String output = ""; 
        String getMyService = todoService.retriveService(user);
        
        if(getMyService.equalsIgnoreCase(output)) {
            return getMyService; 
        }
        else {
            return "No service is here" ;
        }
        
    }

}
