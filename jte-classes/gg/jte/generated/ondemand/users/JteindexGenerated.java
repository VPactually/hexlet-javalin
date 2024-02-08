package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,7,10,10,28,28,30,30,30,30,30,30,30,31,31,31,32,32,32,33,33,33,35,35,39,39,41,41,42,42,43,43,44,44,44,44,44,44,44,44,45,45,46,46,46,46,46,46,46,46,48,48,49,49,49,49,49,49,49,49,50,50,51,51,54,54,56,56,56,57,57,57,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\">\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Not found any users</p>\n            <a href=\"/users\">Back</a>\n        ");
				} else {
					jteOutput.writeContent("\n            <h2>Users list</h2>\n            <form class=\"nav active\" action=\"/users\" method=\"get\">\n                <label>\n                    <input type=\"search\" required name=\"term\">\n                </label>\n                <input class=\"nav-link\" type=\"submit\" value=\"Искать\">\n            </form>\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Email</th>\n                    <th>FirstName</th>\n                    <th>LastName</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                    <tr>\n                        <td><a href=\"/users/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(user.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</a></td>\n                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</td>\n                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getFirstName());
						jteOutput.writeContent("</td>\n                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getLastName());
						jteOutput.writeContent("</td>\n                    </tr>\n                ");
					}
					jteOutput.writeContent("\n                </tbody>\n                <tr>\n                    <td colspan=\"4\">\n                        ");
					if (page.getTerm() != null) {
						jteOutput.writeContent("\n                            <a href=\"/courses\">Back</a>\n                        ");
					} else {
						jteOutput.writeContent("\n                        ");
						if (page.getCurrentPage() < page.getTotalPages()) {
							jteOutput.writeContent("\n                        ");
							if (page.getCurrentPage() > 1) {
								jteOutput.writeContent("\n                            <a href=\"/courses?page=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getCurrentPage()-1);
								jteOutput.setContext("a", null);
								jteOutput.writeContent("&per=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getPerParam());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("\">Previous</a>\n                        ");
							}
							jteOutput.writeContent("\n                        <a href=\"/courses?page=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getCurrentPage()+1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("&per=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getPerParam());
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\">Next</a>\n                    </td>\n                    ");
						} else {
							jteOutput.writeContent("\n                        <a href=\"/courses?page=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getCurrentPage()-1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("&per=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getPerParam());
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\">Previous</a>\n                    ");
						}
						jteOutput.writeContent("\n                    ");
					}
					jteOutput.writeContent("\n                </tr>\n            </table>\n        ");
				}
				jteOutput.writeContent("\n    </div>\n");
			}
		}, null);
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
