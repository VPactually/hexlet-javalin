package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.NamedRoutes;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,9,9,9,9,9,9,9,9,9,12,12,14,14,14,14,14,14,14,14,14,15,15,17,17,17,17,17,17,17,17,17,24,24,24,24,24,24,24,24,24,45,45,47,47,47,47,47,47,47,47,47,47,47,47,48,48,48,49,49,49,51,51,55,55,56,56,56,56,56,56,56,56,56,57,57,58,58,59,59,60,60,60,60,60,60,60,60,60,60,60,60,61,61,62,62,62,62,62,62,62,62,62,62,62,62,63,63,64,64,65,65,65,65,65,65,65,65,65,65,65,65,66,66,67,67,68,68,70,70,72,72,72,73,73,73,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\" align=\"right\">\n        <a");
				var __jte_html_attribute_0 = NamedRoutes.buildUserPath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Create user</a>\n    </div>\n    <div class=\"container\">\n        ");
				if (page.getUsers().isEmpty()) {
					jteOutput.writeContent("\n            <p>Not found any users</p>\n            <a");
					var __jte_html_attribute_1 = NamedRoutes.usersPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Back</a>\n        ");
				} else {
					jteOutput.writeContent("\n            <h2>Users list</h2>\n            <form class=\"nav active\"");
					var __jte_html_attribute_2 = NamedRoutes.usersPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\n                <label>\n                    <input type=\"search\" required name=\"term\">\n                </label>\n                <input class=\"nav-link\" type=\"submit\" value=\"Search\">\n            </form>\n            <div align=\"right\">\n                <form");
					var __jte_html_attribute_3 = NamedRoutes.usersPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\n                    <input type=\"hidden\" name=\"page\" value=\"1\">\n                    <label>\n                        <select name=\"per\">\n                            <option value=\"10\" selected>10</option>\n                            <option value=\"20\">20</option>\n                            <option value=\"50\">50</option>\n                        </select>\n                    </label>\n                    <input class=\"btn btn-primary btn-sm\" type=\"submit\" value=\"Show\">\n                </form>\n            </div>\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Email</th>\n                    <th>Name</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
					for (var user : page.getUsers()) {
						jteOutput.writeContent("\n                    <tr>\n                        <td><a");
						var __jte_html_attribute_4 = NamedRoutes.userPath(user.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_4);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
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
					jteOutput.writeContent("\n                </tbody>\n            </table>\n            <div class=\"container\" align=\"right\">\n                ");
					if (page.getTerm() != null) {
						jteOutput.writeContent("\n                    <a");
						var __jte_html_attribute_5 = NamedRoutes.usersPath();
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_5);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">Back</a>\n                ");
					} else {
						jteOutput.writeContent("\n                    ");
						if (page.hasNextPage()) {
							jteOutput.writeContent("\n                        ");
							if (page.hasPreviousPage()) {
								jteOutput.writeContent("\n                            <a href=\"");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(NamedRoutes.usersPath());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("?page=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getCurrentPage()-1);
								jteOutput.setContext("a", null);
								jteOutput.writeContent("&per=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getPerParam());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("\">Previous</a>\n                        ");
							}
							jteOutput.writeContent("\n                        <a href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(NamedRoutes.usersPath());
							jteOutput.setContext("a", null);
							jteOutput.writeContent("?page=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getCurrentPage()+1);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("&per=");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(page.getPerParam());
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\">Next</a>\n                    ");
						} else {
							jteOutput.writeContent("\n                        ");
							if (page.hasPreviousPage()) {
								jteOutput.writeContent("\n                            <a href=\"");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(NamedRoutes.usersPath());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("?page=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getCurrentPage()-1);
								jteOutput.setContext("a", null);
								jteOutput.writeContent("&per=");
								jteOutput.setContext("a", "href");
								jteOutput.writeUserContent(page.getPerParam());
								jteOutput.setContext("a", null);
								jteOutput.writeContent("\">Previous</a>\n                        ");
							}
							jteOutput.writeContent("\n                    ");
						}
						jteOutput.writeContent("\n                ");
					}
					jteOutput.writeContent("\n            </div>\n        ");
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
