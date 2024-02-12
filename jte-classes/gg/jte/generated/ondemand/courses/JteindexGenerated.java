package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,12,12,15,15,47,47,49,49,49,49,49,49,49,50,50,50,51,51,51,52,52,52,54,54,57,57,59,59,59,59,59,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, page, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"container\" align=\"right\">\n        <a href=\"/courses/build\">Create course</a>\n    </div>\n\n    <div class=\"container\">\n        ");
				if (page.getCourses().isEmpty()) {
					jteOutput.writeContent("\n            <p>Not found any courses</p>\n            <a href=\"/courses\">Back</a>\n        ");
				} else {
					jteOutput.writeContent("\n            <h2>Courses list</h2>\n            <form class=\"nav active\" action=\"/courses\" method=\"get\">\n                <label>\n                    <input type=\"search\" required name=\"term\">\n                </label>\n                <input class=\"nav-link\" type=\"submit\" value=\"Искать\">\n            </form>\n            <div align=\"right\">\n                <form action=\"/courses\" method=\"get\">\n                    <input type=\"hidden\" name=\"page\" value=\"1\">\n                    <label>\n                        <select name=\"per\">\n                            <option value=\"10\" selected>10</option>\n                            <option value=\"20\">20</option>\n                            <option value=\"50\">50</option>\n                        </select>\n                    </label>\n                    <input class=\"btn btn-primary btn-sm\" type=\"submit\" value=\"Show\">\n                </form>\n            </div>\n\n            <table class=\"table\">\n                <thead>\n                <tr>\n                    <th>ID</th>\n                    <th>Name</th>\n                    <th>Description</th>\n                    <th>Full name of the course</th>\n                </tr>\n                </thead>\n                <tbody>\n                ");
					for (var course : page.getCourses()) {
						jteOutput.writeContent("\n                    <tr>\n                        <td><a href=\"/courses/");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(course.getId());
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\">");
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
					jteOutput.writeContent("\n                </tbody>\n            </table>\n        ");
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
