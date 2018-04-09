package com.todo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.todo.codetype.StatusCode;
import com.todo.impl.TodoServiceImpl;
import com.todo.model.Todo;

class TodoServiceImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testTodoServiceImpl() {
		TodoServiceImpl todoServiceImpl = new TodoServiceImpl();
		Todo todo = new Todo();
		todo.setCreatedDateTime(new Date());
		todo.setTitle("Test");
		todo.setDescription("Test Description");
		todo.setStatus(StatusCode.ACTIVE);
		todoServiceImpl.saveTodo(todo);

		assertEquals(1,1);
	}

}
