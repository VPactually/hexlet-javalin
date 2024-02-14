package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.repository.UserRepository;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,8,8,10,10,10,10,10,10,10,10,10,14,14,16,16,16,16,16,16,16,16,16,17,17,19,19,19,19,19,19,19,19,19,26,26,26,26,26,26,26,26,26,47,47,49,49,49,49,49,49,49,49,49,49,49,49,50,50,50,51,51,51,53,53,58,58,58,58,59,59,59,59,59,59,59,59,59,59,59,59,61,61,61,61,62,62,62,62,62,62,62,62,62,62,62,62,66,66,68,68,68,69,69,69,3,3,3,3};
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
				jteOutput.writeContent(">Create user</a>\n\n    </div>\n    <div class=\"container\">\n        ");
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
					jteOutput.writeContent(" method=\"get\">\n                    <input type=\"hidden\" name=\"page\" value=\"1\">\n                    <label>\n                        <select name=\"per\" onchange=\"this.form.submit()\">\n                            <option value=\"10\">10</option>\n                            <option value=\"20\">20</option>\n                            <option value=\"50\">50</option>\n                        </select>\n                    </label>\n                    <input class=\"btn btn-primary btn-sm\" type=\"submit\" value=\"Show\">\n                </form>\n            </div>\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Email</th>\n                    <th>Name</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
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
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</td>\n                    </tr>\n                ");
					}
					jteOutput.writeContent("\n                </tbody>\n            </table>\n            <nav aria-label=\"Page navigation example\">\n                <ul class=\"pagination justify-content-end\">\n                    <li class=\"page-item ");
					jteOutput.setContext("li", "class");
					jteOutput.writeUserContent(page.getPageNumber() > 1 ? "" : "disabled");
					jteOutput.setContext("li", null);
					jteOutput.writeContent("\">\n                        <a class=\"page-link\" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(NamedRoutes.coursesPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("?page=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(page.getPageNumber() - 1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("&per=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(page.getPerPage());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">Previous</a>\n                    </li>\n                    <li class=\"page-item ");
					jteOutput.setContext("li", "class");
					jteOutput.writeUserContent(page.getPageNumber()*page.getPerPage() < UserRepository.size() ? "" : "disabled");
					jteOutput.setContext("li", null);
					jteOutput.writeContent("\">\n                        <a class=\"page-link\" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(NamedRoutes.coursesPath());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("?page=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(page.getPageNumber() + 1);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("&per=");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(page.getPerPage());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">Next</a>\n                    </li>\n                </ul>\n            </nav>\n        ");
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
