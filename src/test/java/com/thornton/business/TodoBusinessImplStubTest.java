//package com.thornton.business;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import com.thornton.data.api.TodoService;
//import com.thornton.data.api.TodoServiceStub;
//
//public class TodoBusinessImplStubTest
//{
//
//    @Test
//    public void test()
//    {
//        TodoService todoServiceStub = new TodoServiceStub();
//        TodoBuinessImpl todoBusinessImpl = new TodoBuinessImpl(todoServiceStub);
//        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
//        assertEquals(3,filteredTodos.size());
//
//    }
//
//}
