/* 
 * Instalar Advanced Rest client en el navegador
 * para probar la API rest*/

package com.books2.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/* Etiquetas obligatorias */
@RestController
@CrossOrigin // Soluciona problemas de compatibilidad navegadores
@RequestMapping("/books") // obligatoria para Spring

public class BookRestControler {
	
	private List<Book> books = new ArrayList<>();
	
	@PostMapping
	//Recuperamos datos Json y los convertimos a nuestrea estructura java de objetos
	public String createBooks(@RequestBody String json) throws Exception{ //Recibe json por requestBody
		Book book=new Gson().fromJson(json, Book.class); //json se convierte a objeto
		books.add(book);
		
		return toJson(book);
	}

	@GetMapping // CTRL+SPACE aparece el texto de la API
	public String getAllBooks() throws Exception {
		//Book book = new Book("Hola", 19);
		// return "Estos son todos los libros";
		return toJson(books);
	}
	
	@GetMapping ("/{id}") // CTRL+SPACE aparece el texto de la API
	public String getBook(@PathVariable String id) throws Exception {
		//buscar el libro
		Book book = findBook(id);
		
		return toJson(books);
	}
	
	private Book findBook(String id) throws Exception{
		for (Book b: books) {
			if (b.getId().equals(id)) {
				return b;
			}
		}
		throw new Exception();
	}


	@DeleteMapping
	public void removeAllBooks() throws Exception {
		books= new ArrayList<>();
	}
	
	private String toJson(Object o) {
		//Librería Gson que le pones objeto y devuelve cadena JSON
		//se debe añadir una línea de implementación en buil.gradle
		return new Gson().toJson(o);
	}

}
