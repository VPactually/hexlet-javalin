package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.repository.CourseRepository;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,8,8,10,10,10,10,10,10,10,10,10,14,14,16,16,16,16,16,16,16,16,16,17,17,18,18,19,19,19,20,20,23,23,23,23,23,23,23,23,23,30,30,30,30,30,30,30,30,30,53,53,55,55,55,55,55,55,55,55,55,55,55,55,56,56,56,57,57,57,58,58,58,60,60,65,65,65,65,67,67,67,67,67,67,67,67,67,67,67,67,69,69,69,69,71,71,71,71,71,71,71,71,71,71,71,71,75,75,77,77,77,77,77,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\" align=\"right\">\n        <a");
				var __jte_html_attribute_0 = NamedRoutes.buildCoursePath();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" href=\"");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(">Create course</a>\n    </div>\n\n    <div class=\"container\">\n        ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n            <p>Not found any courses</p>\n            <a");
					var __jte_html_attribute_1 = NamedRoutes.coursesPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">Back</a>\n        ");
				} else {
					jteOutput.writeContent("\n            ");
					if (page.getFlash() != null) {
						jteOutput.writeContent("\n                <p class=\"alert alert-success\" role=\"alert\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(page.getFlash().toString());
						jteOutput.writeContent("</p>\n            ");
					}
					jteOutput.writeContent("\n            <h2>Courses list</h2>\n\n            <form class=\"nav active\"");
					var __jte_html_attribute_2 = NamedRoutes.coursesPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_2);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\n                <label>\n                    <input type=\"search\" required name=\"term\">\n                </label>\n                <input class=\"nav-link\" type=\"submit\" value=\"Искать\">\n            </form>\n            <div align=\"right\">\n                <form");
					var __jte_html_attribute_3 = NamedRoutes.coursesPath();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
						jteOutput.writeContent(" action=\"");
						jteOutput.setContext("form", "action");
						jteOutput.writeUserContent(__jte_html_attribute_3);
						jteOutput.setContext("form", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" method=\"get\">\n                    <input type=\"hidden\" name=\"page\" value=\"1\">\n                    <label>\n                        <select name=\"per\" onchange=\"this.form.submit()\">\n                            <option value=\"10\">10</option>\n                            <option value=\"20\">20</option>\n                            <option value=\"50\">50</option>\n                        </select>\n                    </label>\n                    <input class=\"btn btn-primary btn-sm\" type=\"submit\" value=\"Show\">\n                </form>\n            </div>\n\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Name</th>\n                    <th>Description</th>\n                    <th>Full name of the course</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                    <tr>\n                        <td><a");
						var __jte_html_attribute_4 = NamedRoutes.coursePath(course.getId());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_4);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(course.getId());
						jteOutput.writeContent("</a></td>\n                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getName());
						jteOutput.writeContent("</td>\n                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.getDescription());
						jteOutput.writeContent("</td>\n                        <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(course.toString());
						jteOutput.writeContent("</td>\n                    </tr>\n                ");
					}
					jteOutput.writeContent("\n                </tbody>\n            </table>\n            <nav aria-label=\"Page navigation example\">\n                <ul class=\"pagination justify-content-end\">\n                    <li class=\"page-item ");
					jteOutput.setContext("li", "class");
					jteOutput.writeUserContent(page.getPageNumber() > 1 ? "" : "disabled");
					jteOutput.setContext("li", null);
					jteOutput.writeContent("\">\n                        <a class=\"page-link\"\n                           href=\"");
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
					jteOutput.writeUserContent(page.getPageNumber()*page.getPerPage() < CourseRepository.size() ? "" : "disabled");
					jteOutput.setContext("li", null);
					jteOutput.writeContent("\">\n                        <a class=\"page-link\"\n                           href=\"");
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
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
