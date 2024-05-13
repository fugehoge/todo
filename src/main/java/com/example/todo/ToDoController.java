package com.example.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping("")
@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService todoService;
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/post")
	public String post(){
		return "post";
	}
	
	@GetMapping("/complete")
	public String complete(){
		return "complete";
	}
	
	@PostMapping("/complete")
	public String complete(@RequestParam String title,@RequestParam String time_limit, Model model){
		ToDo newToDo= new ToDo();
		newToDo.setTitle(title);
		newToDo.setTime_limit(time_limit);
		todoService.saveToDo(newToDo);
		
		return "complete";
	}
	
	@GetMapping("/view")
	public String view(Model model){
        Iterable<ToDo> iterable = todoService.getAllToDos();
        List<ToDo> todos = new ArrayList<>();  // ArrayListのインスタンスを作成
        iterable.forEach(todos::add);  // Iterableの全ての要素をListに追加
        model.addAttribute("todos", todos);  // モデルにダジャレを追加
        return "view";  // 投稿閲覧ページ
		
		
	}

}
