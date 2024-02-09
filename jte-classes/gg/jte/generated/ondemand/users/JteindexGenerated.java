package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,12,12,15,15,32,32,34,34,34,34,34,34,34,35,35,35,36,36,36,38,38,42,42,44,44,45,45,46,46,47,47,47,47,47,47,47,47,48,48,49,49,49,49,49,49,49,49,50,50,51,51,52,52,52,52,52,52,52,52,53,53,54,54,55,55,59,59,61,61,61,62,62,62,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\" align=\"right\">\n        <a href=\"/users/build\">Create user</a>\n    </div>\n    <div class=\"container\">\n\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Not found any users</p>\n            <a href=\"/users\">Back</a>\n        ");
				} else {
					jteOutput.writeContent("\n            <h2>Users list</h2>\n            <form class=\"nav active\" action=\"/users\" method=\"get\">\n                <label>\n                    <input type=\"search\" required name=\"term\">\n                </label>\n                <input class=\"nav-link\" type=\"submit\" value=\"Search\">\n            </form>\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Email</th>\n                    <th>Name</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
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
						jteOutput.writeContent("</td>\n                    </tr>\n                ");
					}
					jteOutput.writeContent("\n                </tbody>\n                <tr>\n                    <td colspan=\"4\">\n                        ");
					if (page.getTerm() != null) {
						jteOutput.writeContent("\n                            <a href=\"/users\">Back</a>\n                        ");
					} else {
						jteOutput.writeContent("\n                            ");
						if (page.getCurrentPage() < page.getTotalPages()) {
							jteOutput.writeContent("\n                                ");
							if (page.getCurrentPage() > 1) {
								jteOutput.writeContent("\n                                    <a href=\"/users?page=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getCurrentPage()-1);
								jteOutput.setContext("a", null);
								jteOutput.writeContent("&per=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getPerParam());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("\">Previous</a>\n                                ");
							}
							jteOutput.writeContent("\n                                <a href=\"/users?page=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getCurrentPage()+1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("&per=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getPerParam());
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\">Next</a>\n                            ");
						} else {
							jteOutput.writeContent("\n                                ");
							if (page.getCurrentPage() > 1) {
								jteOutput.writeContent("\n                                    <a href=\"/users?page=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getCurrentPage()-1);
								jteOutput.setContext("a", null);
								jteOutput.writeContent("&per=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getPerParam());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("\">Previous</a>\n                                ");
							}
							jteOutput.writeContent("\n                            ");
						}
						jteOutput.writeContent("\n                        ");
					}
					jteOutput.writeContent("\n                    </td>\n                </tr>\n            </table>\n        ");
				}
				jteOutput.writeContent("\n    </div>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
