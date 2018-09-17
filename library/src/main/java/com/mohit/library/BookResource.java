package com.mohit.library;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("books")
public class BookResource {
	
	BookRepository repo=new BookRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Book> getBooks()
	{
		return repo.getBooks();
	}
	
	@GET
	@Path("book/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book getBook(@PathParam("id") int id)
	{
		return repo.getBook(id);
	}
	
	@POST
	@Path("book")
	public Book createBook(Book bk)
	{
		System.out.println(bk);
		repo.create(bk);
		
		return bk;
	}
	
	@PUT
	@Path("book")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book updateBook(Book bk)
	{
		System.out.println(bk);
		repo.update(bk);
		
		return bk;
	}
	
	@DELETE
	@Path("book/{id}")
	public Book deleteBook(@PathParam("id") int id)
	{
		Book bk=repo.getBook(id);
		
		if(bk.getId() != 0)
		{
			repo.delete(id);
		}
		return bk;
	}

}
