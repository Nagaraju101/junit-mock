package com.thornton.data.api;

import java.util.List;

public interface TodoService
{
    public List<String> retrieveTodos(String user);
    
    public void deleteTodo(String todo);
    
    public String retriveService(String user);
}
