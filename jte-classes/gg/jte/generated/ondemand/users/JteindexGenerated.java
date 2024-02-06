package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,7,9,9,21,21,23,23,23,23,23,23,23,24,24,24,25,25,25,26,26,26,28,28,32,32,33,33,34,34,34,34,34,34,34,34,35,35,36,36,36,36,36,36,36,36,38,38,39,39,39,39,39,39,39,39,40,40,43,43,45,45,45,46,46,46,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\">\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Users not added in the list</p>\n        ");
				} else {
					jteOutput.writeContent("\n            <h2>Users list</h2>\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Email</th>\n                    <th>FirstName</th>\n                    <th>LastName</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
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
					if (page.getCurrentPage() < page.getTotalPages()) {
						jteOutput.writeContent("\n                        ");
						if (page.getCurrentPage() > 1) {
							jteOutput.writeContent("\n                            <a href=\"/users?page=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getCurrentPage()-1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("&per=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getPerParam());
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\">Previous</a>\n                        ");
						}
						jteOutput.writeContent("\n                        <a href=\"/users?page=");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(page.getCurrentPage()+1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("&per=");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(page.getPerParam());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">Next</a>\n                    </td>\n                    ");
					} else {
						jteOutput.writeContent("\n                        <a href=\"/users?page=");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(page.getCurrentPage()-1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("&per=");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(page.getPerParam());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">Previous</a>\n                    ");
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
