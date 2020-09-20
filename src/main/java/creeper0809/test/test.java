package creeper0809.test;

import static spark.Spark.*;

public class test {
//	http://localhost:4567/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get("/hello", (request, response) -> "Hello World!");

		post("/hello", (request, response) -> "Hello World: " + request.body());

		get("/private", (request, response) -> {
			response.status(401);
			return "Go Away!!!";
		});

		get("/users/:name", (request, response) -> "Selected user: " + request.params(":name"));

		get("/news/:section", (request, response) -> {
			response.type("text/xml");
			return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
		});

		get("/protected", (request, response) -> {
			halt(403, "I don't think so!!!");
			return null;
		});

		get("/redirect", (request, response) -> {
			response.redirect("/news/world");
			return null;
		});

		get("/", (request, response) -> "root");
	}
}
